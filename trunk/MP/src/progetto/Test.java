// GPL License

package progetto;

import media.*;
import players.*;

public class Test {
private static Media[] array =new Media[5];
private static Player[] lettori =new Player[5];

public static void main(String args[]){
	
		array[0]=new CD("Resta in ascolto","Sony", 60,null);
		array[1]=new DVD("Matrix","Philips", 120,4700);
		array[2]=new BluRay("Batman","20CenturyFox", 110,50000);
		array[3]=new HDDVD("Titanic","Nickelodeon", 180,15000);
		array[4]=new Vinile("Abbronzatissima","Records", 5,null);
		
		lettori[0]=new CDPlayer("Lettore CD","Samsung");
		lettori[1]=new DVDPlayer("Lettore DVD","Philips");
		lettori[2]=new BluRayPlayer("Lettore Blu-Ray","Sony");
		lettori[3]=new HDDVDPlayer("Lettore HDDVD","Majestic");
		lettori[4]=new Grammofono("DiscPlayer","Kenwood");
	
for(int i=0;i<array.length;i++){
	System.out.println(array[i].readLeggibile()+"\n");
}

for(int i=0;i<4;i++){
	lettori[i].accept(array[i]);
	System.out.print(lettori[i].play());
}
lettori[4].accept(array[3]);
System.out.print(lettori[4].play());

Item  a = new TVSet("s","s", (float)12.2,"s",(float)55);
System.out.println(a.getBrand()+" "+a.getDescription()+" "+a.getName()+" "+a.getPrice());
}
}
