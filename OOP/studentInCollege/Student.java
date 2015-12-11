package studentInCollege;

public class Student {

	String name;
	String subject;
	double grade;
	byte yearInCollege;
	int age;
	boolean isDegree;
	double money;
	
	Student(){
		this.grade = 4;
		this.yearInCollege = 1;
		this.isDegree = false;
		this.money = 0;
	}
	
	Student(String name, String subject,int age){
		this();
		this.name = name;
		this.subject = subject;
		this.age = age;
	}
	
	void upYear(){
		if (!isDegree) {
			this.yearInCollege++;
			System.out.println(this.name +" passed to year " + this.yearInCollege + ".");
		} 
		else {
			System.out.println(this.name +" can't go to an upper year because he has already graduated!");
			return;
		}
		if (this.yearInCollege == 4) {
			this.isDegree = true;
			System.out.println(this.name + " successufly graduated!");
		}
	}
	
	double receiveScholarship(double min, double amount){
		if (this.grade >= min && this.age <= 30) {
			this.money += amount;
			System.out.println(this.name + " receives a scholarship of " + amount);
		}
		else if (this.grade < min) {
			System.out.printf(this.name + "'s grade(%.2f) is less than the minimum grade(%.2f) for a scholarship! \n",this.grade,min);
		}
		else {
			System.out.printf(this.name + "(%d) is older than the maximum age(%d) for a scholarship! \n",this.age,30);
		}	
		
		return this.money;
	}
}
