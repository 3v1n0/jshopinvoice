package entities;

public abstract class Entity {
	private String name;
	private Address address;
	private String phone;
	private String fax;
	private String email;
	
	protected Entity(String nm, Address adr, String phn, String fx, String mail) {
		name = nm;
		address = adr;
		phone = phn;
		fax = fx;
		email = mail;
	}
	
	public String getName() {return name;}
	public Address getAddress() {return address;}
	public String getPhone() {return phone;}
	public String getFax() {return fax;}
	public String getMail() {return email;}
}
