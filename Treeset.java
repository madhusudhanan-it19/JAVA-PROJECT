package Set;
import java.util.*;
class Treeset{
	public static void main(String[] args) {
		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(1);
		ts.add(2);
		ts.add(5);
		ts.add(3);
		ts.add(4);
		System.out.println(ts);
		System.out.println("Smallest Number: "+ts.pollFirst());
		System.out.println("Largest Number: "+ts.pollLast());
		System.out.println(ts);
		ts.add(5);
		ts.add(1);
		System.out.println(ts);
		Iterator<Integer> itr = ts.descendingIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("Head set: "+ts.headSet(4, true));
		System.out.println("Subset: "+ts.subSet(2, true, 4, true));
		System.out.println("Tailset: "+ts.tailSet(3, false));
	}
}