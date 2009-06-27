package mediaitems;

public class Vinile extends Audio {
	
	private Vinile() {};
	public Vinile(String house, String auth, String title, Integer len,
				  String genre, String lang, String desc, Float price) {
		super(house, auth, title, len, genre, lang, desc, price);
	}
	
	Media createMedia() {return new Vinile();}
}