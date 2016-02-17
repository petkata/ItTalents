package engine;

import java.time.LocalTime;
import java.util.Stack;

public class Item {

	private String name;
	
	private boolean isRent;
	
	private double totalTax;

	public Item(String name) {
		this.name = name;
	}

	public String getName(){
		return this.name;
	}
	
	private Stack<LocalTime> timeOfTake = new Stack<>();
	private Stack<LocalTime> timeOfreturn = new Stack<>();



	protected LocalTime getTimeOfTake() {
		return timeOfTake.peek();
	}

	protected void setTimeOfTake(LocalTime timeOfTake) {
		this.timeOfTake.push(timeOfTake);
	}

	protected LocalTime getTimeOfreturn() {
		return timeOfreturn.peek();
	}

	protected void setTimeOfreturn(LocalTime timeOfreturn) {
		this.timeOfreturn.push(timeOfreturn);
	}

	protected boolean isRent() {
		return isRent;
	}

	protected void setRent(boolean isRent) {
		this.isRent = isRent;
	}

	protected double getTotalTax() {
		return totalTax;
	}

	protected void setTotalTax(double totalTax) {
		this.totalTax += totalTax;
	}
	
	@Override
	public String toString() {
		return "TOtal tax " +this.totalTax + " ";
	}
	
}
