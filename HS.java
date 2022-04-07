package Set;

import java.util.*;
class HS{
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(1);
		hs.add(2);
		hs.add(3);
		hs.add(4);
		hs.add(5);
		hs.add(1);
		hs.remove(2);
		System.out.println(hs);
		Iterator <Integer> itr = hs.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}
}