package item;
import java.util.LinkedList;
import java.util.ListIterator;

public class ItemLinkedList extends ItemList {
	private final LinkedList<Item> list;
	
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
	
	public int getCount() {
		int count = 0;
		for (Item i : list)
			count += i.getCount();
		
		return count;
	}

	public Item get(int idx) {
		return list.get(idx);
	}

}
