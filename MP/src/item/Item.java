package item;

public interface Item {
	public String getType();
	public String getName();
	public String getBrand();
	public String getDescription();
	public ItemFeatures getFeatures();
	public Float getPrice();
	public Integer getDiscount();
	public int getId();
	public int getCount();
	
	public void setFeatures(ItemFeatures f);
	public ItemFeatureValue getFeature(String f);
	public void addFeature(String f, ItemFeatureValue v);
	public void removeFeature(String f);

	public void setId(int ID);
	public void setCount(int c);

	public void add(Item i) throws SinglePartException;
	public void remove(Item i) throws SinglePartException;
	public ItemList<? extends Item> getSubItems() throws SinglePartException;
	public int getSubItemsCount() throws SinglePartException;
	public Item getSubItem(int n) throws SinglePartException;
	
	public Item clone();
	public boolean equals(Object i);
	
	public void accept(ItemVisitor iv);
}
