package items;

import item.GenericItem;
import item.ItemFeatureValue;

public class TVSet extends GenericItem {

	public TVSet(String nm, String br, Float pr, String desc, Integer inches) {
		super(br, nm, desc, pr);
		addFeature("Inches", new ItemFeatureValue(inches));
	}

	public Integer getInches() {return getFeature("Inches").getIntValue();}

}