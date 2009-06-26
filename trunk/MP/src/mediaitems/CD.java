package mediaitems;

public class CD extends Media {
	
	private String author;
	
	CD() {};
	CD(String b, String t, String a, String brand, String g, Integer dur, String l, String desc, Float pr){
		super(b, a, t, dur, g, l, desc, pr);
		author = a;
	}
	
	Media createMedia() {return new CD();}

	public String getName() {return author+" - "+getTitle();}
}
