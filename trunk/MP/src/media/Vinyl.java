package media;

public class Vinyl extends Audio {
	
	private Vinyl() {};
	public Vinyl(String house, String auth, String title, Integer len,
				  String genre, String lang, String desc, Float price) {
		super(house, auth, title, len, genre, lang, desc, price);
	}
	
	Media createMedia() {return new Vinyl();}
	protected String createType() {return "Vinyl";}
}