package players;

import item.ItemInterface;
import media.Media;


public interface Player extends ItemInterface {
	public void accept( Media m );
	public String play();
}
