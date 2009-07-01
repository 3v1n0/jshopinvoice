package item;
import java.util.LinkedList;
import java.util.ListIterator;

public class ItemLinkedList extends AbstractItemList {
	LinkedList<Item> list;
	
	public ItemLinkedList() {
		list = new LinkedList<Item>();
	}
	
	public void add(Item i) {
		list.add(i);
	}
	
	public void remove(Item i) {
		if (list.contains(i))
			list.remove(i);
	}
	
	public ListIterator<Item> iterator() {
		return list.listIterator();
	}
	
	public int getSize() {
		return list.size();
	}

	Item get(int idx) {
		if (idx > getSize() || idx < 0) //TODO is it better to leave the exception?!?
			return null;
		else
			return list.get(idx);
	}

}
