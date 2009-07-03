package item;

public abstract class ItemDiscount extends Item {

	private Item obj;
	private Integer discount;
	
	protected ItemDiscount(Item a){
		obj = a;
		discount = createDiscount();		
	}
	
	public ItemDiscount(Item a, Integer disc){
		obj = a;
		discount = disc;		
	}
	
	protected abstract Integer createDiscount();
	protected String createType() {return obj.getType();}
	
	public String getType() {return obj.getType();}
	public String getBrand() {return obj.getBrand();}
	public String getDescription() {return obj.getDescription();}
	public String getName() {return obj.getName();}
	public Float getPrice() {return (obj.getPrice()-(obj.getPrice()*discount/100));}
	public Integer getDiscount() {return discount;}
	public int getId() {return obj.getId();}
	public int getCount() {return obj.getCount();}
	
	public void setCount(int c) {obj.setCount(c);}
	public void setId(int ID) {obj.setId(ID);}

	public int getSubItemsCount() throws SinglePartException {return obj.getSubItemsCount();}
	public void add(Item i)throws SinglePartException{obj.add(i);}
	public void remove(Item i)throws SinglePartException{obj.remove(i);}
	public Item getSubItem(int n)throws SinglePartException {return obj.getSubItem(n);}
}
