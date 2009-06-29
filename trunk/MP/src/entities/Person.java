package entities;

public class Person extends Entity {
	private String name;
	private String surname;
	
	public Person(String n, String s, Address ad, String v, String p, String f, String e, String w) {
		super(n, ad, p, f, e);
		surname = s;
	}
	
	public String getFirstName() {return name;}
	public String getLastName() {return surname;}
	public String getName() {return getFirstName()+" "+getLastName();}

}
