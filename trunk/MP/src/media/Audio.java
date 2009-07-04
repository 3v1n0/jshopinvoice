package media;
import item.ItemFeatureValue;

public class Audio extends Media {

	protected Audio() {};
	protected Audio(String house, String auth, String title, Integer len,
					String genre, String lang, String desc, Float price) {
		super(house, title, len, genre, lang, desc, price);
		addFeature("Author", new ItemFeatureValue(auth));
	}
	
//	public String getInfo(){
//		String s;
//		s = "Author:\t\t"+getAuthor()+
////		super.getInfo() TODO alternativa possibile ???
//			"\nTitle:\t\t"+getTitle()+
//			"\nBrand:\t\t"+getBrand()+
//			"\nDuration:\t"+getDuration()+
//			"\nLanguage:\t"+getLanguage()+
//			"\nType:\t\t"+getMediaType()+
//			"\nSupport:\t"+getMedia();
//		return s;
//	}
	
	protected String createType() {return "Audio Media";}
	
	public String getAuthor() throws Exception {return getFeature("Author").getStringValue();}

	public String getName() {
		try {
			return getAuthor()+" - "+getTitle();
		} catch (Exception e) {
			return getTitle();
		}
	}
	
	Media createMedia() {return new Audio();}
	final Media createMediaType() {return new Audio();}

}
