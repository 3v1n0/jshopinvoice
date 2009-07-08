package item;

public abstract class ItemDiscount extends Item {

	private Item item;
	private Integer discount;
	
	protected ItemDiscount(Item a) {
		item = a;
		discount = createDiscount();		
	}
	
	abstract Integer createDiscount();
	
	protected String createType() {return item.getType();}
	private void setItem(Item i) {item = i;}
	
	public String getType() {return item.getType();}
	public String getName() {return item.getName();}
	public String getBrand() {return item.getBrand();}
	public String getDescription() {return item.getDescription();}
	public ItemFeatures getFeatures() {return item.getFeatures();}
	public Float getPrice() {return (item.getPrice()-(item.getPrice()*discount/100));}
	public Integer getDiscount() {return discount;}
	public int getId() {return item.getId();}
	public int getCount() {return item.getCount();}

	public void setFeatures(ItemFeatures f) {item.setFeatures(f);};
	public ItemFeatureValue getFeature(String f) {return item.getFeature(f);}
	public void addFeature(String f, ItemFeatureValue v) {item.addFeature(f, v);}
	public void removeFeature(String f) {item.removeFeature(f);}
	
	public void setCount(int c) {item.setCount(c);}
	public void setId(int ID) {item.setId(ID);}

	public ItemList<? extends Item> getSubItems() throws SinglePartException {return item.getSubItems();}
	public int getSubItemsCount() throws SinglePartException {return item.getSubItemsCount();}
	public Item getSubItem(int n) throws SinglePartException {return item.getSubItem(n);}
	public void add(Item i) throws SinglePartException{item.add(i);}
	public void remove(Item i) throws SinglePartException{item.remove(i);}
	
	public boolean equals(Object i) {
		if (!(i instanceof Item))
			return false;
		
		Item it = (Item)i;
		/*
		System.out.println(getPrice()+" = "+it.getPrice()+" "+(this.getDiscount().equals(it.getDiscount()))+" "+(this.getDiscount().equals(it.getDiscount()))+
				" "+(item.equals(it) && this.getDiscount().equals(it.getDiscount()))+" "+item.equals(it));
		*/
//		return (item.equals(it) && this.getDiscount().equals(it.getDiscount())); //FIXME controllo sul prezzo
		return item.equals(it);
	}

	public ItemDiscount clone() {
		ItemDiscount itd = (ItemDiscount)super.clone();
		itd.setItem(item.clone());
		return itd;
	}
}
