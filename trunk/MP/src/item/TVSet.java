package item;

public class TVSet extends Item{
	
	private Float inches;

	public TVSet(String nm, String br, Float pr, String desc,Float inch){
	super(nm,br,pr,desc);
	inches =inch;
	}

	public Float getInches() {return inches;}
	
	public String describe(){
		return "Name:\t"+name+"\nBrand:\t"+brand+"\nPrice:\t"+price+"\nInches:\t"+inches+"\nDescription:\n"+description;
	}

}
