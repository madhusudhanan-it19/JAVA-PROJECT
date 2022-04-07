import java.util.*;
class Switch{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name:");
		String name = sc.next();
		System.out.println("Enter a level:");
		boolean flag = true;
		while(flag) {
			int n  = sc.nextInt();
		switch(n) {
		case 1: 
			System.out.println("Hi "+name+" you are manager");
			flag = false;
			break;
		case 2: 
			System.out.println("Hi "+name+" you are HR");
			flag = false;
			break;
		case 3:
			System.out.println("Hi "+name+" you are intern");
			flag = false;
			break;
		default:
			System.out.println("Please enter level between 1-3: ");
			flag = true;
			break;
		}
		}
	}
}