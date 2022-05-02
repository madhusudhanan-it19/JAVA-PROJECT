package dataset;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserProcess {
	protected static Scanner intScanner = new Scanner(System.in);
	protected static Scanner strScanner = new Scanner(System.in);
	protected static QueryExecutor executorObject = new QueryExecutor();
	protected static String userId;
	protected static String fromAccount;
	protected static boolean isSignIn= false;
	
	
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
	
	protected int getAccount(Map<Integer, Vector<String>> accountMap) {
		for (Map.Entry<Integer, Vector<String>> account : accountMap.entrySet()) {
			 System.out.println(account.getKey() + " . " + account.getValue().toString());
		}
		int input = intScanner.nextInt();
		return input;
	}
	
	
	
	protected double getAmount(String account) {
		try {
			ResultSet result1 = executorObject.selectAll("account", "acc_no", account);
			result1.next();
			return result1.getDouble(4);
			
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return 0;
	}
	protected String chooseAccount() {
		try {
			Map<Integer, Vector<String>> accountMap = new HashMap<>();
			int key = 1;
			Vector<String> accountVector;
			ResultSet result = executorObject.selectAll("account", "user_id", userId);
			while(result.next()) {
				accountVector = new Vector<>();
				accountVector.add(result.getString(2));
				accountVector.add(result.getString(3));
				accountMap.put(key,  accountVector);
				key++;
			}
			int choice = getAccount(accountMap);
			return accountMap.get(choice).get(0);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return null;
	}
	
	
}
