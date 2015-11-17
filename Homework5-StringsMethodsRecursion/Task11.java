
public class Task11 {

	public static void main(String[] args) {
//		Да се създаде метод, който отпечатва масив в конзолата.
		
		int[] arr = {1,2,3,4,56,6,7,8,9,45,51,6,0};
		
		printArray(arr);
	}

	private static void printArray(int[] array) {
		
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length -1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		
	}
}
