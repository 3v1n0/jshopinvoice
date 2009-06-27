package item;

public abstract class ConcreteItem implements Item {
// classe component del pattern composite
	
	private String name;
	private String brand;
	private Float price;
	private String description;
	private static int id;
	
	
	protected ConcreteItem() {};
	protected ConcreteItem(String br, String nm, String desc, Float pr) {
		brand = br;
		name = nm;
		description = desc;
		price = pr;
		id++;
	}
	
	public String getBrand() {return brand;}
	public String getDescription() {return description;}
	public String getName() {return name;}
	public Float getPrice() {return price;}
	public int getId() {return id;}
	
	public void add(Item i)throws SinglePartException{
		if(!(this instanceof Composti)) throw new SinglePartException();		
	}
	
	public void remove(Item i)throws SinglePartException{
		if(!(this instanceof Composti)) throw new SinglePartException();		
	}
	
	public Item getChild(int n){ return null;}

}
