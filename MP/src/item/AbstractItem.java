package item;

public abstract class AbstractItem implements Item, Cloneable {

	public abstract String getType();
	public abstract String getBrand();
	public abstract String getName();
	public abstract String getDescription();
	public abstract ItemFeatures getFeatures();
	public abstract Float getPrice();
	public abstract Integer getDiscount();
	public abstract int getId();
	public abstract int getCount();
	
	protected abstract String createType();

	public abstract void setId(int ID);
	public abstract void setCount(int c);
	
	public abstract void setFeatures(ItemFeatures f);
	public abstract ItemFeatureValue getFeature(String f);
	public abstract void addFeature(String f, ItemFeatureValue v);
	public abstract void removeFeature(String f);

	public abstract void add(Item i) throws SinglePartException;
	public abstract void remove(Item i) throws SinglePartException;
	public abstract ItemList<? extends Item> getSubItems() throws SinglePartException;
	public abstract int getSubItemsCount() throws SinglePartException;
	public abstract Item getSubItem(int n) throws SinglePartException;
	
	public abstract boolean equals(Object i);
	public abstract void accept(ItemVisitor iv);
	
	public Item clone() {
		try {
			return (Item) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
