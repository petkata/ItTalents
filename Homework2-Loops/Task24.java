import java.util.Scanner;

public class Task24 {
	public static void main(String[] args) {
//		Едно число X е палиндром, aко се чете еднакво отпред назад и отзад напред.
//		Да се състави програма, която проверява дали въведено число е палиндром.
//		Входни данни: N - естествено число от интервала [10 .. 30000].
//		
//		Edno chislo X e palindrom, ako se chete ednakvo otpred nazad i otzad napred.
//		Da se sastavi programa, koyato proveryava dali vavedeno chislo e palindrom.
//		Vhodni danni: N - estestveno chislo ot intervala [10 .. 30000].

		int num;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter number:");
		num = sc.nextInt();
		
		while(num < 10 || num > 30000) {
			System.out.println("Enter a positive number between 10 and 30 000 including and try again!");
			num = sc.nextInt();
		}
		sc.close();
		
		int originalNum = num;
		int result = 0;
		
		num = originalNum; // returning original value
		
		do {
			result *= 10;
			result += (num % 10);
			num /= 10;		
		} while (num > 0);
		
		System.out.println(result); // the original number in backwards 
		
		if (result == originalNum) {
			System.out.println("The number " + originalNum + " is palindorme");
		} else {
			System.out.println("The number " + originalNum + " is NOT palindorme");
		}
	}
}
