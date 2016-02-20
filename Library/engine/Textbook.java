package engine;

public class Textbook extends Item {

	private static final int TEXTBOOK_RENT_PERIOD = 150;
	private static final double TEXTBOOK_TAX = 3;
	private String author;
	private double totalTax;

	public Textbook(String title, String author, String publisher, String type) {
		super(title, publisher, type);
		this.author = author;
	}

	@Override
	public int compareTo(Item o) {
		return super.getTitle().compareToIgnoreCase(o.getTitle());
	}
	
	@Override
	protected int getPeriod() {
		return TEXTBOOK_RENT_PERIOD;
	}

	@Override
	protected double setTax(double tax) {
		return TEXTBOOK_TAX;
	}

	@Override
	protected void setTotaltax() {
		this.totalTax += TEXTBOOK_TAX*0.01;
	}

	@Override
	protected double getTotaltax() {
		return this.totalTax + TEXTBOOK_TAX;
	}
}
