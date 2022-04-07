import java.util.*;
class While{
	static void display(int [] array, int arrlen) {
		int i = 0;
		while(i<arrlen) {
			System.out.println(array[i]);
			i++;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrlen = sc.nextInt();
		int [] array = new int [arrlen];
		int i =0;
		while(i<arrlen) {
			array[i] = sc.nextInt();
			i++;
		}
		display(array,arrlen);
	}
}