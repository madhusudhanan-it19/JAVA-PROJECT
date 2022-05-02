package userinterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import dataset.UserProcess;

class Validation extends UserProcess {
	static boolean avoidRecursion = false;
	static boolean checkDigit(String value) {
		try {
			Long.parseLong(value);
		} catch (NumberFormatException e) {
			System.out.println("Invalid input!");
			return false;
		}
		return true;
	}
	static boolean checkAccount(String account) {
		int length = account.length();
		if((length>=10) && (length<=16) && checkDigit(account)) {
			return true;
		}
		System.out.println("Please provide a valid Account number!");
		return false;
	}
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
	static boolean checkphoneNumber(String phonenumber) {
		if(phonenumber.length() == 10 && checkDigit(phonenumber))
		{
			return true;
		}
		System.out.println("Provide a valid phone number!");
		return false;
		
	}
	static boolean checkValidPin(int pin) {
		if(pin>=1000 && pin<=9999)
			return true;
		System.out.println("Pin consits only of 4 digits!");
		return false;
	}
	
	static boolean checkPin(int pin) {

		try {
			ResultSet result = executorObject.selectAll("account", "acc_no", fromAccount);
			result.next();
			int acc_pin = result.getInt(5);
			if(acc_pin == pin)
				return true;
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		System.out.println("Incorrect Pin!");
		return false;
	}
	
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
	
	static boolean checkLimit(double amount) {
		if(amount > 50000.00) {
			System.out.println("Amount limit is not accepttable!");
			return false;
		}
		return true;
	}
	
	static int getInteger () {
		try {
			if(avoidRecursion)
				intScanner.next();
			int choice = intScanner.nextInt();
			avoidRecursion = false;
			return choice;
		}
		catch (InputMismatchException inputMismatch ) {
			System.out.println("Provide a valid input !");
			avoidRecursion = true;
			return getInteger(); 
		}
		
	}
	
	static double getDouble () {
		try {
			if(avoidRecursion)
				intScanner.next();
			double choice = intScanner.nextDouble();
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