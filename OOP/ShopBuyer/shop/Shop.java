package shop;

import java.util.Arrays;

import utilities.IProductAddable;
import utilities.Validations;

public class Shop implements IProductAddable{

	private String name;
	private String address;
	private double moneyInSafe;
	private int storageVolume;
	private Product[] listOfProducts;
	
	private Shop(String name, String address, double moneyInSafe, int storageVolume) {
		this.name = name;
		this.address = address;
		this.setMoneyInSafe(moneyInSafe);
		this.storageVolume = storageVolume;
		this.listOfProducts = new Product[storageVolume];
	}
	
	public static Shop createShop(String name, String address, double moneyInSafe, int storageVolume){
		if (Validations.isValidString(name) 
				&& Validations.isValidString(address)
				&& Validations.isValidDouble(moneyInSafe)
				&& Validations.isValidInt(storageVolume)
				) {
			return new Shop(name, address, moneyInSafe, storageVolume);
		}
		System.out.println("Cannot create shop " +name.toUpperCase()+ ": Incorrect input data");
		return null;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setMoneyInSafe(double moneyInSafe){
		this.moneyInSafe += moneyInSafe;
	}
	
	public Product[] getListOfProducts(){
		return this.listOfProducts;
	}
	
	public Product getProductFromList(Product product){
		
		for (int i = 0; i < this.listOfProducts.length; i++) {
			if (this.listOfProducts[i] == null) {
				continue;
			}
			if (this.listOfProducts[i].equals(product)) {
				return this.listOfProducts[i];
			}
		}
		return null;
	}
	/**
	 * <strong>Adds a product to the storage of the shop</strong>
	 * <p>If the added product exists in the storage its quantity is added to the existing one</p>
	 * @param newProduct -> the product to be added
	 * @param quantity -> the quantity of the product
	 */
	public void addToStorage(Product newProduct, double quantity) {
		if (!Validations.isValidDouble(quantity) || !Validations.isValidString(newProduct.getName()) || !Validations.isValidDouble(newProduct.getPrice())) {
			System.out.println("--Cannot add product " + newProduct.getName() + ": Incorrect input data");
			return;
		}
		if (this.storageVolume <= 0 && !Arrays.asList(this.listOfProducts).contains(newProduct)) {
			System.out.println("--Cannot add " + newProduct.getName() + "! The storage of " + this.name.toUpperCase() + " is full!");
			return;
		}
		if (Arrays.asList(this.listOfProducts).contains(newProduct)) {
			addQuantityToExistingProduct(this.listOfProducts, newProduct, quantity);
			System.out.println(" to storage of " + this.name.toUpperCase());
			return;
		}
		if (newProduct instanceof WeightProduct) {
			System.out.print(" " + quantity +" kilo"+((quantity<=1)? " ": "s ")+ "of " +newProduct.getName() + " added to storage");
			this.listOfProducts[this.listOfProducts.length - this.storageVolume--] = new WeightProduct(newProduct.getName(), newProduct.getPrice(), quantity);
		}
		if (newProduct instanceof QuantityProduct) {
			if (quantity != Math.round(quantity)) {
				System.out.println("--Warning: qunatity of \"" + newProduct.getName() + "\" must be a whole number. Qunatity would be rounded!");
			}
			this.listOfProducts[this.listOfProducts.length - this.storageVolume--] = new QuantityProduct(newProduct.getName(), newProduct.getPrice(),(int) Math.round(quantity));
			System.out.print(" " + (int) Math.round(quantity) + " " + newProduct.getName()+ ((Math.round(quantity)<=1)? " ": "s ") + "added to storage");
		}
		System.out.println(" of " + this.name.toUpperCase());
	}

	public void showStats() {
		System.out.println("-----------------------");
		System.out.println("Name of the store: " + this.name);
		System.out.println("Address of the store: " + this.address);
		System.out.println("Money in safe: " + this.moneyInSafe);
		System.out.println("Products in store:");
		if (this.storageVolume == this.listOfProducts.length) {
			System.out.println(" -The storage is empty!");
			System.out.println("-----------------------");
			return;
		}
		for (int i = 0; i < listOfProducts.length; i++) {
			if (this.listOfProducts[i] != null) {
				listOfProducts[i].showInfoForProduct();
				System.out.println();
			}
		}
		System.out.println("-----------------------");
	}
}
