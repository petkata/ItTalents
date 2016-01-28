package utils;

import engine.Vehicle;

public abstract class Validations {
	
	public static int validateYear(int inputValue){
		if (inputValue < Vehicle.EARLIEST_YEAR_FOR_VEHICLE) {
			System.out.println("Incorrect year : Must be later than " + Vehicle.EARLIEST_YEAR_FOR_VEHICLE);
			System.out.println("A default year would be set: " + Vehicle.EARLIEST_YEAR_FOR_VEHICLE);
			return Vehicle.EARLIEST_YEAR_FOR_VEHICLE;
		}
		else {
			return inputValue;
		}
	}
	
	public static String validateString(String inputString){
		if (inputString == null || inputString.length() < 2) {
			System.out.println("Incorrect input: must be at least 2 characters long");
			return "N/A";
		}
		else {
			return inputString;
		}
	}
	
	public static String validateDate(String inputDate){
		if (inputDate.matches("(199[0-9]{1}|20[0-9]{2})-(0[1-9]{1}|1[0-2])-([123]0|[012][1-9]|31)")) {
			System.out.println(true);
			return inputDate;
		}
		else {
			System.out.println("Incorrect date: Must be between 1990-01-01 and 2099-12-31");
			System.out.println("Default 1990-01-01 would be set");
			return "1990-01-01";
		}
	}
}
