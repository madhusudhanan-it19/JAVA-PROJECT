package userinterface;
import java.sql.ResultSet;
import java.sql.SQLException;

import dataset.UserProcess;

public class Transaction extends UserProcess {
		
	void showTransaction() {
		if(isSignIn) {
			
				try {
					ResultSet result = executorObject.showTransaction(userId);
					System.out.println();
					while(result.next()) {
						if(result.getString(2).equals(userId)) {
							System.out.println(result.getString(3) + "\t"+result.getString(5)+"\t" + result.getString(7) +"\t" + "- " + result.getString(6) );
						}
						else {
							System.out.println(result.getString(2) + "\t"+ result.getString(4)+"\t" + result.getString(7) +"\t" + "+ " + result.getString(6) );
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
