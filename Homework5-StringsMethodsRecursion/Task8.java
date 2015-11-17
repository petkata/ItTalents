import java.util.Scanner;

public class Task8 {

	public static void main(String[] args) {
//		Да се състави програма, чрез която се въвежда ред от символи
//		(стринг, низ).
//		Програмата да изведе на екрана дали въведения стринг е палиндром,
//		т.е. дали четен отляво-надясно и отдясно-наляво е един и същ.

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a string");
		String word = sc.nextLine();
		sc.close();
		
		checkIfIsPalindrome(word);
		
	}
	
	static void checkIfIsPalindrome(String str){
		boolean isPalindrome = true;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				isPalindrome = false;
				break;
			}
		}
		if (isPalindrome) {
			System.out.printf("The string '%s' is a palindrome", str );
		} else {
			System.out.printf("The string '%s' is NOT a palindrome" , str);
		}
	}
}
