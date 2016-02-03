package engineextended;

import java.util.ArrayList;
import java.util.List;
 

public class ExtendedDemo {

	public static void main(String[] args) {
		Employee em = new Employee("Pencho", 45);
		Employee em1 = new Employee("Pencho", 46);
		Employee.Manager man = new Employee.Manager("Гошо началника", 44, "Шеф");
		
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Roni", 21));
		emps.add(new Employee("Ivan", 11));
		emps.add(new Employee("Tim", 31));
		emps.add(new Employee("Petkan", 19));		
		
		Company blizzard = new Company("Blizzard");

		blizzard.addEmployeeToDepartment("Tester", em);
		blizzard.addEmployeeToDepartment("Tester", em);
		blizzard.addEmployeeToDepartment("Tester", em1);
		blizzard.addEmployeeToDepartment("Tester", man);
		
		blizzard.addListOfEmployeesToDepartment("Production", emps);
		blizzard.addEmployeeToDepartment("Production", em1);
		blizzard.addEmployeeToDepartment("Production", man);
		
//		blizzard.showAllEmployees();
		blizzard.showAllEmployeesByDepartments();
	}
}
