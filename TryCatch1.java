package ExceptionHandling;

class TryCatch1{
	public static void main(String[] args) {
		try {
			int n = 10/0;
			String s = null;
			s.length();
			int [] a = new int [2];
			a[3] = 10;
			}
		catch(NullPointerException np){
			System.out.println(np);
		}
		catch(ArithmeticException ae){
			System.out.println(ae);
		}
		catch(ArrayIndexOutOfBoundsException aio){
			System.out.println(aio);
		}
		catch (Exception e) {
			System.out.println("Parent exception");
		}
	}
}