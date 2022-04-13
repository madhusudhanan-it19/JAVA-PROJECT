package SolidPrinciples;
import java.util.InputMismatchException;
import java.util.Map;

class Search extends Operation{
	Search() {
		try {
			System.out.println("Choose the parameter to search:");
			System.out.println("1. By Department id");
			System.out.println("2. By Project id");
			int choice = scInt.nextInt();
			if(choice == 1) {
				System.out.println("Enter Department id");
				int dep_id = scInt.nextInt(); 
				String dept_name = dept.get(dep_id);
				if(check(dept_name)) {
				for (Map.Entry<Integer, Employee> e : map.entrySet()) {
					Employee employee = e.getValue();
					if(employee.department.dept_id == dep_id)
						new View(employee.emp_id);
				}
				}
			}
			if(choice == 2) {
				System.out.println("Enter Project id");
				int pro_id = scInt.nextInt(); 
				String pro_name = pro.get(pro_id);
				if(check(pro_name, pro_id)) {
				for (Map.Entry<Integer, Employee> e : map.entrySet()) {
					Employee employee = e.getValue();
					if(employee.project.proId == pro_id)
						new View(employee.emp_id);
				}
				}
			}
		} catch (InputMismatchException imee) {
			System.out.println("Input mismatch Please try again!");
	}
}
}