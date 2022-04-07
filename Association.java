import java.util.*;
class Student{
	int rollno;
	String name;
	String dept;
	Student(int rollno, String name, String dept){
		this.rollno = rollno;
		this.name = name;
		this.dept = dept;
	}
	void printData() {
		System.out.println(rollno+" "+name+" "+dept);
	}
}
class Department{
	String dept;
	ArrayList<Student> student ;
	Department(String dept, ArrayList<Student> student){
		this.dept = dept;
		this.student = student;
	}
	void printData() {
		System.out.println("Department page: " + dept);
		for(Student s : student) {
			System.out.println(s.rollno + " "+s.name);
		}
	}
}
class College{
	String name;
	ArrayList<Department> dept;
	ArrayList<Student> student;
	College(String name, ArrayList<Department> dept, ArrayList<Student> student){
		this.name = name;
		this.dept = dept;
		this.student= student;
		
	}
	public void printCount(){
		System.out.println("College page");
		System.out.println("Student count: "+student.size());
		System.out.println("Department count: "+dept.size());
	}
}
class Association{
	public static void main(String[] args) {
		Student s1 = new Student(101,"Madhu","IT");
		Student s2 = new Student(102,"Sanjay","IT");
		Student s3 = new Student(103,"Kavin","CS");
		Student s4 = new Student(104,"Hamsha","CS");
		Student s5 = new Student(105,"Nanda","IT");
		ArrayList<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		ArrayList<Student> itStudent = new ArrayList<>();
		itStudent.add(s1); itStudent.add(s2); itStudent.add(s5);
		ArrayList<Student> csStudent = new ArrayList<>();
		csStudent.add(s3); csStudent.add(s4);
		System.out.println("Student Page:");
		for(Student s: students) {
			s.printData();
		}
		Department d1 = new Department("It", itStudent);
		Department d2 = new Department("Cs", csStudent);
		ArrayList<Department> dept = new ArrayList<>();
		dept.add(d1);
		dept.add(d2);
		d1.printData();
		d2.printData();
		College college = new College("BIT", dept, students);
		college.printCount();
		
	}
}