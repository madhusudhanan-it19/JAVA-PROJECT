package SolidPrinciples;

import java.util.Map;

class View extends Operation{
	View(int id){
		Employee e = map.get(id);
		if(check(e)) {
		System.out.println("Id: "+ id +"\nName: "+ e.emp_name
				+ "\nDepartment Id: "+e.department.dept_id+
				"\nDepartment Name: "+e.department.dept_name+
				"\nPhone No: "+e.PhNo+
				"\nAddress:"+e.address
				+ "\nProject ID: "+e.project.proId+
				"\nProject Name: "+e.project.proName
				);
		}
	}
	View (Map<Integer, String> passmap){
		for (Map.Entry<Integer, String> pass : passmap.entrySet()) {
			System.out.println("Id: "+pass.getKey()+" Name: "+pass.getValue());
		}
	}
}
