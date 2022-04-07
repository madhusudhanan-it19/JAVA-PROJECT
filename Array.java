import java.util.*;
class Array{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrlen = sc.nextInt();
		int [] array = new int [arrlen];
		for(int i =0;i<arrlen;i++)
			array[i] = sc.nextInt();
		int element = sc.nextInt();
		int pos = -1;
		for(int i = 0;i<arrlen;i++) {
			if(array[i]==element) {
				pos = i;
				break;
			}
		}
		if(pos!=-1) {
			for(int i = pos;i<arrlen-1;i++) {
				array[i] = array[i+1];
			}
			arrlen--;
		}
		
		for(int i = 0;i<arrlen;i++)
			System.out.println(array[i]);
	}
}