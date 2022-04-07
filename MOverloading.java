class MOverloading{
	static int add(int i, int j) {
		return i+j;
	}
	static float add(float i, float j) {
		return i+j;
	}
	public static void main(String[] args) {
		System.out.println(add(1, 2));
		System.out.println(add(3.0f, 2.5f));
	}
}