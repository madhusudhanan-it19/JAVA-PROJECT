import java.util.*;
class Break{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrlen = sc.nextInt();
		int [] array = new int [arrlen];
		for(int i =0;i<arrlen;i++)
			array[i] = sc.nextInt();
		for(int i =0;i<arrlen;i++) {
			if((i>0)&&(array[i]-array[i-1] > 1)) break;
			System.out.println(array[i]);
		}
	}
}