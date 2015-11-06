
public class Task4 {

	public static void main(String[] args) {
//		Имате предварително въведени стойности на елементи в двумерен
//		масив - естествени числа.
//		Да се състави програма, чрез която се извеждат стойностите на
//		елементите в двумерен масив след обръщането му на +90 градуса.
//		
//		Imate predvaritelno vavedeni stoynosti na elementi v dvumeren
//		masiv - estestveni chisla.
//		Da se sastavi programa, chrez koyato se izvezhdat stoynostite na
//		elementite v dvumeren masiv sled obrashtaneto mu na +90 gradusa.
		
		int[][] arr = {
						{1,2,3,4},
						{5,6,7,8},
						{9,10,11,12},
						{13,14,15,16}
					   };
		
		for (int j = 0; j < arr[j].length; j++) {
			for (int i = arr.length - 1; i >= 0; i--) {
				System.out.print(arr[i][j] + " ");
			}
			
			System.out.println();
			
			if (j == arr[j].length - 1) {
				break;
			}
		}
	}
}
