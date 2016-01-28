package engine;

import java.time.*;

import utils.SortByPrice;
import utils.RandomGenerator;

public class GasStation {
	
	private double dailyIncome;

	private int countSoldVignettes;
	
	public static final int GS_VIGNETTE_CAPACITY = 10_000;
	private Vignette[] availableVignettes;
	
	public GasStation() {
		this.countSoldVignettes =0;
		this.availableVignettes = new Vignette[GS_VIGNETTE_CAPACITY];
		this.generateVignettes(this.availableVignettes);
		this.sortAvailableVignettes(this.availableVignettes);
	}

	private void generateVignettes(Vignette[] v){
		//We want vignettes only for the current year
		int year = LocalDate.now().getYear();
		String[] colors = {Vignette.VIGNETTE_COLOR_CAR,Vignette.VIGNETTE_COLOR_TRUCK, Vignette.VIGNETTE_COLOR_BUS};
		String[] periods = {Vignette.VIGNETTE_PERIOD_WEEK,Vignette.VIGNETTE_PERIOD_MONTH,Vignette.VIGNETTE_PERIOD_YEAR};
		
		for (int i = 0; i < v.length; i++) {
			
			String randomColor = colors[RandomGenerator.generateRandom(colors.length)];
			
			int randomMonth = RandomGenerator.generateRandomDate(12);
			int randomDay =  this.generateDayOfMonth(randomMonth);
			String randomDate = year + "-" + ((randomMonth<10)? "0"+randomMonth : randomMonth)
					+ "-" + ((randomDay<10)? "0"+randomDay : randomDay);
			
			String randomPeriodType = periods[RandomGenerator.generateRandom(periods.length)];
			v[i] = new Vignette(randomDate, randomColor, randomPeriodType);
		}
	}
	
	private int generateDayOfMonth(int month){
		if(month == 1 || month == 3 || month ==  5 || month == 7 || month == 8 || month == 10 || month == 12)
		{
			return RandomGenerator.generateRandomDate(31) ;
		}
		else if( month == 4 || month == 6 || month == 9 || month == 11)
		{
			return RandomGenerator.generateRandomDate(30) ;
		}
		else {
			return RandomGenerator.generateRandomDate(28) ;
		}
	} 

	public Vignette sellVignette(Vehicle vehicle, String period){
		for (int i = 0; i < availableVignettes.length-this.countSoldVignettes; i++) {
			if (vehicle.getType().equals(availableVignettes[i].getVehicleType()) && 
					period.equals(availableVignettes[i].getPeriodType())) {
				Vignette soldVignette = availableVignettes[i];
				this.dailyIncome += soldVignette.getPrice();
				this.countSoldVignettes++;
				this.sortAfterSelling(i,this.countSoldVignettes);
				return soldVignette;
			}
		}
		System.out.println("No availability");
		return null;
	}
	
	private void sortAfterSelling(int positionOfSoldVignette, int sold) {
		for (int i = positionOfSoldVignette; i < this.availableVignettes.length-sold+1; i++) {
			if (i >= this.availableVignettes.length -sold) {
				this.availableVignettes[i] = null;
				return;
			}
			this.availableVignettes[i] = this.availableVignettes[i+1];
		}
		
	}

	private void sortAvailableVignettes(Vignette[] v){
		SortByPrice.sortVignettes(this.availableVignettes, 0, this.availableVignettes.length-1);
	}
	
	public void showDailyIncome(){
		System.out.println("Income for the day: " + this.dailyIncome);
	}
	
	/**
	 * Show all available vignettes
	 */
	public void showAvailableVignettes(){
		System.out.println("Info for V: ");
		int count = 0;
		for (int i = 0; i < availableVignettes.length-this.countSoldVignettes; i++) {
			count++;
			this.availableVignettes[i].showInfo();
			System.out.println("\t -------------------");
		}
		System.out.println(count + " vignettes left");
	}
	
}
