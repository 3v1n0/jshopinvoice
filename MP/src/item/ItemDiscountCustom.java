package item;

public class ItemDiscountCustom extends ItemDiscount {
	Integer discount;

	protected ItemDiscountCustom(Item a, Integer disc) {
		super(a);
		discount = disc;
	}

	protected Integer createDiscount() {
		return discount;
	}
}
