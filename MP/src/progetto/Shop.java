package progetto;

import item.Item;

import java.util.LinkedList;

import people.Company;

public class Shop {
	private Company company;
	private String name;
	private LinkedList<Item> items;
	private int invoicenum;
	private static int id;
	
	Shop(Company c, String n) {
		company = c;
		name = n;
		invoicenum = 0;
		items = new LinkedList<Item>();
		id++;
	}
	
	public void addItem(Item i) {
		items.add(i);
	}
}
