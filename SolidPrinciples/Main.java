package SolidPrinciples;
import java.util.*;

class Main{
	static int getChoice() {
		Scanner scInt = new Scanner(System.in);
		int n = 0;
		try {
		n = scInt.nextInt();
		}
		catch (InputMismatchException ime) {
			System.out.println("Input mismatch Please try again!");
		}
		return n;
	}
	public static void main(String[] args){
		
		boolean flag = true;
		Scanner scInt = new Scanner(System.in);
		System.out.println("Welcome to Employee Details Management Project!(SP)");
		
		while(flag) {
			System.out.println("***********************************************");
			System.out.println("Enter your choice of actions");
			System.out.println("1.Insert Details");
			System.out.println("2.View Details");
			System.out.println("3.Update Details");
			System.out.println("4.Delete Details");
			System.out.println("5.View All Details");
			System.out.println("6.Search");
			System.out.println("7.Add or update Department");
			System.out.println("8.Add or update Project");
			System.out.println("9.Exit");
			int choice = getChoice();
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
				 new Search();
				 break;
			case 7:
				 new AddDept();
				 break;
			case 8:
				new AddPro();
				 break;
			case 9:
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