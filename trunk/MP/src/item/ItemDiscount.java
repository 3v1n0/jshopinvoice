package item;

public abstract class ItemDiscount extends Item implements ItemInterface {

	Item obj;
	Integer discount;
	
	protected ItemDiscount(Item a){
		obj = a;
		discount = createDiscount();		
	}
	protected abstract Integer createDiscount();
	
/*
 *  Il decorator avvolge l'oggetto con un nuovo oggetto che per come lo creiamo noi ha i campi nome brand ecc
 *  nulli. se non facciamo l'overload dei metodi questi ritornano valori nulli mentre noi vogliamo che 
 *  ritornino i valori dell'oggetto avvolto, e questo lo otteniamo con la delegation a obj. E' descritto
 *  anche nel libro dei pattern. :p
 */ 
	
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
