package userinterface;

import java.sql.ResultSet;
import java.sql.SQLException;

import dataset.UserProcess;

public class Recharge extends UserProcess {
	double amount;
	String phNo;
	String provider = null;
	SimProvider simObject;
		Recharge() {
			if(isSignIn) {
				System.out.println("Enter phone Number: ");
				phNo = strScanner.next();
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
					System.out.println("Enter your pin: ");
					int pin =  Validation.getInteger();
					if(Validation.checkPin(pin)) {
					transfer();
					System.out.println("Recharge successfull!");
					}
				}
			}
			else {
				System.out.println("Please sign in!");
			}
		}
		
		private void transfer() {
			try {
				ResultSet result = executorObject.selectAll("account", "acc_no", fromAccount);
				result.next();
				double balanceAmount = result.getDouble(4);
				if(balanceAmount>amount) {
					balanceAmount -= amount;
					executorObject.setAmount(fromAccount, balanceAmount);
					executorObject.insertTransaction(userId, fromAccount, provider, phNo,amount);
				}
				else {
					System.out.println("Minimum balance!");
				}
				
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
			
		}

	
}
