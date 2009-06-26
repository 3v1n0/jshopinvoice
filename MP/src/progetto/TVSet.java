package progetto;

public class TVSet implements Item{
	
	String name;
	String brand;
	Double price;
	String description;

	public TVSet(String nm, String br, Double pr, String desc){
	name = nm;
	brand = br;
	price = pr;
	description = desc;
	}
	public String getBrand() {return brand;}
	public String getDescription() {return description;}
	public String getName() {return name;}
	public Double getPrice() {return price;}
	

}
