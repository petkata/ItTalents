import java.util.Scanner;

public class PalindromeRecursion {

	public static void main(String[] args) {
//		Да се състави програма, чрез която се въвежда естествено число N.
//		Програмата да извежда число, чиито цифри са написани в ред обратен
//		на въведеното число.
//		Да се извежда съобщение дали въведеното число е палиндром.
		

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int num = sc.nextInt();
		sc.close();
		
//		recursive method one
		int mirrorNum = 0;
		System.out.println("Recursive with int");
		mirrorNum = calcIntMirrorNum(num,mirrorNum);
		showWetherIntNumIsPalindrome(num,mirrorNum);
		
//		recursive method two Strings
		System.out.println("Recursive with String");
		String strNum = String.valueOf((num > 0)? num : num*-1);
		StringBuilder reversed = new StringBuilder();
		reverseString(strNum, strNum.length(), reversed);
	}

	private static int calcIntMirrorNum(int num, int mirror) {
		if (num == 0) {
			return mirror;
		}
		mirror *= 10;
		mirror += num % 10;
		num /= 10;
		return calcIntMirrorNum(num, mirror);
	}
	
	private static void showWetherIntNumIsPalindrome(int num, int mirrorNum) {
		if (num == mirrorNum) {
			System.out.printf("%d  %d The number is palindrome %n" ,num , mirrorNum);
			return;
		} else {
			System.out.printf("%d  %d The number is NOT palindrome %n" ,num , mirrorNum);
			return;
		}
		
	}

	private static void reverseString(String strNum, int length, StringBuilder reversed) {
		if (length == 0) {
			if (reversed.toString().equals(strNum)) {
				System.out.println("The absolute value IS palindrome");
				return;
			} else {
				System.out.println("The absolute value is NOT palindrome");
				return;
			}
		}
		reversed.append(strNum.charAt(length-1));
		reverseString(strNum, --length, reversed);
	}
}
