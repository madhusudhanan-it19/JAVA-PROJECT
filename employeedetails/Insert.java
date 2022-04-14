package employeedetails;

import java.util.InputMismatchException;

/*
 * This class is mainly to achieve insertion operation.
 * Here also exception is handled to avoid mismatch exception.
 * Here this class follows the the Single Responsibility Principle.
 */

class Insert extends Operation {
	Insert() {
		try {
			System.out.println("Enter name:");
			String name = scStr.nextLine();
			System.out.println("Enter Department Id "
					+ "[201(Employee), 202(Admin)]:");
			int dept_id = scInt.nextInt();
			String dept_name = dept.get(dept_id);
			if(check(dept_name)) {
			System.out.println("Enter Phone No:");
			long ph = scInt.nextLong();
			System.out.println("Enter Full address:");
			String address = scStr.nextLine();
				if(dept_id == 201) {
					Employee e = new Employee(emp_id,name,dept_id,
							dept_name,ph,address);
					Department d = new Department(dept_id,dept_name,e);
					departments_obj.add(d);
					map.put(emp_id,e);
				}
				else {
					Employee e = new Admin(emp_id,name,dept_id,
							dept_name,ph,address);
					Department d = new Department(dept_id,dept_name,e);
					departments_obj.add(d);
					map.put(emp_id, e);
				}
			System.out.println("Your id : "+emp_id);
			System.out.println("Inserted Successfully!");
			emp_id++;
			}
			
		} catch (InputMismatchException imee) {
			System.out.println("Input mismatch Please try again!");
	}
}
}