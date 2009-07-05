package item;

public abstract class ItemFeatures {
	public abstract void add(String k, ItemFeatureValue v);
	public abstract void remove(String k);
	public abstract Iterable<String> getKeys();
	public abstract Iterable<ItemFeatureValue> getValues(); //TODO ItemFeature
	public abstract ItemFeatureValue getValue(String key);
	public abstract boolean equals(Object o);
	public abstract ItemFeatures clone();
	
	public String toString() {
		String out = "";
		
		for (String k : getKeys())
			out += k+": "+getValue(k).toString()+"\n";
		
		return out;		
	}
}
