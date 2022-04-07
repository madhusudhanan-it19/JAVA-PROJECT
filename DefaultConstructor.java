class Car1{
	int id;
	String name;
	
	void printDetails() {
		System.out.println("car id: "+ id);
		System.out.println("car name: "+ name);
	}
}
class DefaultConstructor{
	public static void main(String[] args) {
		Car1 c = new Car1();
		c.printDetails();
		
	}
}