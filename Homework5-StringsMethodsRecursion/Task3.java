import java.util.Scanner;

public class Task3 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
//		Да се състави програма, чрез която се въвеждат последователно две
//		редици от символи без интервали.
//		Програмата да извежда съобщение за резултата от сравнението им по
//		позиции.
		
		System.out.println("Please enter two strings separated by comma, containing no spaces");
		// using StringBuilder because in the validation method after every new input 
		// it would replace the previous one, which was incorrect 
		StringBuilder word = new StringBuilder(sc.nextLine());
		
		validate(word);
//		Exercising split function
		String[] wordsArray = word.toString().split(",");
		
//		Exercising trim function
		compareLengthOfStrings(wordsArray[0], wordsArray[1].trim());
		
		checkDifferenceInStrings(wordsArray[0], wordsArray[1].trim());
	}

	private static StringBuilder validate(StringBuilder word) {
		boolean isValid = false;
		while(!isValid){
			if (word.indexOf(" ") != word.indexOf(",") + 1 || word.lastIndexOf(" ") != word.indexOf(",") + 1) {
				System.out.println("Do not use space in the strings! Try Again!");
				word.delete(0, word.length());
				word.append(sc.nextLine());
			} else {
				isValid = true;
			}
		}
		return word;
		
	}

	private static void compareLengthOfStrings(String firstStr, String secondStr) {
		if (firstStr.length() == secondStr.length()) {
			System.out.println("The two strings have equal length");
		} else if(firstStr.length() > secondStr.length()){
			System.out.printf("The %s string is longer and has %d chars" , "first" , firstStr.length());
		} else {
			System.out.printf("The %s string is longer and has %d chars" , "second" , secondStr.length());
		}		
	}
	private static void checkDifferenceInStrings(String firstStr, String secondStr) {
		
		System.out.println("Different letters by position:");
		
		for (int i = 0; i < ((firstStr.length() > secondStr.length())? secondStr.length() : firstStr.length()); i++) {
			if (firstStr.charAt(i) != secondStr.charAt(i)) {
				System.out.printf("%d %s-%s \n", i, firstStr.charAt(i), secondStr.charAt(i));
			}
		}
		
	}
}
