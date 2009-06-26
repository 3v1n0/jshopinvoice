package readable;

public abstract class Readable {
	
	private String title;
	private String brand;
	private Integer duration;
	private Integer size;
	private Readable r;
	
	Readable(){}
	Readable(String t, String b, Integer d, Integer s){
		r=createLeggibili();
		title = t;
		brand = b;
		duration = d;
		size = s;
	}
	
	abstract Readable createLeggibili();
	
	public String readLeggibile(){
		String s;
		s="Title:\t\t"+title+"\nBrand:\t\t"+brand+"\nDuration:\t"+duration+"\nSupport:\t"+r.getClass().getSimpleName()+"\nSize:\t";
		if (size==null) s+="\t/\n\n";
		else s+= "\t"+size+" MB\n\n";
		return s;
	}

}
