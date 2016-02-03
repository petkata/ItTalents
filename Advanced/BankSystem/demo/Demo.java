package demo;

import java.util.ArrayList;

import engine.Bank;
import engine.Person;
import utils.RandomGenerator;
import engine.Credit;
import engine.Deposit;

public class Demo {

	public static void main(String[] args) {
		
		
		
		Bank bank= Bank.getInstance("OBB", "Sofiq", 10_000);
		
		ArrayList<Person> clients = generateClients();
		
		for (Person client : clients) {
			System.out.println(client);
		}
		System.out.println(bank);
		
		System.out.println("\n-------After deposit-------\n");
		makeDeposit(bank, clients);
//		Deposit shortDeposit = new Deposit("Short Deposit", 3, 3);
//		clients.get(2).makeDeposit(bank, 10, shortDeposit); 
		System.out.println(bank);
		bank.showProducts();
		
		System.out.println("\n-------After credit-------\n");
		
		
		
		drawCredit(bank, clients);
//		drawCredit(bank, clients, 1500, 6);
		
//		System.out.println(clients.get(2));
//		clients.get(2).drawCredit(bank, consumerCredit, 2000, 5);
//		clients.get(2).drawCredit(bank, homeCredit, 1000, 5);
//		clients.get(3).drawCredit(bank, homeCredit, 2000, 5);
//		clients.get(3).drawCredit(bank, homeCredit, 2000, 5);
//		System.out.println(clients.get(2).creditsTotalTax());

		System.out.println(bank);
		bank.showProducts();
	}
	
	static ArrayList<Person> generateClients(){
		ArrayList<Person> clients = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			clients.add(new Person(
					RandomGenerator.nameGenerator(), 
					RandomGenerator.townGenerator(), 
					RandomGenerator.salaryGenerator(),
					RandomGenerator.moneyGenerator()));
		}
		return clients;
	}

	static void makeDeposit(Bank bank, ArrayList<Person> clients){
		
		for (Person client : clients) {
			Deposit shortDeposit = new Deposit("Short Deposit", 3, 3);
			Deposit longDeposit = new Deposit("long Deposit", 5, 12);
			Deposit[] deposits = {shortDeposit,longDeposit};
			client.makeDeposit(
					bank, 
					deposits[RandomGenerator.numberGenerator(deposits.length)], 
					(client.getCurrentMoney()*RandomGenerator.depositGenerator())/100);
		}
	}

	static void drawCredit(Bank bank, ArrayList<Person> clients){   //,double creditAmount, int period){
		
		for (Person client : clients) {
			Credit homeCredit = new Credit("Home Credit", 6);
			Credit consumerCredit = new Credit("Consumer Credit", 10);
			Credit[] credits = {homeCredit, consumerCredit};
			client.drawCredit(
					bank, 
					credits[RandomGenerator.numberGenerator(credits.length)],
					RandomGenerator.moneyGenerator(), 
					RandomGenerator.numberGenerator(12)
//					creditAmount,
//					period
					);
		}
	}
}
