import java.util.Scanner;

public class Task1 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
//		Да се състави програма, чрез която се въвеждат два низа съдържащи
//		до 40 главни и малки букви.
//		Като резултат на екрана да се извеждат низовете само с главни и само
//		с малки букви.
		
		System.out.println("Please enter first string(max length 40 chars)");
		// using StringBuilder because in the validation method after every new input 
		// it would replace the previous one, which was incorrect
		StringBuilder firstString = new StringBuilder(sc.nextLine());
		validate(firstString);
		
		System.out.println("Please enter second string(max length 40 chars)");
		StringBuilder secondString = new StringBuilder(sc.nextLine());
		validate(secondString);
		
		sc.close();
		
		System.out.println(firstString.toString().toUpperCase() + " " + firstString.toString().toLowerCase() 
		+ " " + secondString.toString().toUpperCase() + " " + secondString.toString().toLowerCase());
	}

	 static StringBuilder validate(StringBuilder str) {
		while(str.length() > 40 || str.lastIndexOf(" ") >= 0 || str.length() < 1) {
			System.out.println("The string must be within 40 characters with no spaces! Try Again!");
			str.delete(0, str.length());
			str.append(sc.nextLine());
		}
		return str;
	}
}
