class A{
	private int salary = 2000;
	public int getSalary() {
		return salary;
	}
}
class Encapsulation{
	public static void main(String[] args) {
		A a = new A();
		//System.out.println(a.salary);
		System.out.println(a.getSalary());
		
	}
}