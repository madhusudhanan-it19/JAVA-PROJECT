package Generics;

class MyClass <T> {
	T object;
	 MyClass(T obj) {
		this.object = obj;
	}
	 T getData() {
		 return object;
	 }
}
class GenericClass{
	public static void main(String[] args) {
		MyClass <Integer> mc = new MyClass(2);
		
		System.out.println(mc.getData());
	}
}