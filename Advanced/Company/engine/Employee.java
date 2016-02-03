package engine;

import java.util.Random;

public class Employee {

	static int employeeId;
	
	private int age;
	private String name;
	private double salary;
	private int personalId;
	
	public Employee(String name, int age) {
		// Employee id starts from 1
		this.age = age;
		this.name = name;
		this.personalId=++employeeId;
		//for testing 
		Random r = new Random();
		this.salary = r.nextDouble()*100;
	}
		
	Double getSalary(){
		return this.salary;
	}
	
	void setSalary(double newSalary){
		this.salary = newSalary;
	}
	
	String getName(){
		return this.name;
	}
	
	int getAge(){
		return this.age;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ID:"+ this.personalId+ " - " + this.name + "(" + this. age + "г) salary: " + this.salary;
	}
}
