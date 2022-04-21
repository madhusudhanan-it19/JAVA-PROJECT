package employeedetails;
import java.util.Map;
/*
 * This class is mainly to view all details.
 * here this class follows the the Single Responsibility Principle.
 */
class ViewAll extends Operation {
	ViewAll() {
		System.out.println("Worker Details: ");
		boolean isEmpty = true;
		for (Map.Entry<Integer, Employee> employee : employeeMap.entrySet()) {
			 new View(employee.getKey());
			 System.out.println("");
			 isEmpty = false;
		}
		if(isEmpty) {
			System.out.println("No employee Found!");
			System.out.println("");
		}
		System.out.println("Department Details: ");
		new View(departmentMap);
		System.out.println("");
		
		
	}
}