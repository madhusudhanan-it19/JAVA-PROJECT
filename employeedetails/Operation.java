package employeedetails;

import java.util.*;
import java.util.Map;
import java.util.Scanner;
/*
	* This class act as a parent class for all other subclasses
	  like Insert,Delete...
	* Here hashmap is used as a storage for employee id(key) 
	 and employee object(Value).
	* Here also method overloading is used to check whether the
	  given details exit or not.
	* Here the check() method is used to check whether the user 
		provided id are exists or not.
 */


public class Operation {
	static Map<Integer,Employee> employeeMap= new HashMap<>();
	static int employeeId = 101;
	Scanner intScanner = new Scanner(System.in);
	Scanner strScanner = new Scanner(System.in);
	static Map<Integer,Department> departmentMap = new LinkedHashMap<> () { {
		put(201, new Department(201,"Employee")); 
		put(202, new Department(202,"Admin"));
	} };
	//List<Department> dept_list = new ArrayList();
	boolean isAvailable( String departmentName) {
		if(departmentName == null) {
			System.out.println("Department Id Not found!");
			return false;
		}
		return true;
	}
	boolean isAvailable(Employee employeeObject) {
		if(employeeObject == null) {
			System.out.println("Employee Id Not found!\nYou can add Employee!");
			return false;
		}
		return true;
	}
	boolean isAvailable(ValueChanger employeeObject) {
		if(employeeObject == null) {
			System.out.println("Employee Id Not found!\nYou can add Employee!");
			return false;
		}
		return true;
	}
	boolean isAvailable(Department departmentObject) {
		if(departmentObject == null) {
			System.out.println("Department Id not found!");
			return false;
		}
		return true;
	}
}


