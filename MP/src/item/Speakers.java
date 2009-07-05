package item;

public class Speakers extends GenericItem {
// classe leaf del pattern composite
	
	public Speakers(String nm, String br, Float pr, String desc, Integer power, Integer channels) {
		super(br, nm, desc, pr);
		addFeature("Power", new ItemFeatureValue(power));
		addFeature("Channels", new ItemFeatureValue(channels));
	}

	public Integer getPower() {return getFeature("Power").getIntValue();}
	public Integer getChannels() {return getFeature("Channels").getIntValue();}

}