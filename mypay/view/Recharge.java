package view;

import controller.UserProcess;
import model.Transaction;

/*
 * This class is used to recharge a mobile.
 */

public class Recharge extends UserProcess {
	double amount;
	String phNo;
	String provider = null;
	SimProvider simObject;
		Recharge() {
			if(isSignIn) {
				System.out.println("Enter phone Number: ");
				phNo = stringScanner.next();
				if(Validation.checkphoneNumber(phNo)) {
					System.out.println("Enter sim type: ");
					System.out.println("1. Jio");
					System.out.println("2. Airtel");
					int choice =  Validation.getInteger();
					switch(choice) {
					case 1: 
						simObject = new Jio();
						provider = "Jio Prepaid";
						break;
					case 2:
						simObject = new Airtel();
						provider = "Airtel Prepaid";
						break;
					default:
						System.out.println("Incorret choice");
					}
					amount = simObject.getOffers();
					accountObject = chooseAccount();
					double fromAmount = accountObject.amount;
					if(fromAmount > amount) {
						System.out.println("Enter your pin: ");
						int pin =  Validation.getInteger();
						if(accountObject.checkPin(pin)) {
						transfer();
						System.out.println("Recharge successfull!");
						}
					}
					else {
						System.out.println("Minimum balance!");
					}
				}
			}
			else {
				System.out.println("Please sign in!");
			}
		}
		
		// this method is used to update amount and transaction table after recharge.
		private void transfer() {
					accountObject.amount -= amount;
					executorObject.updateAmount(accountObject);
					transactionExecutor.insert(new Transaction(accountObject.userId,phNo,accountObject.accountNo,provider, amount));
			
			
		}

	
}
