package item;

public class ItemDiscount10 extends ItemDiscount{

	public ItemDiscount10(Item obj){
		super(obj);
	}

	protected Integer createDiscount() {	return 10;	}

}
