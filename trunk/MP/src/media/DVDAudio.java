package media;

public class DVDAudio extends Audio {
	
	private DVDAudio() {};
	public DVDAudio(String house, String auth, String title, Integer len,
					String genre, String lang, String desc, Float price) {
		super(house, auth, title, len, genre, lang, desc, price);
	}
	
	Media createMedia() {return new DVDAudio();}
	protected String createType() {return "Audio DVD";}
}
