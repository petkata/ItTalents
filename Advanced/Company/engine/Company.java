package engine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Company {

	private String companyName;
	private Map<String, ArrayList<Employee>> employeesByDepartment;
//	private List<Employee> employees;
	
	public Company(String companyName) {
		this.companyName = companyName;
		this.employeesByDepartment = new HashMap<>();
//		this.employees = new ArrayList<>();
	}
	
	public Map<String, ArrayList<Employee>> getEmployeesByDepartment(){
		return this.employeesByDepartment;
	}
	
//	public void addEmployee(Employee em){
//		this.employees.add(em);
//	}
	
//	public void addListOfEmployees(List<Employee> employees){
//		this.employees.addAll(employees);
//	}

	public void addEmployeeToDepartment(String department, Employee em){
		if (!this.employeesByDepartment.containsKey(department)) {
			this.employeesByDepartment.put(department, new ArrayList<Employee>());
			
		}
		this.employeesByDepartment.get(department).add(em);
//		this.employees.add(em);
	}
	
	public void addListOfEmployeesToDepartment(String department,List<Employee> employees){
		if (!this.employeesByDepartment.containsKey(department)) {
			this.employeesByDepartment.put(department, new ArrayList<Employee>());
		}
		this.employeesByDepartment.get(department).addAll(employees);
//		this.employees.addAll(employees);
	}
	
	public void showAllEmployees(){
		System.out.println("All employees: ");
		for(Employee em: this.convertToSeparateList(employeesByDepartment)){
			System.out.println("\t"+em);
		}
	}
	
	public void showAllEmployeesByDepartments(){
		System.out.println("All employees by departments: ");
		//TODO put some css here
 		for(Map.Entry<String, ArrayList<Employee>> entry: employeesByDepartment.entrySet()){
			System.out.println(entry.getKey()+" - "+entry.getValue());
		}
	}
	
	//TODO add some css
	private List<Employee> convertToSeparateList(Map<String, ArrayList<Employee>> employeesInDeps){
		List<Employee> listOfEmployees = new ArrayList<>();
		for(Map.Entry<String, ArrayList<Employee>> employees: employeesInDeps.entrySet()){
			listOfEmployees.addAll(employees.getValue());
		}
		listOfEmployees.sort(new Comparator<Employee>(){

			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareToIgnoreCase(e2.getName());
			}
		});
		return listOfEmployees;
		
	} 
	
	/**
	 * From highest to lowest 
	 */
	public void sortEmployeesBySalaryDesc(){
		System.out.println("Sort by salary from highest(\u2193)");
//		this.employees.sort(new Comparator<Employee>() {
		List<Employee> sortedEmpl = this.convertToSeparateList(employeesByDepartment);
		sortedEmpl.sort(new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return -e1.getSalary().compareTo(e2.getSalary());
//				if (e1.getSalary() > e2.getSalary()) {
//					return -1;
//				}
//				else if(e1.getSalary() < e2.getSalary()){
//					return 1;
//				}
//				return 0;
			}
		});
//		this.showAllEmployees();
		for (Employee employee : sortedEmpl) {
			System.out.println(employee);
		}
//		System.out.println(sortedEmpl);
	}
	
	/**
	 * Sorts by names alphabetically 
	 */
	public void sortEmployeesByName(){
		System.out.println("Sort by name in alphabetical order");
//		this.employees.sort(new Comparator<Employee>() {
		List<Employee> sortedEmpl = this.convertToSeparateList(employeesByDepartment);
		sortedEmpl.sort(new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareToIgnoreCase(e2.getName());
			}
		});
//		this.showAllEmployees();
		for (Employee employee : sortedEmpl) {
			System.out.println(employee);
		}
//		System.out.println(sortedEmpl);
	}
	
	/**
	 * Sorts by age from oldest to youngest 
	 */
	public void sortEmployeesByAgeDesc(){
		System.out.println("Sort by age from oldest(\u2193)");
//		this.employees.sort(new Comparator<Employee>() {
		List<Employee> sortedEmpl = this.convertToSeparateList(employeesByDepartment);
		sortedEmpl.sort(new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				if (e1.getAge() > e2.getAge()) {
					return -1;
				}
				else if(e1.getAge() < e2.getAge()){
					return 1;
				}
				return 0;
			}
		});
		
//		this.showAllEmployees();
		for (Employee employee : sortedEmpl) {
			System.out.println(employee);
		}
//		System.out.println(sortedEmpl);
	}
	
	public void removeDuplicatesFromList(){
		List<Employee> allEmployees = this.convertToSeparateList(this.employeesByDepartment);
		Set<Employee> uniqueEmployeeList = new HashSet<Employee>();
		
		uniqueEmployeeList.addAll(allEmployees);
		System.out.println(uniqueEmployeeList);
	}
	
	public void removeDuplicateEmployee(){
		for (Map.Entry<String, ArrayList<Employee>> entry : employeesByDepartment.entrySet()) {
			Set<Employee> uniqueEmployeeList = new HashSet<Employee>();
			uniqueEmployeeList.addAll(entry.getValue());
			entry.getValue().clear();
			entry.getValue().addAll(uniqueEmployeeList);
		}
	}
	
	/**
	 * sets the salary for employees in exact department
	 * @param String
	 */
	public void setSalaryForDepartment(String department, double newSalary){
		if (employeesByDepartment.containsKey(department)) {
			for (Employee employee : employeesByDepartment.get(department)) {
				employee.setSalary(newSalary);
			}
			
			
//			for (Map.Entry<String, ArrayList<Employee>> entry : employeesByDepartment.entrySet()) {
//				for
//			}
		}
	}
	
}
