package players;

import media.HDDVD;
import media.Media;

public class HDDVDPlayer extends ConcretePlayer{

	private HDDVDPlayer(){}
	public HDDVDPlayer(String title,String brand,String description, Float price){
		super(title,brand,price,description);
	}
	
	ConcretePlayer createPlayer(){return new HDDVDPlayer();}

	public void accept(Media m){
		if(m instanceof HDDVD) {super.accept(m);}
		else System.out.println("Media non corretto per il tipo di lettore.");
	}
}
