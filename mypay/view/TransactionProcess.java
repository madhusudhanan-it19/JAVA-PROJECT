package view;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.UserProcess;

/*
 * This class is to view the transactions done by the user. 
 */

public class TransactionProcess extends UserProcess {
	
	// this method is to show transaction done by the user.
	void showTransaction() {
		if(isSignIn) {
			
				try {
					ResultSet result = (ResultSet)transactionExecutor.select(userObject.userId);
					System.out.println();
					while(result.next()) {
						if(result.getString(3).equals(userObject.userId)) {
							System.out.println(result.getString(2) + "\t"+ result.getString(4)+"\t" + result.getString(7) +"\t" + "+ " + result.getDouble(6) );
						}
						if(result.getString(2).equals(userObject.userId)) {
							System.out.println(result.getString(3) + "\t"+result.getString(5)+"\t" + result.getString(7) +"\t" + "- " + result.getDouble(6) );
						}
					}
				} 
				catch (SQLException exception) {
					exception.printStackTrace();
				}
		}
		else {
			System.out.println("Please Sign In!");
		}
	}
}
