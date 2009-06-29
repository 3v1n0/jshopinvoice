package media_old;

public class HDDVD extends Media {
	
	private String director;
	
	private HDDVD(){};
	public HDDVD(String title,String director, String brand,Integer duration,Integer size,String description,Float price){
		super(title,brand,duration,size,description,price);	
		this.director=director;
	}
	
	Media createMedia(){return new HDDVD();}
	
	public String getName() { return super.getName()+"-"+director;}

}
