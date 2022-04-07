import java.util.*;
class DoWhile{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		do {
			System.out.println("Hi");
			n--;
		}
		while(n>1);
	}
}