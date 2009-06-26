package media;

public class CD extends Media {
	
	private String author;
		
	private CD(){};
	public CD(String title,String author, String brand,Integer duration,Integer size,String description,Float price){
		super(title,brand,duration,size,description,price);	
		this.author=author;
	}
	
	Media createLeggibili(){return new CD();}
	
	public String getName() { return super.getName()+"-"+author;}

}
