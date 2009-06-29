package media;
import item.ConcreteItem;

public abstract class Media extends ConcreteItem {
	
	private String title;
	private Integer duration;
	private String genre;
	private String language; //list?!? TODO
	//private int medianum; // numero di dischi?!? TODO
	//private Integer year; // TODO???
	private Media mi;
	private Media mt;

	Media() {};
	Media(String house, String tit, Integer len, String gen,
		  String lang, String desc, Float price) {
		super(house, tit, desc, price);
		mi = createMedia();
		mt = createMediaType();
		title = tit;
		genre = gen;
		language = lang;
		duration = len;
	}
	
	abstract Media createMedia();
	abstract Media createMediaType();
	
	public String getMedia() {
		return mi.getClass().getSimpleName();
	}
	
	public String getMediaType() {
		return mt.getClass().getSimpleName();
	}

	public String getInfo(){
		String s;
		s = "Title:\t\t"+title+
			"\nBrand:\t\t"+getBrand()+
			"\nDuration:\t"+duration+
			"\nGenre:\t\t"+genre+
			"\nLanguage:\t"+language+
			"\nType:\t\t"+getMediaType();
		return s;
	}
	
	public String getTitle() {return title;}
	public String getGenre() {return genre;}
	public String getLanguage() {return language;}
	public Integer getDuration() {return duration;}

}
