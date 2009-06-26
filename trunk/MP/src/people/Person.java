package people;

public class Person extends Buyer {
	private String name;
	private String surname;
	
	Person(String n, String s, Address ad, String v, String p, String f, String e, String w) {
		super(ad, p, f, e);
		name = n;
		surname = s;
	}
	
	public String toString() {
		return "";
	}

}
