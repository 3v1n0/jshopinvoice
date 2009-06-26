package mediaitems;

public class Vinile extends Media {
	
	private String author;
	
	Vinile() {};
	Vinile(String b, String t, String a, String brand, Integer dur, String l, String desc, Float pr){
		super(b, a, t, dur, l, desc, pr);
		author = a;
	}
	
	Media createMedia() {return new Vinile();}

	public String getName() {return author+" - "+getTitle();}
}