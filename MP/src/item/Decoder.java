package item;

public class Decoder extends Item{

	private boolean smartCard;
	
	Decoder(String nm, String br, Float pr, String desc,boolean sc) {
		super(br, nm, desc, pr);
		smartCard = sc;
	}
	
		
	public boolean getSmartCard() {return smartCard;}

	
}