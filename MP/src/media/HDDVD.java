package media;

public class HDDVD extends Video {
	
	private HDDVD() {};
	public HDDVD(String house, Integer year, String dir, String act, String title, Integer len,
				 String genre, String lang, String sub, String fmt, String desc, Float price) {
		super(house, year, dir, act, title, len, genre, lang, sub, fmt, desc, price);
	}
	
	Media createMedia() {return new HDDVD();}
	protected String createType() {return "HDDVD";}
}
