package progetto;

import item.Item;
import entities.Company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
//TODO singleton?!?

public class Shop extends Company {
	private String shopname;
	private LinkedList<Item> items;
	private LinkedList<Invoice> invoices;
	//private LinkedList<Entity> clients; //TODO???
	private static int id;
	
	Shop(Company cmp, String nm) {
		super(cmp.getName(), cmp.getAddress(), cmp.getVATIN(), cmp.getPhone(),
			  cmp.getFax(), cmp.getMail(), cmp.getWeb());
		shopname = nm;
		invoices = new LinkedList<Invoice>();
		items = new LinkedList<Item>();
		id++;
	}
	
	public void addItem(Item i) {
		items.add(i);
	}
	
	public void printItemsHtml() throws IOException {
		String filepath = System.getProperty("java.io.tmpdir") +
						  System.getProperty("file.separator") + "Shop.html";
		
		FileOutputStream file = new FileOutputStream(filepath);
		//TODO manage exception
		
		String html = "<html>\n" +
					  "\t<head>\n" +
					  "\t\t<title>"+getName()+" Items list</title>\n" +
					  "\t</head>\n" +
					  "\t<body>\n" +
					  "\t\t<h1>"+getName()+"</h1>\n" +
					  "\t\t<table align=\"center\">\n";
		
		html += "\t\t\t<tr>\n" +
				"\t\t\t\t<td><b>Oggetto</b></td>\n"+
				"\t\t\t\t<td><b>Descrizione</b></td>\n"+
				"\t\t\t\t<td><b>Prezzo</b></td>\n" +
				"\t\t\t</tr>\n";
		
		for (Item i : items)
			html += "\t\t\t<tr id='"+i/*.getId() TODO*/+"'>\n" +
					"\t\t\t\t<td>"+stringToHTML(i.getName())+"</td>\n"+
					"\t\t\t\t<td>"+stringToHTML(i.getDescription())+"</td>\n"+
					"\t\t\t\t<td>"+i.getPrice()+"</td>\n" +
					"\t\t\t</tr>\n";
		
		html += "\t\t</table>\n" +
				"\t<body>\n" +
				"</html>";

		file.write(html.getBytes("US-ASCII"));
		System.out.println("\nINFO Shop Item file list saved in "+filepath);
	}
	
	// Move as a static method to an utility class?
	private String stringToHTML(String str) {
		String tstr = "";
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch (c) {
				case '<':
					tstr += "&lt;";
					break;
				case '>':
					tstr += "&gt;";
					break;
				case '"':
					tstr += "&quot;";
					break;
				case '&':
					tstr += "&quot;";
					break;
				default:
					if (c > 0x7f)
						tstr += "&#"+(int)c+";";
					else
						tstr += c;
			}
		}
		
		return tstr.toString();
	}
	
	public String getName() {return shopname;}
	public int getItemNum() {return items.size();}
	public LinkedList<Invoice> getInvoices() {return invoices;}
}
