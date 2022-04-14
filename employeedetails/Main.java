package employeedetails;
import java.util.*;

/*
 This is main class of the project.
 The project start executing here.
 Object creation of all classes are done in this class.
 */



class Main{
	
/* Here the input is get from this function to avoid 
   continuous looping while using try catch in switch
*/
	static int getChoice() {
		Scanner scInt = new Scanner(System.in);
		int n = 0;

// Here Mismatch exception is handled by try catch
		
		try {
		n = scInt.nextInt();
		}
		catch (InputMismatchException ime) {
			System.out.println("Input mismatch "
					+ "Please try again!");
		}
		return n;
	}
	public static void main(String[] args){
		
// flag is for continuous looping until user stops.
		boolean flag = true;
		Scanner scInt = new Scanner(System.in);
		System.out.println("Welcome to Employee Details"
				+ " Management Project!(EP)");
		
		while(flag) {
			System.out.println("*****************************"
								+ "******************");
			System.out.println("Enter your choice of actions");
			System.out.println("1.Insert Details");
			System.out.println("2.View Details");
			System.out.println("3.Update Details");
			System.out.println("4.Delete Details");
			System.out.println("5.View All Details");
			System.out.println("6.Update salary");
			System.out.println("7.View Department employees");
			System.out.println("8.Exit");
			int choice = getChoice();
/* the object creation of specific class to achieve 
 	specific functions employee. 
*/
			switch(choice) {
			case 1:
				 new Insert();
				 break;
			case 2:
				System.out.println("Enter Employee Id: ");
				int id = scInt.nextInt();
				new View(id);
				break; 
			case 3:
				 new Update();
				 break;
			case 4:
				 new Delete();
				 break;
			case 5:
				 new ViewAll();
				 break;
			case 6:
				 new UpdateSalary();
				 break;
			case 7:
				new ViewDepartment();
				break;
			case 8:
				System.out.println("Thank You\n"
						+ "See you again!");
				flag = false;
				 break;
			default:
				System.out.println("Choose the correct option!");
				break;
			}
		}
	
	}
}