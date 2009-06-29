

package progetto;

import java.io.IOException;

import item.*;
import media.*;
import players.*;

public class Test {
	private static Item[] array =new Item[15];


	public static void main(String args[]) throws IOException{
	//	array[0]=new CD("Resta in ascolto","Laura Pausini","New Logic Studio", 60,null,"Ultimo cd dell'artista Laura Pausini.",15.00f);
		array[0]=new CD("New Logic Studio", "Laura Pausini", "Resta in ascolto", 60,
						"POP", "Italiano", "Ultimo cd dell'artista Laura Pausini.", 15.00f);
	//	array[1]=new DVD("Matrix","Andy e Larry Wachowsky","Warner Bros", 120,4700,"La famosa trilogia di fantascenza informatica",50.00f);
		array[1]=new DVD("Warner Bros", "Andy e Larry Wachowsky",
						 "Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, Hugo Weaving, Gloria Foster",
						 "The Matrix", 120, "Azione, Fantascienza", "Italiano/Inglese", "Italiano/Inglese/Spagnolo",
						 "Colore, AC-3, Dolby, 16:9, PAL", "La famosa trilogia di fantascenza informatica", 50.00f);
	//	array[2]=new BluRay("Batman","Tim Burton","Warner Bros", 110,50000,"Film di Batman del 1989",30.00f);
		array[2]=new BluRay("Warner Bros", "Tim Burton",
							"Michael Keaton, Jack Nicholson, Kim Basinger, Robert Wuhl, Pat Hingle",
							"Batman", 110, "Azione, Avventura, Fantasia", "Italiano/Inglese/Spangolo",
							"Italiano/Inglese/Spagnolo/Francese", "Colore, 16:9, NTSC", "Film di Batman del 1989", 30.00f);
	//	array[3]=new HDDVD("Titanic","James Cameron","20th Century Fox", 180,15000,"Film vincitore di 11 premi oscar con L.Di Caprio",15.00f);
		array[3]=new HDDVD("20th Century Fox", "James Cameron",
						   "Leonardo DiCaprio, Kate Winslet, Jason Barry, Kathy Bates, Nicholas Cascone",
						   "Titanic", 180, "Sentimentale, Storico, Drammatico", "Italiano/Inglese/Francese",
						   "Italiano/Inglese/Francese/Spangolo/Tedesco", "Colore, 16:9, AC-3, Dolby, PAL",
						   "Film vincitore di 11 premi oscar con L.Di Caprio", 15.00f);
	//	array[4]=new Vinile("Abbronzatissima","Edoardo Vianello","Records", 5,null,"Grande hit dell'artista Edoardo Vianello",10.00f);
		array[4]=new Vinyl("Capitol", "The Beatles", "Abbey Road", 55, "Rock, Classico, POP",
						   "Inglese",
						   "L'ultimo album registrato in studio dai Beatles risalente al 1969 in Vinile",
						   15.00f);
			
		array[5]=new CDPlayer("Lettore CD","Samsung","Velocità= 52x, Formati supportati= cd,vcd,svcd,avi,mpg3,mpg4",50.00f);
		array[6]=new DVDPlayer("Lettore DVD","Philips","Velocità= 26x, Formati supportati= dvd+r,dvd-r,dvd+rw,dvd-rw",100.00f);
		array[7]=new BluRayPlayer("Lettore Blu-Ray","Sony","Velocità= 16x, Formati supportati= BluRay",250.00f);
		array[8]=new HDDVDPlayer("Lettore HDDVD","Toshiba","Velocità= 16x, Formati supportati= HD Dvd",220.00f);
		array[9]=new Grammofono("DiscPlayer","Kenwood","Un bellissimo modello di grammofono",150.00f);
		
		array[10]=new Decoder("Decoder","Samsung",150.00f,"Un bellissimo modello di decoder",true);
		array[11]=new Speakers("Casse","Samsung",150.00f,"Un bellissimo modello di casse",500,20);
		array[12]=new Hi_Fi("Hi-fi",(CDPlayer)array[5],(Speakers)array[11],"Un bellissimo modello di hi-fi");
		array[13]=new TVSet("TV","Samsung",150.00f,"Un bellissimo modello di TV",20);
		
		Composti packet = new Composti("Pacchetto bLu","Sony, Samsung","Lettore blu ray+TVset+bluray batman");
		try {
			packet.add(array[2]);
			packet.add(array[7]);
			packet.add(array[13]);
		} catch (SinglePartException e) {
			e.printStackTrace();
		}
		
		array[14]=packet;
		
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]+"\n"+array[i].getName()+", "+array[i].getBrand()+", "+array[i].getDescription()+", "+array[i].getPrice());
		}
	
		try {
			array[10].add(array[12]);
		} catch (SinglePartException e) {
			e.printStackTrace();
		}
	}
}
