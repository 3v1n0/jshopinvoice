package item;

import players.*;

public class HiFi extends GenericItem {
// classe leaf del pattern composite

	private final String pw = "Power";

	public HiFi(String nm, String br, Float pr, String desc) {
		super(br, nm, desc, pr);
	}
	
	public HiFi(String nm, CDPlayer cdp,Speakers s,String desc) {
		super(cdp.getBrand(), nm, desc, (cdp.getPrice()+s.getPrice()));
		addFeature(pw, new ItemFeatureValue(s.getPower()));
	}
	
	public Integer getPower() throws Exception {return getFeature(pw).getIntValue();}

}
