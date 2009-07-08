package jshopper;

import invoice.Shopper;
import item.Item;

public class ItemSelectorRandom extends ItemSelector {
	private final int MAXLOOP = 20;
	private int instances;
	
	ItemSelectorRandom() {
		instances = 0;
	}

	protected Item select(Shopper sh) {
		instances++;
		if (instances < MAXLOOP)
			return sh.getItems().get((int)(Math.random()*100) % sh.getItems().getSize());
		else
			return null;
	}

	protected boolean setLoop() {
		return true;
	}

}
