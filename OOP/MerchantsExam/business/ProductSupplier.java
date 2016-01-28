package business;

import utils.RandomGenerator;

public class ProductSupplier {

	private String supplierName;
	private String workingTime;
	private String address;
	private Product[] products;
	
	public ProductSupplier(String name, String workingtime, String address) {
		this.supplierName = name;
		this.workingTime = workingtime;
		this.address = address;
		this.fillProductList();
	}

	static class WholesaleSupplier extends ProductSupplier{

		public WholesaleSupplier(String name, String workingtime, String address) {
			super(name, workingtime, address);
		}
		
		public double discountProduct(double price){
			return price - price*0.15;
		}
	}
	
	private void fillProductList(){
		String[] prod = {"laptop", "monitor", "vcr", "vef","kbrd", "watch", "gsm","sugar","potatoes","salt","watermelon","flour","apfel","water"};
		this.products = new Product[prod.length];
		for (int i = 0; i < this.products.length; i++) {
			this.products[i] = new Product(prod[i]);
		}
	}
	
	public String getSupplierName(){
		return  this.supplierName;
	}
	
	public void supply(CommercialBuilding[] cb){
		for (int i = 0; i < cb.length; i++) {
			while(cb[i].getMoneyToSpend() >=  Product.PRODUCT_MIN_PRICE){
				Product randomProductFromList =this.products[RandomGenerator.generateNumberInRange(this.products.length-1)];
				if (cb[i].getMoneyToSpend() >= randomProductFromList.getPrice()) {
					cb[i].addProduct(randomProductFromList, this);
				}
				else {
					if (cb[i].getMoneyToSpend() >= Product.PRODUCT_MIN_PRICE) {
						boolean hasCheaperProduct = false;
						for (int j = 0; j < products.length; j++) {
							if (products[j].getPrice() < cb[i].getMoneyToSpend()) {
								cb[i].addProduct(products[j], this);
//								hasCheaperProduct = true;
//								break;
							}
						}
						if (!hasCheaperProduct) {
							break;
						}
					}
					else break;
				}
			}
		}
	}
	
	public Product[] supply(double totalOrderCost, int numberOfProducts) {
		Product[] productsToBeSupplied = new Product[numberOfProducts];
		while (totalOrderCost >=  Product.PRODUCT_MIN_PRICE) {
			for (int i = 0; i < productsToBeSupplied.length; i++) {
				Product randomProductFromList =this.products[RandomGenerator.generateNumberInRange(this.products.length-1)];
				if (totalOrderCost >= randomProductFromList.getPrice()) {
					productsToBeSupplied[i] = randomProductFromList;
					totalOrderCost -= randomProductFromList.getPrice();
				}
				else {
					if (totalOrderCost >= Product.PRODUCT_MIN_PRICE) {
						boolean hasCheaperProduct = false;
						for (int j = 0; j < products.length; j++) {
							if (products[i].getPrice() < totalOrderCost) {
								totalOrderCost -= randomProductFromList.getPrice();
								productsToBeSupplied[i] = products[i];
//								hasCheaperProduct = true;
//								break;
							}
						}
						if (!hasCheaperProduct) {
							return productsToBeSupplied;
						}
					}
					else return productsToBeSupplied;
				}
			}
		}
		return null;
	}
	
	private Product[] sortedProducts() {
		
		return null;
	}

	//tests
	void infoForSupp(){
		System.out.println("Name: " + this.supplierName);
		System.out.print("Type of supplier: ");
		if (this instanceof WholesaleSupplier) {
			System.out.println(" wholesales");
		}
		else {
			System.out.println("retail");
		}
		System.out.println("List of products: ");
		for (int i = 0; i < products.length; i++) {
			this.products[i].showProduct();
			System.out.println("-------------------------------");
		}
	}
}
