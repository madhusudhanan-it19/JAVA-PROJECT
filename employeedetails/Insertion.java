package employeedetails;

import java.util.InputMismatchException;

/*
 * This class is mainly to achieve insertion operation.
 * Here also exception is handled to avoid mismatch exception.
 * Here this class follows the the Single Responsibility Principle.
 */

class Insertion extends Operation {
	Insertion() {
		try {
			System.out.println("Enter name:");
			String name = strScanner.nextLine();
			System.out.println("Enter Department Id "
					+ "[201(Employee), 202(Admin)]:");
			int departmentId = intScanner.nextInt();
			String departmentName = departmentMap.get(departmentId).departmentName;
			if(isAvailable(departmentName)) {
			System.out.println("Enter Phone No:");
			long phNo = intScanner.nextLong();
			System.out.println("Enter Full address:");
			String address = strScanner.nextLine();
			if(departmentId == 201) {
				Employee employeeObject = new Employee(employeeId,name,departmentId,departmentName,phNo,address);
				departmentMap.get(departmentId).AddEmployee(employeeObject);
				employeeMap.put(employeeId,employeeObject);
			}
			else {
				System.out.println("Enter password: ");
				String password = strScanner.next();
				Employee employeeObject = new Admin(employeeId,name,departmentId,departmentName,phNo,address,password);
				departmentMap.get(departmentId).AddEmployee(employeeObject);
				employeeMap.put(employeeId, employeeObject);
			}
			System.out.println("Your id : "+employeeId);
			System.out.println("Inserted Successfully!");
			employeeId++;
			}
			
		} catch (InputMismatchException inputMismatch) {
			System.out.println("Input mismatch Please try again!");
	}
}
}