package item;

import players.*;

public class Hi_Fi extends ConcreteItem {
// classe leaf del pattern composite

	private Integer power;

	Hi_Fi(String nm, String br, Float pr, String desc) {
		super(br, nm, desc, pr);
	}
	
	Hi_Fi(String nm, CDPlayer cdp,Speakers s,String desc) {
		super(cdp.getBrand(), nm, desc, (cdp.getPrice()+s.getPrice()));
		power=s.getPower();
	}
	
	public Integer getPower() {return power;}

}
