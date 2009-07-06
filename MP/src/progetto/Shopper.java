package progetto;

import item.ItemList;
import item.Item;
import java.util.LinkedList;

public interface Shopper {
	public Item addItem(Item i);
	public void removeItemInstance(Item i);
	public void addCategory(String cat);
	public void removeCategory(String cat);
	public String getName();
	public String getCompanyName();
//	public int getId(); TODO
	public ItemList<? extends Item> getItems();
	public int getItemCount();
	public int getInvoicesCount();
	public LinkedList<Invoice> getInvoices();
	public LinkedList<String> getCategories();
}
