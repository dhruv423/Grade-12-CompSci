
public abstract class Item {
	protected double purchasePrice;
	protected double sellingPrice;
	protected long UPC;
	
	
	public Item(double pPrice, double sPrice, long UPC){
		this.purchasePrice = pPrice;
		this.sellingPrice = sPrice;
		this.UPC = UPC;
	}
	public abstract void sale (double percent_discount);
	
}
