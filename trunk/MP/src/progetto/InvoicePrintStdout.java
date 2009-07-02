package progetto;

import item.Item;

public class InvoicePrintStdout extends InvoicePrint {

	protected void print() {
		Invoice i = getInvoice();
		System.out.println(i.getCount());
		
		for (Item o : i.getItems())
			System.out.println(o.getCount()+" * "+o.getBrand()+" - "+o.getName());
		
		System.out.print("\n");
	}

}
