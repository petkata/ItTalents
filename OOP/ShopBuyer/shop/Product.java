package shop;

import utilities.Validations;

public abstract class Product {

	private String name;
	private double price;
	
	public Product(String name, double price) {
		this.setName(name);
		this.setPrice(price);
	}
	
	public Product(String name, double price,double quantity) {
		this.setName(name);
		this.setPrice(price);
		this.setProductQuantity(quantity);
	}
	
	public String getName() {
		return name;
	}

	private void setName(String name) {
		if (Validations.isValidString(name)) {
			this.name = name;
			return;
		}
		System.out.println("Incorrect name!");
	}

	protected double getPrice() {
		return price;
	}

	private void setPrice(double price) {
		if (Validations.isValidDouble(price)) {
			this.price = price;
			return;
		}
		System.out.println(this.name + ": Invalid price!");
	}
	// Is it correct to use these methods?
	public abstract double getProductQuantity();
	public abstract void setProductQuantity(double newQuantity);
	
	void showInfoForProduct(){
		System.out.print("  - "+this.name +" "+ this.price);
	}
	
	@Override
	public boolean equals(Object anotherProduct) {
		if (anotherProduct instanceof Product) {
			if (this.name.equalsIgnoreCase(((Product)anotherProduct).name)) {
				return true;
			}
		}
		return false;
	}
}
