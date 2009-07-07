package discounts;

import item.Item;
import item.ItemDiscount;

public class ItemDiscount20 extends ItemDiscount{
	
	public ItemDiscount20(Item obj){
		super(obj);
	}

	protected Integer createDiscount() {	return 20;	}

}
