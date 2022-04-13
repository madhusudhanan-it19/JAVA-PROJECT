package SolidPrinciples;

import java.util.InputMismatchException;

class Update extends Operation{
	Update(){
	try {
		System.out.println("What do you want to update:");
		System.out.println("1.All Details");
		System.out.println("2.Only Name");
		System.out.println("3.Only Department");
		System.out.println("4.Only Address");
		System.out.println("5.Only PhNo");
		System.out.println("6.Only Project Details");
		int choice = scInt.nextInt();
		System.out.println("Enter Employee Id: ");
		int id = scInt.nextInt();
		Employee e = map.get(id);
		if(check(e)) {
		if(choice ==1 || choice == 2) {
			System.out.println("Enter name:");
			String name = scStr.nextLine();
			e.change(name,2);
			System.out.println("Updated Successfully!");
		}
		if(choice ==1 || choice == 3) {
			System.out.println("Enter Department Id:");
			int dept_id = scInt.nextInt();
			String dept_name = dept.get(dept_id);
			if(check(dept_name)) {
				e.change(dept_id, dept_name);
				System.out.println("Updated Successfully!");
			}
		}
		if(choice ==1 || choice == 4) {
			System.out.println("Enter Full address:");
			String address = scStr.nextLine();
			e.change(address,4);
			System.out.println("Updated Successfully!");
		}
		if(choice ==1 || choice == 5) {
			System.out.println("Enter Phone No:");
			long ph = scInt.nextLong();
			e.change(ph);
			System.out.println("Updated Successfully!");
		}
		if(choice ==1 || choice == 6) {
			System.out.println("Enter Project Id:");
			int pro_id = scInt.nextInt();
			String pro_name = pro.get(pro_id);
			if(check(pro_name,pro_id)) {
				e.change(choice,pro_id,pro_name);
				System.out.println("Updated Successfully!");
			}
				
		}
		
		}
	} catch (InputMismatchException imee) {
			System.out.println("Input mismatch Please try again!");
}
}
}