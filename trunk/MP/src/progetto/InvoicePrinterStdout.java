package progetto;

import item.Item;

public class InvoicePrinterStdout extends InvoicePrinter {

	protected void print() {
		Invoice i = getInvoice();
		
		System.out.println("|----------------------- INVOICE -----------------------|");
		System.out.println("|---Seller:---------------------------------------------|\n"+
							i.getSeller().getCompanyName()+" "+
							i.getSeller().getAddress()+i.getSeller().getContacts()+"\nVATIN: "+
							i.getSeller().getVATIN());
	
		System.out.print("|--- Buyer:---------------------------------------------|\n"+
						 i.getBuyer().getName()+", "+i.getBuyer().getAddress()+
						 ""+i.getBuyer().getContacts());
		
		if (i.getBuyer() instanceof entities.Company)
			System.out.println(", "+((entities.Company)i.getBuyer()).getVATIN());
			
		System.out.println("\n\n Numero Fattura: "+ i.getId()+ " - Data: "+i.getTime());
		System.out.println("|-------------------------------------------------------|");
		System.out.println("\n\n|---Quantità------Oggetto-------------------------------------------Prezzo (Sconto)-----|");
		
		for (Item o : i.getItems()) {
			String itemstr = normalizeString(o.getBrand()+" - "+o.getName(), 45);
			System.out.println("\t"+o.getCount()+"\t"+itemstr+
							   "\t\t"+o.getPrice()+(o.getDiscount() > 0 ? " ("+o.getDiscount()+"%)" : ""));
		}

		System.out.println("|----------------------------------------------------------------------------------------|");
		System.out.println("\t"+i.getItemsCount()+"\t"+normalizeString("", 45)+"\t\t"+i.getTotal()+" EUR");
		
		System.out.print("\n");
	}
	
	private String normalizeString(String str, int n) {
		String out = str;
		
		if (str.length() > n)
			out = str.substring(0, (n-3))+"...";
		else
			while (out.length() < n)
				out += " ";
		
		return out;
	}

}
