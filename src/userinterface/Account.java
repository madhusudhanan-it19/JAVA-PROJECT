package userinterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import dataset.UserProcess;

public class Account  extends UserProcess{
		void addAccount(){
			if(isSignIn) {
					System.out.println("Enter account Number: ");
					String accountNumber = strScanner.next();
					System.out.println("Enter Bank Name: ");
					strScanner.nextLine();
					String bankName = strScanner.nextLine();
					System.out.println("Enter balance amount: ");
					double amount = Validation.getDouble();
					System.out.println("Enter Upi pin: ");
					int pin = Validation.getInteger();
					if(Validation.checkValidPin(pin)) {
						executorObject.insertAccount(userId, accountNumber, bankName, amount, pin);
						System.out.println("Account added successfully!");
					}
			}
			else {
				System.out.println("Please Sign In!");
			}
		}
		
		void checkBalance() {
			if(isSignIn) {
			System.out.println("Choose the account: ");
			fromAccount = chooseAccount();
			System.out.println("Enter pin:");
			int pin = intScanner.nextInt();
			if(Validation.checkPin(pin)) {
			try {
				ResultSet result = executorObject.selectAll("account", "acc_no", fromAccount);
				result.next();
				System.out.println("Balance: "+ result.getString(4));
			}
			catch(SQLException sql) {
				sql.printStackTrace();
			}
		}
		}
			else {
				System.out.print("sign in please!");
			}
		}
}
