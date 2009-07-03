

package progetto;

import javax.swing.JOptionPane;

import entities.*;
import item.*;

public class Test {
	
	
	/** metodo per leggere interi */
	public static int getInt(AbstractItemList items) {
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
				  "\n";
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
								  "JHSDF1751285", "+390557475892", "+390557475894", "info@newsrl.it",
								  "http://www.newsrl.it");
	
		Shop sh = Shop.createShop(cmp, "The New SHOP");
		Shop sh1 = Shop.createShop(cmp, "The New SHOP");
		
		System.out.println(sh.equals(sh1));
		
		Entity en = new Company("prova",new Address("prova",0,"prova","prova",0,"prova"),"prova","prova","prova","prova","prova");
		
		ItemImporter ii = new ItemImporterTest();
		
		for (Item i : ii.getItemList()) {
			System.out.println(i.getName()+" "+i.getId());
			sh.addItem(i);
			System.out.println(i.getName()+" "+i.getId());
		}
		
		sh.removeItem(ii.getItemList().get(6));
		sh.addItem(ii.getItemList().get(6));
		
		System.out.print("Shop Categories: ");
		for (String c : sh.getCategories())
			System.out.print(c+", ");
		System.out.print("\n");
		
		sh.printItemsHtml();
		
		Invoice a= new Invoice(sh,en);

		System.out.println("Invoices: "+sh.getInvoicesCount());
		a.setPrinter(new InvoicePrinterStdout());
		
/*		
 		for(int i=0;i<array.length;i++){
			a.add(array[i]);
		}
		for(int i=0;i<3;i++){
			a.add(array[i]);
		}
*/
//		String s = "Inserire il numero corrispondente al prodotto desiderato per aggiungerlo al carrello.\n"+
//					"1.Laura Pausini - Resta in ascolto, Genere: POP, Ultimo cd dell'artista Laura Pausini, Prezzo 15.00 EUR\n"+
//					"2.The Matrix, La famosa trilogia di fantascenza informatica - DVD, Prezzo 50.00 EUR\n"+
//					"3.Batman, Film di Batman del 1989 - BluRay, Prezzo 30.00 EUR\n"+
//					"4.Titanic, Film vincitore di 11 premi oscar - HDDVD 15.00 EUR\n"+
//					"5.The Beatles - Abbey Road, Genere: Rock Classico POP, L'ultimo album registrato in studio dai Beatles risalente al 1969 in Vinile, Prezzo 15.00 EUR\n"+
//					"6.Lettore CD, Samsung, Formati supportati= cd,vcd,svcd,avi,mpg3,mpg,  Prezzo:50.00 EUR\n"+
//					"7.Lettore DVD, Philips, Formati supportati= dvd+r,dvd-r,dvd+rw,dvd-rw, Prezzo: 100.00 EUR\n"+
//					"8.Lettore Blu-Ray, Sony, Formati supportati= BluRay Prezzo: 250.00 EUR\n"+
//					"9.Lettore HDDVD, Toshiba, Formati supportati= HD Dvd Prezzo: 220.00 EUR\n"+
//					"10.Grammofono, Kenwood, Un bellissimo modello di grammofono Prezzo: 150.00 EUR\n"+
//					"11.Decoder, Samsung, Un bellissimo modello di decoder Prezzo: 150.00 EUR\n"+
//					"12.Casse,Samsung, Un bellissimo modello di casse Prezzo:150.00 EUR\n"+
//					"13.Hi-fi, Un bellissimo modello di hi-fi composto dal lettore CD e dalle casse della Samsung Prezzo: 200.00 EUR\n"+
//					"14.TV, Samsung, Un bellissimo modello di TV Prezzo: 150.00 EUR\n"+
//					"15.Pacchetto bLu, Sony - Samsung, Lettore blu ray + TVset + bluray batman, con sconto 20% sul totale\n"+
//					"16.Pacchetto film e audio superscontati (Resta in ascolto + The matrix + Titanic)\n"+
//					"0. Uscire.";
					
		int c = -1;
		while(c != 0){
			System.out.println(c);
			c = getInt(ii.getItemList());
			
			if (c > 0 && c < ii.getItemList().getSize())
				a.add(ii.getItemList().get(c-1));
		}

		System.out.println(a.getTotal()+" EUR for "+a.getCount()+" items");
		
		
		Invoice b= new Invoice(sh,en);
		
		for(int i=0; i < ii.getItemList().getSize()/2; i++){
			b.add(ii.getItemList().get(i));
		}
		System.out.println(b.getTotal()+" EUR for "+b.getCount()+" items");
		
		
	}
}
