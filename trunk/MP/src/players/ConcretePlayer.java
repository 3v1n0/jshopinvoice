package players;

import item.*;
import media.Media;

public abstract class ConcretePlayer extends Item implements Player{

	private Media read;

	private ConcretePlayer pl;
	
	ConcretePlayer(){}
	ConcretePlayer(String name,String brand,Float price,String description){
		super (brand, name, description, price);
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
		s = "Name: "+this.getName()+" Brand: "+this.getBrand()+" read \n\n"+read.getInfo();
		return s;
		}
	
	public void add(Item i)throws SinglePartException{
		throw new SinglePartException();		
		}
		
		public void remove(Item i)throws SinglePartException{
		throw new SinglePartException();		
		}
		
		public Item getChild(int n){ return null;}
}
