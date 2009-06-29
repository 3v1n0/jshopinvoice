package players;

import item.Item;
import item.SinglePartException;
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
	ConcretePlayer(String name,String brand,Float price,String description){
		this.name=name;
		this.brand=brand;
		this.price=price;
		this.description = description;
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
		s = "Name: "+name+" Brand: "+brand+" read \n\n"+read.getInfo();
		return s;
		}
	
	public String getBrand(){return brand;}
	public String getDescription(){return description;}
	public String getName(){return name;}
	public Float getPrice(){return price;}
	
	
	public void add(Item i)throws SinglePartException{
		throw new SinglePartException();		
		}
		
		public void remove(Item i)throws SinglePartException{
		throw new SinglePartException();		
		}
		
		public Item getChild(int n){ return null;}
}
