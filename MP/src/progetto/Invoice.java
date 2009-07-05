package progetto;

import entities.*;
import item.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.Observable;

public class Invoice extends Observable {
	private Shop seller;
	private Entity buyer;
	private Date time;
	private ItemPackage invoice;
	private LinkedList<InvoicePrinter> printers;
	private int id;

	public Invoice(Shop sel, Entity buy) throws Exception {
		if (sel == null)
		    throw new IllegalArgumentException("Invalid Shop!!");
		
		invoice = new ItemPackage("Invoice", sel.getCompanyName(), sel.getName());
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
	
	public void add(Item a) throws Exception {
		if (a.getId() < 1)
			throw new Exception("Invalid Item ID!"); //TODO
		
		Item tmp = a.clone();
		boolean add = true;
		tmp.setCount(1);
	
		for (Item i : invoice.getSubItems()) {
			if (tmp.equals(i)) {
				i.setCount(i.getCount()+1);
				add = false;
			}
		}
	
		if (add)
			invoice.add(tmp);

		emitChange();
//		setChanged();
//		notifyObservers(a);
	}

	public void remove(Item a) {
		a.setCount(a.getCount()-1);
		
		if (a.getCount() < 1)
			invoice.remove(a);
	
		emitChange();
	}
	
	public int getId() {
		return id;
	}
	
	public ItemList getItems() {
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
	
	/* My Idea:
	 * invoice.setPrinter(new InvoicePrintStdout());
	 * invoice.print();
	 * 
	 * InvoicePrint html = new InvoicePrintHTML();
	 * html.setFile("ohoho.html");
	 * invoice.setPrinter(html);
	 * invoice.print(); // To be notified of changes by observer!!!
	 */
	
	public void addPrinter(InvoicePrinter ip) {
		if (ip != null) {
			printers.add(ip);
			ip.setInvoice(this);
		}
	}
	
	public void print() {
		for (InvoicePrinter p : printers)
			if (p != null && p.getInvoice() == this)
				p.print();
	}
}
