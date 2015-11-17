import java.util.Arrays;
import java.util.Scanner;

public class Task12 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
//		Да се създаде метод, който приема за входни данни число N и
//		връща масив от числа с дължина N, който съдържа всички числа
//		от 1 до N.
		
		System.out.println("Please enter a number:");
		
		int num = validateInput(sc.nextInt());
		
		sc.close();
		
		printNumberSequence(num);
	}
	
	static int validateInput(int num){
		if (num <= 0) {
			// We need a positive number because we want to print from 1 to N
			System.out.println("Please enter a positive number!");
			num = validateInput(sc.nextInt());
		}
		return num;
	}
	
	static void printNumberSequence (int num) {
		int[] arr = new int[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		System.out.println(Arrays.toString(arr));
	}
}
