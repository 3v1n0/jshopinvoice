package players;

import item.Item;
import media.Media;


public interface Player extends Item {
	public void accept( Media m );
	public String play();
}
