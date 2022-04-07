package Inheritance;

class Employee2{
	public int salary = 40000;
}
class Hr1 extends Employee2{
	int bonus = 40000;
	//int totalsalry = bonus + salary;
}
class SeniorHr extends Hr1{
	int totalsalary = bonus + salary + 40000;
}
class MLInheritance{
	public static void main(String[] args) {
		SeniorHr h = new SeniorHr();
		System.out.println(h.totalsalary);
	}
}