package item;

import java.util.HashMap;

public class ItemFeaturesHashMap extends ItemFeatures {
	private final HashMap<String, ItemFeatureValue> features;
	
	ItemFeaturesHashMap() {
		features = new HashMap<String, ItemFeatureValue>();
	}

	public Iterable<String> getKeys() {
		return features.keySet();
	}

	public ItemFeatureValue getValue(String key) {
		return features.get(key);
	}

	public Iterable<ItemFeatureValue> getValues() {
		return features.values();
	}

	public void add(String k, ItemFeatureValue v) {
		features.put(k, v);
	}

	public void remove(String k) {
		features.remove(k);		
	}
	
	public int size() {
		return features.size();
	}

	public boolean equals(Object o) {
		if (!(o instanceof ItemFeatures))
			return false;
		
		ItemFeaturesHashMap ft = (ItemFeaturesHashMap)o;
		System.out.println(features.size() +" "+ft.size());
		if (features.size() != ft.size())
			return false;
		
		ItemFeatureValue v1, v2;
		
		for (String k : getKeys()) {
			v1  = getValue(k);
			v2 = ft.getValue(k);
			
			if (v1 == null || v2 == null || v1 != v2)
				return false;
		}
			
		return true;
	}
	
	public ItemFeatures clone() {
		ItemFeatures ft = new ItemFeaturesHashMap();
		for (String k : getKeys())
			ft.add(k, getValue(k));
		
		return ft;
	}
}
