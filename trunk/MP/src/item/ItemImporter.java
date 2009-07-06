package item;

public interface ItemImporter {
	public ItemList<? extends Item> getItemList() throws Exception;
}
