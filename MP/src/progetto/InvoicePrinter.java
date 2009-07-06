package progetto;

public abstract class InvoicePrinter {
	private Invoice invoice;

	protected final void setInvoice(Invoice inv) {
		invoice = inv;
	}
	
	protected final Invoice getInvoice() {
		return invoice;
	}

	protected abstract void print() throws Exception;
}
