package engine;
import java.time.Year;

public class Vehicle {

	public static final String VEHICLE_TYPE_CAR = "car";
	public static final String VEHICLE_TYPE_TRUCK = "truck";
	public static final String VEHICLE_TYPE_BUS = "bus";
	
	public static final int EARLIEST_YEAR_FOR_VEHICLE = 1920;
	
	public static final int VIGNETTE_APPLY_TIME_CAR = 5;
	public static final int VIGNETTE_APPLY_TIME_TRUCK = 10;
	public static final int VIGNETTE_APPLY_TIME_BUS = 20;
	
	private String model;
	private Vignette currentVignette;
	private Year yearOfProduction;
	private String type;
	private int timeForApplying;
	
	public Vehicle(String model, Year yearOfProduction) {
		this.model = model;
		this.yearOfProduction = yearOfProduction;
	}
	
	String getType(){
		return this.type;
	}
	
	Vignette getCurrentVignette(){
		return this.currentVignette;
	}
	
	static class Car extends Vehicle{

		public Car(String model, Year yearOfProduction) {
			super(model, yearOfProduction);
			super.type = VEHICLE_TYPE_CAR;
			super.timeForApplying = VIGNETTE_APPLY_TIME_CAR;
		}
		
	}
	
	static class Truck extends Vehicle{

		public Truck(String model, Year yearOfProduction) {
			super(model, yearOfProduction);
			super.type = VEHICLE_TYPE_TRUCK;
			super.timeForApplying = VIGNETTE_APPLY_TIME_TRUCK;
		}
		
	}
	
	static class Bus extends Vehicle{

		public Bus(String model, Year yearOfProduction) {
			super(model, yearOfProduction);
			super.type = Vehicle.VEHICLE_TYPE_BUS;
			super.timeForApplying = VIGNETTE_APPLY_TIME_BUS;
		}
		
	}
	
	void putVignette(Vignette vignette){
		this.currentVignette = vignette;
		System.out.println("Time for applying: " + this.timeForApplying);
		
	}
	
	protected String getColorOfVignetteForVehicle(){
		if (this instanceof Car) {
			return Vignette.VIGNETTE_COLOR_CAR;
		}
		else if (this instanceof Truck) {
			return Vignette.VIGNETTE_COLOR_TRUCK;
		}
		else if (this instanceof Bus){
			return Vignette.VIGNETTE_COLOR_BUS;
		}
		else return null;
	}
	
	// testing
	void showVeh(){
		System.out.println("------VEHICLE INFO------");
		System.out.println("\tType: " + this.type);
		System.out.println("\tModel: " + this.model);
		System.out.println("\tYear: " + this.yearOfProduction);
		if (this.currentVignette != null) {
			this.currentVignette.showInfo();
		}
		else {
			System.out.println("No vignette bought");
		}
		System.out.println("------------------------");
	}
}
