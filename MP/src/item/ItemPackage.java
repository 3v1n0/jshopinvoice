package item;

public class ItemPackage extends GenericItem {
	// classe composite del pattern composite
	private ItemList items; //TODO type AbstractItemList?
	

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
	
	public ItemList getSubItems() {
		return items;
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
	
	public Item getSubItem(int n) {
		return items.get(n);
	}
	
//	public ItemFeatures getFeatures() { //TODO merging them?
//		ItemFeatures features = new ItemFeaturesHashMap();
//
//		for (Item it : items)
//			for (String itf : it.getFeatures().getKeys())
//				features.add(itf, it.getFeatures().getValue(itf));
//			
//		return features;
//	}
}