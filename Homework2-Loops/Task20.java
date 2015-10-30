
public class Task20 {
	public static void main(String[] args) {
//		Да се състави програма, чрез която се извежда квадрат от
//		цифри. Сумите от елементите на произволен ред или стълб са
//		равни на 45.
//
//		Da se sastavi programa, chrez koyato se izvezhda kvadrat ot
//		tsifri. Sumite ot elementite na proizvolen red ili stalb sa
//		ravni na 45.

		for (int i = 1; i <= 10; i++) {
			for (int j = i; j <= 9; j++) {
				if (i == 10 ) {
					continue;
				}
				System.out.print(j + " ");
			}
			for (int k = 0; k < i; k++) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}
}
