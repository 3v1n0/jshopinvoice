package people;

public class Company extends Buyer {
	private String name;
	private String VATIN;
	private String web;
	
	Company(String n, Address ad, String v, String p, String f, String e, String w) {
		super(ad, p, f, e);
		name = n;
		VATIN = v;
		web = w;
	}
	
	public String toString() {
		return "";
	}
}
