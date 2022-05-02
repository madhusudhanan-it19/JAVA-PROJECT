package userinterface;


import java.sql.ResultSet;
import java.sql.SQLException;
import dataset.UserProcess;



public class Payment extends  UserProcess {
		
		boolean transferAmount(String fromAccount,String toAccount,String toUser,double amount) {
			double fromAmount, toAmount;
			fromAmount = getAmount(fromAccount);
			toAmount = getAmount(toAccount);
			if(fromAmount > amount) {
			fromAmount = fromAmount - amount ;
			executorObject.setAmount(fromAccount,fromAmount);
			toAmount = toAmount + amount;
			executorObject.setAmount(toAccount,toAmount);
			return true;
			}
			System.out.println("Your balance is low!");
			return false;
		}
		
		
		
		void PayUser() {
			try {
				if(isSignIn) {
					System.out.println("Enter to user id: ");
					String toUser = strScanner.next();
					if(isUserAvailable(toUser)) {
					System.out.println("Enter amount to transfer");
					double amount = Validation.getDouble();
					if(Validation.checkLimit(amount)) { 
						System.out.println("Choose the account to transfer amount: ");
						fromAccount = chooseAccount();
						System.out.println("Enter your pin:");
						int pin = Validation.getInteger();
						if(Validation.checkPin(pin)) {
							String toAccount = "";
							ResultSet result1 = executorObject.selectAll("user", "user_id", toUser);
							result1.next();
							toAccount = result1.getString(4);
							if(transferAmount(fromAccount,toAccount,toUser,amount)) {
								executorObject.insertTransaction(userId, fromAccount, toAccount, toUser, amount);
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
			} catch (SQLException exception) {
				
				exception.printStackTrace();
			}
		}

}