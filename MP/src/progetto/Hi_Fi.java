package progetto;

import players.*;

public class Hi_Fi extends Item{
	
	private Integer power;

	Hi_Fi(String nm, String br, Float pr, String desc) {
		super(nm, br, pr, desc);
	}
	
	Hi_Fi(String nm, CDPlayer cdp,Speakers s,String desc) {
		super(nm, cdp.getBrand(), (cdp.getPrice()+s.getPrice()), desc);
		power=s.getPower();
	}
	
	public Integer getPower() {return power;}

}
