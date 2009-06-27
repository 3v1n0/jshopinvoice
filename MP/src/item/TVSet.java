package item;

public class TVSet extends ConcreteItem {
// classe leaf del pattern composite	
	private Float inches;

	public TVSet(String nm, String br, Float pr, String desc, Float in) {
		super(br, nm, desc, pr);
		inches = in;
	}

	public Float getInches() {return inches;}
	

}