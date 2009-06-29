package item;

import java.util.LinkedList;

public class Package extends ConcreteItem {
	// classe composite del pattern composite
	private LinkedList<Item> items;
	
	
	public Package(String nm, String br, String desc) {
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
	
	//TODO is exception needed here?
	public void remove(Item i) throws SinglePartException {
		if (items.contains(i))
			items.remove(i);
		// TODO else throw exception?!?
	}
	
	public Item getChild(int n){
		return items.get(n);
	}
}