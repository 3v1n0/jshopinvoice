package item;

public abstract class Sconto extends Item{

	Item obj;
	Integer percent;
	
	protected Sconto(Item a){
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
	public int getId() {return obj.getId();}
	
	public void add(Item i)throws SinglePartException{	obj.add(i);	}
	public void remove(Item i)throws SinglePartException{	obj.remove(i); }
	public Item getChild(int n){ return obj.getChild(n);}
}