package item;

public abstract class Item  {
// classe component del pattern composite
	
	private String name;
	private String brand;
	private Float price;
	private String description;
	private static int id; //FIXME this can't be static (=> every item will share it)!!!
						   //      An item has an ONLY ID when it is added to a shop...
						   // => TODO ShopItem that surrounds an Item with price and ID.
	
	
	protected Item() {};
	protected Item(String br, String nm, String desc, Float pr) {
		brand = br;
		name = nm;
		description = desc;
		price = pr;
		id++;
	}
	
	public String getBrand() {return brand;}
	public String getDescription() {return description;}
	public String getName() {return name;}
	public Float getPrice() {return price;}
	public int getId() {return id;}
	
	public int getCount() throws SinglePartException {
		throw new SinglePartException(); //TODO return 1 anyway?
	}
	
	public void add(Item i) throws SinglePartException {
		throw new SinglePartException();
	}
	
	public void remove(Item i) throws SinglePartException {
		throw new SinglePartException();		
	}
	
	public Item getSubItem(int n){ return null;}

}
