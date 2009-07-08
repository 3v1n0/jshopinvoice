package invoice;

public interface ShopObservable {
	public void addObserver(ShopObserver sho);
	public void deleteObserver(ShopObserver sho);
	public void notifyObservers();
}
