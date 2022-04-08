package ExceptionHandling;

class Finally1{
	public static void main(String[] args) {
		try {
			System.out.println("try Block");
			int a = 10/0;
		}
		catch(ArithmeticException ae) {
			System.out.println("catch Block");
		}
		finally {
			System.out.println("finally Block");
		}
		System.out.println("End of the code...");
	}
}