package encapsulation;

import unitilites.Validations;

public class Employee extends Person {

	private static final double DEFAULT_DAY_SALARY = 40;
	private static final int DEFAULT_WORKING_DAY_HOURS = 8;
	private static final double DEFAULT_OVERTIME_INDEX = 1.5;

	private double daySalary;
	
	public Employee(String newName, int newAge, boolean isMale, double daySalary) {
		super(newName, newAge, isMale);
		setDaySalary(daySalary);
	}
	
	private void setDaySalary(double salary){
		if (Validations.validateDouble(salary)) {
			this.daySalary = salary;
		}
		else {
			System.out.println("The value of salary must be non negative! A default value of 40 will be set!");
			this.daySalary = DEFAULT_DAY_SALARY;
		}
	}
	
	public double calculateOvertime(double hours){
		if (Validations.validateDouble(hours) && super.getAge() >= 18) {
			double salaryPerHour = this.daySalary / DEFAULT_WORKING_DAY_HOURS;
			return hours * salaryPerHour * DEFAULT_OVERTIME_INDEX;
		}
		else if(super.getAge() < 18){
			System.out.println("Employees under the age of 18 cannot work overtime!");
			return 0;
		}
		else {
			System.out.println("Hours must be non negative!");
			return 0;
		}
	}
	
	public void showEmployeeInfo(){
		super.showPersonInfo();
		System.out.println("Daily salary: " + this.daySalary);
	}
	
	public void showCalculatedOvertime(int hours) {
		if (super.getAge() < 18 ) {
				System.out.println(super.getName() + " is under 18 and cannot work overtime");
				return;
		}
		System.out.println(super.getName() + "'s salary for " + hours + " hours overtime is: " + this.calculateOvertime(hours));
	}
}
