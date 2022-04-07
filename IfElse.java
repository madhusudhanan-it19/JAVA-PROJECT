import java.util.*;
class IfElse{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n == 0)
			System.out.println("It is not even and odd number");
		else if(n%2 == 0)
			System.out.println("It is even number");
		else 
			System.out.println("It is odd number");
	}
}