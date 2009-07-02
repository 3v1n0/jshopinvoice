package item;

import players.*;

public class HiFi extends GenericItem {
// classe leaf del pattern composite

	private Integer power;

	public HiFi(String nm, String br, Float pr, String desc) {
		super(br, nm, desc, pr);
	}
	
	public HiFi(String nm, CDPlayer cdp,Speakers s,String desc) {
		super(cdp.getBrand(), nm, desc, (cdp.getPrice()+s.getPrice()));
		power=s.getPower();
	}
	
	public Integer getPower() {return power;}

}
