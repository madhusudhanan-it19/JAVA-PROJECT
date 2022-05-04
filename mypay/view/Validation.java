package view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;

import controller.UserProcess;

/*
 * This class undergoes all validations for the input.
 */

public class Validation extends UserProcess {
	static boolean avoidRecursion = false; // This boolean variable is simply to avoid recursion. 
	
	// The below method is to check whether the given input contains only integers
	static boolean checkDigit(String value) {
		try {
			Long.parseLong(value);
		} catch (NumberFormatException e) {
			System.out.println("Invalid input!");
			return false;
		}
		return true;
	}
	
	// The below method is to check the given account number is valid
	static boolean checkAccount(String account) {
		int length = account.length();
		if((length>=13) && (length<=16) && checkDigit(account)) {
			return true;
		}
		System.out.println("Please provide a valid Account number!");
		return false;
	}
	
	//The below method is to check whether the given account is exists or not.
	static boolean checkAccountExits(String account) {
			ResultSet result = executorObject.selectAll("account", "acc_no", account);
			try {
				result.next();
				result.getString(2);
			} catch (SQLException exception) {
				return false;
			}
		return true;
	}
	
	//This method is to check the given input is a valid phone number.
	static boolean checkphoneNumber(String phonenumber) {
		if(phonenumber.length() == 10 && checkDigit(phonenumber))
		{
			return true;
		}
		System.out.println("Provide a valid phone number!");
		return false;
		
	}
	
	//this method is to check the given input is valid Pin number.
	static boolean checkValidPin(int pin) {
		if(pin>=1000 && pin<=9999)
			return true;
		System.out.println("Pin consits only of 4 digits!");
		return false;
	}
	
	// this method is to check the given password is correct or not.
	static boolean checkPassword(String user, String password) {
		try {
			ResultSet result = executorObject.selectAll("user", "user_id", user);
				result.next();
				if(result.getString(3).equals(password)) {
					return true;
				}			
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		System.out.println("Password Incorrect");
		return false;
	}
	
	
	// this method is to check whether the given amount is in the limit.
	static boolean checkLimit(double amount) {
		if(amount > 50000.00) {
			System.out.println("Amount limit is not accepttable!");
			return false;
		}
		return true;
	}
	
	// this method is to get the valid integer input from the user.
	public static int getInteger () {
		try {
			if(avoidRecursion)
				integerScanner.next();
			int choice = integerScanner.nextInt();
			avoidRecursion = false;
			return choice;
		}
		catch (InputMismatchException inputMismatch ) {
			System.out.println("Provide a valid input !");
			avoidRecursion = true;
			return getInteger(); 
		}
		
	}
	
	
	//this method is to get the valid double value as a input from the user.
	static double getDouble () {
		try {
			if(avoidRecursion)
				integerScanner.next();
			double choice = integerScanner.nextDouble();
			avoidRecursion = false;
			return choice;
		}
		catch (InputMismatchException inputMismatch ) {
			System.out.println("Provide a valid input !");
			avoidRecursion = true;
			return getDouble();
		}
	}
	
}