package item;

public abstract class AbstractItemList implements Iterable<Item> {
	abstract void add(Item i);
	abstract void remove(Item i);
	abstract Item get(int idx);
	abstract int getSize();
}
