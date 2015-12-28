package encapsulation;

import unitilites.Validations;

public class Person {
	
	private static final int DEFAULT_AGE = 18;
	
	private String name;
	private int age;
	private boolean isMale;
	
	public Person (String newName, int newAge, boolean isMale){
		this.setName(newName);
		this.setAge(newAge);
		this.isMale = isMale;
	}

	private void setName(String name) {
		if (this.checkIfValidNameChars(name.toString())) {
			this.name = this.setFirstLetterOfNameToUpperCase(name).toString();
		}
	}
	
	protected String getName() {
		return this.name;
	}

	protected void setAge(int age) {
		if (Validations.validateInt(age) && age != 0) {
			this.age = age;
		}
		else {
			System.out.println("Value for age is not valid(must be between 0 and 150)! A deafult value of 18 will be set!");
			this.age = DEFAULT_AGE;
		}
	}
	
	protected int getAge(){
		return this.age;
	}
		
	public void showPersonInfo(){
		System.out.println("Information about the " + this.getClass().getSimpleName() + ": ");
		System.out.println("Name: " + ((this.name != null)? this.name : "N/A"));
		System.out.println("Age: " + this.age);
		System.out.println("Gender: " + ((isMale)? "Male" : "Female"));
	}
	
	/**
	 * 
	 * <strong>[a-zA-z]{2,}+ </strong>- check if there are at least 2 letters, </br>
	 * <strong>(\\s*-?\\s*[a-zA-z]{2,}+)* </strong>- check if it is a hyphenated name
	 * @param String
	 * @return <strong>boolean </strong>
	 */
	private boolean checkIfValidNameChars(String name){
		if (name.trim().matches("[a-zA-z]{2,}+(\\s*-?\\s*[a-zA-z]{2,}+)*")){
			return true;
		}
		else {
			System.out.println(name + " is not a valid name");
			return false;
		}
	}
	
	/**
	 * Sets the first letter of each name to upper case
	 * @param StringBuilder name
	 * @return StringBuilder
	 */
	private StringBuilder setFirstLetterOfNameToUpperCase(String nameToConvert){
		StringBuilder name = new StringBuilder(nameToConvert);
		name.setCharAt(0, ((char)(name.charAt(0)-32)));
		for (int i = 1; i < name.length(); i++) {
			if (name.charAt(i) > 90) {
				if (name.charAt(i-1) == ' ' || name.charAt(i-1) == '-') {
					name.setCharAt(i, ((char)(name.charAt(i)-32)));
				}
			}
			
		}
		return name;
	}
}
