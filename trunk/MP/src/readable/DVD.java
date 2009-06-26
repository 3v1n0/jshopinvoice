package readable;

public class DVD extends Readable {
	
	private DVD(){};
	public DVD(String title,String brand,Integer duration,Integer size){
		super(title,brand,duration,size);		
	}
	
	Readable createLeggibili(){return new DVD();}

}