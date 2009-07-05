package media;
import item.GenericItem;
import item.ItemFeatureValue;

public abstract class Media extends GenericItem {
	private Media mi;
	private Media mt;

	Media() {};
	Media(String house, Integer year, String title, Integer length,
		  String genre, String lang, String desc, Float price) {
		super(house, title, desc, price);
		mi = createMedia();
		mt = createMediaType();
		
		addFeature("Year", new ItemFeatureValue(year));
		addFeature("Title", new ItemFeatureValue(title));
		addFeature("Genre", new ItemFeatureValue(genre));
		addFeature("Language", new ItemFeatureValue(lang));
		addFeature("Duration", new ItemFeatureValue(length));
	}
	
	abstract Media createMedia();
	abstract Media createMediaType();
	
	public String getMedia() {
		return mi.getClass().getSimpleName();
	}
	
	public String getMediaType() {
		return mt.getClass().getSimpleName();
	}

//	public String getInfo(){
//		String s;
//		s = "Title:\t\t"+getTitle()+
//			"\nBrand:\t\t"+getBrand()+
//			"\nDuration:\t"+getDuration()+
//			"\nGenre:\t\t"+getGenre()+
//			"\nLanguage:\t"+getLanguage()+
//			"\nType:\t\t"+getMediaType();
//		return s;
//	}
	
	protected String createType() {return "Media";}
	
	public String getTitle() {return getFeature("Title").getStringValue();}
	public String getGenre() {return getFeature("Genre").getStringValue();}
	public String getLanguage() {return getFeature("Language").getStringValue();}
	public Integer getDuration() {return getFeature("Duration").getIntValue();}
}
