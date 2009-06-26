package media;

public class Vinile extends Media {
	
	private String author;
	
	private Vinile(){};
	public Vinile(String title,String author, String brand,Integer duration,Integer size,String description,Float price){
		super(title,brand,duration,size,description,price);	
	}
	
	Media createLeggibili(){return new Vinile();}

	public String getName() { return super.getName()+author;}
}