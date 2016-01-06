package officeWork;

import officeWorkEngine.Employee;
import officeWorkEngine.Task;

public class WorkStatistic {

	public static void main(String[] args) {
		Task changeLightbulb = new Task("Change light bulb", 11); 
		System.out.println(changeLightbulb.getName());
		System.out.println(changeLightbulb.getWorkHours());

		Employee electrician = new Employee("Pesho Toka");
		electrician.setCurrentTask(changeLightbulb);
		electrician.setHoursLeft(8);
//		electrician.name = "";
//		electrician.setName("some");
		electrician.work();
		
		electrician.showReport();
		
	}
}
