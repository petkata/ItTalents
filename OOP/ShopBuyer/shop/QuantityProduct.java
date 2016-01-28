package shop;

public class QuantityProduct extends Product {
	
	private int quantity;
	
	public QuantityProduct(String name, double price, int quantity) {
		super(name, price);
		this.setQuantity(quantity);
	}
	
	protected int getQuantity() {
		return this.quantity;
	}

	protected void setQuantity(int newQuantity){
		this.quantity = newQuantity;
	}
	
	@Override
	public double getProductQuantity() {
		return this.quantity;
	}
	
	@Override
	public void setProductQuantity(double newQuantity) {
		this.setQuantity((int) Math.round(newQuantity) + this.quantity);
	}

	@Override
	void showInfoForProduct() {
		super.showInfoForProduct();
		System.out.print(" per piece(");
		System.out.print(this.quantity + " pieces in total)");
	}
}
