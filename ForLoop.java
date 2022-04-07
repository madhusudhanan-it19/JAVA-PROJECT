import java.util.*;
class ForLoop{
	static void display(int [] array) {
		for(int i =0;i<array.length;i++)
			System.out.println(array[i]);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrlen = sc.nextInt();
		int [] array = new int [arrlen];
		for(int i = 0;i<arrlen;i++) {
			array[i] = sc.nextInt();
		}
		display(array);
	}
}