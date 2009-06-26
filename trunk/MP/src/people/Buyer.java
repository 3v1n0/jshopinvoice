package people;

public abstract class Buyer {
	private Address address;
	private String phone;
	private String fax;
	private String email;
	
	Buyer(Address ad, String p, String f, String e) {
		address = ad;
		phone = p;
		fax = f;
		email = e;
	}
	
	public Address getAddress() {
		return address;
	}
}
