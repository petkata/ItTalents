
public class Task5 {

	public static void main(String[] args) {
//		Напишете програма, която създава масив с 10 елемента и
//		инициализира всеки от елементите със стойност, равна на индекса на
//		елемента, умножен по 3.
//		Да се изведат елементите на екрана.
//
//		Napishete programa, koyato sazdava masiv s 10 elementa i
//		initsializira vseki ot elementite sas stoynost, ravna na indeksa na
//		elementa, umnozhen po 3.
//		Da se izvedat elementite na ekrana.
		
		int[] arr = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i * 3; 
		}
		
		// Printing the new array
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length -1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}
