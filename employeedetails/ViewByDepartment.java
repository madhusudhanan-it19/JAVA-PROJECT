package employeedetails;

import java.util.InputMismatchException;
import java.util.List;

/*
 * This class is used to view a employees in department wise
 */

class ViewByDepartment extends Operation{
	public ViewByDepartment() {
		try {
			System.out.println("Enter department Id: ");
			int departmentId = intScanner.nextInt();
			Department departmentObject = departmentMap.get(departmentId);
			if(isAvailable(departmentObject)) {
				List<Employee> employeeList = departmentObject.employeeList;
				System.out.println(departmentObject.departmentName + " Members:");
				boolean isEmpty = true;
				for(Employee employee : employeeList) {
					System.out.println(employee.employeeName);
					isEmpty = false;
				}
				if(isEmpty) {
					System.out.println("No members found in this department!");
				}
				
			}
		} catch (InputMismatchException inputMismatch) {
			System.out.println("Input mismatched please try again!");
		}
	}
}