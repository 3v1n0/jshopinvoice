package progetto;


import entities.*;
import item.*;

import java.util.Date;
// import java.util.LinkedList;


public class Invoice {
	private Shop seller;
	private Entity buyer;
	private Date time;
	private Item invoice;
	int nOggetti;
	private static int id;
	//TODO keep trace of the duplicates

	public Invoice(Shop sel, Entity buy){
		invoice = new Packages("Fattura",null,null);
		seller = sel;
		buyer = buy;
		nOggetti=0;
		id++;
//		time = getTime(); dunno what you would do
	}
	
	public void add(Item a) throws SinglePartException{
		invoice.add(a);
		nOggetti++;
	}
	public void remove(Item a) throws SinglePartException{
		invoice.remove(a);
		nOggetti--;
	}
	//TODO add get buyer set buyer get seller set seller ecc..
	public Float getTotal(){
		return invoice.getPrice();
	}
	public int getNumObject(){
		return nOggetti;
	}
	
}
