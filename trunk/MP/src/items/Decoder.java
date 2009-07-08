package items;

import item.GenericItem;
import item.ItemFeatureValue;

public class Decoder extends GenericItem{
	private final String SMARTCARD = "SmartCard";
	
	public Decoder(String nm, String br, Float pr, String desc, boolean smartcard) {
		super(br, nm, desc, pr);
		addFeature(SMARTCARD, new ItemFeatureValue(smartcard));
	}
	
		
	public boolean getSmartCard() {return getFeature(SMARTCARD).getBooleanValue();}
}
