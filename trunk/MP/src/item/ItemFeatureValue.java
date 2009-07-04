package item;

public class ItemFeatureValue {
	private Object value;
	
	//FIXME null values...
	
	public ItemFeatureValue(String s) { //TODO set them all protected!
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
	
	//FIXME add new proper exception based on http://mindprod.com/jgloss/exception.html
	public String getStringValue() throws Exception {
		if (!(value instanceof String))
			throw new Exception();
		
		return (String)value;
	}
	
	public Integer getIntValue() throws Exception {
		if (!(value instanceof Integer))
			throw new Exception();
		
		return (Integer)value;
	}
	
	public Double getDoubleValue() throws Exception {
		if (!(value instanceof Double))
			throw new Exception();
		
		return (Double)value;
	}
	
	public Float getFloatValue() throws Exception {
		if (!(value instanceof Float))
			throw new Exception();
		
		return (Float)value;
	}
	
	protected boolean getBooleanValue() throws Exception {
		if (!(value instanceof Boolean))
			throw new Exception();
		
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

		return value.toString();
	}
}
