package employeedetails;

/*
This class holds the Employment details..
It is simply act as a data type.
This class also contains the method overloading 
and aggregation concepts.
Here the interface contains contains only one function to achieve
Interface segregation principles.
*/

interface CheckAccess{
	boolean checkAdmin(Employee e);
}

public class Employee implements CheckAccess{
		String emp_name;
		int emp_id ;
		//aggregation(The employee class has a Department class)  
		Department department;
		String address;
		long  PhNo;
		int dept_id;
		String dept_name;
		protected double salary;
		Employee(int emp_id,String name,int dept_id,
				String dept_name,long ph,String address){
			this.emp_name = name;
			this.dept_id = dept_id;
			this.dept_name = dept_name;
			this.address = address;
			this.PhNo = ph;
			this.emp_id = emp_id;
			this.salary = 25000.00;
			
		}
//Method Overloading
/*
 * here change() method used to change or update the 
 values of the data members
*/	
		
// This change() method is to change employee name or address
		public void change(String val, int choice) {
			if(choice == 2)
			this.emp_name = val;
			if(choice == 4)
			this.address = val;
		}
		
// This change() method is used to change Phone number
		public void change(long ph) {
			this.PhNo = ph;
		}
		public void change(double sal) {
			this.salary = sal;
		}
		public boolean checkAdmin(Employee e) {
			return false;
		}
}
