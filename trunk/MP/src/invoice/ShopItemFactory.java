package invoice;

import item.Item;
import item.SinglePartException;

public class ShopItemFactory {
	protected static ShopItem getShopItem(Item i, int id, int count) {
		try {
			i.getSubItemsCount();
			return new ShopItemPackage(i, id, count);
		} catch (SinglePartException e) {
			return new ShopItem(i, id, count);
		}
	}
}
