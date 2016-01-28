package shop;

import java.util.Arrays;

import utilities.IProductAddable;
import utilities.Validations;

public class Buyer implements ICart, IProductAddable{

	private Shop shop;
	private int quantityOfCarriableItems;
	private double availableMoney;
	private Product[] cart;
	
	private Buyer(Shop shop, int quantityOfCarriableItems, double availableMoney) {
		if(shop == null) return;
		this.shop = shop;
		this.quantityOfCarriableItems = quantityOfCarriableItems;
		this.availableMoney = availableMoney;
		this.cart = new Product[quantityOfCarriableItems];
	}
	
	public static Buyer createBuyer(Shop shop, int quantityOfCarriableItems, double availableMoney){
		if (shop!=null && 
			Validations.isValidInt(quantityOfCarriableItems) &&
			Validations.isValidDouble(availableMoney)) {
			return new Buyer(shop, quantityOfCarriableItems, availableMoney);
		}
		System.out.println("Cannot create buyer: Incorrect input data");
		return null;
	}
	
	/**
	 * <strong>Adds a product to the buyer's cart</strong>
	 * <p>If the added product exists in the cart its quantity is added to the existing one</p>
	 * @param product -> the product to be added
	 * @param quantity -> the quantity of the product
	 */
	public void addToCart(Product product, double quantity) {
		if (!Validations.isValidDouble(quantity)) {
			System.out.println("--Cannot add to cart("+product.getName()+"): Incorrect quantity!");
			return;
		}
		if (this.shop.getProductFromList(product)==null) {
			System.out.println("--Cannot add to cart: There is no such product("+product.getName()+") in " + this.shop.getName().toUpperCase());
			return;
		}
		
		/*
		 * Which is better:
		 *  Arrays.sort(this.cart, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER));
		 *  this sorts the array and puts the nulls after the products
		 *  or
		 *  the implementation below which finds the first null element and stores there the product that we want to add
		 */
		
		for (int i = 0; i < this.cart.length; i++) {
			if (this.cart[i] == null) {
				
				if (this.shop.getProductFromList(product).getProductQuantity() - quantity < 0) {
					System.out.println("--You request " + quantity +" "+ product.getName() + ", but there are only " + 
							this.shop.getProductFromList(product).getProductQuantity() + 
								" " + 
								product.getName() + " left in " + this.shop.getName().toUpperCase());
					System.out.println("--" + this.shop.getProductFromList(product).getProductQuantity() + 
								" " + 
								product.getName() + " will be added to cart!");
					quantity = this.shop.getProductFromList(product).getProductQuantity();
				}
				
				if (Arrays.asList(this.cart).contains(product)) {
					addQuantityToExistingProduct(this.cart, product, quantity);
					System.out.println(" to cart");
					return;
				}
				
				if (product instanceof WeightProduct) {
					
					this.cart[i] = new WeightProduct(product.getName(), product.getPrice(), quantity);
					this.addToCartWeightedProduct(this.shop,product, quantity);
					System.out.println(" " + quantity +" kilo"+((quantity<2)? " ": "s ")+ "of " +product.getName() + " added to cart");
					break;
				}
				if (product instanceof QuantityProduct) {
					if (quantity != Math.round(quantity)) {
						System.out.println("--Warning: qunatity of \"" + product.getName() + "\" must be a whole number. Qunatity would be rounded!");
					}
					this.cart[i] = new QuantityProduct(product.getName(), product.getPrice(), (int) Math.round(quantity));
					this.addToCartQuantityProduct(this.shop, product, quantity);
					System.out.println(" " +(int) Math.round(quantity) + " " + product.getName()+ ((quantity<2)? " ": "s ") + "added to cart");
					break;
				}
			}
			if(i == this.cart.length - 1 ) {
				System.out.println("The cart is full!");
				return;
			}
		}
		this.quantityOfCarriableItems--;
	}
	/**
	 * <strong>Removes a product to the buyer's cart</strong>
	 * <p>If the removed quantity is greater that the existing one the whole product is removed</p>
	 * @param product -> the product to be removed
	 * @param quantity -> the quantity which will be removed 
	 */
	public void removeFromCart(Product product, double quantity) {
		for (int i = 0; i < this.cart.length; i++) {
			if (this.cart[i] == null) {
				continue;
			}
			if (this.cart[i].equals(product)) {
				if (this.cart[i] instanceof QuantityProduct) {
					if (((QuantityProduct) this.cart[i]).getQuantity() >= quantity) {
						this.removeFromCartQuantityProduct(this.shop, this.cart[i], (int) Math.round(quantity));
						((QuantityProduct) this.cart[i]).setQuantity(((QuantityProduct) this.cart[i]).getQuantity() - (int) Math.round(quantity));
						if (((QuantityProduct) this.cart[i]).getQuantity() != 0) {
							System.out.println((int)Math.round(quantity) + " " + product.getName() + " removed from cart");
							return;
						}
					}
					else {
						this.removeFromCartQuantityProduct(this.shop, this.cart[i], ((QuantityProduct) this.cart[i]).getQuantity());
						System.out.println("--You do not have " + quantity + " " + product.getName() + "! All " + product.getName() + " will be removed!");
					}
					
				}
				if (this.cart[i] instanceof WeightProduct) {
					if (((WeightProduct) this.cart[i]).getWeight() >= quantity) {
						this.removeFromCartWeightProduct(this.shop, this.cart[i], quantity);
						((WeightProduct) this.cart[i]).setWeight(((WeightProduct) this.cart[i]).getWeight() - (quantity));
						if (((WeightProduct) this.cart[i]).getWeight() != 0) {
							System.out.println(quantity + " " + product.getName() + " removed from cart");
							return;
						}
					}
					else {
						this.removeFromCartWeightProduct(this.shop, this.cart[i], ((WeightProduct) this.cart[i]).getWeight());
						System.out.println("--You do not have " + quantity + " " + product.getName() + "! All " + product.getName() + " will be removed!");
					}
				}
				this.cart[i] = null;
				this.quantityOfCarriableItems++;
				System.out.println("All " + product.getName() + " removed from cart");
				return;
			}
		}
		System.out.println("No such item("+product.getName()+") in your cart!");
	}

	public void pay(Shop shop) {
		if (this.availableMoney < this.calcBillFromItemsInCart()) {
			System.out.println("--Insufficient money to complete payment!");
			return;
		}
		this.availableMoney -= this.calcBillFromItemsInCart();
		this.shop.setMoneyInSafe(this.calcBillFromItemsInCart());
		this.emptyCart();
		System.out.println("--Payment successful! Money left: " + this.availableMoney );
	} 

	public void showCart() {
		System.out.println("-----------------------");
		System.out.println("Items in cart:");
		if (this.quantityOfCarriableItems == this.cart.length) {
			System.out.println("  - The cart is empty!");
			System.out.println("You have: " + this.availableMoney);
			return;
		}
		for (int i = 0; i < this.cart.length; i++) {
			if (this.cart[i] == null) {
				continue;
			}
			System.out.println("  - " + this.cart[i].getName() + ": " + this.cart[i].getProductQuantity());
		}
		System.out.println("Total bill: " + this.calcBillFromItemsInCart());
		System.out.println("You have: " + this.availableMoney);
		if (this.availableMoney < this.calcBillFromItemsInCart()) {
			System.out.println("Not enough money!");
		}
		else {
			System.out.println("Money after payment: " + (this.availableMoney - this.calcBillFromItemsInCart()));
		}
		System.out.println("-----------------------");
	}
	
	private double calcBillFromItemsInCart(){
		double bill = 0;
		for (int i = 0; i < this.cart.length; i++) {
			if (this.cart[i] == null) {
				continue;
			}
			bill += this.cart[i].getPrice()*this.cart[i].getProductQuantity();
		}
		return bill;
	}

	public void emptyCart() {
		for (int i = 0; i < cart.length; i++) {
			this.cart[i] = null;
		}
		this.quantityOfCarriableItems = this.cart.length;
	}
}
