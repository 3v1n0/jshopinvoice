package progetto;

import item.Item;
import item.ItemLinkedList;
import entities.Company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
//TODO singleton?!?  only if you want just one shop in our world, in this case you don need a cmp and a nm..

public class Shop extends Company {
	private String shopname;
	private InvoiceObserver obs;
	private ItemLinkedList items;
	private LinkedList<Invoice> invoices;
	//private LinkedList<Entity> clients; //TODO??? no.
	private static int shops;
	private static int added;
	private int id;
	
	Shop(Company cmp, String nm) {
		super(cmp.getName(), cmp.getAddress(), cmp.getVATIN(), cmp.getPhone(),
			  cmp.getFax(), cmp.getMail(), cmp.getWeb());
		shopname = nm;
		invoices = new LinkedList<Invoice>();
		items = new ItemLinkedList();
		obs = new InvoiceObserver();
		id = (++shops);
	}
	
	public void addItem(Item i) {
		i.setId(++added);
		items.add(i);
	}
	
	public void removeItem(Item i) {
		i.setId(0);
		items.remove(i);
	}
	
	protected void addInvoice(Invoice i) {
		i.addObserver(obs);
		invoices.add(i);
	}
	
	protected void removeInvoice(Invoice i) {
		i.deleteObservers();
		invoices.add(i);
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
				"\t\t\t\t<td><b>Oggetto</b></td>\n" +
				"\t\t\t\t<td><b>Descrizione</b></td>\n" +
				"\t\t\t\t<td><b>Prezzo</b></td>\n" +
				"\t\t\t</tr>\n";
		
		for (Item i : items)
			html += "\t\t\t<tr id='"+i.getId()+"'>\n" +
					"\t\t\t\t<td>"+stringToHTML(i.getName())+"</td>\n" +
					"\t\t\t\t<td>"+stringToHTML(i.getDescription())+"</td>\n" +
					"\t\t\t\t<td>"+i.getPrice()+
					(i.getDiscount() > 0 ? " ("+i.getDiscount()+"%)" : "") +
					"</td>\n" +
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
					tstr += "&amp;";
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
	public String getCompanyName() {return super.getName();}
	public int getId() {return id;}
	public int getItemCount() {return items.getSize();}
	public int getInvoicesCount() {return invoices.size();}
	public LinkedList<Invoice> getInvoices() {return invoices;}
}
