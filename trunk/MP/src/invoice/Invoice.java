package invoice;

import entities.*;
import item.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.Observable;


public class Invoice extends Observable {
	private Shop seller;
	private Entity buyer;
	private Date time;
	private ItemPackage<ShopItem> invoice;
	private LinkedList<InvoicePrinter> printers;
	private int id;

	public Invoice(Shop sel, Entity buy) throws Exception {
		if (sel == null)
		    throw new IllegalArgumentException("Invalid Shop!!");
		
		invoice = new ItemPackage<ShopItem>("Invoice", sel.getCompanyName(), sel.getName());
		seller = sel;
		buyer = buy;
		time = new Date(System.currentTimeMillis());
		printers = new LinkedList<InvoicePrinter>();
		id = seller.getInvoicesCount() + 1;
		seller.addInvoice(this);
	}
	
	private void emitChange() {
		setChanged();
		notifyObservers();
	}
	
	public void add(ShopItem si) throws Exception {	
		boolean add = true;
		
		if (si.getCount() < 1)
			return;
	
		for (Item i : invoice.getSubItems()) {
			if (si.equals(i)) {
				i.setCount(i.getCount()+1);
				add = false;
				break;
			}
		}
	
		if (add) {
			ShopItem shi = si.clone();
			shi.setCount(1);
			invoice.add(shi);
		}
		
		seller.removeItemInstance(si);

		emitChange();
	}

	public void remove(Item a) {
		a.setCount(a.getCount()-1);
		
		if (a.getCount() < 1)
			invoice.remove(a);
		
		seller.addItem(a);
	
		emitChange();
	}
	
	public int getId() {
		return id;
	}
	
	public ItemList<ShopItem> getItems() {
		return invoice.getSubItems();
	}

	public Float getTotal() {
		return invoice.getPrice();
	}
	
	public int getItemsCount() {
		return invoice.getSubItemsCount();
	}
	
	public Shop getSeller() {
		return seller;
	}
	
	public Entity getBuyer() {
		return buyer;
	}
	
	public Date getTime() {
		return time;
	}
	
	public void addPrinter(InvoicePrinter ip) {
		if (ip != null) {
			if (!printers.contains(ip)) {
				printers.add(ip);
				ip.setInvoice(this);
			}
		}
	}
	
	public void print() throws Exception {
		for (InvoicePrinter p : printers)
			if (p != null && p.getInvoice() == this)
				p.print();
			else 
				throw new IllegalStateException("No valid printer found for the invoice!");
	}
}
