import java.util.Scanner;

public class Task6 {

	public static void main(String[] args) {
//		Да се състави програма, чрез която се въвежда изречение с отделни
//		думи.
//		Като резултат на екрана да се извежда същия текст, но всяка отделна
//		дума да започва с главна буква, а следващите я букви да са малки.
		
		Scanner sc = new Scanner(System.in);
		String originalText = sc.nextLine();
		sc.close();
		System.out.print("Original text: ");
		System.out.println(originalText);
		
//		First Way with arrays
		System.out.print("First way of conversion: ");
		String[] textArray = originalText.split(" ");		
		for (int i = 0; i < textArray.length; i++) {
				System.out.print(textArray[i].toUpperCase().substring(0, 1) + textArray[i].toUpperCase().substring(1, textArray[i].length()).toLowerCase());
				if(i < textArray.length -1) {
					System.out.print(" ");
				}
		}

		System.out.println();
		
//		Second Way with StringBuilder
		System.out.print("Second way of conversion: ");
		StringBuilder modifiedText = new StringBuilder(originalText);

		modifiedText.replace(0 , 1, originalText.substring(0,1).toUpperCase());
		
		for (int i = 0; i < modifiedText.length(); i++) {
			if (originalText.charAt(i) == ' ') {
				modifiedText.replace(i +1 , i + 2, originalText.substring(i+1,i+2).toUpperCase()); 
			}
		}
		System.out.println(modifiedText);
		
//		Third way replacing the original text
		System.out.print("Third way of conversion: ");
		originalText = originalText.toUpperCase();
		
		for (int i = 0; i < originalText.length(); i++) {
			if (originalText.charAt(i) == ' ') {
				originalText = originalText.replace(originalText.substring(i, i+2), originalText.substring(i, i+2).toUpperCase());
				continue;
			}
			originalText = originalText.replace(originalText.substring(i+1, originalText.length()), originalText.substring(i+1, originalText.length()).toLowerCase());
		}
		System.out.println(originalText);
	}
}
