package mediaitems;

public class DVD extends Media {
	
	private String director;
	
	DVD() {};
	DVD(String b, String t, String d, String brand, Integer dur, String l, String desc, Float pr){
		super(b, d, t, dur, l, desc, pr);
		director = d;
	}
	
	Media createMedia() {return new DVD();}

	public String getName() {return super.getTitle()+" by "+director;}
}