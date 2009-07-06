package progetto;

import java.util.Observable;
import java.util.Observer;

public class InvoiceObserver implements Observer {

	public void update(Observable observed, Object obj) {
		if (observed instanceof Invoice) {
			Invoice i = (Invoice)observed;
			try {
				i.print();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} //else // TODO exception!
	}

}
