package controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import model.Account;
import model.User;

/*
 *  This class act as parent class to provide the following functionalities:
 *  get amount, get account and choose account.
 */

public class UserProcess {
	protected static Scanner integerScanner = new Scanner(System.in);
	protected static Scanner stringScanner = new Scanner(System.in);
	protected static QueryProcess executorObject = new QueryExecutor();
	protected static User userObject;
	protected static Account accountObject;
	protected static boolean isSignIn= false;
	
	// this method is used to check whether the given user is available or not.
	protected boolean isUserAvailable(String user) {
		try {
			ResultSet result = executorObject.selectAll("user", "user_id", user);
			if(result.next()) {
				return true;
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return false;
		
	}
	
	// this method is to get choice of account from the user.
	protected int getAccount(Map<Integer,Account> accountMap) {
		for (Map.Entry<Integer, Account> account : accountMap.entrySet()) {
			 System.out.println(account.getKey() + " . " + account.getValue().accountNo + " " + account.getValue().bankName);
		}
		int input = view.Validation.getInteger();
		return input;
	}
	
	// this method is to choose account of the user.
	protected Account chooseAccount() {
		try {
			Map<Integer, Account> accountMap = new HashMap<>();
			int key = 1;
			ResultSet result = executorObject.selectAll("account", "user_id", userObject.userId);
			while(result.next()) {
				accountMap.put(key, new Account(result.getString(1),result.getString(2), result.getString(3), result.getDouble(4), result.getInt(5)));
				key++;
			}
			int choice = getAccount(accountMap);
			return accountMap.get(choice);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return null;
	}
	
	
}
