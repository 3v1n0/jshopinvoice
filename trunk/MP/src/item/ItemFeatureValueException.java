package item;

@SuppressWarnings("serial")
public class ItemFeatureValueException extends IllegalArgumentException {

	public ItemFeatureValueException(String e) {
		super(e);
	}

	public ItemFeatureValueException() {
		this("Bad Item Feature value requested, type mismatch!");
	}
}
