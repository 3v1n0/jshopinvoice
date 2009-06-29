package item;

public interface Item {
//	public int getId(); //TODO!
	public String getBrand();
	public String getDescription();
	public String getName();
	//public String getInfo(); //TODO this should be class-specific.
	public Float getPrice();
	public void add(Item i)throws SinglePartException;
	public void remove(Item i)throws SinglePartException;
	public Item getChild(int n);
}
