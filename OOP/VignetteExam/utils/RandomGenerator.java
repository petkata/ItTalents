package utils;

import java.util.Random;

public class RandomGenerator {

	
	public static int generateRandomDate(int rangeOfDate){
		Random r = new Random();
		return (r.nextInt(rangeOfDate)+1);
	}
	
	public static int generateRandom(int range){
		Random r = new Random();
		return (r.nextInt(range));
	}
	
	public static double generateMoney(double range){
		double random = new Random().nextDouble();
		return (random*range);
	}
	
}
