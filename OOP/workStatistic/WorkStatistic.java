package workStatistic;

public class WorkStatistic {

	public static void main(String[] args) {
		Task changeLightbulb = new Task("Change a lightbulb", -3); 
		System.out.println(changeLightbulb.getName());
		changeLightbulb.setWorkHours(9);
		System.out.println(changeLightbulb.getWorkHours());

		Employee electrician = new Employee("Pesho Toka");
		electrician.setTask(changeLightbulb);
		electrician.setHoursLeft(5);

		electrician.work();
		
		electrician.showReport();
		
	}
}
