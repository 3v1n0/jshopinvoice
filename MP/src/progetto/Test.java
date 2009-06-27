

package progetto;

import item.Item;
import media.*;
import players.*;

public class Test {
private static Item[] array =new Media[5];
private static Item[] lettori =new Player[5];

public static void main(String args[]){
	
	array[0]=new CD("Resta in ascolto","Laura Pausini","New Logic Studio", 60,null,"Ultimo cd dell'artista Laura Pausini.",(float)15.00);
	array[1]=new DVD("Matrix","Andy e Larry Wachowsky","Warner Bros", 120,4700,"La famosa trilogia di fantascenza informatica",(float)50.00);
	array[2]=new BluRay("Batman","Tim Burton","Warner Bros", 110,50000,"Film di Batman del 1989",(float)10.00);
	array[3]=new HDDVD("Titanic","James Cameron","20th Century Fox", 180,15000,"Film vincitore di 11 premi oscar con L.Di Caprio",(float)15.00);
	array[4]=new Vinile("Abbronzatissima","Edoardo Vianello","Records", 5,null,"Grande hit dell'artista Edoardo Vianello",(float)10.00);
		
	lettori[0]=new CDPlayer("Lettore CD","Samsung","Velocità= 52x, Formati supportati= cd,vcd,svcd,avi,mpg3,mpg4",(float)50.00);
	lettori[1]=new DVDPlayer("Lettore DVD","Philips","Velocità= 26x, Formati supportati= dvd+r,dvd-r,dvd+rw,dvd-rw",(float)100.00);
	lettori[2]=new BluRayPlayer("Lettore Blu-Ray","Sony","Velocità= 16x, Formati supportati= BluRay",(float)250.00);
	lettori[3]=new HDDVDPlayer("Lettore HDDVD","Toshiba","Velocità= 16x, Formati supportati= HD Dvd",(float)220.00);
	lettori[4]=new Grammofono("DiscPlayer","Kenwood","Un bellissimo modello di grammofono",(float)150.00);
	
for(int i=0;i<array.length;i++){
	System.out.println(array[i].getName()+" "+array[i].getBrand()+" "+array[i].getDescription()+" "+array[i].getPrice());
}

for(int i=0;i<5;i++){
	System.out.println(lettori[i].getName()+" "+lettori[i].getBrand()+" "+lettori[i].getDescription()+" "+lettori[i].getPrice());
}

}

}
