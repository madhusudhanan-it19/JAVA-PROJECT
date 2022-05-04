package view;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to MyPay!");
		boolean flagloop = true;
		do {
			System.out.println("*****************************************************************");
			System.out.println("Enter your choice of option!");
			System.out.println("1. Sign Up");
			System.out.println("2. Sign In");
			System.out.println("3. Exit");
			int choice  = Validation.getInteger();
			switch(choice) {
				case 1: 
					new Authentication().signUp();
					break;
				case 2:
					new Authentication().signIn();
					break;
				case 3: 
					new Authentication().closeConnection();
					System.out.println("Thank you!");
					flagloop = false;
					break;
				default:
					System.out.println("Choose the correct option!");
			}
		}
		while(flagloop);
	}

}
