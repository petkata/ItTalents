package engine;

public class Book extends Item {

	private static final int BOOK_RENT_PERIOD = 300;
	private static final double BOOK_TAX = 2;
	private String author;
	private int dateOfPublish;
	private double totalTax;
	
	public Book(String title, String author, int dateOfPublish, String publisher, String type) {
		super(title, publisher, type);
		this.author = author;
		this.dateOfPublish = dateOfPublish;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - Year of publish: " + this.dateOfPublish;
	}

	@Override
	public int compareTo(Item o) {
		if (((Book)o).dateOfPublish > this.dateOfPublish) {
			return 1;
		}
		if (((Book)o).dateOfPublish< this.dateOfPublish) {
			return -1;
		}
		return 0;
	}

	@Override
	protected int getPeriod() {
		return BOOK_RENT_PERIOD;
	}

	@Override
	protected double setTax(double tax) {
		return BOOK_TAX;
	}

	@Override
	protected void setTotaltax() {
		this.totalTax += BOOK_TAX*0.01;
	}

	@Override
	protected double getTotaltax() {
		return this.totalTax + BOOK_TAX;
	}
}
