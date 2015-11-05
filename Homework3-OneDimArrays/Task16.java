
public class Task16 {

	public static void main(String[] args) {
//		Да се състави програма, чрез която предварително въведени 10
//		реални числа от интервала се обработват по следния начин:
//		1. Извежда съществуващите числа.
//		2. Всички елементи със стойност по-малки от -0.231 се заменят със
//		сумата от квадрата на поредния им номер + числото 41.25, а всички
//		останали елементи се заменят с произведението между самия елемент
//		и неговият пореден номер. Поредният номер на първият елемент е 1.
//		3. Да се изведат елементите от началния и новообразувания масив.
//
//		Da se sastavi programa, chrez koyato predvaritelno vavedeni 10
//		realni chisla ot intervala se obrabotvat po sledniya nachin:
//		1. Izvezhda sashtestvuvashtite chisla.
//		2. Vsichki elementi sas stoynost po-malki ot -0.231 se zamenyat sas
//		sumata ot kvadrata na poredniya im nomer + chisloto 41.25, a vsichki
//		ostanali elementi se zamenyat s proizvedenieto mezhdu samiya element
//		i negoviyat poreden nomer. Poredniyat nomer na parviyat element e 1.
//		3. Da se izvedat elementite ot nachalniya i novoobrazuvaniya masiv.
		
		double[] arr = { -1.12, -2.43, 3.1, 4.2, 0, 6.4, - 7.5, 8.6, 9.1, -4};
		
		// 1. Printing all the numbers
		System.out.println("The initial numbers : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length -1) {
				System.out.print(", ");
			}
		}
		
		double[] secondArr = new double[arr.length];
		for (int i = 0; i < secondArr.length; i++) {
			if (arr[i] < -0.231) {
				secondArr[i] = (i+1)*(i+1) + 41.25;
			} else {
				secondArr[i] = arr[i] * (i+1);
			}
		}
		// 3. Print the original and the second arrays
		System.out.printf("%nOriginal array : %n");
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length -1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		
		System.out.println("Modified array : ");
		System.out.print("[");
		for (int i = 0; i < secondArr.length; i++) {
			System.out.print(secondArr[i]);
			if (i < secondArr.length -1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}
