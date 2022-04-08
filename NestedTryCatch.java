package ExceptionHandling;
class NestedTryCatch{
	public static void main(String[] args) {
		try {
			try {
				try {
					int a = 10/0;
				}catch (ArithmeticException ae) {
					System.out.println("Dividing 0 cause exception..");
				}
				int a[] = new int [10];
				a[10] = 20;
				
			}
			catch (ArrayIndexOutOfBoundsException aioe) {
				System.out.println("Array index error cause exception..");
			}
			String s = null;
			s.length();
		}
		catch(NullPointerException npe) {
			System.out.println("Null pointer exception error");
		}
	}
}