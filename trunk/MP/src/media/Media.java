package media;

import item.Item;
import item.SinglePartException;

public abstract class Media implements Item{
	
	private String title;
	private String brand;
	private String description;
	private Integer duration;
	private Integer size;
	private Float price;
	private Media r;
	
	
	Media(){}
	Media(String t, String b, Integer d, Integer s, String desc, Float prc){
		r=createMedia();
		title = t;
		brand = b;
		duration = d;
		size = s;
		description = desc;
		price = prc;
	}
	
	abstract Media createMedia();
	
	public String readLeggibile(){
		String s;
		s="Title:\t\t"+title+"\nBrand:\t\t"+brand+"\nDuration:\t"+duration+"\nSupport:\t"+r.getClass().getSimpleName()+"\nSize:\t";
		if (size==null) s+="\t/\n\n";
		else s+= "\t"+size+" MB\n\n";
		return s;
	}
	public String getName() { return title;}
	public String getBrand(){return brand;}
	public String getDescription(){return description;}
	public Float getPrice(){return price;}
	
	public void add(Item i)throws SinglePartException{
	throw new SinglePartException();		
	}
	
	public void remove(Item i)throws SinglePartException{
	throw new SinglePartException();		
	}
	
	public Item getChild(int n){ return null;}

}
