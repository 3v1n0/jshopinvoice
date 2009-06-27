package mediaitems;

public class CD extends MediaAudio {
	
	private CD() {};
	public CD(String house, String auth, String title, Integer len,
	   String genre, String lang, String desc, Float price) {
		super(house, auth, title, len, genre, lang, desc, price);
	}
	
	Media createMedia() {return new CD();}
}
