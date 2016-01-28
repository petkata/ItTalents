package utils;

import business.Product;

public class SortByPrice {

	static int partition(Product[] products, int start , int end){
		int p = start;
		double pivot;
		while (true) {
			if (products[end] != null) {
				pivot = products[end].getPrice();
				break;
			}
			end--;
		}
		
		for (int i = start; i < end; i++) {
			if (products[i] == null) {
				continue;
			}
			if (pivot >= products[i].getPrice()) {
				Product swap = products[i];
				products[i] = products[p];
				products[p] = swap;
				p++;
			}
		}
		Product temp = products[p];
		products[p] = products[end];
		products[end]= temp;
		
		return p;
	}
	
	public static void sortProducts(Product[] products, int start, int end) {
		if (start >= end) {
			return;
		}
		int pivotIndex = partition(products, start, end);
		sortProducts(products, start, pivotIndex-1);
		sortProducts(products, pivotIndex+1, end);
	}
}
