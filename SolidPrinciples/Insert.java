package SolidPrinciples;

import java.util.InputMismatchException;

class Insert extends Operation {
	Insert() {
		try {
			System.out.println("Enter name:");
			String name = scStr.nextLine();
			System.out.println("Enter Department Id:");
			int dept_id = scInt.nextInt();
			String dept_name = dept.get(dept_id);
			if(check(dept_name)) {
			System.out.println("Enter Phone No:");
			long ph = scInt.nextLong();
			System.out.println("Enter Full address:");
			String address = scStr.nextLine();
			System.out.println("Enter Project Id:");
			int pro_id = scInt.nextInt();
			String pro_name = pro.get(pro_id);
			
			if(check(pro_name, pro_id)) {
			Employee e = new Employee(emp_id,name,dept_id,dept_name,ph,address,pro_id,pro_name);
			map.put(emp_id,e);
			System.out.println("Your id : "+emp_id);
			System.out.println("Inserted Successfully!");
			emp_id++;
			}
			}
		} catch (InputMismatchException imee) {
			System.out.println("Input mismatch Please try again!");
	}
}
}