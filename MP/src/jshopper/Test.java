

package jshopper;

import javax.swing.JOptionPane;

import discounts.ItemDiscount10;

import entities.*;
import invoice.Invoice;
import invoice.InvoicePrinterHtml;
import invoice.InvoicePrinterStdout;
import invoice.Shop;
import invoice.ShopItem;
import item.*;

public class Test {
	
	
	/** metodo per leggere interi */
	public static int getInt(ItemList<ShopItem> items) {
		byte[] b = new byte[9];
		int res = 0;
		int m = 1;
		boolean cfl = false;
		String s, c = "";
		
		for (int i = 0; i < items.getSize(); i++) {
			Item item = items.get(i);
			c += (i+1)+") "+item.getName()+", "+item.getDescription() +
				  " - "+item.getType()+" - "+item.getPrice() +"EUR " +
				  (item.getDiscount() > 0 ? " ("+item.getDiscount()+"% di sconto)" : "" )+
				  " - Disponibilità: "+item.getCount()+"\n";
		}

		c += "0) Quit";		
			
		s = JOptionPane.showInputDialog(c);
		for (int i = 0; i < s.length(); i++) {
			b[i] = (byte) s.charAt(i);
			if (b[i] == ' ')
				continue;
			else if (b[i] == '-' && (!cfl && m > 0))
				m = -1;
			else if (b[i] == '-' && m < 0)
				break;
			else if (b[i] >= '0' && b[i] <= '9') {
				res = res * 10 + b[i] - '0';
				cfl = true;
			} else
				break;
		}
		return m * res;
	}


	public static void main(String args[]) throws Exception{
		
		

		/////////////////////////////////////////////////////////////////////////////
		
		
		// A first Shop test
		Company cmp = new Company("New s.r.l",
								  new Address("Via di Novoli", 25, "Firenze", "FI", 50100, "Italia"),
								  new Contacts("+390557475892", "+390557475894", "info@newsrl.it", "http://www.newsrl.it"),
								  "JHSDF1751285");
	
		Shop sh = Shop.createShop(cmp, "The New SHOP");
		Shop sh1 = Shop.createShop(cmp, "The New SHOP");
		
		System.out.println(sh.equals(sh1));
		
		Entity en = new Person("Matteo","Pratesi", new Address("Via L.Manara",7,"Sesto Fiorentino","Firenze",50019,"Italia"),
								new Contacts("055-445661", null, "matteo.pratesi@libero.it",null));
		
		ItemImporter ii = new ItemImporterTest();
		
		for (Item i : ii.getItemList())
			sh.addItem(i, (int)(Math.random()*100));
		
		sh.removeItem(sh.getItems().get(6));
		sh.addItem(ii.getItemList().get(6), 5);
		System.out.println(ii.getItemList().get(4).getFeatures());
		sh.addCategory("Misc");
		sh.removeItem(sh.getItems().get(4));
		sh.removeCategory("Item"); // It won't remove it (it's ok!).
		System.out.println("Shop categories after test removing "+sh.getCategories().toString());
		sh.addItem(ii.getItemList().get(4), 3);
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
		for (String c : sh.getCategories())
			System.out.print(c+", ");
		System.out.print("\n");
		
		sh.printItemsHtml();
		
		sh.addDefaultInvoicePrinter(new InvoicePrinterHtml());
		
		Invoice a= new Invoice(sh,en);

		System.out.println("Invoices: "+sh.getInvoicesCount());
		a.addPrinter(new InvoicePrinterStdout());
		a.addPrinter(new InvoicePrinterHtml()); //Not added...
	
		
		int c = -1;
		while(c != 0) {
			c = getInt(sh.getItems());
			
			if (c > 0 && c <= sh.getItems().getSize())
				a.add(sh.getItems().get(c-1));
		}

		System.out.println(a.getTotal()+" EUR for "+a.getItemsCount()+" items");
		
		
		Invoice b= new Invoice(sh,en);
		
		for(int i=0; i < sh.getItems().getSize()/2; i++){
			b.add(sh.getItems().get(i));
		}
		System.out.println(b.getTotal()+" EUR for "+b.getItemsCount()+" items");
	}
}
