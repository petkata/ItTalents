package estates;

public class House extends Estate {

	private int numberOfFloors;

	protected House(String name, double area, String location, boolean hasFurniture, int numberOfFloors) {
		super(name, area, location, hasFurniture);
		this.numberOfFloors = numberOfFloors;
	}

	@Override
	protected String getType() {
		return "House";
	}
	
	@Override
	public void showEstateInfo() {
		super.showEstateInfo();
		System.out.println("Number of floors: " + this.numberOfFloors);
	}
}
