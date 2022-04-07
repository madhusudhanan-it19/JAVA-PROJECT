abstract class Emp1{
	abstract void position();
}
class Hr1 extends Emp1{
	void position() {
		System.out.println("This is HR");
	}
}
class Manager1 extends Emp1{
	void position() {
		System.out.println("This is Manager");
	}
}
class Abstract{
	public static void main(String[] args) {
		Emp1 e1 = new Hr1();
		e1.position();
		Emp1 e2 = new Manager1();
		e2.position();
	}
}