package item;

public abstract class Sconto extends Item{

	Item obj;
	Integer percent;
	
	protected Sconto(Item a){
		obj = a;
		percent = createSconto();		
	}
	protected abstract Integer createSconto();
	
//	public String getBrand() {return obj.getBrand();}
//	public String getDescription() {return obj.getDescription();}
//	public String getName() {return obj.getName();}
	public Float getPrice() {return (obj.getPrice()-(obj.getPrice()*percent/100));}
//	public int getId() {return obj.getId();}
	
//	public void add(Item i)throws SinglePartException{	obj.add(i);	}
//	public void remove(Item i)throws SinglePartException{	obj.remove(i); }
//	public Item getChild(int n){ return obj.getChild(n);}
}
