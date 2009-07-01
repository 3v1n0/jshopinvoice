package progetto;


import entities.*;
import item.*;

import java.util.Date;
// import java.util.LinkedList;


public class Invoice {
	private Shop seller;
	private Entity buyer;
	private Date time;
	private ItemPackage invoice;
	private static int id;
	//TODO keep trace of the duplicates

	public Invoice(Shop sel, Entity buy){
		invoice = new ItemPackage("Fattura",null,null);
		seller = sel;
		buyer = buy;
		id++;
//		time = getTime(); dunno what you would do
	}
	
	public void add(Item a) throws SinglePartException{
		invoice.add(a);
	}

	public void remove(Item a) throws SinglePartException{
		invoice.remove(a);
	}

	public Float getTotal() {
		return invoice.getPrice();
	}
	
	public int getCount() throws SinglePartException {
		return invoice.getCount();
	}
	
	public Shop getSeller() {
		return seller;
	}
	
	public Entity getBuyer() {
		return buyer;
	}
	
	public Date getTime() {
		return time;
	}
}
