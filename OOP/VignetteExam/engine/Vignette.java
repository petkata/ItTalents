package engine;
import java.time.LocalDate;
import java.time.Period;

public class Vignette {
	public static final String VIGNETTE_COLOR_CAR = "red";
	public static final String VIGNETTE_COLOR_TRUCK = "green";
	public static final String VIGNETTE_COLOR_BUS = "blue";
	
	public static final String VIGNETTE_PERIOD_WEEK = "w";
	public static final String VIGNETTE_PERIOD_MONTH = "m";
	public static final String VIGNETTE_PERIOD_YEAR = "y";
	
	public static final double VIGNETTE_WEEK_PRICE_CAR = 5;
	public static final double VIGNETTE_WEEK_PRICE_TRUCK = 7;
	public static final double VIGNETTE_WEEK_PRICE_BUS = 9;
	
	private LocalDate dateOfPrint;
	
	private String color;
	private String vehicleType;
	
	private String periodType;
	
	private LocalDate expirationDate;

	private double price;
	
	public Vignette(String dateOfPrint, String color, String periodType) {
		this.dateOfPrint = LocalDate.parse(dateOfPrint);
		this.color = color;
		switch (this.color) {
		case VIGNETTE_COLOR_CAR:
			this.vehicleType = Vehicle.VEHICLE_TYPE_CAR;
			break;
		case VIGNETTE_COLOR_TRUCK:
			this.vehicleType =  Vehicle.VEHICLE_TYPE_TRUCK;
			break;
		case VIGNETTE_COLOR_BUS:
			this.vehicleType =  Vehicle.VEHICLE_TYPE_BUS;
			break;
		default:
			break;
		}
		this.periodType = periodType;
		this.setPrice();
		this.expirationDate = this.dateOfPrint.plus(Period.parse("P1"+this.periodType));
	}
	
	
	String getPeriodType(){
		return this.periodType;
	}
	public String getVehicleType(){
		return this.vehicleType;
	}
	
	public LocalDate getExpirationDate(){
		return this.expirationDate;
	}
	
	private void setPrice(){
		switch (this.color) {
		case VIGNETTE_COLOR_CAR:
			this.price = Vignette.calcVignette(VIGNETTE_WEEK_PRICE_CAR, this.periodType);
			break;
		case VIGNETTE_COLOR_TRUCK:
			this.price = Vignette.calcVignette(VIGNETTE_WEEK_PRICE_TRUCK, this.periodType);
			break;
		case VIGNETTE_COLOR_BUS:
			this.price = Vignette.calcVignette(VIGNETTE_WEEK_PRICE_BUS, this.periodType);
			break;
		default:
			break;
		}
	}

	private static double calcVignette(double vignettePrice , String periodType){
		switch (periodType) {
		case VIGNETTE_PERIOD_WEEK:
			return vignettePrice;
		case VIGNETTE_PERIOD_MONTH:
			return vignettePrice*10;
		case VIGNETTE_PERIOD_YEAR:
			return vignettePrice*60;
		default:
			return 0;
		}
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public void showInfo() {
		System.out.println("Vignette Info: ");
		System.out.println("\t Color: " + this.color);
		System.out.println("\t Date of print: " + this.dateOfPrint);
		System.out.println("\t Period type: " + this.periodType);
		System.out.println("\t Expiration date: " + this.expirationDate);
		System.out.println("\t Price: " + this.price);
		
	}
}
