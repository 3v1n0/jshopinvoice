package progetto;

import item.ConcreteItem;

import java.util.LinkedList;

import people.Company;

public class Shop {
	private Company company;
	private String name;
	private LinkedList<ConcreteItem> items;
	private int invoicenum;
	private static int id;
	
	Shop(Company c, String n) {
		company = c;
		name = n;
		invoicenum = 0;
		items = new LinkedList<ConcreteItem>();
		id++;
	}
	
	public void addItem(ConcreteItem i) {
		items.add(i);
	}
}
