package estates;

public class Apartment extends Estate {
	
	private int numberOfRooms;
	private boolean hasElevator;
	
	protected Apartment(String name, double area, String location, boolean hasFurniture, int numberOfRooms, boolean hasElevator) {
		super(name, area, location, hasFurniture);
		this.numberOfRooms = numberOfRooms;
		this.hasElevator = hasElevator;
	}
	
	@Override
	protected String getType() {
		return "Apartment";
	}
	
	@Override
	public void showEstateInfo() {
		super.showEstateInfo();
		System.out.println("Rooms: " + this.numberOfRooms);
		System.out.println("Has an elevator: " + ((this.hasElevator)? "yes": "no"));
	}
	
}
