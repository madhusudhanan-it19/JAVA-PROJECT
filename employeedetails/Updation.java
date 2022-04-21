package employeedetails;

import java.util.InputMismatchException;

/*
 * This class is used only to update the employee details.
 * Exception is handled in this class to avoid the wrong input 
 from the user.
 */
class Updation extends Operation {
	Updation() {
	try {
		System.out.println("What do you want to update:");
		System.out.println("1.All Details");
		System.out.println("2.Only Name");
		System.out.println("3.Only Address");
		System.out.println("4.Only PhNo");
		int choice = intScanner.nextInt();
		if(choice>0 && choice<5) {
			System.out.println("Enter Employee Id: ");
			int employeeId = intScanner.nextInt();
			ValueChanger employeeObject = employeeMap.get(employeeId);
			if(isAvailable(employeeObject)) {
				if(choice ==1 || choice == 2) {
					System.out.println("Enter name:");
					String name = strScanner.nextLine();
					employeeObject.change(name,2);
					}
				if(choice ==1 || choice == 3) {
					System.out.println("Enter Full address:");
					String address = strScanner.nextLine();
					employeeObject.change(address,4);
					}
				if(choice ==1 || choice == 4) {
					System.out.println("Enter Phone No:");
					long phNo = intScanner.nextLong();
					employeeObject.change(phNo);
					}
				System.out.println("Updated Successfully!");
			}
		}
		else {
			System.out.println("Choose the correct input!");
		}
	} 
	catch (InputMismatchException inputMismatch) {
			System.out.println("Input mismatch Please try again!");
	}
}
}