package SolidPrinciples;
import java.util.*;
import java.util.Map;
import java.util.Scanner;

public class Operation{
	static Map<Integer,Employee> map= new HashMap<>();
	static int emp_id = 101;
	Scanner scInt = new Scanner(System.in);
	Scanner scStr = new Scanner(System.in);
	static Map<Integer,String> dept = new LinkedHashMap<>(){{
		put(201, "IT"); put(202, "CS");
	}};
	static Map<Integer,String> pro = new LinkedHashMap<>(){{
		put(1001, "Console Application"); put(1002, "Web Application");
	}};
	boolean check(String name) {
		if(name == null) {
			System.out.println("Department Id Not found!\nYou can add Department!");
			return false;
		}
		return true;
	}
	boolean check(String name, int id) {
		if(name == null) {
			System.out.println("Project Id Not found!\nYou can add Project!");
			return false;
		}
		return true;
	}
	boolean check(Employee e) {
		if(e == null) {
			System.out.println("Employee Id Not found!\nYou can add Employee!");
			return false;
		}
		return true;
	}
	
}


