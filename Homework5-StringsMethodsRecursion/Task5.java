import java.util.Scanner;

public class Task5 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
//		Да се състави програма, чрез която се въвеждат 2 редици от знаци
//		(думи).
//		Ако в двете редици участва един и същи знак, да се изведе на екрана
//		първата редица хоризонтално, а втората вертикално, така че да се
//		пресичат в общия си знак.
//		Ако редиците нямат общ знак да се изведе само уведомително
//		съобщение.
		
		System.out.println("Please enter first word");
		String horizontalStr = sc.nextLine(); 
		System.out.println("Please enter second word");
		String verticalStr = sc.nextLine(); 
		
		int firstoccurrenceVertical = -1;
		int occurrenceHorizontal = -1;
		
		for (int i = 0; i < horizontalStr.length(); i++) {
			if (firstoccurrenceVertical > -1 || occurrenceHorizontal > -1) {
				break;
			}
			for (int j = 0; j < verticalStr.length(); j++) {
				if (horizontalStr.charAt(i) == verticalStr.charAt(j)){
					firstoccurrenceVertical = verticalStr.indexOf(verticalStr.charAt(j));
					occurrenceHorizontal = horizontalStr.indexOf(verticalStr.charAt(j));
					break;
				}
			}
		}
		
		for (int i = 0; i < verticalStr.length(); i++) {
			// check if there are no occurrences  
			if (firstoccurrenceVertical == -1 || occurrenceHorizontal == -1) {
				System.out.println("All the letters are different!");
				break;
			}
			if (i != firstoccurrenceVertical) {
				int blankSpace = 0;
				while(blankSpace < occurrenceHorizontal) {
					System.out.print(" ");
					blankSpace++;
				}
				System.out.println(verticalStr.charAt(i));
			} else {
				System.out.println(horizontalStr);
			}
		}
	}
}
