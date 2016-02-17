package utils;

import java.util.Random;

public class RandomGenerator {
	
	private static String[] product = {
			"Violin", "Viola", "Contrabass",

			"Harp", "Guitar", "Drums",

			"Tarambuka", "Contrabass", "Tambourine", "Tapan", "Trumpet",

			"Trombone", "Tube", "Flute",

			"Clarinet", "Pipe organ", "Piano", "Accordion", "Synthesizer",

			"Bass Guitar", "Elektric violin"
		};
		
		
		public static String generateProduct(){
			Random r= new Random();
			return product[r.nextInt(product.length)];
		}
	
	
	/**
	 * Generates numbers between 1 and 10 inclusive
	 * @return - int
	 */
	public static int numberGenerator(){
		Random r = new Random();
		return r.nextInt(10)+1; // to exclude 0
	}
}
