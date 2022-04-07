package List;
import java.util.*;
class ListToArray{
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		Integer [] array = list.toArray(new Integer[list.size()]);
		System.out.println(Arrays.toString(array));
		System.out.println(list);
		List <Integer> list1 = Arrays.asList(array);
		System.out.println(list1);
		
	}
}