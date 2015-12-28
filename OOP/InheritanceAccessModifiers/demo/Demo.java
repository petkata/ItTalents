package demo;

import encapsulation.Employee;
import encapsulation.Person;
import encapsulation.Student;

public class Demo {

	public static void main(String[] args) {
		Person[] people = new Person[10];
		
		Person ivan = new Person("ivan petkov ivanov", 19, true);
		Person ina = new Person("ina", 1, false);
		Student maleStudent = new Student("gancho", 9, true, 9);
		Student femaleStudent = new Student("anna-maria jecheva", 9, false, 6);
		Employee maleWorker = new Employee("gosho", 0, true, -9999);
		Employee femaleWorker = new Employee("diqna", 36, false, 90);
		
		people[0] = ivan;
		people[1] = ina;
		people[2] = maleStudent;
		people[3] = femaleStudent;
		people[4] = maleWorker;
		people[5] = femaleWorker;
		
		System.out.println("-----------");
		
		showInfoForPeople(people);
		
		System.out.println("-----------");
		
		showTwoHourOvertimeIncome(people);
	}
	
	static void showTwoHourOvertimeIncome(Person[] group){
		for (int i = 0; i < group.length; i++) {
			if (group[i] == null) {
				break;
			}
			if (group[i] instanceof Employee) {
				Employee emp = (Employee) group[i];
				emp.showCalculatedOvertime(2);
			}
			else {
				continue;
			}
		}
	}
	
	static void showInfoForPeople(Person[] group){
		for (int i = 0; i < group.length; i++) {
			if (group[i] == null) {
				break;
			}
			if (group[i] instanceof Employee) {
				Employee emp = (Employee) group[i];
				emp.showEmployeeInfo();
			}
			else if (group[i] instanceof Student) {
				Student student = (Student) group[i];
				student.showStudentInfo();
			}
			else {
				group[i].showPersonInfo();
			}
		}
	}
}
