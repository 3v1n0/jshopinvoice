package players;

import media.BluRay;
import media.Media;

public class BluRayPlayer extends ConcretePlayer{

	private BluRayPlayer(){}
	public BluRayPlayer(String title,String brand,String description, Float price){
		super(title,brand,price,description);
	}
	
	ConcretePlayer createPlayer(){return new BluRayPlayer();}

	public void accept(Media m){
		if(m instanceof BluRay) {super.accept(m);}
		else System.out.println("Media non corretto per il tipo di lettore.");
	}
}
