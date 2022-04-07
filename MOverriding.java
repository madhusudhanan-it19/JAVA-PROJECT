class Parent{
	void sum(int i, int j) {
		System.out.println("Parent : " +  (i+j));
	}
}
class Child extends Parent{
	void sum(int i, int j) {
		System.out.println("Child: " +  (i+j));
	}
}
class MOverriding{
	public static void main(String[] args) {
		Child c = new Child();
		c.sum(1, 1);
		Parent p = new Parent();
		p.sum(1, 2);
		Parent pc = new Child();
		pc.sum(1, 3);
	}
	
}