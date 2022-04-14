package employeedetails;

import java.util.InputMismatchException;

/*
 * This class is mainly to update salary.
 * This class only allows the admin to update salary.
 */
class UpdateSalary extends Operation{
	 UpdateSalary() {
		System.out.println("Enter your Id:");
		int id = scInt.nextInt();
		Employee admin =  map.get(id);
		if(check(admin)) {
			if(admin.checkAdmin(admin)){
				try {
					System.out.println("Enter the Id to change: ");
					int id1 = scInt.nextInt();
					if(id1 != id) {
					System.out.println("Enter salary to update");
					double sal =scInt.nextDouble();
					Employee employee = map.get(id1);
					employee.change(sal);
					}
					else {
						System.out.println("The admin don't have access"
								+ " to change his Salary");
					}
				} catch (InputMismatchException e1) {
					System.out.println("Please enter a Salary "
							+ "value in double");
				}
			}
			else {

				System.out.println("Employees are not allowed to"
						+ " change Salary!");
			}
		}
	}
}


