package entities;

public class Address {
	private String street;
	private Integer number;
	private String city;
	private String province;
	private Integer zip;
	private String country;
	
	public Address(String st, Integer no, String cy, String pr, Integer zp, String co) {
		street = st;
		number = no;
		city = cy;
		province = pr;
		zip = zp;
		country = co;
	}
	
	public String toString() {
		String out = street + ", " + number + "\n" +
					 zip + " - " + city + "\n" +
					 province + " - " + country + "\n";
		return out;
	}
	
	public String getStreet() {return street;}
	public Integer getNumber() {return number;}
	public String getCity() {return city;}
	public String getProvince() {return province;}
	public Integer getZip() {return zip;}
	public String getCountry() {return country;}
}
