package view;

import java.sql.ResultSet;
import java.sql.SQLException;

import controller.UserProcess;
import model.Account;
import model.Request;
import model.Transaction;

/*
 * This class holds the functionalities of send request and view request.
 */
public class RequestProcess extends UserProcess {
	
	// this method is to send money request to another user. 
	void sendRequest() {
		if(isSignIn) {
			System.out.println("Enter the user Id to send Request: ");
			String toUser = stringScanner.next();
			if(isUserAvailable(toUser)) {
				System.out.println("Enter amount: ");
				double amount =  Validation.getDouble();
				if(Validation.checkLimit(amount)) {
					executorObject.insertRequest(new Request(accountObject.userId, toUser, amount, false));
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
	
	// this method is to view the request given by another user. 
	void viewRequest() {
		if(isSignIn) {
		try {
			ResultSet result = executorObject.selectAll("request", "to_user", userObject.userId);
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
				accountObject = chooseAccount();
				System.out.println("Enter pin: ");
				int pin = Validation.getInteger();
				if(accountObject.checkPin(pin)) {
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
	
	// this method is to accept the request and pay the requested money.
	void acceptRequest(int requestId) {
			Request requestObj = executorObject.selectRequest(requestId);
			double amount = requestObj.amount;
			String toAccountNo = executorObject.getDefaultAccount(requestObj.fromUser);
			Account toAcccountObject = executorObject.selectAccount(toAccountNo);
			if(new Payment().transferAmount(accountObject,toAcccountObject,amount)) {
			executorObject.insertTransaction(new Transaction(accountObject.userId, toAcccountObject.userId, accountObject.accountNo, toAcccountObject.accountNo, amount));
			executorObject.updateRequestStatus(requestId);
			}
	}
	
	//this method is used to reject the request and delete that request from the table.
	void rejectRequest(int requestId) {
		executorObject.deleteRow("request", requestId);
	}
}
