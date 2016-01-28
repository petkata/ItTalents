package engine;

import java.time.LocalDate;

import utils.FormatMoney;

public class Driver {

	private String name;
	
	private Vehicle[] vehicles;
	private int freePlacesForVehicles;
	public static final int TOTAL_PLACES_FOR_VEHICLES = 10; 
	
	private double money;
	
	private GasStation gs;
	
	public Driver(String name) {
		this.name = name;
		this.freePlacesForVehicles = TOTAL_PLACES_FOR_VEHICLES;
		this.vehicles = new Vehicle[this.freePlacesForVehicles];
	}
	
	public String getName(){
		return this.name;
	}
	/**
	 * 
	 * @param vehicle
	 */
	public void addVehicle(Vehicle vehicle){
		if (this.freePlacesForVehicles > 0) {
			this.vehicles[TOTAL_PLACES_FOR_VEHICLES - this.freePlacesForVehicles--] = vehicle;
			System.out.println(vehicle.getType() + " added to " + this.name + "'s garage");
		}
		else{
			System.out.println("No free places in " + this.name + "'s garage");
		}
	}
	/**
	 * 
	 * @param numberOfVehicle
	 * @return Vehicle
	 */
	public Vehicle getVehicle(int numberOfVehicle){
		return this.vehicles[numberOfVehicle];
	}
	
	public void setMoney(double money){
		this.money = money;
	}
	
	public void setGasStation(GasStation newGs){
		this.gs = newGs;
	}
	
	GasStation getGasStation(){
		return this.gs;
	}
	/**
	 * 
	 * @param gasStation
	 * @param periodType
	 */
	public void buyVignetteForAllVehicles(GasStation gasStation,String periodType){
		for (int i = 0; i < vehicles.length; i++) {
			this.buyVignetteForVehicle(gasStation, vehicles[i], periodType);
		}
	}
	/**
	 * 
	 * @param gasStation
	 * @param vehicle
	 * @param periodType
	 */
	public void buyVignetteForVehicle(GasStation gasStation,Vehicle vehicle, String periodType){
		if (!this.hasEnoughMoneyForTransaction(vehicle, periodType)) {
			return;
		}
		Vignette boughtVignette = gasStation.sellVignette(vehicle, periodType);
		if (boughtVignette != null) {
			this.money -= boughtVignette.getPrice();
			vehicle.putVignette(boughtVignette);
			System.out.println(this.name + " has bought a vignette for " + vehicle.getType());
			return;
		}
	}

	private boolean hasEnoughMoneyForTransaction(Vehicle vehicle, String periodType) {
		Vignette v = new Vignette(LocalDate.now().toString(), vehicle.getColorOfVignetteForVehicle(), periodType);
		
		if (this.money - v.getPrice() > 0) {
			return true;
		}
		System.out.println(this.name + " has not Enough money("+FormatMoney.FromatMoney(this.money)+") to buy Vignette for this "+vehicle.getType()+"("+v.getPrice()+")");
		return false;
	}

	void showNumberOfVehiclesWithVignettes(){
		int countVehicles = 0;
		for (int i = 0; i < vehicles.length; i++) {
			if (this.vehicles[i].getCurrentVignette() != null) {
				countVehicles++;
			}
		}
		System.out.println(this.name + " has " + countVehicles + " vehicles with vignettes");
	}
	
	/* method that shows general info regardless of type vehicle
	 * public void showNumberOfVehiclesWithExpiredVignette(String date){
		System.out.println("For driver: " + this.name);
		int countVehicles = 0;
		for (int i = 0; i < vehicles.length; i++) {
			if (this.vehicles[i].getCurrentVignette() == null) {
				continue;
			}
			if (this.vehicles[i].getCurrentVignette().getExpirationDate().isBefore(LocalDate.parse(date))) {
				countVehicles++;
			}
		}
		if (countVehicles==0) {
			System.out.println("There would be no expired vignettes on this date("+date+")");
			return;
		}
		
		System.out.println(" On " + date + " " + countVehicles + " vehicles are going to have expired vignettes");
	}*/
	
	public void showNumberOfVehiclesWithExpiredVignette(String date){
		System.out.println("For driver: " + this.name);
		this.showNumberOfSpecificTypeVehicleWithExpiredVignette(Vehicle.VEHICLE_TYPE_CAR, date);
		this.showNumberOfSpecificTypeVehicleWithExpiredVignette(Vehicle.VEHICLE_TYPE_TRUCK, date);
		this.showNumberOfSpecificTypeVehicleWithExpiredVignette(Vehicle.VEHICLE_TYPE_BUS, date);
	}
	
	public void showNumberOfSpecificTypeVehicleWithExpiredVignette(String vehicleType,String date){
		int countVehicles = 0;
		for (int i = 0; i < vehicles.length; i++) {
			if (this.vehicles[i].getType().equals(vehicleType)) {
				if (this.vehicles[i].getCurrentVignette() == null) {
					continue;
				}
				if (this.vehicles[i].getCurrentVignette().getExpirationDate().isBefore(LocalDate.parse(date))) {
					countVehicles++;
				}
			}
		}
		if (countVehicles==0) {
			System.out.println(" There would be no expired " + vehicleType + " vignettes on this date("+date+")");
			return;
		}
		System.out.println(" On " + date + " " + countVehicles + " " + vehicleType +" are going to have expired vignettes");
	}
	public void getMoney(){
		System.out.println("Name: " + this.name);
		System.out.print(" Money left: " + FormatMoney.FromatMoney(this.money));
	}
	
	
	// for testings only
	void showDriverInfo(){
		System.out.println("Name: " + this.name);
		System.out.println("Money: " + FormatMoney.FromatMoney(this.money));
		System.out.println("Show moto park: ");
		for (int i = 0; i < vehicles.length; i++) {
			vehicles[i].showVeh();
		}
	}
}
