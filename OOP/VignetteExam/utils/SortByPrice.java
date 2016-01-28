package utils;

import engine.Vignette;

public class SortByPrice {

	static int partition(Vignette[] vignettes, int start , int end){
		int p = start;
		double pivot;
		while (true) {
			if (vignettes[end] != null) {
				pivot = vignettes[end].getPrice();
				break;
			}
			end--;
		}
		
		for (int i = start; i < end; i++) {
			if (vignettes[i] == null) {
				continue;
			}
			if (pivot >= vignettes[i].getPrice()) {
				Vignette swap = vignettes[i];
				vignettes[i] = vignettes[p];
				vignettes[p] = swap;
				p++;
			}
		}
		Vignette temp = vignettes[p];
		vignettes[p] = vignettes[end];
		vignettes[end]= temp;
		
		return p;
	}
	
	public static void sortVignettes(Vignette[] vignettes, int start, int end) {
		if (start >= end) {
			return;
		}
		int pivotIndex = partition(vignettes, start, end);
		sortVignettes(vignettes, start, pivotIndex-1);
		sortVignettes(vignettes, pivotIndex+1, end);
	}
}
