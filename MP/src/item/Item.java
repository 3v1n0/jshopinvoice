package item;

//import java.util.HashMap;

public abstract class Item  {
// classe component del pattern composite
	
	private String name;
	private String brand;
	private Float price;
	private String description;
//	private HashMap<String, Object> features;
	private int id;
					// => TODO ShopItem that surrounds an Item with price and ID.
	
	
	protected Item() {};
	protected Item(String br, String nm, String desc, Float pr) {
		brand = br;
		name = nm;
		description = desc;
		price = pr;
		id = 0;
	}
	
	public void setId(int ID) {
		id = ID;
	}
	
	public String getBrand() {return brand;}
	public String getDescription() {return description;}
	public String getName() {return name;}
	public Float getPrice() {return price;}
	public Integer getDiscount() {return 0;}
	public int getId() {return id;}
	
	public int getItemsCount() throws SinglePartException {
		throw new SinglePartException(); //TODO return 1 anyway?
	}
	
	public void add(Item i) throws SinglePartException {
		throw new SinglePartException();
	}
	
	public void remove(Item i) throws SinglePartException {
		throw new SinglePartException();		
	}
	
	public Item getSubItem(int n){ return null;}
	
//	public void getFeatures() { // TODO????
//		for (String k : features.keySet()) {
//			System.out.println(k+" = "+features.get(k));
//		}
//	}

}
