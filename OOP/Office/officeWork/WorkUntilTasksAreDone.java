package officeWork;

import officeWorkEngine.*;

public class WorkUntilTasksAreDone {

	public static void main(String[] args) {
		
		AllWork allWorkToBeDone = new AllWork();
		
		allWorkToBeDone.addTask("Cook lunch", 2);
		allWorkToBeDone.addTask("Wash dishes", 1);
		allWorkToBeDone.addTask("Write homework", 10);
		allWorkToBeDone.addTask("Do shopping", 5);
		allWorkToBeDone.addTask("Play games", 15);
		allWorkToBeDone.addTask("Draw painting", 3);
		allWorkToBeDone.addTask("Think of task names", 4);
		allWorkToBeDone.addTask("Eat", 1);
		allWorkToBeDone.addTask("Reinstal Android", 8);
		allWorkToBeDone.addTask("Reinstal winXp", 25);
		
		Employee geri = new Employee("Geri");
		Employee pesho = new Employee("Pesho");
		Employee andy = new Employee("Andy");
		
		Employee[] employees = {geri, pesho, andy};
		
		geri.setAllWork(allWorkToBeDone);
		int day =1;
		while (true) {
			System.out.println("day " + day);
			System.out.println();
			assignTasksToEmployees(employees);
			startDay(employees);
			geri.work();
			pesho.work();
			andy.work();
			System.out.println("-----------");
			if (allWorkToBeDone.isAllWorkDone()) {
				System.out.println("All tasks have been completed at day " + day);
				break;
			}
			day++;
		}
	}

	private static void assignTasksToEmployees(Employee[] employees){
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getCurrentTask() == null ) {
				employees[i].setCurrentTask(Employee.getAllWork().getNextTask());
			}
		}
	}
	
	private static void startDay(Employee[] employees){
		for (int i = 0; i < employees.length; i++) {
			employees[i].startWorkingDay();
		}
	}
}
