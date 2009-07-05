package media;

public class BluRay extends Video {
	
	private BluRay() {};
	public BluRay(String house, Integer year,  String dir, String act, String title, Integer len,
		   String genre, String lang, String sub, String fmt, String desc, Float price) {
		super(house, year, dir, act, title, len, genre, lang, sub, fmt, desc, price);
	}
	
	Media createMedia() {return new BluRay();}
	
	protected String createType() {return "BluRay";}
}
