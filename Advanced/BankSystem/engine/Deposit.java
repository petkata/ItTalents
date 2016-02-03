package engine;

import utils.FormatMoney;

public class Deposit extends BankProduct {

	private double monthPayAmount;
	
	public Deposit(String nameOfProduct, double yearInterest, int period) {
		super(nameOfProduct, yearInterest, period);
	}
	
	public double getMonthPayAmount(){
		return this.monthPayAmount = (super.getAvailableMoney()*super.getYearInterest())/super.getPeriod();
	}

	@Override
	public String toString() {
		return super.toString() + " -- Interest per month: " + FormatMoney.FromatMoney(this.getMonthPayAmount());
	}
}
