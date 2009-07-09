package invoice;

import item.*;
import entities.*;

import java.util.LinkedList;


public class Shop extends Company implements Shopper {
	private String shopname;
	private InvoiceObserver obs;
	private ItemList<ShopItem> items;
	private LinkedList<Invoice> invoices;
	private LinkedList<String> categories;
	private LinkedList<InvoicePrinter> iprinters;
	private LinkedList<Entity> clients;
	private LinkedList<ShopObserver> observers;
	private static int shops;
	private static int added;
	private int id;
	
	public Shop(Company cmp, String nm, Address add, Contacts cnt) {
		super(cmp.getName(), add, cnt, cmp.getVATIN());
		shopname = nm;
		invoices = new LinkedList<Invoice>();
		categories = new LinkedList<String>();
		clients = new LinkedList<Entity>();
		items = new ItemLinkedList<ShopItem>();
		iprinters = new LinkedList<InvoicePrinter>();
		observers = new LinkedList<ShopObserver>();
		obs = new InvoiceObserver();
		id = (++shops);
	}
	
	public Shop(Company cmp, String nm) {
		this(cmp, nm, cmp.getAddress(), cmp.getContacts());
	}

//	private Shop sh;
//	public static Shop createShop(Company cmp, String nm, Address add, Contacts cnt) {
//		if (sh == null)
//			sh = new Shop(cmp, nm, add, cnt);
//
//		return sh;
//	}
	
//	public static Shop createShop(Company cmp, String nm) {
//		return createShop(cmp, nm, cmp.getAddress(), cmp.getContacts());
//	}
	
	private ShopItem findItem(Item i) {
		for (int j = 0; j < items.getSize(); j++) {
			ShopItem sh = items.get(j);
			if (i.equals(sh))
				return sh;
		}

		return null;
	}
	
	public ShopItem addItem(Item i, int count) throws SinglePartException {
		
		ShopItem shf = ShopItemFactory.getShopItem(this, i, added+1, count);
		
		if (shf instanceof ShopItemPackage) {
			int min = 0;
			
			for (Item it : shf.getSubItems()) {
				ShopItem sh = findItem(it);
				if (sh != null) {
					if (sh.getCount() < min || min == 0)
						min = sh.getCount();
				} else {
					return null;
				}
			}
			count = (count < min ? count : min);
			shf.setCount(count);
		}
		
		ShopItem shi = findItem(i);
		
		if (shi == null) {
			shi = shf;
			items.add(shi);
			addCategory(shi.getType());
			added++;
		} else {
			if (shi instanceof ShopItemPackage)
				shi.setCount(count);
			else
				shi.setCount(shi.getCount() + count);
		}
		
		return shi;
	}
	
	public ShopItem addItem(Item i) throws Exception {
		return addItem(i, 1);
	}
	
	public void removeItem(Item i) {
		items.remove((ShopItem)i);
		removeCategory(i.getType());
	}
	
	protected void removeItemInstance(Item i) throws SinglePartException {
		ShopItem shi = findItem(i);
		
		if (shi instanceof ShopItemPackage) {
			for (Item it : i.getSubItems()) {
				ShopItem sh = findItem(it);
				if (sh != null) {
					sh.setCount(sh.getCount()-1);
				}
			}
		}
		
		if (shi != null) {
			if (shi.getCount() > 0) {
				shi.setCount(shi.getCount()-1);
				
				for (Item it : getItems()) {
					boolean found = false;
					try {
						for (Item sub : it.getSubItems())
							if (sub.equals(shi))
								found = true;
					} catch (SinglePartException e) {}
					
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

	public void addInvoice(Invoice i) {
		if (!invoices.contains(i)) {
			i.addObserver(obs);
			invoices.add(i);

			if (!clients.contains(i.getBuyer()))
				clients.add(i.getBuyer());
			
			for (InvoicePrinter ip : iprinters)
				i.addPrinter(ip);
		}
	}
	
	public void removeInvoice(Invoice i) {
		if (invoices.contains(i)) {
			i.deleteObservers();
			invoices.remove(i);
		}
	}
	
	public Invoice addCustomerInvoice(Entity buyer) throws Exception {
		Invoice i = new Invoice(this, buyer);
		addInvoice(i);
		return i;
	}
	
	public void addDefaultInvoicePrinter(InvoicePrinter ip) {
		iprinters.add(ip);

		for (Invoice inv : invoices)
			inv.addPrinter(ip);
	}
	
	public void addObserver(ShopObserver sho) {
		observers.add(sho);
	}
	
	public void deleteObserver(ShopObserver sho) {
		observers.remove(sho);
	}
	
	public void notifyObservers() {
		for (ShopObserver sho : observers)
			sho.update(this);
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Shop))
			return false;
		
		Shop sh = (Shop)o;
		return (sh.getId() == this.getId());
	}

	public String getName() {return shopname;}
	public Company getCompany() { return this; }
	public String getCompanyName() {return super.getName();}
	public int getId() {return id;}
	public ItemList<ShopItem> getItems() {return items;}
	public int getItemCount() {return items.getCount();}
	public int getInvoicesCount() {return invoices.size();}
	public LinkedList<Invoice> getInvoices() {return invoices;}
	public LinkedList<String> getCategories() {return categories;}
}
