package jshopper;

import invoice.Shopper;
import item.Item;

public abstract class ItemSelector {
	boolean loop;
	
	ItemSelector() {
		loop = setLoop();
	}
	
	protected abstract Item select(Shopper sh);
	protected abstract boolean setLoop();
	public boolean getLoop() {return loop;}
}
