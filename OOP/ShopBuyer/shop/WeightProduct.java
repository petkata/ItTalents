package shop;

public class WeightProduct extends Product {

	private double weight;
	
	public WeightProduct(String name, double price, double weight) {
		super(name,price);
		this.setWeight(weight);
	}
	
	protected double getWeight(){
		return this.weight;
	}
	
	protected void setWeight(double newWeight){
		this.weight = newWeight;
	}
	
	@Override
	public double getProductQuantity() {
		return this.weight;
	}
	
	@Override
	public void setProductQuantity(double newQuantity) {
		this.setWeight(newQuantity + this.weight);
	}

	@Override
	void showInfoForProduct() {
		super.showInfoForProduct();
		System.out.print(" per kilo(");
		System.out.print(this.weight + " kgs in total)");
	}
}
