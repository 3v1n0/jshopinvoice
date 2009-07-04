package entities;

public class Contacts {
	private String phone;
	private String fax;
	private String email;
	private String web;
	
	public Contacts(String ph, String fx, String mail, String wb) {
		phone = ph;
		fax = fx;
		email = mail;
		web = wb;
	}
	
	public String getPhone() {return phone;}
	public String getFax() {return fax;}
	public String getMail() {return email;}
	public String getWeb() {return web;}

}
