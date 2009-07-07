package invoice;

public abstract class InvoicePrinter {
	private Invoice invoice;
	private String name;
	private String id;
	
	protected InvoicePrinter() {
		name = createName();
		id = createID();
	}

	protected final void setInvoice(Invoice inv) {
		invoice = inv;
	}
	
	protected final Invoice getInvoice() throws IllegalStateException {
		if (invoice == null)
			throw new IllegalStateException("Invoice not initialized yet.");

		return invoice;
	}
	
	protected final String createID() {return getClass().getName();}
	
	public String getName() {return name;}
	protected final String getID() {return id;}

	protected abstract String createName();
	protected abstract void print() throws Exception;
	
	public final boolean equals(Object o) {
		if (!(o instanceof InvoicePrinter))
			return false;
		
		InvoicePrinter ip = (InvoicePrinter)o;
		return getID().equals(ip.getID());
	}
}
