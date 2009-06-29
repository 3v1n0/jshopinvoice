package entities;

public class Company extends Entity {
	private String VATIN;
	private String web;
//	private Person manager;
	
	public Company(String n, Address ad, String v, String p, String f, String e, String w) {
		super(n, ad, p, f, e);
		VATIN = v;
		web = w;
	}

	public String getWeb() {return web;}
	public String getVATIN() {return VATIN;}
}
