package engine;

import java.time.Year;

import utils.*;

public class Demo {
	
	public static void main(String[] args) {
		

		GasStation gs = new GasStation();
//		gs.showAvailableVignettes();
		
//		Driver[] drivers = new Driver[20] ;
//		createDrivers(drivers, gs);

//		Vehicle[] vehicles = new Vehicle[200]; 		
//		generateVehicles(vehicles);
		
//		addVehiclesToDrivers(vehicles, drivers);
//		drivers[0].addVehicle(new Vehicle.Car("yaris", Year.of(Validations.validateYear(1995))));

//		buyVignettesForDrivers(drivers);
		
//		showDriverInfo(drivers,Validations.validateDate("2017-01-15"));
		
//		gs.showAvailableVignettes();
		
//		showNumberOfSpecificTypeVehicleWithExpiredVignette(drivers, Vehicle.VEHICLE_TYPE_TRUCK, Validations.validateDate("2017-01-15"));
		
//		gs.showAvailableVignettes();
//		gs.showDailyIncome();
		
	}
	
	private static void showNumberOfSpecificTypeVehicleWithExpiredVignette(Driver[] drivers, String vehicleType, String date) {
		for (int i = 0; i < drivers.length; i++) {
			System.out.println(drivers[i].getName());
			drivers[i].showNumberOfSpecificTypeVehicleWithExpiredVignette(vehicleType, date);
		}
	}

	private static void showDriverInfo(Driver[] drivers, String date) {
		for (int i = 0; i < drivers.length; i++) {
			System.out.print("\t");
			drivers[i].showNumberOfVehiclesWithVignettes();
			System.out.print("\t");
			drivers[i].showNumberOfVehiclesWithExpiredVignette(date);
			System.out.print("\t");
			drivers[i].getMoney();
		}
	}

	private static void buyVignettesForDrivers(Driver[] drivers) {
		for (int i = 0; i < drivers.length; i++) {
			if ((i*2-1)%3 == 0 && i!=0) {
				int count = 0;
				while (count<5){
					//generate number 
					// check if vehicle number already has a vignette
					int generatedNumber = RandomGenerator.generateRandom(Driver.TOTAL_PLACES_FOR_VEHICLES-1);
					if (drivers[i].getVehicle(generatedNumber).getCurrentVignette() == null) {
						drivers[i].buyVignetteForVehicle(drivers[i].getGasStation(),drivers[i].getVehicle(generatedNumber),generateRandomPeriod());
						count++;
					}
					
				}
				
			}
			else {
				drivers[i].buyVignetteForAllVehicles(drivers[i].getGasStation(),generateRandomPeriod());
			}
		}
	}

	private static String generateRandomPeriod(){
		String[] periods = {Vignette.VIGNETTE_PERIOD_WEEK, Vignette.VIGNETTE_PERIOD_MONTH, Vignette.VIGNETTE_PERIOD_YEAR};
		return periods[RandomGenerator.generateRandom(periods.length)];
	}
	
	private static void createDrivers(Driver[] drivers, GasStation gs){
		String[] names = {"gosho", "gen4o", "maria", "ivan", "dragan", "petkan", "toni", "val", "dani","poli",
				"tosho", "pen4o", "daria", "sinan", "drago", "penka", "antoni", "valio", "doni","doli"};
		for (int i = 0; i < drivers.length; i++) {
			drivers[i] = new Driver(names[RandomGenerator.generateRandom(names.length)]);
			drivers[i].setMoney(RandomGenerator.generateMoney(10_000));
			drivers[i].setGasStation(gs);
//			addVehiclesToDriver(vehicles, drivers[i], i);
		}
	}
	
	private static void addVehiclesToDrivers(Vehicle[] vehicles, Driver[] drivers){
		
		for (int i = 0; i < drivers.length; i++) {
			for (int j = i*10; j < i*10+10; j++) {
				drivers[i].addVehicle(vehicles[j]);
			}
			
		}
	}
	
	private static void generateVehicles(Vehicle[] vehicles){
		String[] modelsOfVehicles = {"mrcds", "bmw", "ford","jeep","scania","alfa","hyundai"};
		for (int i = 0; i < vehicles.length; i++) {
			Vehicle randomCar = new Vehicle.Car(modelsOfVehicles[RandomGenerator.generateRandom(modelsOfVehicles.length)], generateRandomYearForVehicle());
			Vehicle randomTruck = new Vehicle.Truck(modelsOfVehicles[RandomGenerator.generateRandom(modelsOfVehicles.length)], generateRandomYearForVehicle());
			Vehicle randomBus = new Vehicle.Bus(modelsOfVehicles[RandomGenerator.generateRandom(modelsOfVehicles.length)], generateRandomYearForVehicle());
			Vehicle[] randomVehicles = {randomCar,randomTruck,randomBus};
			vehicles[i] = randomVehicles[RandomGenerator.generateRandom(randomVehicles.length)];
		}
	}
	
	private static Year generateRandomYearForVehicle(){
		return Year.parse(String.valueOf(
				(RandomGenerator.generateRandom(
						Integer.parseInt(Year.now().toString()) - Vehicle.EARLIEST_YEAR_FOR_VEHICLE)
						) + Vehicle.EARLIEST_YEAR_FOR_VEHICLE
				)
			);
	}
}
