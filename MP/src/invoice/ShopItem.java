package invoice;

import item.*;

public class ShopItem extends AbstractItem {
	private Item item;
	private int count;
	private int id;
	
	protected ShopItem(Item i, int id, int count) {
		item = i;
		this.id = id;
		this.count = count;
	}
	
	protected String createType() {return item.getType();}
	private void setItem(Item i) {item = i;}
	
	public String getType() {return item.getType();}
	public String getName() {return item.getName();}
	public String getBrand() {return item.getBrand();}
	public String getDescription() {return item.getDescription();}
	public ItemFeatures getFeatures() {return item.getFeatures();}
	public Float getPrice() {return item.getPrice();}
	public Integer getDiscount() {return item.getDiscount();}
	public int getId() {return id;}
	public int getCount() {return count;}

	public void setFeatures(ItemFeatures f) {item.setFeatures(f);};
	public ItemFeatureValue getFeature(String f) {return item.getFeature(f);}
	public void addFeature(String f, ItemFeatureValue v) {item.addFeature(f, v);}
	public void removeFeature(String f) {item.removeFeature(f);}
	
	public void setCount(int c) {if (c > 0) count = c; else count = 0;}
	public void setId(int ID) {id = ID;}

	public ItemList<? extends Item> getSubItems()throws SinglePartException {return item.getSubItems();}
	public int getSubItemsCount() throws SinglePartException {return item.getSubItemsCount();}
	public Item getSubItem(int n) throws SinglePartException {return item.getSubItem(n);}
	public void add(Item i) throws SinglePartException{item.add(i);}
	public void remove(Item i) throws SinglePartException{item.remove(i);}
	
	public boolean equals(Object i) {
		if (!(i instanceof Item))
			return false;
		
		Item it = (Item)i;
		
		return (item.equals(it) && it.getId() == this.getId());
	}

	public ShopItem clone() {
		ShopItem shi = (ShopItem)super.clone();
		shi.setItem(item.clone());
		return shi;
	}
}
