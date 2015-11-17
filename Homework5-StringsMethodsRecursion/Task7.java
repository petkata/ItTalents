import java.util.Scanner;

public class Task7 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
//		Да се състави програма, която чете набор от думи разделени с
//		интервал.
//		Като резултат да се извеждат броя на въведените думи, както и броя
//		знаци в най-дългата дума.
		
		System.out.println("Enter words separated by space");
		StringBuilder originalText = new StringBuilder(sc.nextLine());

		validate(originalText);
		sc.close();
		String[] textArray = originalText.toString().split("\\s+");	
		
		int firstWordLength = textArray[0].length();
		boolean wordsHaveSameLength = true;
		int countMaxSizedWords = 0;
		int maxSize = textArray[0].length();
		
		for (int i = 1; i < textArray.length; i++) {
			if (maxSize < textArray[i].length()) {
				maxSize = textArray[i].length();
			}
			if (firstWordLength != textArray[i].length()) {
				wordsHaveSameLength = false;
			}
		}
		
		for (int i = 0; i < textArray.length; i++) {
			if (maxSize == textArray[i].length()) {
				countMaxSizedWords++;
			}
		}
		
		if (wordsHaveSameLength) {
			System.out.println("All words have the same length: " + maxSize);
		} else{
			System.out.printf("%d words,%d word%s with the most letters - %d letters" , textArray.length, countMaxSizedWords, (countMaxSizedWords > 1)? "s" : "", maxSize);
		}
	}
	
	private static void validate(StringBuilder str) {
		String pattern = "(\\w+\\s*\\w+){2,}";
		if (!str.toString().matches(pattern)) {
			System.out.println("Incorrect input! Write at least 2 words");
			str.delete(0, str.length());
			str.append(sc.nextLine());
			validate(str);
		}
		
	}
}
