package utilities;

public abstract class Validations {
	/**
	 * Checks if the input value is non negative.
	 * @param inputValue -> input value
	 * @return if non positive - prevents from creating the the object
	 * else returns the value of input int.
	 */
	public static boolean isValidInt(int inputValue){
		if (inputValue < 0) {
			return false;
		}
		else {
			return true;
		}
	}
	/**
	 * Checks if the input String is at least 2 characters long.
	 * @param inputString -> input value
	 * @return if string is empty prevents from creating the the object. Else  returns inputString. 
	 */
	public static boolean isValidString(String inputString){
		if (inputString == null || inputString.length() < 2) {
			return false;
		}
		else {
			return true;
		}
	}
	/**
	 * Checks if the input value is non negative.
	 * @param  inputDouble -> input value
	 * @return if non positive - prevents from creating the the object
	 * else returns the value of input int.
	 */
	public static boolean isValidDouble(double inputDouble){
		if (inputDouble < 1) {
			return false;
		}
		else {
			return true;
		}
	}
}
