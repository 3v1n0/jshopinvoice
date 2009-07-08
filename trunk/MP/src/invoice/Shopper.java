package invoice;

import item.ItemList;
import item.Item;
import java.util.LinkedList;

public interface Shopper {
	public Item addItem(Item i) throws Exception;
	public void removeItem(Item i) throws Exception;
	public void addCategory(String cat);
	public void removeCategory(String cat);
	public String getName();
	public String getCompanyName();
	public ItemList<? extends Item> getItems();
	public int getItemCount();
	public int getInvoicesCount();
	public LinkedList<Invoice> getInvoices();
	public LinkedList<String> getCategories();
}