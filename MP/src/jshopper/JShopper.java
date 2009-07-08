package jshopper;
import java.util.LinkedList;

import invoice.*;
import entities.*;
import item.Item;
import item.ItemList;

public class JShopper {
	static JShopper jshopper;
	private LinkedList<Shopper> shops;
	private LinkedList<Entity> clients;
	private ItemSelector is;
	
	private JShopper() {
		shops = new LinkedList<Shopper>();
		clients = new LinkedList<Entity>();
		is = null;
	}
	
	public static JShopper createJShopper() {
		if (jshopper == null)
			return new JShopper();
		else
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
		if (!shops.contains(sh))
			shops.add(sh);
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
	
	public void addShopItem(Shopper sh, Item i, int count) throws Exception {
		if (!shops.contains(sh)) return;
		
		for (Shopper s : shops) {
			if (!s.equals(sh)) {
				for (Item it : s.getItems())
					if (it.equals(i))
						throw new Exception("The item added is already listed in another shop!");
			}
		}
		
		if (count > 0)
			sh.addItem(i, count);
		else
			sh.addItem(i);
		
		sh.notifyObservers();
	}
	
	public void addShopItems(Shopper sh, ItemList<? extends Item> ils) throws Exception {
		for (Item i : ils) {
			addShopItem(sh, i, 0);
		}
	}
	
	public void removeShopItem(Shopper sh, Item i) throws Exception {
		if (shops.contains(sh)) {
			sh.removeItem(i);
			sh.notifyObservers();
		}
	}

	public void setItemSelector(ItemSelector its) {
		is = its;
	}
	
	public Invoice addNewShopInvoice(Shopper sh, Entity buyer) throws Exception {
		if (!shops.contains(sh)) return null;
		
		return new Invoice(sh, buyer);
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
