class Narrowing{
	double y = 7.0;
	float x = (float)y;
	long m = (long)y;
	int n = (int)y;
	void print() {
		System.out.println("Narrowing: ");
		System.out.println("int: "+n);
		System.out.println("long: "+m);
		System.out.println("float: "+x);
		System.out.println("double: "+y);
	}
}
class Widening{
	int n = 7;
	long m = n;
	float x = m;
	double y = x;
	void print() {
		System.out.println("Widening: ");
		System.out.println("int: "+n);
		System.out.println("long: "+m);
		System.out.println("float: "+x);
		System.out.println("double: "+y);
	}
}
class TypeCasting{
	public static void main(String[] args) {
		Widening w = new Widening();
		w.print();
		Narrowing n = new Narrowing();
		n.print();
		
	}
}