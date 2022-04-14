package employeedetails;

import java.util.InputMismatchException;

/*
 * This class is used only to update the employee details.
 * Exception is handled in this class to avoid the wrong input 
 from the user.
 */
class Update extends Operation{
	Update(){
	try {
		System.out.println("What do you want to update:");
		System.out.println("1.All Details");
		System.out.println("2.Only Name");
		System.out.println("3.Only Address");
		System.out.println("4.Only PhNo");
		int choice = scInt.nextInt();
		if(choice>0 && choice<5) {
		System.out.println("Enter Employee Id: ");
		int id = scInt.nextInt();
		Employee e = map.get(id);
		if(check(e)) {
		if(choice ==1 || choice == 2) {
			System.out.println("Enter name:");
			String name = scStr.nextLine();
			e.change(name,2);
		}
		if(choice ==1 || choice == 3) {
			System.out.println("Enter Full address:");
			String address = scStr.nextLine();
			e.change(address,4);
		}
		if(choice ==1 || choice == 4) {
			System.out.println("Enter Phone No:");
			long ph = scInt.nextLong();
			e.change(ph);
		}
		System.out.println("Updated Successfully!");
		}
		}
		else {
			System.out.println("Choose the correct input!");
		}
	} catch (InputMismatchException imee) {
			System.out.println("Input mismatch Please try again!");
}
}
}