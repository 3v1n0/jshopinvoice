package item;

public class Decoder extends GenericItem{
// classe leaf del pattern composite
	private boolean smartCard;
	
	public Decoder(String nm, String br, Float pr, String desc,boolean sc) {
		super(br, nm, desc, pr);
		smartCard = sc;
	}
	
		
	public boolean getSmartCard() {return smartCard;}

	
}
