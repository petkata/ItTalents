package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

	
	static List<String> names = new ArrayList<>(Arrays.asList("Pencho", "Ivan", "Atanas", "Kiril", "Tom", "Tedi", "Geri", "Angel", "Simo", "Qsena"));
	static List<String> towns = new ArrayList<>(Arrays.asList("Sofia", "Plovdiv", "Varna", "Montana", "Lom"));
	
	public static String nameGenerator(){
		Random r = new Random();
		return names.remove(r.nextInt(names.size()));
	}
	
	public static String townGenerator(){
		Random r = new Random();
		return towns.get(r.nextInt(towns.size()));
	}
	
	public static double salaryGenerator(){
		Random r = new Random();
		return r.nextDouble()*1000;
	}
	
	public static int moneyGenerator(){
		Random r = new Random();
		return r.nextInt(500)+500; // -> sets the random seed between 500 - 1000 inclusive
	}
	
	public static int depositGenerator(){
		Random r = new Random();
		return r.nextInt(21)+80; // -> sets the random seed between 80 - 100 inclusive
	}
	
	public static int numberGenerator(int bound){
		Random r = new Random();
		return r.nextInt(bound);
	}
}
