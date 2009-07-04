package item;

public interface ItemInterface {
	public String getType();
	public String getName();
	public String getBrand();
	public String getDescription();
	public ItemFeatures getFeatures();
	public Float getPrice();
	public Integer getDiscount();
	public int getId();
	public int getCount();
	
	public void addFeature(String f, ItemFeatureValue v); //TODO protected?
	public void removeFeature(String f); //TODO protected?

	public void setId(int ID);
	public void setCount(int c);

	public void add(Item i) throws SinglePartException;
	public void remove(Item i) throws SinglePartException;
	public int getSubItemsCount() throws SinglePartException;
	public Item getSubItem(int n) throws SinglePartException;
	
//	public Item clone();
}
