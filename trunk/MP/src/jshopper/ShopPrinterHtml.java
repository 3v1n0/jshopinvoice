package jshopper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import invoice.*;
import item.Item;

public class ShopPrinterHtml implements ShopObserver {

	public void update(Shopper sh) {
		String filepath = Utility.getTmpPath()+sh.getName().replaceAll(" ", "_")+"_Items_list.html";

		FileOutputStream file;
		try {
			file = new FileOutputStream(filepath);
		} catch (FileNotFoundException e1) {
			System.out.println("Can't open file "+filepath);
			return;
		}

		String html = "<html>\n" +
			  "\t<head>\n" +
			  "\t\t<title>"+sh.getName()+" Items list</title>\n" +
			  "\t</head>\n" +
			  "\t<body>\n" +
			  "\t\t<h1>"+sh.getName()+"</h1>\n" +
			  "\t\t<table align=\"center\">\n";
		
		html += "\t\t\t<tr>\n" +
		"\t\t\t\t<td><b>Oggetto</b></td>\n" +
		"\t\t\t\t<td><b>Descrizione</b></td>\n" +
		"\t\t\t\t<td><b>Prezzo</b></td>\n" +
		"\t\t\t\t<td><b>"+Utility.stringToHTML("Disponibilità")+"</b></td>\n" +
		"\t\t\t</tr>\n";
		
		for (Item i : sh.getItems())
			html += "\t\t\t<tr id='"+i.getId()+"'>\n" +
				"\t\t\t\t<td>"+Utility.stringToHTML(i.getName())+"</td>\n" +
				"\t\t\t\t<td>"+Utility.stringToHTML(i.getDescription())+"</td>\n" +
				"\t\t\t\t<td>"+i.getPrice()+
				(i.getDiscount() > 0 ? " ("+i.getDiscount()+"%)" : "") +
				"</td>\n" +
				"\t\t\t\t<td>"+i.getCount()+"</td>\n" +
				"\t\t\t</tr>\n";
		
		html += "\t\t</table>\n" +
		"\t<body>\n" +
		"</html>";
		
		try {
			file.write(html.getBytes("US-ASCII"));
			System.out.println("\nShop Items file list saved in "+filepath);
		} catch (Exception e) {
			System.out.println("\nError saving Shop Items file list in "+filepath);
			e.printStackTrace();
		}
		
	}

}
