package item;

public class Decoder extends GenericItem{
	private final String scard = "SmartCard";
	
	public Decoder(String nm, String br, Float pr, String desc, boolean smartcard) {
		super(br, nm, desc, pr);
		addFeature(scard, new ItemFeatureValue(smartcard));
	}
	
		
	public boolean getSmartCard() throws Exception {return getFeature(scard).getBooleanValue();}
}
