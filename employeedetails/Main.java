package employeedetails;
import java.util.*;

/*
 This is main class of the project.
 The project start executing here.
 Object creation of all classes are done in this class.
 */



class Main {
	
/* Here the input is get from this function to avoid 
   continuous looping while using try catch in switch
*/
	static int getInput() {
		Scanner intScanner = new Scanner(System.in);
		int input = 0;

// Here Mismatch exception is handled by try catch
		
		try {
		input = intScanner.nextInt();
		}
		catch (InputMismatchException input_mismatch) {
			System.out.println("Input mismatch Please try again!");
		}
		return input;
	}
	
	public static void main(String[] args) {
		
// flag is for continuous looping until user stops.
		boolean flagForLoop = true;
		System.out.println("Welcome to Employee Details Management Project!(EP)");
		
		while(flagForLoop) {
			System.out.println("***********************************************");
			System.out.println("Enter your choice of actions");
			System.out.println("1.Insert Details");
			System.out.println("2.View Details");
			System.out.println("3.Update Details");
			System.out.println("4.Delete Details");
			System.out.println("5.View All Details");
			System.out.println("6.View Department member Details");
			System.out.println("7.Update salary");
			System.out.println("8.Change admin password");
			System.out.println("9.Exit");
			int choice = getInput();
/* the object creation of specific class to achieve 
 	specific functions employee. 
*/
			switch(choice) {
			case 1:
				new Insertion();
				break;
			case 2:
				System.out.println("Enter Employee Id: ");
				int employeeId = getInput();
				new View(employeeId);
				break; 
			case 3:
				 new Updation();
				 break;
			case 4:
				 new Deletion();
				 break;
			case 5:
				 new ViewAll();
				 break;
			case 6:
				new ViewByDepartment();
				break;
			case 7:
				 new SalaryUpdation();
				 break;
			case 8:
				new PasswordChanger();
				break;
			case 9:
				System.out.println("Thank You \nSee you again!");
				flagForLoop = false;
				break;
			default:
				System.out.println("Choose the correct option!");
				break;
			}
		}
	
	}
}