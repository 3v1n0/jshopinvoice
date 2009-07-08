package items;

import item.GenericItem;
import item.ItemFeatureValue;
import players.*;

public class HiFi extends GenericItem {

	private final String POWER = "Power";

	public HiFi(String nm, String br, Float pr, String desc) {
		super(br, nm, desc, pr);
	}
	
	public HiFi(String nm, CDPlayer cdp,Speakers s,String desc) {
		super(cdp.getBrand(), nm, desc, (cdp.getPrice()+s.getPrice()));
		addFeature(POWER, new ItemFeatureValue(s.getPower()));
	}
	
	public Integer getPower() {return getFeature(POWER).getIntValue();}

}
