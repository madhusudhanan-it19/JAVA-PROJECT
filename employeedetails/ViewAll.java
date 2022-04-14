package employeedetails;
import java.util.Map;
/*
 * This class is mainly to view all details.
 * here this class follows the the Single Responsibility Principle.
 */
class ViewAll extends Operation{
	ViewAll(){
		System.out.println("Worker Details: ");
		boolean flag = true;
		for (Map.Entry<Integer, Employee> e : map.entrySet()) {
			 new View(e.getKey());
			 System.out.println("");
			 flag = false;
		}
		if(flag) {
			System.out.println("No employee Found!");
			System.out.println("");
		}
		System.out.println("Department Details: ");
		new View(dept);
		System.out.println("");
		
		
	}
}