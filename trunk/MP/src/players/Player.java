package players;

import media.Media;
import progetto.*;

public interface Player extends ItemInterface {
	public void accept( Media m );
	public String play();
}
