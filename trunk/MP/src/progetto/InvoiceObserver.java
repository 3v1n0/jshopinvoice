package progetto;

import java.util.Observable;
import java.util.Observer;

public class InvoiceObserver implements Observer {

	public void update(Observable observed, Object obj) {
		if (observed instanceof Invoice) {
			System.out.println("DEBUG: Invoice "+observed+" changed!");
			Invoice i = (Invoice)observed;
			i.print();
		} //else // TODO exception!
	}

}
