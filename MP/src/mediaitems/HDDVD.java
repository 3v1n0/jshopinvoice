package mediaitems;

public class HDDVD extends Media {
	
	private String director;
	
	HDDVD() {};
	HDDVD(String b, String t, String d, String brand, Integer dur, String l, String desc, Float pr){
		super(b, d, t, dur, l, desc, pr);
		director = d;
	}
	
	Media createMedia() {return new HDDVD();}

	public String getName() {return super.getTitle()+" by "+director;}
}
