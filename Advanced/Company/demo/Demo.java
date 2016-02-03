package demo;

import java.util.ArrayList;
import java.util.List;

import engine.Company;
import engine.Employee;

public class Demo {

	public static void main(String[] args) {

		Employee em = new Employee("Pencho", 45);
		Employee em1 = new Employee("Pencho", 45);
		
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Roni", 21));
		emps.add(new Employee("Ivan", 11));
		emps.add(new Employee("Tim", 31));
		emps.add(new Employee("Petkan", 19));		
		
		Company blizzard = new Company("Blizzard");

		blizzard.addEmployeeToDepartment("Tester", em);
		blizzard.addEmployeeToDepartment("Tester", em);
		blizzard.addEmployeeToDepartment("Tester", em1);
		
		blizzard.addListOfEmployeesToDepartment("Production", emps);
		
		blizzard.showAllEmployees();
//		blizzard.showAllEmployeesByDepartments();

//		blizzard.removeDuplicatesFromList();
		blizzard.removeDuplicateEmployee();
		
//		blizzard.sortEmployeesBySalaryDesc();
//		blizzard.sortEmployeesByName();
//		blizzard.sortEmployeesByAgeDesc();
		
//		blizzard.setSalaryForDepartment("Production", 500);
		
		blizzard.showAllEmployees();
		
	}

}
