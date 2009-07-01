

package progetto;

import java.io.IOException;

import entities.*;
import item.*;
import media.*;
import players.*;

public class Test {
	private static Item[] array =new Item[15];


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
		try {
			pkg.add(array[2]);
			pkg.add(array[7]);
			pkg.add(array[13]);
			pkg.remove(array[7]);
			pkg.add(array[7]);
		} catch (SinglePartException e) {
			e.printStackTrace();
		}
		
		pkg = new ItemDiscount20(pkg);
		array[14]=pkg;
		//TODO do a pkg of pkgs
		// the invoice has an item which is a package of packages
		

		
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]+"\n"+array[i].getName()+", "+array[i].getBrand()+", "+array[i].getDescription()+", "+array[i].getPrice());
		}
	
		try {
			array[10].add(array[12]);
		} catch (SinglePartException e) {
			e.printStackTrace();
		}
		
		// A first Shop test
		Company cmp = new Company("New s.r.l",
								  new Address("Via di Novoli", 25, "Firenze", "FI", 50100, "Italia"),
								  "JHSDF1751285", "+390557475892", "+390557475894", "info@newsrl.it",
								  "http://www.newsrl.it");
	
		Shop sh = new Shop(cmp, "The New SHOP");
		
		for (Item i : array)
			sh.addItem(i);
		
		sh.printItemsHtml();
		
		Entity en = new Company("prova",new Address("prova",0,"prova","prova",0,"prova"),"prova","prova","prova","prova","prova");
		
		Invoice a= new Invoice(sh,en);
		for(int i=0;i<array.length;i++){
			try {
				a.add(array[i]);
			} catch (SinglePartException e) {
				e.printStackTrace();
			}
		}
		System.out.println(a.getTotal()+" EUR for "+a.getCount()+" items");
	}
}
