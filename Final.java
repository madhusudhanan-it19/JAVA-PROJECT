class P{
	final void print() {
		System.out.println("I am in p");
	}
}
class A extends P{
	final int x;
	static final int y;
	static {
		y = 10;
	}
	A(){
		x = 100;
		System.out.println(x);
		System.out.println(y);
	}
	// void print(){ } cannot override a final method
}
class Final{
	public static void main(String[] args) {
		final int x = 10;
		//x += 1;  compilation error 
		A a = new A();
		a.print();
	}
}