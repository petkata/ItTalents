package demo;

import java.util.ArrayList;
import java.util.HashMap;

import engine.BankProduct;
import engine.Credit;
import engine.Deposit;
import engine.Person;

public class Test {

	public static void main(String[] args) {

		HashMap<Person, HashMap<BankProduct, Double>> map = new HashMap<>();
		Person person = new Person("test", "testaddr", 500, 1000);
		
		Deposit shortDeposit = new Deposit("Short Deposit", 3, 3);
		Deposit longDeposit = new Deposit("long Deposit", 5, 12);
		
		Credit homeCredit = new Credit("Home Credit", 6);
		Credit consumerCredit = new Credit("Consumer Credit", 10);
		
		map.put(person, new HashMap<>());
		map.get(person).put(shortDeposit,800d);
		map.get(person).put(longDeposit,1200d);
//		map.get(person).put(homeCredit);
//		map.get(person).add(consumerCredit);
		
		System.out.println(map.get(person));
	}

}
