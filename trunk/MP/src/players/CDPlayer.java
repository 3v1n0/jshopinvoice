package players;

import media.CD;
import media.Media;

public class CDPlayer extends ConcretePlayer{

	private CDPlayer(){}
	public CDPlayer(String title,String brand,String description, Float price){
		super(title,brand,price,description);
	}
	
	ConcretePlayer createPlayer() {return new CDPlayer();}

	public void accept(Media m) {
		if (m instanceof CD) {super.accept(m);}
		else System.out.println("Media non corretto per il tipo di lettore.");
	}
}
