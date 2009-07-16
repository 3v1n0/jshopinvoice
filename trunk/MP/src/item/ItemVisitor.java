package item;

public interface ItemVisitor {
	void visit(Item i);
	void visit(ItemPackage<? extends Item> ip);
	void visit(GenericItem gi);
}
