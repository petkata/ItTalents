package business;

import business.CommercialBuilding.*;
import business.Merchant.ChainStoreSeller;
import business.Merchant.StoreSeller;
import business.Merchant.Vendor;
import business.ProductSupplier.WholesaleSupplier;
import utils.FormatMoney;
import utils.RandomGenerator;

public class Demo {

	public static void main(String[] args) {

		ProductSupplier[] suppliers = new ProductSupplier[10];
		createSuppliers(suppliers);
		/*
		 * for (int i = 0; i < suppliers.length; i++) {
		 * suppliers[i].infoForSupp(); } /
		 **/
		CommercialBuilding[] commercialBuildings = new CommercialBuilding[20];
		createCommercialBuildings(commercialBuildings);
		// for (int i = 0; i < commercialBuildings.length; i++) {
		// commercialBuildings[i].infoForBuilding();
		// }
		Merchant vendor = new Merchant.Vendor("Vendor", RandomGenerator.generateAddress(), 100);
		// vendor.showInfoFOrMerchant();

		Merchant storeSeller = new Merchant.StoreSeller("Store seller", RandomGenerator.generateAddress(), 500); 
		// storeSeller.showInfoFOrMerchant();

		Merchant chainStoreSeller = new Merchant.ChainStoreSeller("Chain store seller",
				RandomGenerator.generateAddress(), 3000);
		// chainStoreSeller.showInfoFOrMerchant();
		Merchant[] merchants = { vendor, storeSeller, chainStoreSeller };

		assignCommercialBuildingsToMerchants(merchants, commercialBuildings);
		// storeSeller.listStores();
		// chainStoreSeller.listStores();

		assignSuppliersToMerchants(merchants, suppliers);
		
//		vendor.listSuppliers();
//		System.out.println("++++++++");
//		 storeSeller.listSuppliers();
//		 System.out.println("++++++++");
//		 chainStoreSeller.listSuppliers();
		
//		 vendor.makeOrder(vendor.getSuppliers()[RandomGenerator.generateNumberInRange(vendor.getSuppliers().length-1)]);
//		 ((Vendor)vendor).showProducts();
//		storeSeller.makeOrder(storeSeller.getSuppliers()[RandomGenerator.generateNumberInRange(vendor.getSuppliers().length-1)]);
//		storeSeller.listStores();
//		chainStoreSeller.makeOrder(storeSeller.getSuppliers()[RandomGenerator.generateNumberInRange(vendor.getSuppliers().length-1)]);
//		chainStoreSeller.listStores();		

		startCommerce(merchants);
		
//		System.out.println("\n\n SELL \n\n");
		
//		((Vendor) vendor).sellProducts();
//		((Vendor) vendor).showProducts();
//		for (int i = 0; i < storeSeller.getShops().length; i++) {
//			storeSeller.getShops()[i].sellProducts();
//		}
//		storeSeller.listStores();
//		for (int i = 0; i < chainStoreSeller.getShops().length; i++) {
//			chainStoreSeller.getShops()[i].sellProducts();
//		}
//		chainStoreSeller.showInfoForMerchant();
		
		showCurrentMoneyForAllMerchants(merchants);
		merchantSoldMostProducts(merchants);
		merchantWithHighestTaxes(merchants);
	}

	private static void merchantWithHighestTaxes(Merchant[] merchants) {
		System.out.println("\nMerchant who has paid highest tax(with positive funds): \n");
		int indexOfMaxMerchant =0 ;
		for (int i = 0; i < merchants.length; i++) {
			//check if merchant has negative funds
			if (merchants[i].getFunds() < 0) {
				continue;
			}
			if (merchants[i].getTax() > merchants[indexOfMaxMerchant].getTax()) {
				indexOfMaxMerchant = i;
			}
		}
		merchants[indexOfMaxMerchant].showInfoForMerchant();
		System.out.println(FormatMoney.FromatMoney(merchants[indexOfMaxMerchant].getTax() )+" paid in taxes");
	}
	
	private static void merchantSoldMostProducts(Merchant[] merchants) {
		System.out.println("\nMerchant who has sold most products (with positive funds): \n");
		int indexOfMaxMerchant =0 ;
		for (int i = 0; i < merchants.length; i++) {
			//check if merchant has negative funds
			if (merchants[i].getFunds() < 0) {
				continue;
			}
			if (merchants[i].getTotalNumberOfSoldProducts() > merchants[indexOfMaxMerchant].getTotalNumberOfSoldProducts()) {
				indexOfMaxMerchant = i;
			}
		}
		merchants[indexOfMaxMerchant].showInfoForMerchant();
		System.out.println(merchants[indexOfMaxMerchant].getTotalNumberOfSoldProducts() +" sold products");
	}

	private static void showCurrentMoneyForAllMerchants(Merchant[] merchants) {
		System.out.println("\nInfo for merchants: \n");
		for (int i = 0; i < merchants.length; i++) {
			merchants[i].showInfoForMerchant();
		}
	}

	private static void startCommerce(Merchant[] merchants) {
		for (int i = 0; i < merchants.length; i++) {
			System.out.println("\n\n ORDER \n\n");
			merchants[i].makeOrder(merchants[i].getSuppliers()[RandomGenerator.generateNumberInRange(merchants[i].getSuppliers().length-1)]);
			if (merchants[i] instanceof Vendor) {
				((Vendor)merchants[i]).showProducts();
			}
			else {
				merchants[i].listStores();
			}
			System.out.println("\n\n SELL \n\n");
			if (merchants[i] instanceof Vendor) {
				((Vendor)merchants[i]).sellProducts();
			}
			else {
				for (int j = 0; j< merchants[i].getShops().length; j++) {
					merchants[i].getShops()[j].sellProducts();
				}
				merchants[i].collectMoney(merchants[i].getShops());
			}
			merchants[i].showInfoForMerchant();
			System.out.println("\n\n TAX \n\n");
			merchants[i].payTax();
			merchants[i].showInfoForMerchant();
		}
	}

	private static void assignSuppliersToMerchants(Merchant[] merchants, ProductSupplier[] suppliers) {
		// we could have one supplier supplying multiple merchants and stores
		for (int i = 0; i < merchants.length; i++) {
			int numberOfSuppliers = merchants[i].getSuppliers().length;
			while (numberOfSuppliers > 0) {
				if (merchants[i] instanceof ChainStoreSeller) {
					merchants[i].addSupplier( suppliers[RandomGenerator
				           								.generateNumberInRange(suppliers.length - 1)]);
					numberOfSuppliers--;
				} else {
					ProductSupplier supplier = suppliers[RandomGenerator
					           								.generateNumberInRange(suppliers.length - 1)];
					while(true){
						if (supplier instanceof WholesaleSupplier) {
							supplier = suppliers[RandomGenerator
			           								.generateNumberInRange(suppliers.length - 1)];
						}
						else { break;}
					}
					merchants[i].addSupplier(supplier);
					numberOfSuppliers--;
				}
			}
		}
	}

	private static void assignCommercialBuildingsToMerchants(Merchant[] sellers, CommercialBuilding[] cb) {
		for (int i = 0; i < sellers.length; i++) {
			if (sellers[i] instanceof StoreSeller) {
				((StoreSeller) sellers[i]).setCommercialBuilding(chooseShop(sellers[i], cb));
			}
			if (sellers[i] instanceof ChainStoreSeller) {
				int freePlaces = ((ChainStoreSeller) sellers[i]).getNumberOfStores();
				while (freePlaces > 0) {
					((ChainStoreSeller) sellers[i]).addStore(chooseShop(sellers[i], cb));
					freePlaces--;
				}
			}
		}
	}

	private static CommercialBuilding chooseShop(Merchant seller, CommercialBuilding[] cb) {

		for (int i = 0; i < cb.length; i++) {
			if (cb[i] == null) {
				continue;
			}
			if (((cb[i] instanceof Rep) || (cb[i] instanceof ShopInMall)) && (seller instanceof ChainStoreSeller)) {
				CommercialBuilding newCB = cb[i];
				cb[i] = null;
				return newCB;
			}
			if (((cb[i] instanceof Rep) || (cb[i] instanceof Stand)) && (seller instanceof StoreSeller)) {
				CommercialBuilding newCB = cb[i];
				cb[i] = null;
				return newCB;
			}
		}
		return null;
	}

	private static void createCommercialBuildings(CommercialBuilding[] commercialBuildings) {
		for (int i = 0; i < commercialBuildings.length; i++) {
			CommercialBuilding stand = new CommercialBuilding.Stand(RandomGenerator.generateAddress(), "non-stop");
			CommercialBuilding shop = new CommercialBuilding.ShopInMall(RandomGenerator.generateAddress(), "non-stop");
			CommercialBuilding rep = new CommercialBuilding.Rep(RandomGenerator.generateAddress(), "non-stop");
			CommercialBuilding[] buildings = { stand, shop, rep };
			commercialBuildings[i] = buildings[RandomGenerator.generateNumberInRange(buildings.length - 1)];
		}
	}

	
	private static void createSuppliers(ProductSupplier[] suppliers) {
		// TODO random create suppliers
		for (int i = 0; i < suppliers.length; i++) {
			ProductSupplier suppl = new ProductSupplier("retailSupplier" + RandomGenerator.generateName(), "non-stop",
					RandomGenerator.generateAddress());
			ProductSupplier wholesaleSupp = new ProductSupplier.WholesaleSupplier(
					"wholesalesSupplier" + RandomGenerator.generateName(), "non-stop",
					RandomGenerator.generateAddress());
			ProductSupplier[] supps = { suppl, wholesaleSupp };
			suppliers[i] = supps[RandomGenerator.generateNumberInRange(supps.length - 1)];
		}

	}
}
