package item;

public abstract class ItemDiscount extends Item {

	Item item;
	Integer discount;
	
	protected ItemDiscount(Item a){
		item = a;
		discount = createDiscount();		
	}
	protected abstract Integer createDiscount();
	
	protected String createType() {return item.getType();}
	
	public String getType() {return item.getType();}
	public String getName() {return item.getName();}
	public String getBrand() {return item.getBrand();}
	public String getDescription() {return item.getDescription();}
	public ItemFeatures getFeatures() {return item.getFeatures();}
	public Float getPrice() {return (item.getPrice()-(item.getPrice()*discount/100));}
	public Integer getDiscount() {return discount;}
	public int getId() {return item.getId();}
	public int getCount() {return item.getCount();}
	
	public ItemFeatureValue getFeature(String f) {return item.getFeature(f);}
	public void addFeature(String f, ItemFeatureValue v) {item.addFeature(f, v);}
	public void removeFeature(String f) {item.removeFeature(f);}
	
	public void setCount(int c) {item.setCount(c);}
	public void setId(int ID) {item.setId(ID);}

	public ItemList getSubItems()throws SinglePartException {return item.getSubItems();}
	public int getSubItemsCount() throws SinglePartException {return item.getSubItemsCount();}
	public Item getSubItem(int n)throws SinglePartException {return item.getSubItem(n);}
	public void add(Item i)throws SinglePartException{item.add(i);}
	public void remove(Item i)throws SinglePartException{item.remove(i);}
}
