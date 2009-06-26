package item;

public class Speakers extends Item{

	private Integer power;
	
	Speakers(String nm, String br, Float pr, String desc,Integer pwr) {
		super(nm, br, pr, desc);
		power = pwr;
	}

	public Integer getPower() {return power;}

}
