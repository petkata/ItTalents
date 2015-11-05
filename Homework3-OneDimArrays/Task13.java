import java.util.Scanner;

public class Task13 {

	public static void main(String[] args) {
//		Да се състави програма, чрез която се въвежда число и се представя
//		като число в двоична бройна система.
//		Програмата, чрез масив, да изчислява последователно всички цифри
//		на въведеното естествено число в 2-ична бройна система.
//
//		Da se sastavi programa, chrez koyato se vavezhda chislo i se predstavya
//		kato chislo v dvoichna broyna sistema.
//		Programata, chrez masiv, da izchislyava posledovatelno vsichki tsifri
//		na vavedenoto estestveno chislo v 2-ichna broyna sistema.

		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		while (num <= 0) {
					
					System.out.println("Please enter a number :");
					num = sc.nextInt();
					
					if (num <= 0 ) {
						System.out.print("Must be positive! ");
						continue;
					}
				}
		sc.close();
		
		// To determine how many digits the binary number has
		int baseTwo = 1;
		int counter = 0;
		
		while (num >= baseTwo) {
			baseTwo *=2;
			counter++;
		}
		
		// construct the array 
		int[] bitArr = new int[counter];
		
		//Fill the array
		for (int i = 0; i < bitArr.length; i++) {
			bitArr[bitArr.length -i -1] = num % 2;
			num /= 2;
		}
		
		//Print the array 
		for (int i = 0; i < bitArr.length; i++) {
			System.out.print(bitArr[i]);
		}
	}
}
