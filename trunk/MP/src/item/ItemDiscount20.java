package item;

public class ItemDiscount20 extends ItemDiscount{
	
	public ItemDiscount20(Item obj){
		super(obj);
	}

	protected Integer createSconto() {	return 20;	}

}
