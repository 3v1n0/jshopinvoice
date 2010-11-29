package jshopper;
import java.util.LinkedList;

import invoice.*;
import entities.*;
import item.Item;
import item.ItemList;

public class JShopper {
	private static JShopper jshopper;
	private LinkedList<Shopper> shops;
	private LinkedList<Entity> clients;
	private ItemSelector is;
	private Shopper shop;

	private JShopper() {
		shops = new LinkedList<Shopper>();
		clients = new LinkedList<Entity>();
		is = null;
		jshopper = null;
	}
	
	public static JShopper createJShopper() {
		if (jshopper == null) {
			jshopper = new JShopper();
			return jshopper;
		} else
			return jshopper;
	}
	
	public void addClient(Entity b) {
		clients.add(b);
	}
	
	public void removeClient(Shopper sh) {
		clients.remove(sh);
	}
	
	public LinkedList<Entity> getClients() {
		return clients;
	}
	
	public void addShop(Shopper sh) {
		if (!shops.contains(sh)) {
			shops.add(sh);
			if (shops.size() == 1)
				shop = sh;
		}
	}
	
	public void addShop(Shopper sh, ShopObserver sho) {
		sh.addObserver(sho);
		addShop(sh);
	}
	
	public void removeShop(Shopper sh) {
		shops.remove(sh);
	}
	
	public LinkedList<Shopper> getShops() {
		return shops;
	}
	
	public Shopper getShop(int i) {
		if (i >= 0 && i < shops.size())
			return shops.get(i);
		return null;
	}
	
	public void setSelectedShop(Shopper sh) {
		if (shops.contains(sh))
			shop = sh;
	}
	
	public Shopper getShop() {
		return shop;
	}
	
	public void addShopItem(Shopper sh, Item i, int count) throws Exception {
		if (!shops.contains(sh)) return;
		
		for (Shopper s : shops) {
			if (!s.equals(sh)) {
				for (Item it : s.getItems())
					if (i.equals(it))
						throw new Exception("The item added is already listed in another shop!");
			}
		}
		
		if (count > 0)
			sh.addItem(i, count);
		else
			sh.addItem(i);
		
		sh.notifyObservers();
	}
	
	public void addShopItem(Item i, int count) throws Exception {
		addShopItem(shop, i, count);
	}
	
	public void addShopItems(Shopper sh, ItemList<? extends Item> ils) throws Exception {
		for (Item i : ils) {
			addShopItem(sh, i, 0);
		}
	}
	
	public void addShopItems(ItemList<? extends Item> ils) throws Exception {
		addShopItems(shop, ils);
	}
	
	public void removeShopItem(Shopper sh, Item i) throws Exception {
		if (shops.contains(sh)) {
			sh.removeItem(i);
			sh.notifyObservers();
		}
	}
	
	public void removeShopItem(Item i) throws Exception {
		removeShopItem(shop, i);
	}

	public void setItemSelector(ItemSelector its) {
		is = its;
	}
	
	public Invoice addNewShopInvoice(Shopper sh, Entity buyer) throws Exception {
		if (!shops.contains(sh)) return null;
		
		return new Invoice(sh, buyer);
	}
	
	public Invoice addNewShopInvoice(Entity buyer) throws Exception {
		return addNewShopInvoice(shop, buyer);
	}
	
	public void populateShopInvoice(Invoice inv) throws Exception {
		if (is != null) {
			Item i;
			do {
				i = is.select(inv.getSeller());
				if (i instanceof ShopItem)
					inv.add((ShopItem)i);
				else
					i = null;
			} while (i != null && is.getLoop());
		}
	}
}
