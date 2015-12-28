package encapsulation;

public class Student extends Person {

	
	private static final double DEFAULT_STUDENT_SCORE = 2;
	private static final int DEFAULT_STUDENT_AGE = 6;
	
	private double score;
	
	public Student(String newName, int newAge, boolean isMale, double score) {
		super(newName, newAge, isMale);
		this.setScore(score);;
	}

	@Override
	protected void setAge(int age) {
		if (age < 6) {
			System.out.println("Age for student must be 6 or more! A default age of 6 will be set!");
			super.setAge(DEFAULT_STUDENT_AGE);
		}
		else {
			super.setAge(age);
		}
	}
	
	private void setScore(double newScore){
		if (newScore < 2 || newScore > 6) {
			System.out.println("Score should be between 2 and 6. A default score of 2 will be set!");
			this.score = DEFAULT_STUDENT_SCORE;
		}
		else {
			this.score = newScore;
		}
	}
	
	public void showStudentInfo(){
		super.showPersonInfo();
		System.out.println("Score: " + this.score);
	}
}
