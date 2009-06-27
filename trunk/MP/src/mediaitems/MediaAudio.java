package mediaitems;

public class MediaAudio extends Media {
	
	private String author;

	MediaAudio() {};
	public MediaAudio(String house, String auth, String title, Integer len,
					  String genre, String lang, String desc, Float price) {
		super(house, title, len, genre, lang, desc, price);
		author = auth;
	}
	
	public String getInfo(){
		String s;
		s = "Author:\t\t"+author+
			"\nTitle:\t\t"+getTitle()+
			"\nBrand:\t\t"+getBrand()+
			"\nDuration:\t"+getDuration()+
			"\nLanguage:\t"+getLanguage()+
			"\nType:\t\t"+getMediaType()+
			"\nSupport:\t"+getMedia();
		return s;
	}
	
	public String getAuthor() {return author;}
	public String getName() {return getAuthor()+" - "+getTitle();}
	
	Media createMedia() {return new MediaAudio();}
	Media createMediaType() {return new MediaAudio();}

}