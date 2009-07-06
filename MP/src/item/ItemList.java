package item;

public abstract class ItemList<I extends Item> implements Iterable<I> {
	public abstract void add(I i);
	public abstract void remove(I i);
	public abstract I get(int idx);
	public abstract int getSize();
	public abstract int getCount();
}
