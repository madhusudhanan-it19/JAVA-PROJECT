package employeedetails;

import java.util.InputMismatchException;
import java.util.Map;

class ViewDepartment extends Operation{
	ViewDepartment(){
		try {
			System.out.println("Enter Department Id: ");
			int id = scInt.nextInt();
			String name = dept.get(id);
			boolean flag = true;
			if(check(name)) {
				System.out.println(name + " workers: ");
			for(Department depart: departments_obj) {
				if(depart.dept_id == id) {
					new View(depart.employee.emp_id);
					flag = false;
				}
			}
			if(flag) {
				System.out.println("No employees found in "
						+ "this department");
			}
			}
		} catch (InputMismatchException ime) {
			System.out.println("Input Mismatched."
					+ " Please provide correct input!");
		}
	}
}