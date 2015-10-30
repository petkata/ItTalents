import java.util.Scanner;

public class Task25 {

	public static void main(String[] args) {
//		Да се направи програма, която по дадено число N, да изчислява
//		N!, т.е. 1*2*3*4...*N.
//		
//		Da se napravi programa, koyato po dadeno chislo N, da izchislyava
//		N!, t.e. 1*2*3*4...*N.
		
		int num;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter number:");
		num = sc.nextInt();
		
		while(num < 0) {
			System.out.println("Enter a positive number and try again!");
			num = sc.nextInt();
		}
		sc.close();
		
		int originalNum = num;
		double result = 1;
		
		do {
			result *= num;
			num--;
		} while (num > 1);
		
		System.out.println(originalNum + "!" + " = " + result);
	}

}
