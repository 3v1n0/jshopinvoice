package item;

import java.util.Collection;

public abstract class ItemFeatures {
	public abstract void add(String k, ItemFeatureValue v);
	public abstract void remove(String k);
	public abstract Collection<String> getKeys();
	public abstract Collection<ItemFeatureValue> getValues(); //TODO ItemFeature
	public abstract ItemFeatureValue getValue(String key);
	
	public String toString() {
		String out = "";
		
		for (String k : getKeys())
			out += k+": "+getValue(k).toString()+"\n";
		
		return out;		
	}
}
