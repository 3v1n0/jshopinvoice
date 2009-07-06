package item;

public /*abstract*/ class ItemPackage<I extends Item> extends GenericItem /* implements Iterable TODO redoundant? */ {
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
//		this.setCount(this.getCount() + 1);
	}

	@SuppressWarnings("unchecked")
	public void remove(Item i) {
//		if (getCount() > 0) {
			items.remove((I)i);
//			this.setCount(this.getCount() - 1);
//		}
	}
	
	public I getSubItem(int n) {
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