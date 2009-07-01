package item;

public class Packages extends Item {
	// classe composite del pattern composite
	private ItemLinkedList items; //TODO type AbstractItemList?
	

	public Packages(String nm, String br, String desc) { // senno fa ambiguita con la classe package di java
		super(br, nm, desc, null);
		items = new ItemLinkedList();
	}
	
	public Float getPrice() {
		float sum = 0;

		for (Item i : items)
			sum += i.getPrice();

		return sum;
	}
	
	public int getCount() {
		return items.getSize();
	}

	public void add(Item i) throws SinglePartException {
		items.add(i);		
	}
	
	public void remove(Item i) {
		items.remove(i);
	}
	
	public Item getSubItem(int n){
		return items.get(n);
	}
	
	public AbstractItemList getItemList() {
		return items;
	}
}