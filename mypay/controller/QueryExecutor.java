package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;
import model.User;

/* 
 * This class acts like a controller to get and update values from database.
 */

public class QueryExecutor {
	public static Connection connection;
	public static PreparedStatement statement;
	public String query = null;
	public ResultSet result = null;
	
	// this constructor is used to get connection of the Database.
	public QueryExecutor() {
		try {
			connection = null ;
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/upi_console","root","");
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	
	//This method is used to delete request from the request table.
	public void deleteRow(String table , int id) {
		try {
			query = "delete from " + table + " where req_id = ? ;";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	
	//This method is used to get default account of the user.
	public String getDefaultAccount (String userId) {
		try {
			query = "select default_acc from user where user_id  = ?;";
			statement = connection.prepareStatement(query);
			statement.setString(1, userId);
			result = statement.executeQuery();
			result.next();
			return result.getString(1);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		return null;
	}
	
	
	// this method is used to select all values from the given table with respective to given column and its values. 
	public ResultSet selectAll (String table, String column, String value) {
		try {
			query = "select * from "+ table+" where "+column+" = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, value);
			return statement.executeQuery();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return null;
	}
	
	//This method is used to update amount to the account table.
	public void updateAmount(Account accountObject) {
		try {
			query = "update account set amount = ? where acc_no = ?;";
			statement = connection.prepareStatement(query);
			statement.setDouble(1, accountObject.amount);
			statement.setString(2, accountObject.accountNo);
			statement.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
	}
	
	// This method is used to update request status in the request table.
	public void updateRequestStatus(int requestId) {
		try {
			query = "update request set status = true where req_id = ?;";
			statement = connection.prepareStatement(query);
			statement.setInt(1, requestId);
			statement.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
		
	// This method is used to close the Database connection.
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

	//This method is used to change password of the user.
	public void changePassword(User userObject) {
		try {
			query = "update user set password = ? where user_id = ? ;";
			statement = connection.prepareStatement(query);
			statement.setString(1, userObject.getPassword());
			statement.setString(2, userObject.userId);
			statement.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
	}
	
	//This method is used to change upi pin of  the account.
	public void changePin(Account accountObject) {
		try {
			query = "update account set upi_pin = ? where acc_no = ? ;";
			statement = connection.prepareStatement(query);
			statement.setInt(1, accountObject.getPin());
			statement.setString(2, accountObject.accountNo);
			statement.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
	}
	
	//This method is used to change default account of the user.
	public void changeDefaultAccount(User userObject) {
		try {
			query = "update user set default_acc = ? where user_id = ? ;";
			statement = connection.prepareStatement(query);
			statement.setString(1, userObject.defaultAccount);
			statement.setString(2, userObject.userId);
			statement.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
	}
}
