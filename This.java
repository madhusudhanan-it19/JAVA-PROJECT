class Car3{
	int id;
	String name;
	Car3(int id,String name){
		this.id = id;
		this.name = name;
	}
	void printDetails() {
		System.out.println("car id: "+ id);
		System.out.println("car name: "+ name);
	}
}
class This{
	public static void main(String[] args) {
		Car2 c = new Car2(101,"BMW");
		c.printDetails();
		Car2 c1 = new Car2(102,"Ford");
		c1.printDetails();
		
	}
}