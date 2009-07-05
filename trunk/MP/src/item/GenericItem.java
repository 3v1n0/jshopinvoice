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
		//TODO add type, brand, name, desc, price as ItemFeatures?
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
	
	public ItemFeatures getFeatures() {
		return features;
	}
	
	public void addFeature(String f, ItemFeatureValue v) {
		getFeatures().add(f, v);
	}
	
	public ItemFeatureValue getFeature(String f) throws ItemFeatureValueException {
		ItemFeatureValue v = getFeatures().getValue(f);
		
		if (v == null)
			throw new ItemFeatureValueException("Bad Item Feature value requested, the key doesn't exist!");
			
		return v;
	}

	public void removeFeature(String f) {
		getFeatures().remove(f);
	}
}
