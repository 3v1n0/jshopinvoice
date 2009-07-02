package item;

//import java.util.HashMap;

public class GenericItem extends Item {
	
	private String type;
	private String name;
	private String brand;
	private Float price;
	private String description;
//	private HashMap<String, Object> features;
	private int id;
	private int count;
					// => TODO ShopItem that surrounds an Item with price and ID.
	
	protected GenericItem() {};
	protected GenericItem(String br, String nm, String desc, Float pr) {
		type = createType();
		brand = br;
		name = nm;
		description = desc;
		price = pr;
		id = 0;
		count = 1;
	}

	protected GenericItem(String br, String nm, String desc, Float pr, int num) {
		this(br, nm, desc, pr);
		//TODO if (num < 1) ...
		count = num;
	}
	
	protected String createType() {return "Item";} //TODO extend to missing sup
	
	public void setId(int ID) {
		id = ID;
	}
	
	public void setCount(int c) {
		count = c;
	}
	
	public String getType() {return type;}
	public String getBrand() {return brand;}
	public String getDescription() {return description;}
	public String getName() {return name;}
	public Float getPrice() {return price;}
	public Integer getDiscount() {return 0;}
	public int getId() {return id;}
	public int getCount() {return count;}
	
	public int getSubItemsCount() throws SinglePartException {
		throw new SinglePartException(); //TODO return 1 anyway?
	}
	
	public void add(Item i) throws SinglePartException {
		throw new SinglePartException();
	}
	
	public void remove(Item i) throws SinglePartException {
		throw new SinglePartException();		
	}
	
	public Item getSubItem(int n) throws SinglePartException { 
		throw new SinglePartException();
	}
	
//	public void getFeatures() { // TODO????
//		for (String k : features.keySet()) {
//			System.out.println(k+" = "+features.get(k));
//		}
//	}

}
