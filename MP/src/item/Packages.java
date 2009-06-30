package item;

import java.util.LinkedList;

public class Packages extends Item {
	// classe composite del pattern composite
	private LinkedList<Item> items;
	

	public Packages(String nm, String br, String desc) { // senno fa ambiguita con la classe package di java
		super(br, nm, desc, null);
		items = new LinkedList<Item>();
	}
	
	public Float getPrice() {
		float sum = 0;

		for (Item i : items)
			sum += i.getPrice();

		return sum;
	}

	public void add(Item i) throws SinglePartException {
		items.add(i);		
	}
	
	
//dunno why but i think it's needed
	public void remove(Item i) {
		if (items.contains(i))
			items.remove(i);
	}
	
	public Item getChild(int n){
		return items.get(n);
	}
}