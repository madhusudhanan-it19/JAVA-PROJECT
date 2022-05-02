package userinterface;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to Upi console apllication(DB)!");
		boolean flagloop = true;
		do {
			System.out.println("*****************************************************************");
			System.out.println("Enter your choice of option!");
			System.out.println("1. Sign Up");
			System.out.println("2. Sign In");
			System.out.println("3. Add account");
			System.out.println("4. Pay user");
			System.out.println("5. Check Balance");
			System.out.println("6. Show Transaction");
			System.out.println("7. Send Request");
			System.out.println("8. View Request");
			System.out.println("9. Recharge");
			System.out.println("10. Sign Out");
			System.out.println("11. Exit");
			int choice  = Validation.getInteger();
			switch(choice) {
			case 1: 
				new Authentication().signUp();
				break;
			case 2:
				new Authentication().signIn();
				break;
			case 3:
				new Account().addAccount();
				break;
			case 4:
				new Payment().PayUser();
				break;
			case 5:
				new Account().checkBalance();
				break;
			case 6:
				new Transaction().showTransaction();
				break;
			case 7:
				new Request().sendRequest();
				break;
			case 8:
				new Request().viewRequest();
				break;
			case 9: 
				new Recharge();
				break;
			case 10:
				new Authentication().signOut();
				break;
			case 11: 
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
