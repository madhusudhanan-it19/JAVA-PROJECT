package Set;
import java.util.*;

class LinkedHS{
	public static void main(String[] args) {
		LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
		lhs.add(5);
		lhs.add(4);
		lhs.add(1);
		lhs.add(3);
		lhs.add(2);
		HashSet<Integer> hs = new HashSet<>();
		hs.add(5);
		hs.add(4);
		hs.add(1);
		hs.add(3);
		hs.add(2);
		System.out.println("HashSet: "+hs);
		System.out.println("LinkedHashSet: "+lhs);
	}
}