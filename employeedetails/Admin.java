package employeedetails;
/*
 * This class extends the Employee class to take all 
 functionalities of  Employee class.
 * This class implements the CheckAccess interface to implement
 CheckAdmin() method.
 */
class Admin extends Employee implements CheckAccess{
	
	Admin(int emp_id, String name, int dept_id, String dept_name,
			long ph, String address) {
		super(emp_id, name, dept_id, dept_name, ph, address);
		super.salary += 50000.00;
	}
	public boolean checkAdmin(Employee e) {
		return true;
	}
}