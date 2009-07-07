package item;

public class ItemPackage<I extends Item> extends GenericItem {
	private ItemList<I> items;
	

	public ItemPackage(String nm, String br, String desc) {
		super(br, nm, desc, null);
		items = new ItemLinkedList<I>();
	}
	
	public Float getPrice() {
		float sum = 0;

		for (Item i : items)
			sum += i.getPrice() * i.getCount();

		return sum;
	}
	
	public ItemList<I> getSubItems() {
		return items;
	}
	
	public int getSubItemsCount() {
		return items.getCount();
	}

	@SuppressWarnings("unchecked")
	public void add(Item i) {
		items.add((I)i);
	}

	@SuppressWarnings("unchecked")
	public void remove(Item i) {
		items.remove((I)i);
	}
	
	public I getSubItem(int n) {
		return items.get(n);
	}
	
	protected String createType() {return "Item Package";}
}