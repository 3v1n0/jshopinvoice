

package progetto;

import item.*;
import media.*;
import players.*;

public class Test {
private static Item[] array =new Item[15];


public static void main(String args[]){
	
	array[0]=new CD("Resta in ascolto","Laura Pausini","New Logic Studio", 60,null,"Ultimo cd dell'artista Laura Pausini.",15.00f);
	array[1]=new DVD("Matrix","Andy e Larry Wachowsky","Warner Bros", 120,4700,"La famosa trilogia di fantascenza informatica",50.00f);
	array[2]=new BluRay("Batman","Tim Burton","Warner Bros", 110,50000,"Film di Batman del 1989",30.00f);
	array[3]=new HDDVD("Titanic","James Cameron","20th Century Fox", 180,15000,"Film vincitore di 11 premi oscar con L.Di Caprio",15.00f);
	array[4]=new Vinile("Abbronzatissima","Edoardo Vianello","Records", 5,null,"Grande hit dell'artista Edoardo Vianello",10.00f);
		
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
	System.out.println(array[i].getName()+", "+array[i].getBrand()+", "+array[i].getDescription()+", "+array[i].getPrice());
}

try {
	array[10].add(array[12]);
} catch (SinglePartException e) {
	e.printStackTrace();
}
}

}
