package readable;

public class CD extends Readable {
	
	private CD(){};
	public CD(String title,String author,Integer duration,Integer size){
		super(title,author,duration,size);		
	}
	
	Readable createLeggibili(){return new CD();}

}
