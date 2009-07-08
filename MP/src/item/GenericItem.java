package item;

public class GenericItem extends AbstractItem {

	private ItemFeatures features;
	
	protected GenericItem() {};
	protected GenericItem(String brand, String name, String desc, Float price) {
		features = new ItemFeaturesHashMap();
		addFeature("Type", new ItemFeatureValue(createType()));
		addFeature("Brand", new ItemFeatureValue(brand));
		addFeature("Name", new ItemFeatureValue(name));
		addFeature("Description", new ItemFeatureValue(desc));
		addFeature("Price", new ItemFeatureValue(price));
	}
	
	protected String createType() {return "Item";}
	
	public void setId(int ID) {}
	public void setCount(int ID) {}
	
	public String getType() {return getFeature("Type").getStringValue();}
	public String getBrand() {return getFeature("Brand").getStringValue();}
	public String getName() {return getFeature("Name").getStringValue();}
	public String getDescription() {return getFeature("Description").getStringValue();}
	public Float getPrice() {return getFeature("Price").getFloatValue();}
	public Integer getDiscount() {return 0;}
	public int getId() {return 0;}
	public int getCount() {return 1;}
	
	public int getSubItemsCount() throws SinglePartException {
		throw new SinglePartException();
	}
	
	public void add(Item i) throws SinglePartException {
		throw new SinglePartException();
	}
	
	public void remove(Item i) throws SinglePartException {
		throw new SinglePartException();		
	}
	
	public ItemList<? extends Item> getSubItems() throws SinglePartException { 
		throw new SinglePartException();
	}
	
	public Item getSubItem(int n) throws SinglePartException { 
		throw new SinglePartException();
	}
	
	public void setFeatures(ItemFeatures f) {
		features = f;
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
	
	public boolean equals(Object i) {
		if (!(i instanceof Item))
			return false;	
		
		Item it = (Item)i;
		
		if (it.getType().equals(this.getType()) &&
			it.getBrand().equals(this.getBrand()) &&
			it.getName().equals(this.getName()) &&
			it.getDescription().equals(this.getDescription()) &&
			it.getFeatures().equals(this.getFeatures()))
			return true;
		else
			return false;
	}
	
	public GenericItem clone() {
		GenericItem i = (GenericItem)super.clone();
		i.setFeatures((getFeatures().clone()));
		return i;
	}
}
