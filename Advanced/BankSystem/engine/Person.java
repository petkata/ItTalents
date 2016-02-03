package engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import utils.FormatMoney;

public class Person {

	private String clientName;
	private String clientaddress;
	private double currentMoney;
	private double monthSalary;
	private Map<BankProduct, Double> clientBankProducts;
	
	public Person(String clientName, String clientaddress, double monthSalary, double startingMoney) {
		this.clientName = clientName;
		this.clientaddress = clientaddress;
		this.monthSalary = monthSalary;
		this.currentMoney  =startingMoney;
		this.clientBankProducts = new HashMap<>();
	}
	
	String getName(){
		return this.clientName;
	}
	
	double getSalary(){
		return this.monthSalary;
	}
	
	public double getCurrentMoney(){
		return this.currentMoney;
	} 	
	
	public void makeDeposit(Bank bank, Deposit deposit, double moneyToDeposit){
		if (this.currentMoney >= moneyToDeposit) {
			
			deposit.setAvailableMoney(moneyToDeposit);
			this.clientBankProducts.put(deposit, moneyToDeposit);
			
			bank.getDepositFromClient(this, deposit, moneyToDeposit);
			this.currentMoney -= moneyToDeposit;
		}
		else{
			System.out.println(this.clientName+" can't deposit more than what you have!(" + this.currentMoney + ")");
		}
		
	}

	public void drawCredit(Bank bank, Credit creditType, double creditMoney, int period){
		
		creditType.setPeriod(period);
		creditType.setAvailableMoney(creditMoney);
		this.clientBankProducts.put(creditType, creditMoney);
		if (bank.giveCreditToClient(this, creditType, creditMoney, period)) {
			this.currentMoney += creditMoney;
			return;
		}
		
	}
	
	public double creditsTotalTax(){
		double sumOfCredits = 0;
		for (Entry<BankProduct, Double> entry : clientBankProducts.entrySet()) {
			if (entry.getKey() instanceof Credit) {
				sumOfCredits += ((Credit) entry.getKey()).getMonthTask();
			}
		}
		return sumOfCredits;
	}
	
	
//	TEST
	
	public void showProducts(){
		for (BankProduct bp : this.clientBankProducts.keySet()) {
			System.out.println(bp);
		}
	}
	
	@Override
	public String toString() {
		return this.clientName + " from " + this.clientaddress + ": Salary " + FormatMoney.FromatMoney(this.monthSalary) + " current money:" + FormatMoney.FromatMoney(this.currentMoney); 
	}
}
