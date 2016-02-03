package engine;

import utils.FormatMoney;

public abstract class BankProduct {

	private String nameOfProduct;
	private double yearInterest;
	private int period;
	private double availableMoney;
	
	public BankProduct(String nameOfProduct, double yearInterest, int period) {
		this.nameOfProduct = nameOfProduct;
		this.yearInterest = yearInterest/100;
		this.period = period;
	}
	
	protected int getPeriod(){
		return this.period;
	}
	
	protected double getYearInterest(){
		return this.yearInterest;
	}
	
	protected double getAvailableMoney(){
		return this.availableMoney;
	}
	
	protected void setAvailableMoney(double money){
		this.availableMoney += money;
	}
	
	//TEST
	@Override
	public String toString() {
		if (this instanceof Deposit) {
			return "Name: "+this.nameOfProduct + " -- Interest:" + this.yearInterest*100 + "% -- Money in deposit: "  + FormatMoney.FromatMoney(this.availableMoney) + " -- Period: " + this.period +"m" ;
		}
		return "Name: "+this.nameOfProduct + " -- Interest:" + this.yearInterest*100 + "% -- Credit: "  + FormatMoney.FromatMoney(this.availableMoney);
	}
}
