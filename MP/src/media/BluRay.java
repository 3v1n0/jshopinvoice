package media;

public class BluRay extends Media {
	
	private String director;
	
	private BluRay(){};
	public BluRay(String title,String director, String brand,Integer duration,Integer size,String description,Float price){
		super(title,brand,duration,size,description,price);		
		this.director=director;
	}
	
	Media createLeggibili(){return new BluRay();}

	public String getName() { return super.getName()+director;}
}
