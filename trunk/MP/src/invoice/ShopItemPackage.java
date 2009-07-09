package invoice;

import item.Item;
public class ShopItemPackage extends ShopItem {
	protected ShopItemPackage(Shopper sh, Item i, int id, int count) {
		super(sh, i, id, count);
	}
}
