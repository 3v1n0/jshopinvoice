package progetto;

import item.Item;

public class InvoicePrinterStdout extends InvoicePrinter {

	protected void print() {
		Invoice i = getInvoice();
		
		System.out.println("|----------------------- INVOICE -----------------------|");
		System.out.println("|---Seller:---------------------------------------------|\n"+i.getSeller().getCompanyName()+" "+i.getSeller().getAddress()+i.getSeller().getContacts()+"\nVATIN: "+i.getSeller().getVATIN());
		System.out.print("|--- Buyer:---------------------------------------------|\n"+ i.getBuyer().getName()+", "+i.getBuyer().getAddress()+""+i.getBuyer().getContacts());if(i.getBuyer() instanceof entities.Company) System.out.println(", "+((entities.Company)i.getBuyer()).getVATIN());System.out.println("");
		System.out.println("\n\n Numero Fattura: "+ i.getId()+ " - Data: "+i.getTime());
		System.out.println("|-------------------------------------------------------|");
		System.out.println("\n\n|-Quantità------Descrizione-------------------------------------------Prezzo(Sconto)-----|");
		
		for (Item o : i.getItems())
			System.out.println("      "+o.getCount()+" \t"+o.getBrand()+" - "+o.getName()+" \t\t\t "+o.getPrice()+"("+o.getDiscount()+")");

		System.out.println("|----------------------------------------------------------------------------------------|");
		System.out.println("numero di oggetti venduti: "+i.getItemsCount()+"\t per un totale di: "+i.getTotal()+" EUR");
		
		System.out.print("\n");
	}

}
