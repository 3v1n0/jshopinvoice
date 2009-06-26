package progetto;

public abstract class Item implements ItemInterface{

	String name;
	String brand;
	Float price;
	String description;
	
	
	Item(String nm, String br, Float pr, String desc){
		name = nm;
		brand = br;
		price = pr;
		description = desc;
	}
	
	public String getBrand() {return brand;}
	public String getDescription() {return description;}
	public String getName() {return name;}
	public Float getPrice() {return price;}
	
	

}
