package business;

import business.ProductSupplier.WholesaleSupplier;
import utils.RandomGenerator;
import utils.SortByPrice;

public class CommercialBuilding {

	private String addressOfBuilding;
	private String workingTime;
	private int area;
	private double tax;
	private double moneyToSpend;
	private Product[] products;
	private String buildingType;
	private double totalOrderCost;
	
	private int numberOfSoldProducts;
	private int numberOfAddedProducts;
	
	public CommercialBuilding(String addressOfBuilding, String workingTime) {
		this.addressOfBuilding = addressOfBuilding;
		this.workingTime = workingTime;
		this.tax = 50;
	}

	static class Stand extends CommercialBuilding{
		
		public Stand(String addressOfBuilding, String workingTime) {
			super(addressOfBuilding, workingTime);
			super.area = RandomGenerator.generateNumberInRange(8)+2;
			super.buildingType = "stand";
		}
		
	}
	
	static class ShopInMall extends CommercialBuilding{

		public ShopInMall(String addressOfBuilding, String workingTime) {
			super(addressOfBuilding, workingTime);
			super.area = RandomGenerator.generateNumberInRange(90)+10;
			super.tax = 150;
			super.buildingType = "mallShop";
		}
		
	}
	
	static class Rep extends CommercialBuilding{

		public Rep(String addressOfBuilding, String workingTime) {
			super(addressOfBuilding, workingTime);
			super.area = RandomGenerator.generateNumberInRange(2)+4;
			super.buildingType = "rep";
		}
	}
	
	public double getTax() {
		return this.tax;
	}
	
	public double getProfit(){
		return this.moneyToSpend;
	}
	
	public void sellProducts() {
		int randomNumberOfSoldProducts = RandomGenerator.generateNumberInRange(this.numberOfAddedProducts) + 1; // at least 1 product would be sold
		for (int i = 0; i < randomNumberOfSoldProducts; i++) {
			int positionOfProductInList = RandomGenerator.generateNumberInRange(this.numberOfAddedProducts-1);
			if (this.products[positionOfProductInList] != null) {
				this.moneyToSpend += this.products[positionOfProductInList].getPrice()*1.3;
				this.numberOfSoldProducts++;
				this.products[positionOfProductInList]=null;
			}
		}
		SortByPrice.sortProducts(this.products, 0, this.products.length-1);
	}
	
	public void setMoneyToSpend(double money){
		this.moneyToSpend -= money;
	}
	
	int getNumberOfSoldProducts(){
		return this.numberOfSoldProducts;
	}

	double getMoneyToSpend(){
		return this.moneyToSpend;
	}

	void setTotalOrderCost(double money){
		this.totalOrderCost = money;
		this.moneyToSpend = this.totalOrderCost;
		//ASSUMES product number
		int ratio = (int) (this.totalOrderCost/Product.PRODUCT_MIN_PRICE);
		this.products = new Product[(ratio)];
	}
	
	void  addProduct(Product p, ProductSupplier supplier){
		double discountCoef=0;
		for (int i = 0; i < this.products.length; i++) {
			if (this.products[i] == null) {
				this.products[i] = p;
				this.numberOfAddedProducts++;
				if (supplier instanceof WholesaleSupplier) {
					discountCoef = 0.15;
				}
				this.setMoneyToSpend(p.getPrice() - p.getPrice()*discountCoef);
				break;
			}
		}
		SortByPrice.sortProducts(this.products, 0, this.products.length-1);
	}	
	// testing
	void infoForBuilding(){
		System.out.println("Shop address: " + this.addressOfBuilding);
		System.out.println("Shop type: " + this.buildingType);
		System.out.println("Tax: " + this.tax);
		System.out.println("money to spend: " + this.moneyToSpend);
	}
	
	void infoForProd(){
		for (int i = 0; i < products.length; i++) {
			if (products[i] != null) {
				products[i].showProduct();
			}
		}
	}
	
}
