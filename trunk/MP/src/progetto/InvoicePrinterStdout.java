package progetto;

import item.Item;

public class InvoicePrinterStdout extends InvoicePrinter {

	protected void print() {
		Invoice i = getInvoice();
		System.out.println(i.getItemsCount());
		
		for (Item o : i.getItems())
			System.out.println(o.getCount()+" * "+o.getBrand()+" - "+o.getName());
		
		System.out.print("\n");
	}

}
