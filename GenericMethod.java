package Generics;
	
class GenericMethod{
	static <T> void printArray(T [] array) {
		for(T element: array) {
			System.out.println(element);
		}
	}
	public static void main(String[] args) {
		Integer [] integer = {1,2,3,4,5};
		Character [] character = {'a','b','c','d','e'};
		printArray(integer);
		printArray(character);
	}
}