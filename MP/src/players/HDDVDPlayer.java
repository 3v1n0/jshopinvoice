package players;

import readable.HDDVD;
import readable.Readable;

public class HDDVDPlayer extends ConcretePlayer{

	private HDDVDPlayer(){}
	public HDDVDPlayer(String title,String brand){
		super(title,brand);
	}
	
	ConcretePlayer createPlayer(){return new HDDVDPlayer();}

	public void accept(Readable m){
		if(m instanceof HDDVD) {super.accept(m);}
		else System.out.println("Media non corretto per il tipo di lettore.");
	}
}
