package view;

import controller.UserProcess;

public class Modification extends UserProcess {
	
		public Modification() {
				boolean flagLoop = true;
				do {
					System.out.println("Choose the option: ");
					System.out.println("1. change user password");
					System.out.println("2. change Upi Pin");
					System.out.println("3. change Default Account");
					System.out.println("4. Exit");
					int choice = Validation.getInteger();
					switch(choice) {
						case 1: 
							changePassword();
							break;
						case 2:
							changePin();
							break;
						case 3: 
							changeDefaultAccount();
							break;
						case 4:
							flagLoop = false;
							break;
						default:
							System.out.println("Please provide a correct Input!");
					}
				} while(flagLoop);
		}
		
		//This method is to change password for the user.
		void changePassword() {
			
				System.out.println("Enter old password: ");
				String oldPassword = stringScanner.next();
				if(userObject.checkPassword(oldPassword)) {
					System.out.println("Enter new Password: ");
					String newPassword = stringScanner.next();
					userObject.setPassword(newPassword);
					executorObject.changePassword(userObject);
					System.out.println("Pass changed!");
				}
				else {
					System.out.println("Password Incorrect!");
				}
			
			
		}
		
		//This method is to change Pin for the account.
		void changePin() {
				System.out.println("Enter user password: ");
				String Password = stringScanner.next();
				if(userObject.checkPassword(Password)) {
					System.out.println("Choose the account: ");
					accountObject = chooseAccount();
					System.out.println("Enter new pin!");
					int pin = Validation.getInteger();
					if(Validation.checkValidPin(pin)) {
						accountObject.setPin(pin);
						executorObject.changePin(accountObject);
						System.out.println("Pin changed successfully");
					}
				}
				else {
					System.out.println("Password Incorrect!");
				}
		}
		
		//This method is to change default account of the user.
		void changeDefaultAccount() {
				System.out.println("Enter user password: ");
				String Password = stringScanner.next();
				if(userObject.checkPassword(Password)) {
					System.out.println("Choose the account: ");
					accountObject = chooseAccount();
					userObject.defaultAccount = accountObject.accountNo;
					executorObject.changeDefaultAccount(userObject);
					System.out.println("Default account changed successfully!");
				}
				else {
					System.out.println("Password Incorrect!");
				}
		}	
}
