package readable;

public class HDDVD extends Readable {
	
	private HDDVD(){};
	public HDDVD(String title,String brand,Integer duration,Integer size){
		super(title,brand,duration,size);		
	}
	
	Readable createLeggibili(){return new HDDVD();}

}
