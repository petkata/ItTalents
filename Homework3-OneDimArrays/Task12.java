
public class Task12 {

	public static void main(String[] args) {
//		Да се състави програма, чрез която по предварително въведени 7
//		числа в едномерен масив се разменят местата на елементи с индекси:
//		- 0 и 1 чрез трета променлива;
//		- 2 и 3 чрез събиране;
//		- 4 и 5 чрез умножение.
//
//		Da se sastavi programa, chrez koyato po predvaritelno vavedeni 7
//		chisla v ednomeren masiv se razmenyat mestata na elementi s indeksi:
//		- 0 i 1 chrez treta promenliva;
//		- 2 i 3 chrez sabirane;
//		- 4 i 5 chrez umnozhenie.

		int[] arr = {2,3,4,-5,6,-7,8};
		
		// Printing the original array
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length -1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		
		//Swapping [0] and [1]
		int temp = arr[0] ;
		arr[0] = arr[1];
		arr[1] = temp;
		
		//swapping [2] and [3]
		arr[2] = arr[2] + arr[3];
		arr[3] = arr[2] - arr[3];
		arr[2] = arr[2] - arr[3];
		
		//swapping [4] and [5]
		arr[4] = arr[4] * arr[5];
		arr[5] = arr[4] / arr[5];
		arr[4] = arr[4] / arr[5];
		
		//After changes
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
