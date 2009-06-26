package readable;

public class Vinile extends Readable {
	
	private Vinile(){};
	public Vinile(String title,String brand,Integer duration,Integer size){
		super(title,brand,duration,size);		
	}
	
	Readable createLeggibili(){return new Vinile();}

}