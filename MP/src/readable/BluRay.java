package readable;

public class BluRay extends Readable {
	
	private BluRay(){};
	public BluRay(String title,String brand,Integer duration,Integer size){
		super(title,brand,duration,size);		
	}
	
	Readable createLeggibili(){return new BluRay();}

}
