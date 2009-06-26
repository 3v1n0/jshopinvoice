package mediaitems;

public class BluRay extends Media {
	
	private String director;
	
	BluRay() {};
	BluRay(String b, String t, String d, String brand, Integer dur, String l, String desc, Float pr){
		super(b, d, t, dur, l, desc, pr);
		director = d;
	}
	
	Media createMedia() {return new BluRay();}

	public String getName() {return super.getTitle()+" by "+director;}
}
