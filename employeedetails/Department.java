package employeedetails;

import java.util.*;
/*
 * This class holds the list of employee details in that department
 */
public class Department {
		int departmentId;
		String departmentName;
		List <Employee> employeeList;
		Department(int id, String name) {
			this.departmentId = id;
			this.departmentName = name;
			this.employeeList = new ArrayList<>();
		}
		void AddEmployee(Employee employeeObject) {
			this.employeeList.add(employeeObject);
		}
}
