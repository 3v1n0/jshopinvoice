package jshopper;

import javax.swing.JOptionPane;

import invoice.Shopper;
import item.Item;
import item.ItemList;

public class ItemSelectorPane extends ItemSelector {

	public Item select(Shopper sh) {
		int c = -1;
		c = getInt(sh.getItems());
			
		if (c > 0 && c <= sh.getItems().getSize())
			return sh.getItems().get(c-1);
		else
			return null;
	}
	
	protected boolean setLoop() {return true;}

	private int getInt(ItemList<? extends Item> itemList) {
		byte[] b = new byte[9];
		int res = 0;
		int m = 1;
		boolean cfl = false;
		String s, c = "";
		
		for (int i = 0; i < itemList.getSize(); i++) {
			Item item = itemList.get(i);
			c += (i+1)+") "+item.getName()+", "+item.getDescription() +
				  " - "+item.getType()+" - "+item.getPrice() +"EUR " +
				  (item.getDiscount() > 0 ? " ("+item.getDiscount()+"% di sconto)" : "" )+
				  " - Disponibilità: "+item.getCount()+"\n";
		}

		c += "0) Quit";		
			
		s = JOptionPane.showInputDialog(c);
		for (int i = 0; i < s.length(); i++) {
			b[i] = (byte) s.charAt(i);
			if (b[i] == ' ')
				continue;
			else if (b[i] == '-' && (!cfl && m > 0))
				m = -1;
			else if (b[i] == '-' && m < 0)
				break;
			else if (b[i] >= '0' && b[i] <= '9') {
				res = res * 10 + b[i] - '0';
				cfl = true;
			} else
				break;
		}
		return m * res;
	}

}
