class Car{
	int carid = 101;
	String carname = "BMW";
	void printDetails() {
		System.out.println("car id: "+carid);
		System.out.println("car name: "+carname);
	}
}
class Objects{
	public static void main(String[] args) {
		Car c  = new Car();
		c.printDetails();
	}
}