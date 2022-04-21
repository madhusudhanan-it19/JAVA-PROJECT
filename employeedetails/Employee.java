package employeedetails;

/*
This class holds the Employment details..
It is simply act as a data type.
This class also contains the method overloading 
and aggregation concepts.
Here the interface contains contains only one function to achieve
Interface segregation principles.
*/


public class Employee implements ValueChanger {
		String employeeName;
		int employeeId;
		String address;
		long  PhNo;
		int departmentId;
		String departmentName;
		protected double salary;
		Employee(int employeeId,String employeeName,int departmentId,String departmentName,long PhNo,String address) {
			this.employeeName = employeeName;
			this.departmentId = departmentId;
			this.departmentName = departmentName;
			this.address = address;
			this.PhNo = PhNo;
			this.employeeId = employeeId;
			this.salary = 25000.00;
			
		}
		//Method Overloading
		/*
		 * here change() method used to change or update the 
		 values of the data members
		*/	
		
		// This change() method is to change employee name or address
		public void change(String value, int choice) {
			if(choice == 2)
			this.employeeName = value;
			if(choice == 4)
			this.address = value;
		}
		
		// This change() method is used to change Phone number
		public void change(long phNo) {
			this.PhNo = phNo;
		}
		// This change() method is used to change salary
		public void change(double salary) {
			this.salary = salary;
		}
		public boolean checkAdmin() {
			return false;
		}

		public  boolean checkPassword(String password) {
			System.out.println("Employee doesn't have password");
			return false;
		}

		public  void setPassword(String newPass) {
			System.out.println("Employee doesn't have password");
			return;
		}

		public  String getPassword() {
			System.out.println("Employee doesn't have password");
			return null;
		}
}
