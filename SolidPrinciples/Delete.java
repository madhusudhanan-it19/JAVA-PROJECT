package SolidPrinciples;
import java.util.InputMismatchException;

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


