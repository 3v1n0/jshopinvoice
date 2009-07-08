
package jshopper;

import entities.*;
import invoice.Invoice;
import invoice.Shop;
import item.*;

public class Test {

	public static void main(String args[]) throws Exception{
		
		JShopper jsh = JShopper.createJShopper();
		System.out.println(jsh == JShopper.createJShopper());
		
		Company cmp = new Company("New s.r.l",
								  new Address("Via di Novoli", 25, "Firenze", "FI", 50100, "Italia"),
								  new Contacts("+390557475892", "+390557475894", "info@newsrl.it", "http://www.newsrl.it"),
								  "JHSDF1751285");
		
		jsh.addShop(new Shop(cmp, "The New SHOP"), new ShopPrinterHtml());
		
		Entity en = new Person("Matteo","Pratesi", new Address("Via L.Manara",7,"Sesto Fiorentino","Firenze",50019,"Italia"),
								new Contacts("055-445661", null, "matteo.pratesi@libero.it",null));
		jsh.addClient(en);
		jsh.addClient(new Company("The big buyer",
				      new Address("Viale de' Ricchi", 1000, "Firenze", "FI", 50100, "Italia"),
				      new Contacts("+390558595661", "+390558383389", "info@bigbuyer.com", "http://www.bigbuyer.com"),
				      "IASHDKFOADIF67ASDF"));
		
		ItemImporter ii = new ItemImporterTest();
		
//		jsh.setSelectedShop(sh); // default
		
		for (Item i : ii.getItemList())
			jsh.addShopItem(jsh.getShop(), i, (int)(Math.random()*100));
		
		System.out.print("Shop Categories: "+jsh.getShop().getCategories());
		
		jsh.getShop().addDefaultInvoicePrinter(new InvoicePrinterHtml());
		
		Invoice a= new Invoice(jsh.getShop(), jsh.getClients().get(0));

		System.out.println("Invoices: "+jsh.getShop().getInvoicesCount());
		a.addPrinter(new InvoicePrinterStdout());
		a.addPrinter(new InvoicePrinterHtml()); // Not added, it's already there...
		a.addPrinter(new InvoicePrinterHtml(Utility.getTmpPath(), "Test_invoice_%d.html"));
	
		jsh.setItemSelector(new ItemSelectorPane());
		jsh.populateShopInvoice(a);
		
		Invoice b= new Invoice(jsh.getShop(), jsh.getClients().get(1));
		
		jsh.setItemSelector(new ItemSelectorRandom());
		jsh.populateShopInvoice(b);
	}
}
