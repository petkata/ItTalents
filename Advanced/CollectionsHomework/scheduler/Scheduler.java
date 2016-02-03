package scheduler;

import java.util.LinkedList;
import java.util.Queue;

public class Scheduler {

	private Queue<ITask> tasks;
	
	public Scheduler() {
		this.tasks = new LinkedList<>();
	}

	void push(ITask newTask){
		this.tasks.offer(newTask);
	}
	
	void start(){
		if (this.tasks.peek() != null) {
			while (!this.tasks.isEmpty()) {
				this.tasks.poll().doWork();
			}
			System.out.println("All tasks are done");
			return;
		}
		System.out.println("There are no tasks yet");
	}
	
	
	public static void main(String[] args) {
		
		Scheduler sch = new Scheduler();
		
		ITask task1 = new ITask() {
			
			@Override
			public void doWork() {
				System.out.println("Work1");
			}
		};
		ITask task4 = new ITask() {
			
			@Override
			public void doWork() {
				System.out.println("Work4");
			}
		};
		ITask task2 = new ITask() {
			
			@Override
			public void doWork() {
				System.out.println("Work2");
			}
		};
		ITask task3 = new ITask() {
			
			@Override
			public void doWork() {
				System.out.println("Work3");
			}
		};
		
		sch.push(task1);
		sch.push(task3);
		sch.push(task4);
		sch.push(task2);
		
		sch.start();
	}
}


