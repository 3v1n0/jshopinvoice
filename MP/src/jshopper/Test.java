

package jshopper;

import discounts.ItemDiscount10;

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
		
//		jsh.setSelectedShop(sh); //default
		
		for (Item i : ii.getItemList())
			jsh.addShopItem(jsh.getShop(), i, (int)(Math.random()*100));
		
		jsh.getShop().removeItem(jsh.getShop().getItems().get(6));
		jsh.getShop().addItem(ii.getItemList().get(6), 5);
		System.out.println(ii.getItemList().get(4).getFeatures());
		jsh.getShop().addCategory("Misc");
		jsh.getShop().removeItem(jsh.getShop().getItems().get(4));
		jsh.getShop().removeCategory("Item"); // It won't remove it (it's ok!).
		System.out.println("Shop categories after test removing "+jsh.getShop().getCategories().toString());
		jsh.getShop().addItem(ii.getItemList().get(4), 3);
		Item it = new ItemDiscount10(ii.getItemList().get(3));
		System.out.println(it.getFeatures());
		System.out.println(it.equals(it)+" - "+ii.getItemList().get(3).equals(it));
		Item itt = it.clone();
		System.out.println("Uguali: (must be false) "+(itt == it));
		System.out.println(itt.getClass().getName()+" "+it.getClass().getName()+"\nUguali: (must be true) "+itt.equals(it));
		itt.addFeature("Test", new ItemFeatureValue("Provaaaa"));
		System.out.println("Uguali features: " +(itt.getFeatures() == it.getFeatures()));
		System.out.println(itt.getClass().getName()+" "+it.getClass().getName()+"\nUguali: (must be false) "+itt.equals(it));
		
		Item ittt = ii.getItemList().get(3).clone();
		System.out.println(ii.getItemList().get(3).getClass().getName()+" "+ittt.getClass().getName()+"\nUguali: (must be true) "+ittt.equals(ii.getItemList().get(3)));
		
		
		ittt = ii.getItemList().get(2).clone();
		System.out.println(ii.getItemList().get(2).getClass().getName()+" "+ittt.getClass().getName()+"\nUguali: (must be true) "+ittt.equals(ii.getItemList().get(2)));
		
//		sh.removeCategoryItems("Player");
		
		System.out.print("Shop Categories: ");
		for (String c : jsh.getShop().getCategories())
			System.out.print(c+", ");
		System.out.print("\n");
		
		jsh.getShop().addDefaultInvoicePrinter(new InvoicePrinterHtml());
		
		Invoice a= new Invoice(jsh.getShop(), jsh.getClients().get(0));

		System.out.println("Invoices: "+jsh.getShop().getInvoicesCount());
		a.addPrinter(new InvoicePrinterStdout());
		a.addPrinter(new InvoicePrinterHtml()); //Not added...
		a.addPrinter(new InvoicePrinterHtml(Utility.getTmpPath(), "Test_invoice_%d.html"));
	
		jsh.setItemSelector(new ItemSelectorPane());
		jsh.populateShopInvoice(a);

		System.out.println(a.getTotal()+" EUR for "+a.getItemsCount()+" items");
		
		
		Invoice b= new Invoice(jsh.getShop(), jsh.getClients().get(1));
		
		jsh.setItemSelector(new ItemSelectorRandom());
		jsh.populateShopInvoice(b);
	
	
		System.out.println(b.getTotal()+" EUR for "+b.getItemsCount()+" items");
	}
}
