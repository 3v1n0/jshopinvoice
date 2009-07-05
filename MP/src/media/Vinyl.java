package media;

public class Vinyl extends Audio {
	
	private Vinyl() {};
	public Vinyl(String house, Integer year, String auth, String title, Integer len,
				  String genre, String lang, String desc, Float price) {
		super(house, year, auth, title, len, genre, lang, desc, price);
	}
	
	Media createMedia() {return new Vinyl();}
	protected String createType() {return "Vinyl";}
}