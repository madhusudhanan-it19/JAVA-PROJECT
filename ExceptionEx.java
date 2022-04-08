package ExceptionHandling;
class ExceptionEx{
	public static void main(String[] args) {
		try {
			int a = 10/0;
			String s = null;
			s.length();
			int arr[]= new int [5];
			arr[10] = 5;
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("A integer cannot be divided by 0...");
		}
		System.out.println("Program ends...");
	}
}