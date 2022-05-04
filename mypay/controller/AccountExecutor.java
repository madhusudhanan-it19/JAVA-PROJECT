package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;

public class AccountExecutor extends QueryExecutor implements QueryProcess {
	
	
	// This method is used to insert account into the account table.
	public void insert(Object account) {
		try {
			Account accountObject = (Account)account;
			query = "insert into account(user_id, acc_no,bank_name,amount,upi_pin) values(?,?,?,?,?);";
			statement = connection.prepareStatement(query);
			statement.setString(1, accountObject.userId);
			statement.setString(2, accountObject.accountNo);
			statement.setString(3, accountObject.bankName);
			statement.setDouble(4, accountObject.amount);
			statement.setInt(5, accountObject.getPin());
			statement.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	//This method is used to select the account from the account table. 
	public Account select (String accountNo) {
		try {
			query = "select * from account where acc_no = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, accountNo);
			ResultSet result =  statement.executeQuery();
			result.next();
			return new Account(result.getString(1),result.getString(2), result.getString(3), result.getDouble(4), result.getInt(5));
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		return null;
	}
		
}
