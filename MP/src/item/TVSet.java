package item;

public class TVSet extends ConcreteItem {
// classe leaf del pattern composite	
	private Integer inches;

	public TVSet(String nm, String br, Float pr, String desc, Integer in) {
		super(br, nm, desc, pr);
		inches = in;
	}

	public Integer getInches() {return inches;}
	

}