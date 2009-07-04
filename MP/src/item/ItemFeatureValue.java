package item;

public class ItemFeatureValue {
	private Object value;
	
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
	
	protected Integer getIntValue() throws Exception {
		if (!(value instanceof Integer))
			throw new Exception();
		
		return (Integer)value;
	}
	
	protected Double getDoubleValue() throws Exception {
		if (!(value instanceof Double))
			throw new Exception();
		
		return (Double)value;
	}
	
	protected Float getFloatValue() throws Exception {
		if (!(value instanceof Float))
			throw new Exception();
		
		return (Float)value;
	}
	
	protected boolean getBooleanValue() throws Exception {
		if (!(value instanceof Boolean))
			throw new Exception();
		
		return (Boolean)value;
	}
	
	protected Object getObjectValue() {
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
