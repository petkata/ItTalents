package engine;

import utils.FormatMoney;

public class Credit extends BankProduct{

	private double monthTax;
	private int period;
	
	public Credit(String nameOfProduct, double yearInterest) {
		super(nameOfProduct, yearInterest, 0);
	}
	
	void setPeriod(int period){
		this.period = period;
	}
	// if this is not complex interest
	double getMonthTask(){
		return this.monthTax = (super.getAvailableMoney()+(super.getAvailableMoney()*super.getYearInterest()))/this.period;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " -- Period: " + this.period +"m" + " -- Month tax: " + FormatMoney.FromatMoney(monthTax) ;
	}
	
}
