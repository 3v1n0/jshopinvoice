package progetto;

public abstract class ShopListPrinter {
	private Shop shop;
	boolean showall = false;

	protected final void setShop(Shop sh) {
		shop = sh;
	}
	
	protected final Shop getShop() {
		return shop;
	}
	
	protected final void showAll(boolean sha) {
		showall = sha;
	}

	protected abstract void print();
}
