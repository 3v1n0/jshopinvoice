package entities;

public class Company extends Entity {
	private String VATIN;
//	private Person manager;
	
	public Company(String n, Address ad, Contacts cnt, String v) {
		super(n, ad, cnt);
		VATIN = v;
	}

	public String getVATIN() {return VATIN;}
}
