package item;

public class ItemDiscountCustom extends ItemDiscount {

	public ItemDiscountCustom(Item a, Integer disc) {
		super(a, disc);
	}

	protected Integer createDiscount() {
		return super.getDiscount();
	}
}
