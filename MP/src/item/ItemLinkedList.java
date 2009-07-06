package item;
import java.util.LinkedList;
import java.util.ListIterator;

public class ItemLinkedList<I extends Item> extends ItemList<I> {
	private final LinkedList<I> list;
	
	public ItemLinkedList() {
		list = new LinkedList<I>();
	}
	
	public void add(I i) {
		list.add(i);
	}
	
	public void remove(I i) {
		list.remove(i);
	}
	
	public ListIterator<I> iterator() {
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

	public I get(int idx) {
		return list.get(idx);
	}

}
