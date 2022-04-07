import java.util.*;
class Continue{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrlen = sc.nextInt();
		int [] array = new int [arrlen];
		for(int i =0;i<arrlen;i++) {
			array[i] = sc.nextInt();
			}
		for(int i = 0;i<arrlen;i++) {
			if(array[i]%2 == 0) continue;
			System.out.println(array[i]);
		}
		
	}
}