package Generics;

import java.util.Arrays;
import java.util.List;

class LowerBoundedWildCard{
	static void print(List<? super Integer> list) {
		for(Object l : list ) {
			System.out.println(l);
		}
	}
	public static void main(String[] args) {
		List<Integer> integer = Arrays.asList(1,2,3,4);
		print(integer);
		List<Number> number = Arrays.asList(1.0,2.0,3.0,4.0);
		print(number);
		List<Double> doub = Arrays.asList(1.0,2.0,3.0,4.0);
		//print(doub); compilation error-lowerbound not applicable for double
	}
}