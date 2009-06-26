package media;

public class DVD extends Media {
	
	private String director;
	
	private DVD(){};
	public DVD(String title,String director, String brand,Integer duration,Integer size,String description,Float price){
		super(title,brand,duration,size,description,price);	
		this.director=director;
	}
	
	Media createLeggibili(){return new DVD();}

	public String getName() { return super.getName()+director;}
}