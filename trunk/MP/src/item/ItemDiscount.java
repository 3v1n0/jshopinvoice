package item;

public abstract class ItemDiscount extends Item{

	Item obj;
	Integer percent;
	
	protected ItemDiscount(Item a){
		obj = a;
		percent = createSconto();		
	}
	protected abstract Integer createSconto();
	
/*
 *  Il decorator avvolge l'oggetto con un nuovo oggetto che per come lo creiamo noi ha i campi nome brand ecc
 *  nulli. se non facciamo l'overload dei metodi questi ritornano valori nulli mentre noi vogliamo che 
 *  ritornino i valori dell'oggetto avvolto, e questo lo otteniamo con la delegation a obj. E' descritto
 *  anche nel libro dei pattern. :p
 */ 
	
	public String getBrand() {return obj.getBrand();}
	public String getDescription() {return obj.getDescription();}
	public String getName() {return obj.getName();}
	public Float getPrice() {return (obj.getPrice()-(obj.getPrice()*percent/100));}
//	public int getId() {return obj.getId();} //--> If I don't comment it out I get always 0!
	
//	public void add(Item i)throws SinglePartException{	obj.add(i);	}
//	public void remove(Item i)throws SinglePartException{	obj.remove(i); }
//	public Item getSubItem(int n){ return obj.getSubItem(n);}
}
