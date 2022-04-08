package ExceptionHandling;

class TryCatch2{
	public static void main(String[] args) {
		try {
			int n = 10/0;
			String s = null;
			s.length();
			int [] a = new int [2];
			a[3] = 10;
			}
		/*catch (Exception e) {
			System.out.println("Parent exception");
		}*/ // Compilation error due to mis order of parent exception
		catch(NullPointerException np){
			System.out.println(np);
		}
		catch(ArithmeticException ae){
			System.out.println(ae);
		}
		catch(ArrayIndexOutOfBoundsException aio){
			System.out.println(aio);
		}
		
	}
}