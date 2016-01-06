package officeWorkEngine;

public class AllWork {
	
	private static final int DEFAULT_FREE_PLACES_FOR_TASKS = 10; 
	
	private Task[] tasks;
	private int freePlacesForTasks;
	private int currentUnassignedTask;
	
	public AllWork() {
		this.freePlacesForTasks = DEFAULT_FREE_PLACES_FOR_TASKS;
		this.currentUnassignedTask = 0;
		this.tasks = new Task[this.freePlacesForTasks];
	}
	
	public void addTask(String name, int workHours){
		tasks[DEFAULT_FREE_PLACES_FOR_TASKS - freePlacesForTasks--] = new Task(name, workHours);
	}
	
	public Task getNextTask(){
		return tasks[currentUnassignedTask++];
	}
	
	int getNumberOfTasksLeft(){
		return this.tasks.length - this.currentUnassignedTask;
	}
	
	public boolean isAllWorkDone(){
		boolean isDone = true;
		for (int i = 0; i < tasks.length; i++) {
			if (tasks[i].getWorkHours() != 0) {
				isDone = false;
				break;
			}
		}
		return isDone;
	}
}
