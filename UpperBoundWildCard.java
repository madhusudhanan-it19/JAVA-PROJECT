package Generics;
import java.util.*;
class UpperBoundWildCard{
	static void sum(List<? extends Number> numbers) {
		double sum = 0.0;
		for(Number number:numbers) {
			sum = sum + number.doubleValue();
		}
		System.out.println("sum: "+sum);
	}
	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<>();
		integers.add(10);
		integers.add(20);
		integers.add(30);
		List<Double> doubles = new ArrayList<>();
		doubles.add(10.0);
		doubles.add(20.0);
		doubles.add(30.0);
		sum(doubles);
		sum(integers);
	}
}