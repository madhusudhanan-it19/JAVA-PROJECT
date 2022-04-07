package List;
import java.util.*;

class AL{
	static void display(ArrayList<String> al) {
		System.out.println("Display name: ");
		for(String name : al) {
			System.out.println(name);
		}
	}
	static void display(List<Integer> al) {
		System.out.println("Display number: ");
		for(int  number : al) {
			System.out.println(number);
		}
	}
	static void removeMethod(List<Integer> num, ArrayList<String> al) {
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter a element position to remove in numbers: ");
		int n  = sc.nextInt();
		Integer val = n;
		num.remove(val);
		display(num);
		System.out.println("Enter a string to remove in names: ");
		String s = sc.next();
		al.remove(s);
		display(al);
	}
	public static void main(String[] args) {
		ArrayList<String> arraylist = new ArrayList<>();
		List<Integer> numbers = new ArrayList<>();
		arraylist.add("madhu");
		arraylist.add("sanjay");
		arraylist.add("kavin");
		arraylist.add("gopi");
		numbers.add(5);
		numbers.add(3);
		numbers.add(4);
		numbers.add(1);
		numbers.add(2);
		display(numbers);
		Collections.sort(numbers);
		display(numbers);
		display(arraylist);
		Collections.sort(arraylist);
		display(arraylist);
		System.out.println("Size of names: "+arraylist.size());
		System.out.println("Size of number: "+numbers.size());
		removeMethod(numbers, arraylist);
	}
}
