package employeedetails;
/*
 *This class extends the Employee class to take all 
 functionalities of  Employee class.
 * This class implements the CheckAccess interface to implement
 CheckAdmin() method.
 */
class Admin extends Employee implements ValueChanger {
	private String password;
	Admin(int employeeId, String name, int departmentId, String departmentName,long phNo, String address, String password) {
		super(employeeId, name, departmentId, departmentName, phNo, address);
		super.salary +=  50000;
		this.password = password;
	}
	public boolean checkAdmin() {
		return true;
	}
	public boolean checkPassword(String newPassword) {
		
		 if(password.equals(newPassword)) {
			 return true;
		 }
		 else {
			 System.out.println("Password Incorrect!");
			 return false;
		 }
	}
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
	public String getPassword() {
		return password;
	}
}