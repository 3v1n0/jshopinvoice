package entities;

public class Person extends Entity {
	private String name;
	private String surname;
	
	public Person(String n, String s, Address ad, Contacts cnt) {
		super(n, ad, cnt);
		name=n;
		surname = s;
	}
	
	public String getFirstName() {return name;}
	public String getLastName() {return surname;}
	public String getName() {return getFirstName()+" "+getLastName();}

}
