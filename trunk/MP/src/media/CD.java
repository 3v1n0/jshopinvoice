package media;

public class CD extends Audio {
	
	private CD() {};
	public CD(String house, Integer year, String auth, String title, Integer len,
			  String genre, String lang, String desc, Float price) {
		super(house, year, auth, title, len, genre, lang, desc, price);
	}
	
	Media createMedia() {return new CD();}
	protected String createType() {return "CD";}
}
