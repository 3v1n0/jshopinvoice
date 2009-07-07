package invoice;

import item.*;
import entities.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

import jshopper.Utility;


public class Shop extends Company implements Shopper {
	private static Shop sh;
	private String shopname;
	private InvoiceObserver obs;
	private ItemList<ShopItem> items;
	private LinkedList<Invoice> invoices;
	private LinkedList<String> categories;
	private LinkedList<InvoicePrinter> iprinters;
	private LinkedList<Entity> clients;
	private static int shops;
	private static int added;
	private int id;
	
	private Shop(Company cmp, String nm, Address add, Contacts cnt) {
		super(cmp.getName(), add, cnt, cmp.getVATIN());
		shopname = nm;
		invoices = new LinkedList<Invoice>();
		categories = new LinkedList<String>();
		clients = new LinkedList<Entity>();
		items = new ItemLinkedList<ShopItem>();
		iprinters = new LinkedList<InvoicePrinter>();
		obs = new InvoiceObserver();
		id = (++shops);
	}
	
	public static Shop createShop(Company cmp, String nm, Address add, Contacts cnt) {
		if (sh == null)
			sh = new Shop(cmp, nm, add, cnt);

		return sh;
	}
	
	public static Shop createShop(Company cmp, String nm) {
		return createShop(cmp, nm, cmp.getAddress(), cmp.getContacts());
	}
	
	private ShopItem findItem(Item i) {
		for (int j = 0; j < items.getSize(); j++) {
			ShopItem sh = items.get(j);
			if (i.equals(sh))
				return sh;
		}

		return null;
	}
	
	public ShopItem addItem(Item i, int count) {
		boolean ipkg;
		
		try {
			int min = 0;
			
			for (Item it : i.getSubItems()) {
				ShopItem sh = findItem(it);
				if (sh != null) {
					if (sh.getCount() < min || min == 0)
						min = sh.getCount();
				} else {
					return null;
				}
			}
			count = (count < min ? count : min);

			ipkg = true;
		} catch (SinglePartException e) {
			ipkg = false;
		}
		
		ShopItem shi = findItem(i);
		
		if (shi != null) {
			if (ipkg)
				shi.setCount(shi.getCount() + count);
			else
				shi.setCount(count);
		} else {
			shi = new ShopItem(i, ++added, count);
			items.add(shi);
			addCategory(shi.getType());
		}
		
		return shi;
	}
	
	public ShopItem addItem(Item i) {
		return addItem(i, 1);
	}
	
	public void removeItem(Item i) {
		items.remove((ShopItem)i);
		removeCategory(i.getType());
	}
	
	public void removeItemInstance(Item i) {
		ShopItem shi = findItem(i);
		
		try {
			for (Item it : i.getSubItems()) {
				ShopItem sh = findItem(it);
				if (sh != null) {
					sh.setCount(sh.getCount()-1);
				}
			}
		} catch (SinglePartException e) {}
		
		if (shi != null) {
			if (shi.getCount() > 0) {
				shi.setCount(shi.getCount()-1);
				
				for (Item it : getItems()) {
					boolean found = false;
					try {
						for (Item sub : it.getSubItems())
							if (sub.equals(shi))
								found = true;
					} catch  (SinglePartException e) {}
					
					if (found && it.getCount() == (shi.getCount()+1))
						it.setCount(shi.getCount());
				}
						
			}
			/*if (shi.getCount() < 1) {
				removeItem(i); // Remove this to leave in the Shop unavailable items
			}*/
		}
	}
	
	private boolean findnRmCategory(String cat, boolean remove) {
		for (String c : categories) {
			if (c == cat) {
				if (remove)
					categories.remove(c);

				return true;
			}
		}
		
		return false;
	}
	
	private boolean findCategory(String cat) {
		return findnRmCategory(cat, false);
	}
	
	private boolean delCategory(String cat) {
		return findnRmCategory(cat, true);
	}
	
	public void addCategory(String cat) {
		if (!findCategory(cat))
			categories.add(cat);
	}
	
	public void removeCategory(String cat) {
		boolean catfound = false;

		for (Item it : items) {
			if (it.getType() == cat) {
				catfound = true;
				break;
			}
		}
		
		if (!catfound)
			delCategory(cat);
	}
	
	public void removeCategoryItems(String cat) {
		for (int i = 0; i < items.getSize(); i++) {
			if (items.get(i).getType() == cat) {
				removeItem(items.get(i));
				i--;
			}
		}
	}

	protected void addInvoice(Invoice i) {
		if (!invoices.contains(i)) {
			i.addObserver(obs);
			invoices.add(i);

			if (!clients.contains(i.getBuyer()))
				clients.add(i.getBuyer());
			
			for (InvoicePrinter ip : iprinters)
				i.addPrinter(ip);
		}
	}
	
	protected void removeInvoice(Invoice i) {
		if (invoices.contains(i)) {
			i.deleteObservers();
			invoices.remove(i);
		}
	}
	
	protected Invoice addCustomerInvoice(Entity buyer) throws Exception {
		Invoice i = new Invoice(this, buyer);
		addInvoice(i);
		return i;
	}
	
	public void addDefaultInvoicePrinter(InvoicePrinter ip) {
		iprinters.add(ip);

		for (Invoice inv : invoices)
			inv.addPrinter(ip);
	}
	
	public void printItemsHtml() throws IOException {
		String filepath = System.getProperty("java.io.tmpdir") +
						  System.getProperty("file.separator") + "Shop.html";
		
		FileOutputStream file = new FileOutputStream(filepath);
		//TODO manage exception
		
		String html = "<html>\n" +
					  "\t<head>\n" +
					  "\t\t<title>"+getName()+" Items list</title>\n" +
					  "\t</head>\n" +
					  "\t<body>\n" +
					  "\t\t<h1>"+getName()+"</h1>\n" +
					  "\t\t<table align=\"center\">\n";
		
		html += "\t\t\t<tr>\n" +
				"\t\t\t\t<td><b>Oggetto</b></td>\n" +
				"\t\t\t\t<td><b>Descrizione</b></td>\n" +
				"\t\t\t\t<td><b>Prezzo</b></td>\n" +
				"\t\t\t\t<td><b>"+Utility.stringToHTML("Disponibilità")+"</b></td>\n" +
				"\t\t\t</tr>\n";
		
		for (Item i : items)
			html += "\t\t\t<tr id='"+i.getId()+"'>\n" +
					"\t\t\t\t<td>"+Utility.stringToHTML(i.getName())+"</td>\n" +
					"\t\t\t\t<td>"+Utility.stringToHTML(i.getDescription())+"</td>\n" +
					"\t\t\t\t<td>"+i.getPrice()+
					(i.getDiscount() > 0 ? " ("+i.getDiscount()+"%)" : "") +
					"</td>\n" +
					"\t\t\t\t<td>"+i.getCount()+"</td>\n" +
					"\t\t\t</tr>\n";
		
		html += "\t\t</table>\n" +
				"\t<body>\n" +
				"</html>";

		file.write(html.getBytes("US-ASCII"));
		System.out.println("\nINFO Shop Item file list saved in "+filepath);
	}
	

	public String getName() {return shopname;}
	public String getCompanyName() {return super.getName();}
	public int getId() {return id;}
	public ItemList<ShopItem> getItems() {return items;}
	public int getItemCount() {return items.getCount();}
	public int getInvoicesCount() {return invoices.size();}
	public LinkedList<Invoice> getInvoices() {return invoices;}
	public LinkedList<String> getCategories() {return categories;}
}
