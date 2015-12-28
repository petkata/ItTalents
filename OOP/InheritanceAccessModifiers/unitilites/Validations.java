package unitilites;

public class Validations {
	/**
	 * Checks if the input value is non negative.
	 * @param int inputValue
	 * @return if non positive - default value of 100
	 * else returns the value of input int.
	 */
	public static boolean validateInt(int inputValue){
		if (inputValue < 0) {
			return false;
		}
		else {
			return true;
		}
	}
	/**
	 * Checks if the input String is not empty.
	 * @param String 
	 * @return  if string is empty returns null. Else  returns inputString. 
	 */
	public static boolean validateString(String inputString){
		if (inputString.length() <= 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static boolean validateDouble(double inputDouble){
		if (inputDouble <= 0) {
			return false;
		}
		else {
			return true;
		}
	}
}
