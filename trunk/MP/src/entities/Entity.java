package entities;

public abstract class Entity {
	private String name;
	private Address address;
	private Contacts contacts;

	
	protected Entity(String nm, Address adr, Contacts cnt) {
		name = nm;
		address = adr;
		contacts = cnt;
	}
	
	public String getName() {return name;}
	public Address getAddress() {return address;}
	public Contacts getContacts() {return contacts;}
}
