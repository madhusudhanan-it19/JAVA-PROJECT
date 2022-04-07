package Inheritance;

class Employee3{
	public int salary = 40000;
}
class Hr2 extends Employee3{
	int bonus = 40000;
	int totalsalary = bonus + salary;
}
class Manager extends Employee3{
	int bonus = 20000;
	int totalsalary = bonus + salary;
}
class Hierarchical{
	public static void main(String[] args) {
		Hr2 h = new Hr2();
		System.out.println(h.totalsalary);
		Manager m = new Manager();
		System.out.println(m.totalsalary);
		
	}
}