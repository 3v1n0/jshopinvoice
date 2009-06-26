package players;

import media.Media;

public abstract class ConcretePlayer implements Player{

	private Media read;
	private String name;
	private String brand;
	private Float price;
	private String description;
	@SuppressWarnings("unused")
	private ConcretePlayer pl;
	
	ConcretePlayer(){}
	ConcretePlayer(String name,String brand){
		this.name=name;
		this.brand=brand;
		pl=createPlayer();
	}
	
	abstract ConcretePlayer createPlayer();
	
	public void accept(Media m){
		read = m;
	}
	
	public String play() {
		String s;
		if( read == null )
		s = "Error: Insert a media.";
		else
		s = "Name: "+name+" Brand: "+brand+" read \n\n"+read.readLeggibile();
		return s;
		}
	
	public String getBrand(){return brand;}
	public String getDescription(){return description;}
	public String getName(){return name;}
	public Float getPrice(){return price;}
}
