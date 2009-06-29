package progetto;

import item.ConcreteItem;
import entities.Company;
import java.util.LinkedList;


public class Shop extends Company {
	private String shopname;
	private LinkedList<ConcreteItem> items;
	private LinkedList<Invoice> invoices;
	private static int id;
	
	Shop(Company cmp, String nm) {
		super(cmp.getName(), cmp.getAddress(), cmp.getVATIN(), cmp.getPhone(),
			  cmp.getFax(), cmp.getMail(), cmp.getWeb());
		shopname = nm;
		invoices = new LinkedList<Invoice>();
		items = new LinkedList<ConcreteItem>();
		id++;
	}
	
	public void addItem(ConcreteItem i) {
		items.add(i);
	}
	
	public String getName() {return shopname;}
	public int getItemNum() {return items.size();}
	public LinkedList<Invoice> getInvoices() {return invoices;}
}
