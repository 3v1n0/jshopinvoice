package item;

public abstract class Item implements ItemInterface {

	String name;
	String brand;
	Float price;
	String description;
	
	Item(String br, String nm, String desc, Float pr) {
		brand = br;
		name = nm;
		description = desc;
		price = pr;
	}
	
	public String getBrand() {return brand;}
	public String getDescription() {return description;}
	public String getName() {return name;}
	public Float getPrice() {return price;}

}
