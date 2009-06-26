package media;

public class DVD extends Media {
	
	private String director;
	
	private DVD(){};
	public DVD(String title,String director, String distributedBy,Integer duration,Integer size,String description,Float price){
		super(title,distributedBy,duration,size,description,price);	
		this.director=director;
	}
	
	Media createMedia(){return new DVD();}

	public String getName() { return super.getName()+"-"+director;}
}