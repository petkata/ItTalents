package utils;

import java.util.Random;

import business.Product;

public class RandomGenerator {

	public static int generateNumberInRange(int range){
		Random r = new Random();
		return r.nextInt(range+1);
	}
	
	public static double generatePriceForProduct(){
		double r = new Random().nextDouble();
		return r*(Product.PRODUCT_MAX_PRICE - Product.PRODUCT_MIN_PRICE)+Product.PRODUCT_MIN_PRICE;
	}
	
	public static String generateName(){
		String[] str = {"One","Two", "Three","Four", "Five"};
		Random r = new Random();
		return str[generateNumberInRange(str.length-1)];
	}
	
	public static String generateAddress(){
		String[] str = {"Varna","Sofia", "Plovdiv","VT", "Montana"};
		Random r = new Random();
		return str[generateNumberInRange(str.length-1)];
	}

	public static int generateStores(int i) {
		
		return 0;
	}
	
}
