import java.util.Scanner;

public class Task2 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
//		Да се състави програма, чрез която от клавиатурата се въвеждат
//		последователно две думи с дължина 10-20 знака.
//		Програмата да размени първите им 5 знака и да изведе дължината на
//		по-дългата, както и новото им съдържание.

		System.out.println("Please enter first word (between 10 and 20 chars)");
		StringBuilder firstWord = new StringBuilder(sc.nextLine());
		// using StringBuilder because in the validation method after every new input 
		// it would replace the previous one, which was incorrect
		validate(firstWord);
		
		System.out.println("Please enter second word (between 10 and 20 chars)");
		StringBuilder secondWord = new StringBuilder(sc.nextLine());
		validate(secondWord);
		
		sc.close();
		
		StringBuilder tempString = new StringBuilder();
		tempString.append(firstWord);
		
		swapFirstFiveLetters(firstWord, secondWord);
		swapFirstFiveLetters(secondWord, tempString);
		System.out.println("Length of the longest word : " + ((firstWord.length() > secondWord.length())? firstWord.length() : secondWord.length()));
		
		System.out.println("First word after the swap " + firstWord);
		System.out.println("Second word after the swap " + secondWord);
	}
	static StringBuilder swapFirstFiveLetters(StringBuilder changedStr, StringBuilder sourceForSwap) {

		changedStr.replace(0, 5, sourceForSwap.substring(0, 5));
		return changedStr;
		
	}
	static StringBuilder validate(StringBuilder str) {
		while(str.length() < 10 || str.length() > 20 || str.lastIndexOf(" ") >= 0) {
			System.out.println("The word must be between 10 and 20 characters with no spaces! Try Again!");
//			Deleting incorrect word  
			str.delete(0, str.length());
//			Appending the new entry
			str.append(sc.nextLine());
		}
		return str;
	}
}
