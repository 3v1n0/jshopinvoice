package item;

public class ItemFeatureValue {
	private Object value;
	
	//FIXME null values... This is ambiguos, but it won't ever cause errors here
	
	public ItemFeatureValue(String s) {
		value = s;
	}
	
	public ItemFeatureValue(Integer i) {
		value = i;
	}

	public ItemFeatureValue(Double d) {
		value = d;
	}
	
	public ItemFeatureValue(Float f) {
		value = f;
	}
	
	public ItemFeatureValue(Boolean b) {
		value = b;
	}

	public String getStringValue() throws ItemFeatureValueException {
		if (!(value instanceof String))
			throw new ItemFeatureValueException();
		
		return (String)value;
	}
	
	public Integer getIntValue() throws ItemFeatureValueException {
		if (!(value instanceof Integer))
			throw new ItemFeatureValueException();
		
		return (Integer)value;
	}
	
	public Double getDoubleValue() throws ItemFeatureValueException {
		if (!(value instanceof Double))
			throw new ItemFeatureValueException();
		
		return (Double)value;
	}
	
	public Float getFloatValue() throws ItemFeatureValueException {
		if (!(value instanceof Float))
			throw new ItemFeatureValueException();
		
		return (Float)value;
	}
	
	public boolean getBooleanValue() throws ItemFeatureValueException {
		if (!(value instanceof Boolean))
			throw new ItemFeatureValueException();
		
		return (Boolean)value;
	}
	
	public Object getObjectValue() {
		return value;
	}
	
	public String toString() {
		if (value instanceof Boolean) {
			if ((Boolean)value)
				return "yes";
			else
				return "no";
		}

		if (value != null)
			return value.toString();
		else
			return "N/A";
	}
}
