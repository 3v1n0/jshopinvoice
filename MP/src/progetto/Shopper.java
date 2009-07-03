package progetto;

import item.AbstractItemList;
import item.Item;
import java.util.LinkedList;

public interface Shopper {
	public Item addItem(Item i);
	public void removeItem(Item i);
	public void addCategory(String cat);
	public void removeCategory(String cat);
	public String getName();
	public String getCompanyName();
//	public int getId(); TODO
	public AbstractItemList getItems();
	public int getItemCount();
	public int getInvoicesCount();
	public LinkedList<Invoice> getInvoices();
	public LinkedList<String> getCategories();
}
