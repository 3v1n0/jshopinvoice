package players;

import media.DVD;
import media.Media;

public class DVDPlayer extends ConcretePlayer{

	private DVDPlayer(){}
	public DVDPlayer(String title,String brand){
		super(title,brand);
	}
	
	ConcretePlayer createPlayer(){return new DVDPlayer();}

	public void accept(Media m){
		if(m instanceof DVD) {super.accept(m);}
		else System.out.println("Media non corretto per il tipo di lettore.");
	}
}
