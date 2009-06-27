package item;

public class Speakers extends ConcreteItem {
// classe leaf del pattern composite

	private Integer power;
	private Integer channels;
	
	public Speakers(String nm, String br, Float pr, String desc, Integer pwr, Integer ch) {
		super(br, nm, desc, pr);
		power = pwr;
		channels = ch;
	}

	public Integer getPower() {return power;}
	public Integer getChannels() {return channels;}

}