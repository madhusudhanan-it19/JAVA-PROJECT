package Generics;

import java.util.*;

class UnBoundedWildCard{
	static void Print(List<?> number) {
		for(Object o: number) {
			System.out.println(o);
		}
	}
	public static void main(String[] args) {
		List<Integer> integer = Arrays.asList(1,2,3,4,5);
		List<String> string = Arrays.asList("mad","san","kav");
		Print(string); 
		Print(integer);
	}
}