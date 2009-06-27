package item;

public abstract class Item implements ItemInterface {

	private String name;
	private String brand;
	private Float price;
	private String description;
	private static int id;
	
	
	protected Item() {};
	protected Item(String br, String nm, String desc, Float pr) {
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

}
