import java.util.Scanner;

public class Task4 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
//		Да се състави програма, чрез която по въведени трите имена на двама
//		човека разделени със запетая, се извежда чие име има по-голям сбор
//		от ASCII кодовете на съставящите името букви.
		
		System.out.println("Please enter two full names separated by comma"
				+ "(ex. John Smith Doe, Jane Baker Doe):");
		// using StringBuilder because in the validation method after every new input 
		// it would replace the previous one, which was incorrect 
		StringBuilder names = new StringBuilder(sc.nextLine());
		
		validate(names);
		String[] namesArray = names.toString().split(",");
		
		compareASCIISum(namesArray[0], namesArray[1].trim());
	}

	private static void validate(StringBuilder str) {
//		Exercising regexes
		String pattern = "[A-Z][a-z]++[\\s][A-Z][a-z]++[\\s][A-Z][a-z]++";
		if (!str.toString().matches(pattern + ",[\\s]" + pattern)) {
			System.out.println("Incorrect input! See the given example. Check names and try again!");
			str.delete(0, str.length());
			str.append(sc.nextLine());
			validate(str);
		}
		
	}

	private static void compareASCIISum(String str1, String str2) {
		int sumStr1= 0 ;
		int sumStr2 = 0;
		
		for (int i = 0; i < str1.length(); i++) {
			sumStr1 += str1.charAt(i);
		}
		for (int i = 0; i < str2.length(); i++) {
			sumStr2 += str2.charAt(i);
		}
		
		System.out.println(((sumStr1 > sumStr2)? str1 : str2) + " has bigger ASCII sum");
	}
}
