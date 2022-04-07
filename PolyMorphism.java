class Maths{
	int square(int i) {
		return i*i;
	}
	 double square(double i) {
		return i*i;
	}
}
class PolyMorphism{
	public static void main(String[] args) {
		Maths m = new Maths();
		System.out.println(m.square(2));
		System.out.println(m.square(2.0));
	}
}