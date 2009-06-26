package mediaitems;

public class DVDAudio extends Media {
	
	private String author;
	
	DVDAudio() {};
	DVDAudio(String b, String t, String a, String brand, String g, Integer dur, String l, String desc, Float pr){
		super(b, a, t, dur, g, l, desc, pr);
		author = a;
	}
	
	Media createMedia() {return new DVDAudio();}

	public String getName() {return author+" - "+getTitle();}
}
