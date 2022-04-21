package employeedetails;

import java.util.InputMismatchException;

/*
 * This class is mainly to update salary.
 * This class only allows the admin to update salary.
 */
class SalaryUpdation extends Operation {
	 SalaryUpdation() {
		try {
			System.out.println("Enter your Id:");
			int adminId = intScanner.nextInt();
			ValueChanger adminObject = employeeMap.get(adminId);
			if(isAvailable(adminObject)) {
				if(adminObject.checkAdmin()) {
					try {
						System.out.println("Enter Password: ");
						String password = strScanner.next();
						if(adminObject.checkPassword(password)) {
						System.out.println("Enter the Id to change: ");
						int employeeId = intScanner.nextInt();
						if(employeeId != adminId) {
						System.out.println("Enter salary to update");
						double salary =intScanner.nextDouble();	
						ValueChanger changeObject = employeeMap.get(employeeId);
						changeObject.change(salary);
						}
						else {
							System.out.println("The admin don't have access to change his Salary");
						}
						}
					} catch (InputMismatchException input_mismatch) {
						System.out.println("Please enter a Salary value in double");
					}
				}
				else {

					System.out.println("Employees are not allowed to change Salary!");
				}
			}
		} catch (InputMismatchException inputMismatch) {
			System.out.println("Input mismatched please try again!");
		}
	}
}


