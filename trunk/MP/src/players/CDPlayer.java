package players;

import readable.CD;
import readable.Readable;

public class CDPlayer extends ConcretePlayer{

	private CDPlayer(){}
	public CDPlayer(String title,String brand){
		super(title,brand);
	}
	
	public ConcretePlayer createPlayer(){return new CDPlayer();}

	public void accept(Readable m){ 		//TODO excp
		if(m instanceof CD) {super.accept(m);}
		else System.out.println("Media non corretto per il tipo di lettore.");
	}
}
