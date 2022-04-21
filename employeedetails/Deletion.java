package employeedetails;
import java.util.InputMismatchException;

/*
 * This class is mainly to delete the employee details.
 * Here also exception is handled to avoid mismatch exception.
 * This class follows the the Single Responsibility Principle.
 */

class Deletion extends Operation {
	Deletion() {
		try {
			System.out.println("Enter Employee Id: ");
			int employeeId = intScanner.nextInt();
			Employee employeeObject = employeeMap.get(employeeId);
			if(isAvailable(employeeObject)) {
				employeeMap.remove(employeeId);
				System.out.println("Deleted Successfully!");
			}
		} 
		catch (InputMismatchException inputMismatch) {
			System.out.println("Input mismatch Please try again!");
		}
	}
}


