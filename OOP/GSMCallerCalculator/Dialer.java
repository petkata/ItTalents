import java.util.Scanner;

public class Dialer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GSM pesho = new GSM();
//		System.out.println("Please enter phone number of simcard");
		pesho.insertSimCard("0878123456");
		
//		For testing
//		pesho.simMobileNumber = "0878123456";
//		pesho.hasSimCard = true;
		
		GSM gosho = new GSM();
		gosho.insertSimCard("0877654321");
		
		GSM mariq = new GSM();
		mariq.insertSimCard("0878987654");
		
		GSM toni = new GSM();
		toni.insertSimCard("0878963258");
		toni.removeSimCard();
		
//		Call yourself
//		pesho.call(pesho, sc.nextDouble(), sc);
		
		System.out.println("Enter call duration with gosho(" + gosho.simMobileNumber+")");
		pesho.call(gosho,sc.nextDouble(),sc);
		
		System.out.println("Enter call duration with mariq(" + mariq.simMobileNumber+")");
		pesho.call(mariq,sc.nextDouble(),sc);
		
		System.out.println("Enter call duration with toni(" + toni.simMobileNumber+")");
		pesho.call(toni,sc.nextDouble(),sc);
		
		System.out.println("Enter call duration with pesho(" + pesho.simMobileNumber+")");
		gosho.call(pesho,sc.nextDouble(),sc);
		System.out.println("Enter call duration with pesho(" + pesho.simMobileNumber+")");
		mariq.call(pesho,sc.nextDouble(),sc);
		
		sc.close();
		
		System.out.println();
		
		pesho.printInfoForTheLastIncomingCall();
		pesho.printInfoForTheLastOutgoingCall();
		pesho.printInfoForMissedCalls();
		pesho.printTotalBill();
		
	}
}
