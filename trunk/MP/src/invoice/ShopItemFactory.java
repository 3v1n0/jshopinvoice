package invoice;

import item.Item;
import item.SinglePartException;

public class ShopItemFactory {
	protected static ShopItem getShopItem(Shopper sh, Item i, int id, int count) {
		try {
			i.getSubItemsCount();
			return new ShopItemPackage(sh, i, id, count);
		} catch (SinglePartException e) {
			return new ShopItem(sh, i, id, count);
		}
	}
}
