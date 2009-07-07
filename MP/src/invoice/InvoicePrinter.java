package invoice;

public abstract class InvoicePrinter {
	private Invoice invoice;

	protected final void setInvoice(Invoice inv) {
		invoice = inv;
	}
	
	protected final Invoice getInvoice() throws IllegalStateException {
		if (invoice == null)
			throw new IllegalStateException("Invoice not initialized yet.");

		return invoice;
	}

	protected abstract void print() throws Exception;
}
