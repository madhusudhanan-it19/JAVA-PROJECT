package SolidPrinciples;
import java.util.Map;

class ViewAll extends Operation{
	ViewAll(){
		System.out.println("Employee Details: ");
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
		System.out.println("Project Details: ");
		new View(pro);
		System.out.println("");
	}
}