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


public class Operation{
	static Map<Integer,Employee> map= new HashMap<>();
	static int emp_id = 101;
	Scanner scInt = new Scanner(System.in);
	Scanner scStr = new Scanner(System.in);
	static Map<Integer,String> dept = new LinkedHashMap<>(){{
		put(201, "Employee"); 
		put(202, "Admin");
	}};
	static List<Department> departments_obj = new ArrayList<>();
	boolean check(String name) {
		if(name == null) {
			System.out.println("Department Id Not found!");
			return false;
		}
		return true;
	}
	boolean check(Employee e) {
		if(e == null) {
			System.out.println("Employee Id Not found!\n"+
								"You can add Employee!");
			return false;
		}
		return true;
	}
	
}


