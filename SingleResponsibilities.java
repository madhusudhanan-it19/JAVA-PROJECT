package SolidProperties;
class Student{
	int rollno;
	String name;
	String dept;
	Student (int rollno, String name, String dept){
		this.rollno = rollno;
		this.name = name;
		this.dept = dept;
	}
}
class AddStudent{
	Student s;
	AddStudent(int rollno, String name,String dept){
		s = new Student(rollno,name,dept);
	}
}
class PrintStudent {
	Student student;
	PrintStudent(Student s){
		this.student = s;
	}
	void print() {
		System.out.println("Name: "+student.name+" Roll No: "+student.rollno+" Department: "+student.dept);
	}
}
class SingleResponsibilities{
	public static void main(String[] args) {
		AddStudent as1 = new AddStudent(101, "Madhu", "IT");
		AddStudent as2 = new AddStudent(102, "Sanjay", "IT");
		AddStudent as3 = new AddStudent(103, "Kavin", "CS");
		AddStudent as4 = new AddStudent(104, "Hamsha", "CS");
		PrintStudent ps1 = new PrintStudent(as1.s);
		PrintStudent ps2 = new PrintStudent(as2.s);
		PrintStudent ps3 = new PrintStudent(as3.s);
		PrintStudent ps4 = new PrintStudent(as4.s);
		ps1.print(); ps2.print(); ps3.print();
		ps4.print();
	}
}