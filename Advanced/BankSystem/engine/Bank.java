package engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import utils.FormatMoney;

public class Bank {

	private static String bankName;
	private static String bankAddress;
	private static Map<Person, HashMap<BankProduct, Double>> bankProducts;
	private static double bankFunds;
	private static double bankReserve;
	
	private static Bank instance = new Bank();

	private Bank() {
	}
	
	public static Bank getInstance(String bankName, String bankAddress, double bankFunds){
		Bank.bankName = bankName;
		Bank.bankAddress = bankAddress;
		Bank.bankFunds = bankFunds;
//		Bank.bankReserve = 0.1*bankFunds;
		Bank.bankProducts = new HashMap<>();
		return instance;
	}
	
	void getDepositFromClient(Person client,Deposit depositType, double moneyToDeposit){
		if (!bankProducts.containsKey(client)) {
			bankProducts.put(client, new HashMap<>());
		}
		bankProducts.get(client).put(depositType, moneyToDeposit);
		bankFunds += moneyToDeposit;
		bankReserve += 0.9*moneyToDeposit;
	}
	
	//TODO set it to boolean
	void giveCreditToClient(Person client,Credit creditType, double creditMoney, int period){
		if (!bankProducts.containsKey(client)) {
			bankProducts.put(client, new HashMap<>());
		}
		for (Person p : bankProducts.keySet()) {
			if (p.equals(client)) {
				if (Bank.bankReserve < creditMoney ||(Bank.bankFunds - creditMoney) < Bank.bankReserve) {
					System.out.println("----Insufficient money in bank reserve!");
					return;
				}
				if (p.creditsTotalTax() < p.getSalary()/2) {
					bankProducts.get(client).put(creditType, creditMoney);
					bankFunds -= creditMoney;
					System.out.println("Take this credit " + p.getName());
					return;
				}
				System.out.println(p.getName() + " doesn't have enough money to pay monthly tax");
				return;
			}
		}
		
	}
	
	//TEST
	public void showProducts(){
		for (Map.Entry<Person, HashMap<BankProduct, Double>> entry: Bank.bankProducts.entrySet()) {
			System.out.println(entry.getKey());
			for (Entry<BankProduct, Double>  bP : entry.getValue().entrySet()) {
				System.out.println("\t"+bP.getKey());
			}
		}
	}
	
	public double getBankFunds(){
		return Bank.bankFunds;
	}
	
	@Override
	public String toString() {
		return Bank.bankName + " " + bankAddress + " Reserve: " + FormatMoney.FromatMoney(bankReserve) + " Bank Funds:" + FormatMoney.FromatMoney(bankFunds);
	}
}
