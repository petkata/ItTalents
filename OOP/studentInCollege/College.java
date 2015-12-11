package studentInCollege;

public class College {

	public static void main(String[] args) {
		Student pesho = new Student("Pesho", "Mechanics", 22);
		Student unknownStudent = new Student();
		Student ivan = new Student("Ivan", "Mechanics", 22);
		Student gosho = new Student("Gosho", "Art", 17);
		Student mina = new Student("Mina", "Art", 17);
		Student blago = new Student("Blagoslav", "Art", 17);
		Student vasko = new Student("Vasko", "Art", 17);
		Student lazo = new Student("Lazar", "Art", 17);
		Student dancho = new Student("Dancho", "Art", 20);
		Student ivo = new Student("Ivailo", "History", 30);
		Student andrei = new Student("Andrei", "Geodesy", 31);
		
		gosho.grade = 6;
		mina.grade = 5.49;
		
		gosho.receiveScholarship(5.5, 250);
		mina.receiveScholarship(5.5, 250);
		andrei.receiveScholarship(2, 250);
		gosho.upYear();
		gosho.receiveScholarship(5.5, 500);
		
		System.out.println();
		
		StudentGroup mechanics = new StudentGroup("Mechanics");
		mechanics.addStudent(pesho);
		mechanics.addStudent(ivan);
		mechanics.addStudent(dancho);
		
		System.out.println();
		
		StudentGroup art = new StudentGroup("Art");
		art.addStudent(gosho);
		art.addStudent(mina);
		art.addStudent(blago);
		art.addStudent(vasko);
		art.addStudent(lazo);
		art.addStudent(dancho);

		System.out.println();
		
		StudentGroup history = new StudentGroup("History");
		history.addStudent(ivo);
		history.emptyGroup();

		System.out.println();
		
		System.out.println("The student with the highest grade in group " + art.groupSubject + " is " + art.theBestStudent());

		mechanics.printStudentsInGroup();

		System.out.println();
		
		art.printStudentsInGroup();

		System.out.println();
		
		history.printStudentsInGroup();

		System.out.println();

		StudentGroup unknownGroup = new StudentGroup();
		unknownGroup.addStudent(unknownStudent);
		unknownGroup.printStudentsInGroup();

		System.out.println();
		
		vasko.upYear();
		vasko.upYear();
		vasko.upYear();
		vasko.upYear();
		
	}

}
