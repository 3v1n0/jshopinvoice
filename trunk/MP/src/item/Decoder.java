package item;

public class Decoder extends Item{

	private boolean smartCard;
	
	Decoder(String nm, String br, Float pr, String desc,boolean sc) {
		super(nm, br, pr, desc);
		smartCard = sc;
	}
	
		
	public boolean getSmartCard() {return smartCard;}

	
}
