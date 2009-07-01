package progetto;

public abstract class InvoicePrint {
	private Invoice invoice;

	protected final void setInvoice(Invoice inv) {
		invoice = inv;
	}
	
	protected final Invoice getInvoice() {
		return invoice;
	}

	protected abstract void print();
}
