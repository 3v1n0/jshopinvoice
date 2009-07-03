

package progetto;

import java.io.IOException;

import javax.swing.JOptionPane;

import entities.*;
import item.*;
import media.*;
import players.*;

public class Test {
	private static Item[] array =new Item[16];
	
	/** metodo per leggere interi */
	public static int getInt(Item[] items) {
		byte[] b = new byte[9];
		int res = 0;
		int m = 1;
		boolean cfl = false;
		String s, c = "";
		
		for (int i = 0; i < items.length; i++)
			c += (i+1)+") "+items[i].getName()+", "+items[i].getDescription() +
				  " - "+items[i].getType()+" - "+items[i].getPrice() +"EUR " +
				  (items[i].getDiscount() > 0 ? " ("+items[i].getDiscount()+"% di sconto)" : "" )+
				  "\n";

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


	public static void main(String args[]) throws IOException, SinglePartException{
		
		array[0]=new CD("New Logic Studio", "Laura Pausini", "Resta in ascolto", 60,
						"POP", "Italiano", "Ultimo cd dell'artista Laura Pausini.", 15.00f);

		array[1]=new DVD("Warner Bros", "Andy e Larry Wachowsky",
						 "Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, Hugo Weaving, Gloria Foster",
						 "The Matrix", 120, "Azione, Fantascienza", "Italiano/Inglese", "Italiano/Inglese/Spagnolo",
						 "Colore, AC-3, Dolby, 16:9, PAL", "La famosa trilogia di fantascenza informatica", 50.00f);

		array[2]=new BluRay("Warner Bros", "Tim Burton",
							"Michael Keaton, Jack Nicholson, Kim Basinger, Robert Wuhl, Pat Hingle",
							"Batman", 110, "Azione, Avventura, Fantasia", "Italiano/Inglese/Spangolo",
							"Italiano/Inglese/Spagnolo/Francese", "Colore, 16:9, NTSC", "Film di Batman del 1989", 30.00f);

		array[3]=new HDDVD("20th Century Fox", "James Cameron",
						   "Leonardo DiCaprio, Kate Winslet, Jason Barry, Kathy Bates, Nicholas Cascone",
						   "Titanic", 180, "Sentimentale, Storico, Drammatico", "Italiano/Inglese/Francese",
						   "Italiano/Inglese/Francese/Spangolo/Tedesco", "Colore, 16:9, AC-3, Dolby, PAL",
						   "Film vincitore di 11 premi oscar.", 15.00f);

		array[4]=new Vinyl("Capitol", "The Beatles", "Abbey Road", 55, "Rock, Classico, POP",
						   "Inglese",
						   "L'ultimo album registrato in studio dai Beatles risalente al 1969 in Vinile",
						   15.00f);

		array[5]=new CDPlayer("Lettore CD","Samsung","Velocità= 52x, Formati supportati= cd,vcd,svcd,avi,mpg3,mpg4",50.00f);
		array[6]=new DVDPlayer("Lettore DVD","Philips","Velocità= 26x, Formati supportati= dvd+r,dvd-r,dvd+rw,dvd-rw",100.00f);
		array[7]=new BluRayPlayer("Lettore Blu-Ray","Sony","Velocità= 16x, Formati supportati= BluRay",250.00f);
		array[8]=new HDDVDPlayer("Lettore HDDVD","Toshiba","Velocità= 16x, Formati supportati= HD Dvd",220.00f);
		array[9]=new Gramophone("DiscPlayer","Kenwood","Un bellissimo modello di grammofono",150.00f);
		
		array[10]=new Decoder("Decoder","Samsung",150.00f,"Un bellissimo modello di decoder",true);
		array[11]=new Speakers("Casse","Samsung",150.00f,"Un bellissimo modello di casse",500,20);
		array[12]=new HiFi("Hi-fi",(CDPlayer)array[5],(Speakers)array[11],"Un bellissimo modello di hi-fi");
		array[13]=new TVSet("TV","Samsung",150.00f,"Un bellissimo modello di TV",20);
		
		Item pkg = new ItemPackage("Pacchetto bLu","Sony, Samsung","Lettore blu ray+TVset+bluray batman");
		
			pkg.add(array[2]);
			pkg.add(array[7]);
			pkg.add(array[13]);
			pkg.remove(array[7]);
			pkg.add(array[7]);
	
		
		pkg = new ItemDiscount20(pkg);
		array[14]=pkg;
		
		pkg.add(array[9]);
	

		
		Item pkg2 = new ItemPackage("Scooonti!","Vari","Multimedia vari");
	
			pkg2.add(array[0]);
			pkg2.add(new ItemDiscount5(array[1]));
			pkg2.add(new ItemDiscount5(array[3]));
	
		array[15]=new ItemDiscount20(pkg2);

		
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]+"\n"+array[i].getName()+", "+array[i].getBrand()+", "+array[i].getDescription()+", "+array[i].getPrice());
		}
	
		try {
			array[10].add(array[12]);
		} catch (SinglePartException e) {
			System.out.println("ERROR: Tried to add an item over another Item!");
		}

		/////////////////////////////////////////////////////////////////////////////
		
		
		// A first Shop test
		Company cmp = new Company("New s.r.l",
								  new Address("Via di Novoli", 25, "Firenze", "FI", 50100, "Italia"),
								  "JHSDF1751285", "+390557475892", "+390557475894", "info@newsrl.it",
								  "http://www.newsrl.it");
	
		Shop sh = new Shop(cmp, "The New SHOP");
		Entity en = new Company("prova",new Address("prova",0,"prova","prova",0,"prova"),"prova","prova","prova","prova","prova");	

		for (Item i : array)
			sh.addItem(i);
		
		sh.removeItem(array[6]);
		sh.addItem(array[6]);
		
		sh.printItemsHtml();
		
		Invoice a= new Invoice(sh,en);
		a.setPrinter(new InvoicePrintStdout());
		
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
			c = getInt(array);
			
			if (c > 0 && c < array.length)
				a.add(array[c-1]);
		}

		System.out.println(a.getTotal()+" EUR for "+a.getCount()+" items");
		
		
		Invoice b= new Invoice(sh,en);
		
		for(int i=0;i<array.length/2;i++){
			b.add(array[i]);
		}
		System.out.println(b.getTotal()+" EUR for "+b.getCount()+" items");
		
		
	}
}
