package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import model.Transaction;

public class TransactionExecutor extends QueryExecutor implements QueryProcess {
	//This method is used to insert transaction done by user into the transaction table.
	public void insert(Object transaction ) {
		try {
			Transaction transactionObject = (Transaction) transaction;
			String query =  "insert into transaction (from_user, to_user,from_acc_no, to_acc_no,amount,date) values (?,?,?,?,?,?);";
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String datetime = new String(formatter.format(transactionObject.date));  
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, transactionObject.fromUser);
			statement.setString(2, transactionObject.toUser);
			statement.setString(3, transactionObject.fromAccount);
			statement.setString(4, transactionObject.toAccount);
			statement.setDouble(5, transactionObject.amount);
			statement.setString(6, datetime);
			statement.executeUpdate();
			
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
		//This method is used to select the list of transaction done by user.
	public ResultSet select(String userId) {
		try {
			query = "select * from transaction where from_user = ? or to_user = ? order by transaction_id desc ;";
			statement = connection.prepareStatement(query);
			statement.setString(1, userId);
			statement.setString(2, userId);
			return statement.executeQuery();
		} catch (SQLException exception) {
				exception.printStackTrace();
		}
	    return null;
	}
}
