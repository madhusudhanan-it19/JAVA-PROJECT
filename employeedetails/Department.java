package employeedetails;
/*
 This class holds the Department details.
 It is used only to achieve aggregation.
 It is simply act as a data type.
 */
public class Department {
	int dept_id;
	String dept_name;
	Employee employee;
	public Department(int id, String name, Employee e) {
		this.dept_id = id;
		this.dept_name = name;
		this.employee = e;
	}
}
