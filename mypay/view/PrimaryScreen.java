package view;

//This is the primary screen where the user can choose the action.
public class PrimaryScreen {
		public PrimaryScreen() {
			boolean flagloop = true;
			do {
				System.out.println("*****************************************************************");
				System.out.println("Enter your choice of option!");
				System.out.println("1. Add account");
				System.out.println("2. Pay user");
				System.out.println("3. Check Balance");
				System.out.println("4. Show Transaction");
				System.out.println("5. Send Request");
				System.out.println("6. View Request");
				System.out.println("7. Recharge");
				System.out.println("8. Change passwords/pin/Account");
				System.out.println("9. Sign Out");
				int choice  = Validation.getInteger();
				switch(choice) {
					case 1:
						new AccountProcess().addAccount();
						break;
					case 2:
						new Payment().PayUser();
						break;
					case 3:
						new AccountProcess().checkBalance();
						break;
					case 4:
						new TransactionProcess().showTransaction();
						break;
					case 5:
						new RequestProcess().sendRequest();
						break;
					case 6:
						new RequestProcess().viewRequest();
						break;
					case 7: 
						new Recharge();
						break;
					case 8:
						new Modification();
						break;
					case 9:
						new Authentication().signOut();
						flagloop = false;
						break;
					default:
						System.out.println("Choose the correct option!");
				
				}
			}
			while(flagloop);
		}
}
