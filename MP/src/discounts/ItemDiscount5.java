package discounts;

import item.Item;
import item.ItemDiscount;

public class ItemDiscount5 extends ItemDiscount{
	
	public ItemDiscount5(Item obj){
		super(obj);
	}

	protected Integer createDiscount() {	return 5;	}

}
