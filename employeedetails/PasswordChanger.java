package employeedetails;

import java.util.InputMismatchException;
/*
 * This class main aim is to change the password of the admin.
 * it inherits the operation class to get all the properties 
  from it.
 */
class PasswordChanger extends Operation {
	public PasswordChanger() {
		try {
			System.out.println("Enter Id: ");
			int adminId = intScanner.nextInt();
			ValueChanger employeeObject = employeeMap.get(adminId);
			if(isAvailable(employeeObject)) {
				if(employeeObject.checkAdmin()) {
					System.out.println("Enter Old password: ");
					String oldPassword = strScanner.next();
					if(employeeObject.checkPassword(oldPassword)) {
						System.out.println("Enter new password: ");
						String newPassword = strScanner.next();
						System.out.println("Old Password: "+ employeeObject.getPassword());
						employeeObject.setPassword(newPassword);
						System.out.println("New Password: "+ employeeObject.getPassword());
						System.out.println("Password changed successfully!");
					}
				}
				else {
					System.out.println("No password for employee!");
				}
			}
		}
		catch (InputMismatchException inputMismatch) {
			System.out.println("Input mismatched!");
		}
	}
}