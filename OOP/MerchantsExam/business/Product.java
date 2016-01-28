package business;

import utils.FormatMoney;
import utils.RandomGenerator;

public class Product {

	public static final double PRODUCT_MAX_PRICE = 15;
	
	public static final double PRODUCT_MIN_PRICE = 5;
	
	private String productName;

	private double price;
	
	public Product(String name) {
		this.productName = name;
		this.price = RandomGenerator.generatePriceForProduct();
	}
	
	public String getProductName(){
		return this.productName;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	//tests
	void showProduct(){
		System.out.println("  Product name:" + this.productName);
		System.out.println("  Product price: " + FormatMoney.FromatMoney(this.price));
	}
}
