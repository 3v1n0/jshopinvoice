package item;

public class ItemPackage extends GenericItem {
	// classe composite del pattern composite
	private ItemLinkedList items; //TODO type AbstractItemList?
	

	public ItemPackage(String nm, String br, String desc) {
		super(br, nm, desc, null);
		items = new ItemLinkedList();
	}
	
	public Float getPrice() {
		float sum = 0;

		for (Item i : items)
			sum += i.getPrice() * i.getCount();

		return sum;
	}
	
	public int getSubItemsCount() {
		return items.getCount();
	}

	public void add(Item i) {
		items.add(i);
		this.setCount(this.getCount() + 1);
	}

	public void remove(Item i) {
		if (getCount() > 0) {
			items.remove(i);
			this.setCount(this.getCount() - 1);
		}
	}
	
	public Item getSubItem(int n){
		return items.get(n);
	}
	
	public AbstractItemList getItemList() {
		return items;
	}
}