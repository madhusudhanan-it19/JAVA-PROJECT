class Address{
	String street = "vaigai street";
	String city = "vadipatti";
	String district = "Madurai";
}
class Emp{
	int id = 101;
	String name = "Madhu";
	int salary = 10000;
	Address ad = new Address();
	
	void printDetails() {
		System.out.println(id+" "+name+" "+ salary);
		System.out.println("Address: "+ad.street+","+ad.city+","+ad.district);
	}
}
class Aggregation{
	public static void main(String[] args) {
		Emp e = new Emp();
		e.printDetails();
	}
}