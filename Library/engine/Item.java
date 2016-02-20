package engine;

import java.time.LocalTime;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public abstract class Item implements Comparable<Item>{
	
	private String title;
	private String publisher;
	private String type;
	private boolean isRent;
	private Map<LocalTime,LocalTime> timeOfInteraction;

	protected Item(String title, String publisher, String type) {
		this.title = title;
		this.publisher = publisher;
		this.type = type;
		this.timeOfInteraction = new TreeMap<>();
	}
	
	protected void setTimeOFRent(LocalTime timeOfRent) {
		this.timeOfInteraction.put(timeOfRent, null);
	}
	
	protected void setTimeOFReturn(LocalTime timeOfRentur) {
		this.timeOfInteraction.put(Collections.max(timeOfInteraction.keySet()), timeOfRentur);
	}
	
	protected String getType() {
		return this.type;
	}

	public abstract int compareTo(Item o);

	protected String getTitle(){
		return this.title;
	}

	protected double setTax(double tax) {
		return 0;
	}

	protected boolean isRent() {
		return isRent;
	}

	protected void setRent(boolean isRent) {
		this.isRent = isRent;
	}

	protected int getPeriod() {
		return 0;
	}

	protected void setTotaltax() {
	}

	protected double getTotaltax() {
		return 0;
	}
	
	@Override
	public String toString() {
		return "Title: " + this.getTitle();
	}
}
