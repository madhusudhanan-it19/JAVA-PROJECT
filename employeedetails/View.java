package employeedetails;

import java.util.Map;

/*
 * This class is mainly to achieve view operation.
 * here this class follows the the Single Responsibility Principle.
 */

class View extends Operation {
	//Employee details
	View(int employeeId) {
		Employee employeeObject = employeeMap.get(employeeId);
		if(isAvailable(employeeObject)) {
		System.out.println("Id: "+ employeeId +"\nName: "+ employeeObject.employeeName+
				"\nDepartment Id: "+employeeObject.departmentId+
				"\nDepartment Name: "+employeeObject.departmentName+
				"\nPhone No: "+employeeObject.PhNo+
				"\nAddress:"+employeeObject.address+
				"\nSalary: "+employeeObject.salary+"\n"
				);
		}
	}
	
	// to view departments 
	View (Map<Integer, Department> passmap){
		for (Map.Entry<Integer, Department> pass : passmap.entrySet()) {
			System.out.println("Id: "+pass.getKey()+" Name: "+pass.getValue().departmentName);
		}
	}
}
