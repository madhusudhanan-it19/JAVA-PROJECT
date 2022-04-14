package employeedetails;
/*
 This class holds the Department details.
 It is used only to achieve aggregation.
 It is simply act as a data type.
 */
public class Department {
	int dept_id;
	String dept_name;
	public Department(int id, String name) {
		this.dept_id = id;
		this.dept_name = name;
	}
}
