package item;

//import java.util.HashMap;

public class GenericItem extends Item implements Cloneable {
	
	private String type;
	private String name;
	private String brand;
	private Float price;
	private String description;
	private ItemFeatures features;
	private int id;
	private int count;
					// => TODO ShopItem that surrounds an Item with price and ID.
	
	protected GenericItem() {};
	protected GenericItem(String br, String nm, String desc, Float pr, int num) {
		type = createType();
		brand = br;
		name = nm;
		description = desc;
		price = pr;
		id = 0;
		count = num;
		features = new ItemFeaturesHashMap();
	}
	
	protected GenericItem(String br, String nm, String desc, Float pr) {
		this(br, nm, desc, pr, 1);
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
		throw new SinglePartException();
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
	
	public void addFeature(String f, ItemFeatureValue v) {
		features.add(f, v);
	}

	public ItemFeatures getFeatures() {
		return features;
	}
	
	public ItemFeatureValue getFeature(String f) {
		return getFeatures().getValue(f);
	}

	public void removeFeature(String f) {
		features.remove(f);
	}
}
