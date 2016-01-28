package business;

import utils.FormatMoney;
import utils.RandomGenerator;
import utils.SortByPrice;

public abstract class Merchant {

	private String name;
	private String addressOfReg;
	private double funds;
	private CommercialBuilding[] commercialBuildings;
	private ProductSupplier[] suppliers;
	private String merchantType;
	private double tax;

	public Merchant(String name, String addressOfReg, double startingFunds) {
		this.name = name;
		this.addressOfReg = addressOfReg;
		this.funds = startingFunds;
	}

	static class Vendor extends Merchant {
		private Product[] products;
		private double totalOrderCost;
		private int numberOfAddedProducts;
		private int numberOfSoldProducts;
		
		public Vendor(String name, String addressOfReg, double startingFunds) {
			super(name, addressOfReg, startingFunds);
			super.suppliers = new ProductSupplier[1];
			super.commercialBuildings = new CommercialBuilding[0]; // to avoid future nullPointer if we iterate through array of Cb
			super.merchantType = "vendor";
			//ASSUMES generating free space for products if same logic replace
			this.totalOrderCost = super.funds/2;
			int ratio = (int) (this.totalOrderCost/Product.PRODUCT_MIN_PRICE);
			this.products = new Product[(ratio)];
		}

		double getTotalOrderCost(){
			return this.totalOrderCost;
		}
		
		int getNumberOfSoldProducts(){
			return this.numberOfSoldProducts;
		}
		
		private void addProducts(Product[] p) {
			this.products = p;
			SortByPrice.sortProducts(products, 0, products.length-1);
			for (int i = 0; i < p.length; i++) {
				if (p[i] == null ) {
					break;
				}
				this.numberOfAddedProducts++;
			}
		}
		
		public void sellProducts(){
			int randomNumberOfSoldProducts = RandomGenerator.generateNumberInRange(numberOfAddedProducts-1)+1; // +1 to sell at least 1 product
			for (int i = 0; i < randomNumberOfSoldProducts; i++) {
				int positionOfProductInList = RandomGenerator.generateNumberInRange(numberOfAddedProducts-1);
				if (this.products[positionOfProductInList] != null) {
					super.funds += this.products[positionOfProductInList].getPrice()*1.3;
					this.numberOfSoldProducts++;
					this.products[positionOfProductInList]=null;
				}
			}
		}
		
		public void showProducts(){
			System.out.println("Vendor: " +super.name);
			for (int i = 0; i < products.length; i++) {
				if (products[i] !=null) {
					products[i].showProduct();
				}
			}
			System.out.println("Money left: " + super.funds);
		}
	}

	static class StoreSeller extends Merchant {

		public StoreSeller(String name, String addressOfReg, double startingFunds) {
			super(name, addressOfReg, startingFunds);
			//TODO Write method for generating positive numbers
			super.suppliers = new ProductSupplier[RandomGenerator.generateNumberInRange(4)+1];
			super.commercialBuildings = new CommercialBuilding[1];
			super.merchantType = "storeSeller";
		}

		void setCommercialBuilding(CommercialBuilding cb) {
			super.commercialBuildings[0] = cb;
			super.commercialBuildings[0].setTotalOrderCost(super.funds/2);
		}
	}

	static class ChainStoreSeller extends Merchant {

		public ChainStoreSeller(String name, String addressOfReg, double startingFunds) {
			super(name, addressOfReg, startingFunds);
			//TODO Write method for generating positive numbers
			super.suppliers = new ProductSupplier[RandomGenerator.generateNumberInRange(15)+1];
			super.commercialBuildings = new CommercialBuilding[RandomGenerator.generateNumberInRange(9)+1];
			super.merchantType = "chainStoreSeller";
		}
		
		int getNumberOfStores() {
					return super.commercialBuildings.length;
				}
		
		void addStore(CommercialBuilding cb) {
					for (int i = 0; i < super.commercialBuildings.length; i++) {
						if (super.commercialBuildings[i] == null) {
							super.commercialBuildings[i] = cb;
							super.commercialBuildings[i].setTotalOrderCost(super.funds/super.commercialBuildings.length);
							return;
						}
					}
				}
		
	}

	CommercialBuilding[] getShops(){
		return this.commercialBuildings;
	}
	
	double getFunds(){
		return this.funds;
	}
	
	public double getTax(){
		return this.tax;
	}
	
	public double collectMoney(CommercialBuilding[] cb) {
		for (int i = 0; i < cb.length; i++) {
			this.funds += cb[i].getProfit();
		}
		return this.funds;
	}

	void payTax() {
		for (int i = 0; i < commercialBuildings.length; i++) {
			if(this.commercialBuildings[i] != null) {
				this.funds -= commercialBuildings[i].getTax();
				this.tax += commercialBuildings[i].getTax();
			}
		}
		if (!(this instanceof Vendor)) {
			System.out.println("Tax paid for " + this.commercialBuildings.length + " shop"
																+ (( this.commercialBuildings.length>1)? "s: ": ": ") + this.tax);
			if (this.funds <0) {
				System.out.println("@@@@@ - You do not have enough money to pay taxes! YOU are closed!");
			}
			return;
		}
		System.out.println("Vendor does not pay taxes");
	}

	void makeOrder(ProductSupplier supplier) {
		if (this instanceof Vendor) {
			((Vendor)this).addProducts(supplier.supply(((Vendor)this).getTotalOrderCost(),((Vendor)this).products.length));
			for (int i = 0; i < ((Vendor)this).products.length; i++) {
				if ( ((Vendor)this).products[i] == null) {
					continue;
				}
				this.funds -= ((Vendor)this).products[i].getPrice();
			}
		}
		else {
			supplier.supply(this.commercialBuildings);
		}
//		supplier.supply(this.funds/2, this.commercialBuildings);
//		System.out.println("Normal?");
	}

	ProductSupplier[] getSuppliers(){
		return this.suppliers;
	}
	
	void addSupplier(ProductSupplier ps){
//		test purpose
//		System.out.println(this.getClass());
//		System.out.println(ps.hashCode());
//		System.out.println(ps.getClass() + " added \n ---------------");
		for (int i = 0; i < suppliers.length; i++) {
			if (suppliers[i] == null) {
				suppliers[i] = ps;
				return;
			}
		}
	}
	
	int getTotalNumberOfSoldProducts(){
		if (this instanceof Vendor) {
			return ((Vendor)this).getNumberOfSoldProducts();
		}
		else {
			int soldProducts =0;
			for (int i = 0; i < commercialBuildings.length; i++) {
				soldProducts += commercialBuildings[i].getNumberOfSoldProducts();
			}
			return soldProducts;
		}
	}
	// testing
	void showInfoForMerchant() {
		System.out.println("Merchant name: " + this.name);
		System.out.println("Merchant type: " + this.merchantType);
		System.out.println("Money: " + FormatMoney.FromatMoney(this.funds));
	}
	
	public void listSuppliers() {
		for (int i = 0; i < suppliers.length; i++) {
			System.out.println(suppliers[i].hashCode());
			System.out.println(suppliers[i].getSupplierName());
		}
	}
	
	void listStores() {
		double totatMoneyLeftInShops = 0;
		System.out.println("Merchant name: " + this.name);
		System.out.println("Number of shops: "+this.commercialBuildings.length);
		System.out.println("-  -  -  -  List of shops  -  -  -  -");
		for (int i = 0; i < commercialBuildings.length; i++) {
			if (commercialBuildings[i] != null) {
				commercialBuildings[i].infoForBuilding();
				this.commercialBuildings[i].infoForProd();
				System.out.println("------------------++++++++++++");
				totatMoneyLeftInShops += this.commercialBuildings[i].getMoneyToSpend();
				
			}
		}
		System.out.println("From shops: " + FormatMoney.FromatMoney(totatMoneyLeftInShops));
		System.out.println("Money left: " + FormatMoney.FromatMoney(this.collectMoney(this.commercialBuildings)));
		System.out.println("-----+++++-----");
	}

	
}
