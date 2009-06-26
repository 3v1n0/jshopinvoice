package players;

import readable.Readable;

public abstract class ConcretePlayer implements Player{

	private Readable read;
	private String name;
	private String brand;
	@SuppressWarnings("unused")
	private ConcretePlayer pl;
	
	ConcretePlayer(){}
	ConcretePlayer(String name,String brand){
		this.name=name;
		this.brand=brand;
		pl=createPlayer();
	}
	
	abstract ConcretePlayer createPlayer();
	
	public void accept(Readable m){
		read = m;
	}
	
	public String play() {
		String s;
		if( read == null )
		s = "Error: Insert a media.";
		else
		s = "Name: "+name+" Brand: "+brand+" read \n\n"+read.readLeggibile();
		return s;
		}
}
