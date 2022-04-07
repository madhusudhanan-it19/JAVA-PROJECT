class Car2{
	int id;
	String name;
	Car2(int carid,String carname){
		id = carid;
		name = carname;
	}
	void printDetails() {
		System.out.println("car id: "+ id);
		System.out.println("car name: "+ name);
	}
}
class ParameteriezedConstructor{
	public static void main(String[] args) {
		Car2 c = new Car2(101,"BMW");
		c.printDetails();
		
	}
}