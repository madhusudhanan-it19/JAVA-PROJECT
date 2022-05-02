package userinterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import dataset.UserProcess;

public class Request extends UserProcess {
		
	
	
	void sendRequest() {
		if(isSignIn) {
			System.out.println("Enter the user Id to send Request: ");
			String toUser = strScanner.next();
			if(isUserAvailable(toUser)) {
				System.out.println("Enter amount: ");
				double amount =  Validation.getDouble();
				if(Validation.checkLimit(amount)) {
					executorObject.insertRequest(userId, toUser, amount);
					System.out.println("Request Sent!");
				} 
			}
			else {
				System.out.println("User not found!");
			}
			
		}
		else {
			System.out.println("Please Sign In!");
		}
	}
	
	
	void viewRequest() {
		if(isSignIn) {
		try {
			ResultSet result = executorObject.selectAll("request", "to_user", userId);
			boolean isRequestFound = false;
			while(result.next()) {
				if(!result.getBoolean(5)) {
				System.out.println(result.getInt(1) + " . " + result.getString(2) + "\t" + result.getString(4) );
				isRequestFound = true;
				}
			}
			if(isRequestFound) {
				System.out.println("Choose the request Id :");
				int requestId = Validation.getInteger();
				System.out.println("1. Pay request");
				System.out.println("2. Reject request");
				int choice = Validation.getInteger();
				System.out.println("Enter pin: ");
				int pin = Validation.getInteger();
				if(Validation.checkPin(pin)) {
				if(choice == 1) {
					acceptRequest(requestId);
					System.out.println("Request money paid!");
				}
				else {
					rejectRequest(requestId);
					System.out.println("Request rejected!");
				}
				}
		}
			else {
				System.out.println("No request Found!");
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		}
		else {
			System.out.println("Please sign in!");
		}
		
	}
	
	void acceptRequest(int requestId) {
		try {
			ResultSet result = executorObject.selectAll("request", "req_id", requestId);
			result.next();
			String toUser = result.getString(2);
			double amount = result.getDouble(4);
			result = executorObject.selectAll("user", "user_id", toUser);
			result.next();
			String toAccount = result.getString(4);
			if(new Payment().transferAmount(fromAccount, toAccount, toUser, amount)) {
			executorObject.insertTransaction(userId, fromAccount, toAccount, toUser, amount);
			executorObject.updateRequestStatus(requestId);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	void rejectRequest(int requestId) {
		executorObject.deleteRow("request", requestId);
	}
}
