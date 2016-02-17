package engine;

import java.time.LocalDate;
import java.util.Map;

public class Magazine extends Item{

	private String publisher;
	private String category;
	private int number;
	private int dateOfPublishing;

	public Magazine(String name, String publisher, String category, int number, int dateOfPublishing) {
		super(name);
		this.publisher = publisher;
		this.category = category;
		this.number = number;
		this.dateOfPublishing = dateOfPublishing;
	}

	protected String getCategory() {
		return category;
	}



	protected int getNumber() {
		return number;
	}



	@Override
	public String toString() {
		return this.category + " " + super.getName() + " num:" +  this.number;
	}
}
