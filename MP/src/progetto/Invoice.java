package progetto;

import entities.*;
import item.*;

import java.util.Date;
import java.util.Observable;

public class Invoice extends Observable {
	private Shop seller;
	private Entity buyer;
	private Date time;
	private ItemPackage invoice;
	private InvoicePrinter printer;
	private int id;
	//TODO keep trace of the duplicates

	public Invoice(Shop sel, Entity buy) throws Exception {
		if (sel == null)
		    throw new IllegalArgumentException("Invalid Shop!!");
		
		invoice = new ItemPackage("Invoice", sel.getCompanyName(), sel.getName());
		seller = sel;
		buyer = buy;
		time = new Date(System.currentTimeMillis());
		printer = null;
		id = seller.getInvoicesCount() + 1;
		seller.addInvoice(this);
	}
	
	private void emitChange() {
		setChanged();
		notifyObservers();
	}
	
	public void add(Item a) {
		Item tmp = a.clone();
		boolean add = true;
		tmp.setCount(1);
	
		for (Item i : invoice.getItemList()) {
			if (tmp.getId() == i.getId()) {
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
	
	public AbstractItemList getItems() {
		return invoice.getItemList();
	}

	public Float getTotal() {
		return invoice.getPrice();
	}
	
	public int getCount() {
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
	
	public void setPrinter(InvoicePrinter ip) {
		printer = ip;
		
		if (ip != null)
			ip.setInvoice(this);
	}
	
	public void print() {
		if (printer != null && printer.getInvoice() == this)
			printer.print();
		//else //TODO exception!
	}
}
