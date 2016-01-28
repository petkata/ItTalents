package shop;

/**
 * Extended the task for Shop/Buyer with some new methods.
 * 
 * <h1>Implemented</h1>
 * <ol>
 *  <li> create shop (as the original task stated)</li>
 *  <li> add products (as the original task stated) </li>
 *  <li> add products with some quantity to storage of the shop</li>
 *  <li> adding existing products only increases their quantity in the storage</li>
 *  <li> show statistic for the shop
 *  	<ul>
 *  	 	<li>name of the store</li>
 *  		<li>address of the store</li>
 *  		<li>money in the safe</li>
 *  		<li>list of products</li>
 *  	</ul>
 *  </li>
 *  <li> create buyer (as the original task stated)</li>
 *  <li> add products to buyer's cart with stated quantity</li>
 *  <li> adding existing products only increases their quantity in the cart</li>
 *  <li> show statistic for the user's cart
 *  	<ul>
 *  		<li>list of products</li>
 *  		<li>total bill of all products n cart</li>
 *  		<li>current money</li>
 *  		<li>money after payment</li>
 *  	</ul>
 *  </li>
 *  <li>remove stated quantity of product</li>
 *  <li>if the removed quantity is greater that the existing one the whole product is removed</li>
 *  <li>pay for the products in the cart</li>
 * </ol> 
 * 
 * @author Petkata
 *
 */
public class ShopDemo {
	
	public static void main(String[] args) {
		
//		Shop billa = new Shop("Billa", "sofia", 32156.56, 4);
		
		Shop billa = Shop.createShop("billa", "same address", 2, 4);
//		billa.showStats();
		Shop kauf = Shop.createShop("kauf", "asd", 10, 5);
//		kauf.showStats();
		
		// Left the original initialization of product classes
		WeightProduct meat = new WeightProduct(null, 1, 32.5);
		WeightProduct cheese = new WeightProduct("cheese", 11.56, 100.6);
		WeightProduct fish = new WeightProduct("fish", -9, 15);

		QuantityProduct beer = new QuantityProduct("beer", 1.05, 56);
		QuantityProduct book = new QuantityProduct("book", 10.65, 1001);
		QuantityProduct chair = new QuantityProduct("chair", 56.30, 23);
		
		kauf.addToStorage(meat,10);
		kauf.showStats();
		
		billa.addToStorage(fish,32.5);
		billa.addToStorage(fish,-32.5);
		billa.addToStorage(book,1001.5);
		billa.addToStorage(cheese,100.6);
		billa.addToStorage(cheese,55);
		billa.addToStorage(chair,3);
		billa.addToStorage(chair,3);
		billa.addToStorage(beer,30);
		
		
		billa.showStats();
		
//		Buyer buyer = new Buyer(null, 4, 5000.56);
		
		Buyer buyer = Buyer.createBuyer(billa, 4, 5665);
		
		buyer.addToCart(beer, 10);
		buyer.addToCart(chair,1.3);
		buyer.addToCart(fish,5.6);
		buyer.addToCart(book,-50);
		buyer.addToCart(book,2);
		buyer.addToCart(book,2);
		buyer.addToCart(meat, 10);
		buyer.showCart();
//		
//		billa.showStats();
//		
//		buyer.removeFromCart(cheese,100);
		buyer.removeFromCart(book,2);
		buyer.showCart();
//		
		buyer.pay(billa);
//		buyer.addToCart(book,5);
//		buyer.emptyCart();
//		buyer.showCart();
//		billa.showStats();
	}
}
