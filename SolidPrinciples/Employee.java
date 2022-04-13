package SolidPrinciples;

public class Employee{
		String emp_name;
		int emp_id ;
		Department department;
		Project project;
		String address;
		long  PhNo;
		Employee(int emp_id,String name,int dept_id,String dept_name,long ph,String address, int pro_id,String pro_name ){
			this.project = new Project(pro_id,pro_name);
			this.emp_name = name;
			this.department = new Department(dept_id,dept_name);
			this.address = address;
			this.PhNo = ph;
			this.emp_id = emp_id;
			
		}
		void change(String val, int choice) {
			if(choice == 2)
			this.emp_name = val;
			if(choice == 4)
			this.address = val;
		}
		void change(int choice, int id, String name){
			
			this.project.proId = id;
			this.project.proName = name;
		
	}
		void change(int dept_id,String dept_name) {
			this.department.dept_id = dept_id;
			this.department.dept_name = dept_name;
		}
		void change(long ph) {
			this.PhNo = ph;
		}
}
