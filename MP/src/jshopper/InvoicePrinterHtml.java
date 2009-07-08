package jshopper;


import invoice.Invoice;
import invoice.InvoicePrinter;
import invoice.ShopItem;
import item.Item;
import item.SinglePartException;

import java.io.FileOutputStream;
import java.io.IOException;



public class InvoicePrinterHtml extends InvoicePrinter {
	private String htmlfile;
	private String htmlpath;
	
	InvoicePrinterHtml(String path, String file) {
		htmlpath = path;
		htmlfile = file;
	}
	
	InvoicePrinterHtml() {
		this(null, null);
	}
	
	public void setFile(String f) {
		htmlfile = f;
	}
	
	public void setFilePath(String p) {
		htmlpath = p;
	}
	
	protected String createName() {
		return "Test HTML Printer";
	}
	
	protected String getHtmlFile() {
		return htmlfile;
	}
	
	protected String getHtmlPath() {
		return htmlpath;
	}

	protected void print() throws IOException {
		String hfile;
		String hpath;
		
		Invoice i = getInvoice();
		
		if (htmlpath == null)
			hpath = Utility.getTmpPath();
		else
			hpath = htmlpath;

		if (htmlfile == null)
			hfile = i.getSeller().getName().replaceAll(" ", "_")+"_Invoice_%d.html";
		else
			hfile = htmlfile;
		
		hfile = hfile.replaceAll("%d", Integer.toString(getInvoice().getId()));
		
		String hfilepath = hpath+System.getProperty("file.separator")+hfile;
		
		FileOutputStream file = new FileOutputStream(hfilepath);
		
		String html = 
		"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n" +
		"<html>\n" +
		"<head>\n" +
		"<title>"+Utility.stringToHTML(i.getSeller().getName()+" - Invoice n. "+i.getId())+"</title>\n" +
		"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\n" +
		"<style type=\"text/css\">\n" +
		"	 * { \n" +
		"		font-family: Verdana, Arial, Helvetica, sans-serif;\n" +
		"		font-size: 12px;\n" +
		"		font-style: normal;\n" +
		"		}\n" +
		"	 td { height: 25px; padding: 0px 10px; }\n" +
		"   table.main, table.data {border: 1px none #000000; border-collapse: collapse; width:720px; }\n" +
		"	 table.data, table.header, table.footer { width:100%; }\n" +
		"	 table.footer, table.header { color: #333399; }\n" +
		"	 td.data { border: 1px none #000000; border-left-style:solid; border-collapse: separate;}\n" +
		"	 table.detail, table.total {border: 1px solid #333399; width:100%; border-collapse: collapse; padding:5px; border-spacing:1px;}\n" +
		"	 table.total {width: 300px; border: 2px solid #333399; padding: 5px;}\n" +
		"  tr.title { color: #FFFFFF; background-color: #333399; text-align: center; font-weight: bold;}\n" +
		"	 td.title { border: 1px solid #FFFFFF; height: 50px; valign:middle; padding:5px;}\n" +
		"	 tr.item {\n" +
		"							color: #000000;\n" +
		"							background-color: #FFFFFF;\n" +
		"  						border: 1px solid #333399;\n" +
		"						}\n" +
		"	 td.item, td.item_total, td.item_total_detail, td.item_total_project {\n" +
		"		valign:middle;\n" +
		"	 }\n" +
		"	 td.item_total_total {\n" +
		"            border: 2px solid #333399;\n" +
		"\n" +
		"	 }\n" +
		" 	td.item {\n" +
		"			border-top-style: solid; \n" +
		"           border: 1px none #333399;\n" +
		"	 }\n" +
		"   td.subitem {\n" +
		"			height: 10px;\n" +
		"			padding-left: 20px;\n" +
	 	"			font-size: 10px;\n" +
	 	"			border: 1px none #333399;\n" +
	 	"			border-top-style: hidden;\n" +
	 	"}\n" +
		"	 td.item_total_project {\n" +
		"	 	border: 2px none #333399;\n" +
		"		border-top-style: solid; \n" +
		"	 }\n" +
		"	 \n" +
		" </style>\n" +
		"</head>\n" +
		"\n" +
		"<body>\n" +
		"\n" +
		"<table class=\"main\">\n" +
		"\n" +
		"<tr><td>\n" +
		"<table class=\"header\">\n" +
		"<tr>\n" +
		"<td align=\"left\">\n" +
		"<span style=\"font-size: 23px; font-weight: bold; color:#333399;\">"+Utility.stringToHTML(i.getSeller().getName())+"</span>\n" +
		"</td>\n" +
		"<td align=\"right\">\n" +
		Utility.stringToHTML(i.getSeller().getCompanyName())+"<br />\n"+
		Utility.stringToHTML(i.getSeller().getVATIN())+"<br />\n"+
		Utility.stringToHTML(i.getSeller().getAddress().getStreet() +", "+i.getSeller().getAddress().getNumber())+"<br />\n" +
		Utility.stringToHTML(i.getSeller().getAddress().getZip()+" - "+i.getSeller().getAddress().getCity() +
		" ("+i.getSeller().getAddress().getProvince())+")<br />\n" +
		Utility.stringToHTML(i.getSeller().getContacts().getPhone()) + "<br />\n" +
		Utility.stringToHTML(i.getSeller().getContacts().getFax()) +"<br />\n" +
		Utility.stringToHTML(i.getSeller().getContacts().getMail()) + "<br />\n" +
		Utility.stringToHTML(i.getSeller().getContacts().getWeb())+"<br />\n" +
		"</td>\n" +
		"</tr>\n" +
		"</table>\n" +
		"</td></tr>\n" +
		"\n" +
		"<tr><td height=\"40px\"></td></tr>\n" +
		"\n" +
		"<tr><td>\n" +
		"<table class=\"data\">\n" +
		"<tr>\n" +
		"<td class=\"data\" align=\"left\" width=\"70%\">\n" +
		"<b>Bill To: </b><br />\n" +
		Utility.stringToHTML(i.getBuyer().getName())+" <br />\n" +
		Utility.stringToHTML(i.getBuyer().getAddress().getStreet() +", "+i.getBuyer().getAddress().getNumber())+"<br />\n" +
		Utility.stringToHTML(i.getBuyer().getAddress().getZip()+" - "+i.getBuyer().getAddress().getCity() +
		" ("+i.getBuyer().getAddress().getProvince())+")<br />\n" +
		Utility.stringToHTML(i.getBuyer().getContacts().getMail())+"<br />\n" +
		(i.getBuyer() instanceof entities.Company ? "VATIN: "+((entities.Company)i.getBuyer()).getVATIN()+"<br />\n" : "" ) +
		"</td>\n" +
		"<td class=\"data\" align=\"left\" width=\"30%\">\n" +
		"<span style=\"font-size: 20px; font-weight: bold; color:#333399;\"> INVOICE </span> <br />\n" +
		"<b>INVOICE #</b>"+i.getId()+"<br />\n" +
		"<b>DATE: </b>"+Utility.stringToHTML(i.getTime().toString())+"<br />\n" +
		"</td>\n" +
		"</tr>\n" +
		"</table>\n" +
		"</td></tr>\n" +
		"<tr><td height=\"40px\"></td></tr>\n" +
		"<tr><td><b>Items added to the Invoice</b></td></tr>\n" +
		"<tr><td>\n" +
		"<table class=\"detail\">\n" +
		"<tr class=\"title\">\n" +
		"<td class=\"title\" width=\"15%\">Materials Quantity</td>\n" +
		"<td class=\"title\" width=\"40%\">Description</td>\n" +
		"<td class=\"title\" width=\"15%\">Unit Price</td>\n" +
		"<td class=\"title\" width=\"15%\">Discount</td>\n" +
		"<td class=\"title\" width=\"15%\">Total</td>\n" +
		"</tr>\n";
		
		for (ShopItem sh : i.getItems()) {
			html +=
			"<tr class=\"item\">\n" +
			"<td class=\"item\" align=\"left\">"+sh.getCount()+"</td>\n" +
			"<td class=\"item\" align=\"left\">"+Utility.stringToHTML(sh.getBrand()+" - "+sh.getName())+"</td>\n" +
			"<td class=\"item\" align=\"right\">"+sh.getPrice()+"</td>\n" +
			"<td class=\"item\" align=\"right\">"+(sh.getDiscount() > 0 ? sh.getDiscount()+"%" : "")+"</td>\n" +
			"<td class=\"item\" align=\"right\">"+(sh.getPrice()*sh.getCount())+"</td>\n" +
			"</tr>\n";
			
			try {
				for (Item it : sh.getSubItems())
					html +=
					"<tr class=\"subitem\">\n" +
					"<td class=\"subitem\" align=\"left\">&nbsp;</td>\n" +
					"<td class=\"subitem\" align=\"left\">"+Utility.stringToHTML(it.getBrand()+" - "+it.getName())+"</td>\n" +
					"<td class=\"subitem\" align=\"right\">"+it.getPrice()+"</td>\n" +
					"<td class=\"subitem\" align=\"right\">"+(it.getDiscount() > 0 ? it.getDiscount()+"%" : "")+"</td>\n" +
					"<td class=\"subitem\" align=\"right\">"+(it.getPrice()*sh.getCount())+"</td>\n" +
					"</tr>\n";
			} catch (SinglePartException e) {}
		}

		html += 
		"<tr class=\"item\">\n" +
		"<td class=\"item\" align=\"left\">&nbsp;</td>\n" +
		"<td class=\"item\" align=\"left\">&nbsp;</td>\n" +
		"<td class=\"item\" align=\"right\">&nbsp;</td>\n" +
		"<td class=\"item\" align=\"right\">&nbsp;</td>\n" +
		"<td class=\"item\" align=\"right\">&nbsp;</td>\n" +
		"</tr>\n" +
		"</table>\n" +
		"</td></tr>\n" +
		"\n" +
		"<tr><td>\n" +
		"<table class=\"detail\">\n" +
		"<tr>\n" +
		"	<td class=\"item_total_total\" align=\"right\" width=\"85%\"><b>Total</b></td>\n" +
		"    <td class=\"item_total_total\" align=\"right\">"+i.getTotal()+"</td>\n" +
		"</tr>\n" +
		"</table>\n" +
		"</td></tr>\n" +
		"\n" +
		"<tr><td height=\"100px\"></td></tr>\n" +
		"\n" +
		"<tr><td>\n" +
		"<table class=\"footer\">\n" +
		"<tr>\n" +
		"<td align=\"center\" width=\"100%\">\n" +
		"Make checks payable to: <b>"+Utility.stringToHTML(i.getSeller().getCompanyName())+"</b> <br />\n" +
		"<u>Thank you for your business!!</u> <br />\n" +
		"</td>\n" +
		"</tr>\n" +
		"</table>\n" +
		"</td></tr>\n" +
		"\n" +
		"</table>\n" +
		"\n" +
		"</body>\n" +
		"</html>\n";

		file.write(html.getBytes("US-ASCII"));
		System.out.println("HTML Invoice saved at "+hfilepath);
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof InvoicePrinterHtml))
			return false;
		
		InvoicePrinterHtml ip = (InvoicePrinterHtml)o;
		return (super.equals(ip) &&
				this.getHtmlFile() == ip.getHtmlFile() &&
				this.getHtmlPath() == ip.getHtmlPath());
	}

}
