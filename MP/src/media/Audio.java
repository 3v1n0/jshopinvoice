package media;
import item.ItemFeatureValue;

public class Audio extends Media {

	protected Audio() {};
	protected Audio(String house, Integer year, String auth, String title,
					Integer len, String genre, String lang, String desc, Float price) {
		super(house, year, title, len, genre, lang, desc, price);
		addFeature("Author", new ItemFeatureValue(auth));
	}
	
	protected String createType() {return "Audio Media";}
	
	public String getAuthor() {return getFeature("Author").getStringValue();}

	public String getName() {
		if (getAuthor() != null) {
			return getAuthor()+" - "+getTitle();
		} else {
			return getTitle();
		}
	}

	Media createMedia() {return new Audio();}
	final Media createMediaType() {return new Audio();}
}
