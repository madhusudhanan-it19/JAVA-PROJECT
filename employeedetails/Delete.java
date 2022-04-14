package employeedetails;
import java.util.InputMismatchException;

/*
 * This class is mainly to delete the employee details.
 * Here also exception is handled to avoid mismatch exception.
 * This class follows the the Single Responsibility Principle.
 */

class Delete extends Operation{
	Delete() {
		try {
			System.out.println("Enter Employee Id: ");
			int id = scInt.nextInt();
			Employee e = map.get(id);
			if(check(e)) {
			map.remove(id);
			System.out.println("Deleted Successfully!");
			}
		} catch (InputMismatchException imee) {
			System.out.println("Input mismatch Please try again!");
	}
}
}


