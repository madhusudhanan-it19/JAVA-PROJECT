package SolidPrinciples;

import java.util.InputMismatchException;

class AddDept extends Operation{
	public AddDept() {
		try {
			System.out.println("Enter Department Id: ");
			int dept_id = scInt.nextInt();
			System.out.println("Enter Department Name: ");
			String dept_name = scStr.nextLine();
			dept.put(dept_id, dept_name);
			System.out.println("Added successfully!");
		} catch (InputMismatchException imee) {
			System.out.println("Input mismatch Please try again!");
	}
}
}