package item;

public interface ItemInterface {
	public String getBrand();
	public String getDescription();
	public String getName();
	public Float getPrice();
	public Integer getDiscount();
	public int getId();
	public int getCount();

	public void setId(int ID);
	public void setCount(int c);

	public void add(Item i) throws SinglePartException;
	public void remove(Item i) throws SinglePartException;
	public int getSubItemsCount() throws SinglePartException;
	public Item getSubItem(int n) throws SinglePartException;
	
	public Item clone();
}
