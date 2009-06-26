package players;

import readable.Readable;

public interface Player {
	public void accept( Readable m );
	public String play();
}
