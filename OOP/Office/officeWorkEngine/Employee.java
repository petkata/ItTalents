package officeWorkEngine;

public class Employee {
	
	private static final int DEFAULT_WORK_DAY_LENGTH = 8;
	
	private final String name;
	private Task currentTask;
	private int hoursLeft;
	private static AllWork allWork;
	
	public Employee(String newName) {
		this.name = newName;
		this.hoursLeft = DEFAULT_WORK_DAY_LENGTH;
	}
		
	public String getName(){
		return this.name;
	}
	
	public Task getCurrentTask(){
		return this.currentTask;
	}
	
	public void setCurrentTask(Task newTask){
		this.currentTask = newTask;
		System.out.println(this.name + " started task: " + this.currentTask.getName() );
	}
	
	public int getHoursLeft(){
		return this.hoursLeft;
	}
	
	public void setHoursLeft(int hours){
		if (hours < 0) {
			System.out.println("Hours must be non negative !");
		}
		else {
			this.hoursLeft = hours;
		}
	}
	
	public static AllWork getAllWork(){
		return Employee.allWork;
	}
	
	public void setAllWork(AllWork allWork){
		Employee.allWork = allWork;
	}
	
	public void startWorkingDay(){
		this.setHoursLeft(DEFAULT_WORK_DAY_LENGTH);
	}
	
	public void work(){
		if (this.currentTask.getWorkHours() == 0) {
			if (Employee.allWork.getNumberOfTasksLeft() == 0) {
				return;
			}
			this.setCurrentTask(Employee.allWork.getNextTask());
		}
		if (this.currentTask.getWorkHours() <= this.hoursLeft) {
			this.setHoursLeft(this.hoursLeft - this.currentTask.getWorkHours());
			this.currentTask.setWorkHours(0);
			System.out.println(this.name + " finished task: " + this.currentTask.getName());
			if (Employee.allWork.isAllWorkDone() || Employee.allWork.getNumberOfTasksLeft() == 0) {
				return;
			}
			this.setCurrentTask(Employee.allWork.getNextTask());
			this.work();
		}
		else {
			this.currentTask.setWorkHours(this.currentTask.getWorkHours() - this.hoursLeft);
			this.setHoursLeft(0);
		}
	}
	
	
	public void showReport(){
		System.out.println("Name of employee: "+this.name);
		System.out.println("Current task: "+ this.currentTask.getName());
		System.out.println("Hours left for employee: " + this.getHoursLeft());
		System.out.println("Task complete after: " + this.currentTask.getWorkHours());
	}
}
