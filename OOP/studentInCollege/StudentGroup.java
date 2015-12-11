package studentInCollege;

public class StudentGroup {
	
	String groupSubject;
	Student[] students;
	short freePlaces;
	
	boolean isGroupEmpty;
	
	StudentGroup(){
		this.students = new Student[5];
		this.freePlaces = 5;
	}
	
	StudentGroup(String subject){
		this();
		this.groupSubject = subject;
	}
	
	void addStudent(Student student){
		if (student.subject != null && student.subject.equalsIgnoreCase(this.groupSubject) && this.freePlaces > 0) {
			this.students[this.students.length-this.freePlaces] = student;
			this.freePlaces--;
			System.out.println(student.name + " has been added to the group "
					+ this.groupSubject);
		this.isGroupEmpty = false;
		}
		else if(this.freePlaces < 0){
			System.out.println("No free spaces in this group!");
		}
		else if(student.subject == null && this.groupSubject == null){
			this.students[this.students.length-this.freePlaces] = student;
			this.freePlaces--;
			this.isGroupEmpty = false;
			System.out.println("Student added!");
		}
		else {
			System.out.println(student.name + " is not applicable for this group!");
		} 
	}
	
	void emptyGroup(){
		this.students = new Student[5];
		this.freePlaces = 5;
		System.out.println("The group " +this.groupSubject + " has been emptied!");
		this.isGroupEmpty = true;
	}
	
	String theBestStudent(){
		byte bestStudentIndex = 0;
		for (byte i = 0; i < students.length; i++) {
			if (this.students[i] == null) {
				continue;
			}
			if (this.students[bestStudentIndex].grade < this.students[i].grade) {
				bestStudentIndex = i;
			}
		}
		return this.students[bestStudentIndex].name;
	}
	
	void printStudentsInGroup(){
		if (this.groupSubject == null) {
			this.groupSubject = "Unregistered students group";
		}
		System.out.println();
		/*
		 * Here with paddings I am creating a table 
		 */
		String paddingGroupName = String.format("%-"+(this.groupSubject.length() + 20)+"s", "").replace(' ', '_');
		System.out.println(paddingGroupName);
		
		System.out.print("List of students in " + this.groupSubject + "|");
		
		if (isGroupEmpty) {
			System.out.println("\n"+paddingGroupName + "|");
			System.out.println("The group is empty|");
			String padbottom = String.format("%-18s|\n","").replace(' ', '_');
			System.out.printf(padbottom);
			return;
		}
		/*
		 * Here with paddings I am creating a table 
		 */
		String paddingName = String.format("\n%-"+this.longestStudentName()+"s", "").replace(' ', '_');
		String padding = String.format("| %-7s| %-7s| %-7s| %-7s| %-19s|", "", "", "", "", "").replace(' ', '_');
		StringBuilder upperBorder =new StringBuilder(paddingName+padding.replace('|',	' '));
		System.out.println((upperBorder).deleteCharAt(paddingGroupName.length()+1).insert(paddingGroupName.length()+1, '|'));
		System.out.printf("%-"+this.longestStudentName()+"s| %-7s| %-7s| %-7s| %-7s| Total scholarships |","Name","Grade","Year","Age","Degree");
		System.out.println(paddingName+padding);
		
		for (int i = 0; i < this.students.length; i++) {
			if (this.students[i] == null) {
				continue;
			}
			if (this.students[i].name == null) {
				this.students[i].name = "N/a ";
				this.students[i].age = 0;
			}
			System.out.printf("%-"+this.longestStudentName()+"s",this.students[i].name);
			System.out.printf("|  %-6s" , this.students[i].grade);
			System.out.printf("| %6s " , this.students[i].yearInCollege);
			System.out.printf("| %6s " , this.students[i].age);
			System.out.printf("| %6s " , ((this.students[i].isDegree)? "Yes": "No"));
			System.out.printf("| %19s|" , this.students[i].money);
			if (i < this.countNumberOfStudentsInGroup()-1) {
				System.out.println();
			}
		}
		System.out.print(paddingName+padding + "\n");
	}
	
	int countNumberOfStudentsInGroup(){
		int count = 0;
		for (int i = 0; i < students.length; i++) {
			if (this.students[i] == null) {
				continue;
			}
			count++;
		}
		return count;
	}
	
	int longestStudentName(){
		
		int maxNameLengthIndex = 0;
		
//		maxStudentNameLength is 4 in case all the names are less than 
//		the length of the title of the first column("Name") in the table
		int maxStudentNameLength = 4;
		
		for (int i = 0; i < this.students.length; i++) {
			if (this.students[i] == null) {
				continue;
			}
			if (this.students[i].name == null) {
				continue;
			}
			if (this.students[maxNameLengthIndex].name.length() <= this.students[i].name.length()) {
				maxNameLengthIndex = i;
				if (maxStudentNameLength <= this.students[maxNameLengthIndex].name.length()) {
					maxStudentNameLength = this.students[maxNameLengthIndex].name.length();
				}
			}
		}
		return maxStudentNameLength;
	}
}






