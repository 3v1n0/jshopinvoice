package progetto;

import item.Item;
import item.ItemLinkedList;
import entities.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;


public class Shop extends Company {
	private static Shop sh;
	private String shopname;
	private InvoiceObserver obs;
	private ItemLinkedList items;
	private LinkedList<Invoice> invoices;
	private LinkedList<String> categories;
	//private LinkedList<Entity> clients; //TODO??? no.
	private static int shops;
	private static int added;
	private int id;
	
	private Shop(Company cmp, String nm) {
		super(cmp.getName(), cmp.getAddress(), cmp.getVATIN(), cmp.getPhone(),
			  cmp.getFax(), cmp.getMail(), cmp.getWeb());
		shopname = nm;
		invoices = new LinkedList<Invoice>();
		categories = new LinkedList<String>();
		items = new ItemLinkedList();
		obs = new InvoiceObserver();
		id = (++shops);
	}
	
	public static Shop createShop(Company cmp, String nm) {
		if (sh==null) sh = new Shop(cmp, nm);
		return sh;
	}
	public void addItem(Item i) {
		//TODO clone item??? It would need to re-implement clone for all!
		//Item tmp = i.clone(); 
		i.setId(++added);
		items.add(i);
		addCategory(i.getType());
	}
	
	public void removeItem(Item i) {
		i.setId(0);
		items.remove(i);
		removeCategory(i.getType());
	}
	
	private boolean findCategory(String cat) {
		
		for (String c : categories)
			if (c == cat)
				return true;

		return false;
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
		
		if (!catfound && !findCategory(cat))
			categories.remove(cat);
	}

	protected void addInvoice(Invoice i) {
		if (!invoices.contains(i)) {
			i.addObserver(obs);
			invoices.add(i);
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
				"\t\t\t</tr>\n";
		
		for (Item i : items)
			html += "\t\t\t<tr id='"+i.getId()+"'>\n" +
					"\t\t\t\t<td>"+stringToHTML(i.getName())+"</td>\n" +
					"\t\t\t\t<td>"+stringToHTML(i.getDescription())+"</td>\n" +
					"\t\t\t\t<td>"+i.getPrice()+
					(i.getDiscount() > 0 ? " ("+i.getDiscount()+"%)" : "") +
					"</td>\n" +
					"\t\t\t</tr>\n";
		
		html += "\t\t</table>\n" +
				"\t<body>\n" +
				"</html>";

		file.write(html.getBytes("US-ASCII"));
		System.out.println("\nINFO Shop Item file list saved in "+filepath);
	}
	
	// Move as a static method to an utility class?
	private String stringToHTML(String str) {
		String tstr = "";
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch (c) {
				case '<':
					tstr += "&lt;";
					break;
				case '>':
					tstr += "&gt;";
					break;
				case '"':
					tstr += "&quot;";
					break;
				case '&':
					tstr += "&amp;";
					break;
				default:
					if (c > 0x7f)
						tstr += "&#"+(int)c+";";
					else
						tstr += c;
			}
		}
		
		return tstr.toString();
	}

	public String getName() {return shopname;}
	public String getCompanyName() {return super.getName();}
	public int getId() {return id;}
	public int getItemCount() {return items.getCount();}
	public int getInvoicesCount() {return invoices.size();}
	public LinkedList<Invoice> getInvoices() {return invoices;}
	public LinkedList<String> getCategories() {return categories;}
}
