package players;

import media.Media;
import media.Vinile;

public class Grammofono extends ConcretePlayer{

	private Grammofono(){}
	public Grammofono(String title,String brand){
		super(title,brand);
	}
	
	ConcretePlayer createPlayer(){return new Grammofono();}

	public void accept(Media m){
		if(m instanceof Vinile) {super.accept(m);}
		else System.out.println("Media non corretto per il tipo di lettore.");
	}
}
