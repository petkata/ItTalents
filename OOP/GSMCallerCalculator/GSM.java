import java.util.Scanner;

public class GSM {
	String model;
	boolean hasSimCard;
	String simMobileNumber;
	double outgoingCallsDuration;
	Call lastIncomingCall = new Call();
	Call lastOutgoingCall = new Call();
//	Can store up to 10 missed calls
	Call[] missedCalls = new Call[10];
	int countMissedCalls = missedCalls.length -1;
	
	void insertSimCard(String inputNumber) {
		String number = inputNumber;
		if (validateNumber(number)) {
			simMobileNumber = number;
			hasSimCard = true;
			return;
		} else {
			System.out.println("Invalid number!");
			return;
		}
	}

	void removeSimCard(){
		hasSimCard=false;
	}
	
	void call(GSM receiver, double duration, Scanner sc){
		if (receiver.simMobileNumber.equals(simMobileNumber)) {
			System.out.println("Can't call yourself");
			return;
		} else if(duration < 0){
			System.out.println("Invalid duration! Enter new duration");
			call(receiver, sc.nextDouble(),sc);
		} else if(hasSimCard == false || receiver.hasSimCard== false){
			if (hasSimCard == false) {
				System.out.println("Please insert sim");
				return;
			} else {
				System.out.println("The number "+ receiver.simMobileNumber +" you are dialing is unavailable\n");
				return;
			}
		}else if(duration == 0){
			if (receiver.countMissedCalls < 0) {
				receiver.countMissedCalls = missedCalls.length -1;
//				Next missed call should be on top
				for (int i = missedCalls.length -1; i >= 1; i--) {
					receiver.missedCalls[i-1] = receiver.missedCalls[i];
				}
			}
			receiver.missedCalls[receiver.countMissedCalls] = new Call();
			receiver.missedCalls[receiver.countMissedCalls].caller = this.simMobileNumber; 
			
			receiver.countMissedCalls--;
			return;
		} else {
			lastOutgoingCall.receiver = receiver.simMobileNumber;
			lastOutgoingCall.duration = duration;
			
			outgoingCallsDuration += duration;
			
			receiver.lastIncomingCall.caller = simMobileNumber;
			receiver.lastIncomingCall.duration = duration;
		}
	}
	
	double getSumForCall(){
		//calculates total bill in Leva
		return outgoingCallsDuration*Call.priceForAMinute/100f;
	}
	
	void printInfoForTheLastOutgoingCall(){
		System.out.println("Outgoing calls stats for number: " + simMobileNumber);
		if (lastOutgoingCall.receiver == null) {
			System.out.println("No outgoing calls");
			return;
		}
		
		System.out.println("Last outgoing call to: " + lastOutgoingCall.receiver);	
		System.out.println("Last outgoing call duration: " + lastOutgoingCall.duration);
	}

	void printInfoForTheLastIncomingCall(){
		System.out.println("Incoming calls stats for number: " + simMobileNumber);
		if (lastIncomingCall.caller == null) {
			System.out.println("No incoming calls");
			return;
		}
		
		System.out.println("Last incoming call from: " + lastIncomingCall.caller);
		System.out.println("Last incoming call duration: " + lastIncomingCall.duration);
	}
	
	void printInfoForMissedCalls(){
		System.out.println(missedCalls.length -1 -countMissedCalls +" missed calls");
		for (int i = missedCalls.length -1; i > countMissedCalls; i--) {
			System.out.println("Missed call from: " + missedCalls[i].caller);
		}
	}
	
	void printTotalBill(){
		System.out.println("Bill: " + getSumForCall() + "Lv (" + outgoingCallsDuration + " minutes in total * " + Call.priceForAMinute/100f + ")");
	}
	
	boolean validateNumber(String number){
		if (number.matches("08[1-9]{8}")) {
			return true;
		} else {
			return false;
		}
	}
}
