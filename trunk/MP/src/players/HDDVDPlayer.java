package players;

import media.HDDVD;
import media.Media;

public class HDDVDPlayer extends ConcretePlayer{

	private HDDVDPlayer(){}
	public HDDVDPlayer(String title,String brand){
		super(title,brand);
	}
	
	ConcretePlayer createPlayer(){return new HDDVDPlayer();}

	public void accept(Media m){
		if(m instanceof HDDVD) {super.accept(m);}
		else System.out.println("Media non corretto per il tipo di lettore.");
	}
}
