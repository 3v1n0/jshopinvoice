package item;

import java.util.Collection;
import java.util.HashMap;

public class ItemFeaturesHashMap extends ItemFeatures {
	private final HashMap<String, ItemFeatureValue> features;
	
	ItemFeaturesHashMap() {
		features = new HashMap<String, ItemFeatureValue>();
	}

	public Collection<String> getKeys() {
		return features.keySet();
	}

	public ItemFeatureValue getValue(String key) {
		return features.get(key);
	}

	public Collection<ItemFeatureValue> getValues() {
		return features.values();
	}

	public void add(String k, ItemFeatureValue v) {
		features.put(k, v);
	}

	public void remove(String k) {
		features.remove(k);		
	}
}