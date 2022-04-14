package employeedetails;

import java.util.Map;

/*
 * This class is mainly to achieve view operation.
 * here this class follows the the Single Responsibility Principle.
 */

class View extends Operation{
	//Employee details
	View(int id){
		Employee e = map.get(id);
		if(check(e)) {
		System.out.println("Id: "+ id +"\nName: "+ e.emp_name+
				"\nDepartment Id: "+e.dept_id+
				"\nDepartment Name: "+e.dept_name+
				"\nPhone No: "+e.PhNo+
				"\nAddress:"+e.address+
				"\nSalary: "+e.salary+"\n"
				);
		}
	}
	
	// to view departments 
	View (Map<Integer, String> passmap){
		for (Map.Entry<Integer, String> pass : passmap.entrySet()) 
	{
			System.out.println("Id: "+pass.getKey()+
								" Name: "+pass.getValue());
		}
	}
}
