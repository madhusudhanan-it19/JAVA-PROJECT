package view;

import controller.UserProcess;
import model.Account;
import model.Transaction;
import model.User;

/*
 * This class is used to pay a money to user.
 */

public class Payment extends  UserProcess {
	
		double amount;
		
		// this method returns true if the amount get transfer successfully otherwise return false.
		boolean transferAmount(Account fromAccount, Account toAccount, double amount) {
			if(fromAccount.amount > amount) {
				fromAccount.amount = fromAccount.amount - amount ;
				executorObject.updateAmount(fromAccount);
				toAccount.amount = toAccount.amount + amount;
				executorObject.updateAmount(toAccount);
				return true;
			}
			System.out.println("Your balance is low!");
			return false;
		}
		
		
		// this method is used to send money to the user.
		void PayUser() {
				if(isSignIn) {
					System.out.println("Enter to user id: ");
					String toUser = stringScanner.next();
					if(isUserAvailable(toUser)) {
					System.out.println("Enter amount to transfer");
					amount = Validation.getDouble();
					if(Validation.checkLimit(amount)) { 
						System.out.println("Choose the account to transfer amount: ");
						accountObject = chooseAccount();
						System.out.println("Enter your pin:");
						int pin = Validation.getInteger();
						if(accountObject.checkPin(pin)) {
							User toUserObj = (User)userExecutor.select(toUser);
							Account toAccount  = (Account)accountExecutor.select(toUserObj.defaultAccount);
							if(transferAmount(accountObject,toAccount, amount)) {
								transactionExecutor.insert(new Transaction(accountObject.userId, toAccount.userId,accountObject.accountNo,toAccount.accountNo, amount));
								System.out.println("Transaction successfull!");
							}
							else {
								System.out.println("Transaction failed!");
							}
						}
					}
				}
				else {
						System.out.println("No user found!");
					}
			}
				else {
					System.out.println("Not signed In");
				}
		}

}