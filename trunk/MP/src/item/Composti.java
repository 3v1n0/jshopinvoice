package item;

import java.util.ArrayList;

public class Composti extends ConcreteItem{
	// classe composite del pattern composite
	
	private ArrayList<Item> children;
	
	
	public Composti(String nm, String br, String desc) {
		super(br, nm, desc, null);
		children = new ArrayList<Item>();
	}
	
	public Float getPrice() {
		float sum = 0.0f;
		for ( int i=0; i<children.size();i++){
			sum+=children.get(i).getPrice();
		}
		return sum;
	}
	public void add(Item i) throws SinglePartException{
		children.add(i);		
	}
	
	public void remove(Item i) throws SinglePartException{
		children.remove(i);		
	}
	
	public Item getChild(int n){
		return children.get(n);
	}
}
