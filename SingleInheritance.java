package Inheritance;

class Employee1{
	int salary = 40000;
}
class Hr extends Employee1{
	int bonus = 40000;
	int totalsalry = bonus + salary;
}
class SingleInheritance{
	public static void main(String[] args) {
		Hr h = new Hr();
		System.out.println(h.totalsalry);
	}
}