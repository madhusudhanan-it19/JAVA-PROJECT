class Employee{
	int emp_id;
	String emp_name;
	static String office = "Zoho";
	Employee(int id, String name){
		emp_id = id;
		emp_name = name;
	}
	void printDetails() {
		System.out.println(emp_id+" "+emp_name+" "+office);
	}
}
class Static{
	public static void main(String[] args) {
		Employee e = new Employee(101,"Madhu");
		Employee e1 = new Employee(102,"Mani");
		e.printDetails();
		e1.printDetails();
	}
}