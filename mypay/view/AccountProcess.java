package view;

import controller.UserProcess;
import model.Account;

/*
 * This class is mainly used to add account and check balance.
 */

public class AccountProcess  extends UserProcess{
		
		// this method is to add another account to the user.
		void addAccount(){
			if(isSignIn) {
					System.out.println("Enter account Number: ");
					String accountNumber = stringScanner.next();
					if(!Validation.checkAccountExits(accountNumber)) {
					System.out.println("Enter Bank Name: ");
					stringScanner.nextLine();
					String bankName = stringScanner.nextLine();
					System.out.println("Enter balance amount: ");
					double amount = Validation.getDouble();
					System.out.println("Enter Upi pin: ");
					int pin = Validation.getInteger();
					if(Validation.checkValidPin(pin)) {
						accountExecutor.insert(new Account(userObject.userId, accountNumber, bankName, amount, pin));
						System.out.println("Account added successfully!");
					}
				}
			}
			else {
				System.out.println("Please Sign In!");
			}
		}
		
		// this method is to view balance of the given account.
		void checkBalance() {
			if(isSignIn) {
			System.out.println("Choose the account: ");
			accountObject = chooseAccount();
			System.out.println("Enter pin:");
			int pin = integerScanner.nextInt();
			if(accountObject.checkPin(pin)) {
				System.out.println("Balance: "+ accountObject.amount);
			
		}
		}
			else {
				System.out.print("sign in please!");
			}
		}
}
