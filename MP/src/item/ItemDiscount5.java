package item;

public class ItemDiscount5 extends ItemDiscount{
	
	public ItemDiscount5(Item obj){
		super(obj);
	}

	protected Integer createDiscount() {	return 5;	}

}
