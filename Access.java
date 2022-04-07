class Parent{
	private void disp() {
		System.out.println("Private method");
	}
	public void print() {
		System.out.println("Public method");
		disp();
	}
	protected void show() {
		System.out.println("Protected method");
	}
	
}
class Child extends Parent{
	Child(){
		System.out.println("Child: ");	
	}
}
class Empty{
	Parent p = new Parent();
	void print() {
		System.out.println("Empty: ");
		p.print();
		p.show();
		//p.disp(); because it is private
	}
}
class Access{
	public static void main(String[] args) {
		Empty e = new Empty();
		e.print();
		Child c = new Child();
		c.print();
		c.show();
		//c.disp(); because it is private;
	}
}