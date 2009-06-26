package players;

import readable.BluRay;
import readable.Readable;

public class BluRayPlayer extends ConcretePlayer{

	private BluRayPlayer(){}
	public BluRayPlayer(String title,String brand){
		super(title,brand);
	}
	
	ConcretePlayer createPlayer(){return new BluRayPlayer();}

	public void accept(Readable m){
		if(m instanceof BluRay) {super.accept(m);}
		else System.out.println("Media non corretto per il tipo di lettore.");
	}
}
