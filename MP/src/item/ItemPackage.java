package item;

public class ItemPackage extends Item {
	// classe composite del pattern composite
	private ItemLinkedList items; //TODO type AbstractItemList?
	

	public ItemPackage(String nm, String br, String desc) {
		super(br, nm, desc, null);
		items = new ItemLinkedList();
	}
	
	public Float getPrice() {
		float sum = 0;

		for (Item i : items)
			sum += i.getPrice();

		return sum;
	}
	
	public int getItemsCount() {
		return items.getSize();
	}

	public void add(Item i) {
		items.add(i);
		this.setCount(this.getCount() + i.getCount());
		//TODO increment this.setcount of i.getCount() or 1 ???
	}
	
	public void remove(Item i) {
		items.remove(i);
		this.setCount(this.getCount() - i.getCount());
	}
	
	public Item getSubItem(int n){
		return items.get(n);
	}
	
	public AbstractItemList getItemList() {
		return items;
	}
}