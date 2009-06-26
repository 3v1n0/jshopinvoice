package mediaitems;
import item.Item;

public abstract class Media extends Item {
	
	private String title;
	private Integer duration;
	private String language; //list?!? TODO
	private Media mi;

	Media() {};
	Media(String b, String a, String t, Integer d, String l, String desc, Float p) {
		super(b, t, desc, p);
		mi = createMedia();
		title = t;
		language = l;
		duration = d;
	}
	
	abstract Media createMedia();
	
	public String getDescription(){
		String s;
		s = "Title:\t\t"+title+
			"\nBrand:\t\t"+getBrand()+
			"\nDuration:\t"+duration+
			"\nLanguage:\t"+language+
			"\nSupport:\t"+mi.getClass().getSimpleName()+"\nSize:\t";
		return s;
	}
	
	public String getTitle() {return title;}
	public String getLanguage() {return language;}
	public Integer getDuration() {return duration;}

}
