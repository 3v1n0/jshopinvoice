package item;

public abstract class ItemList implements Iterable<Item> {
	public abstract void add(Item i);
	public abstract void remove(Item i);
	public abstract Item get(int idx);
	public abstract int getSize();
	public abstract int getCount();
}
