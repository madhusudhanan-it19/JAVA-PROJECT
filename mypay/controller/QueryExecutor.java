package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import model.Account;
import model.Request;
import model.Transaction;
import model.User;

/* 
 * This class acts like a controller to get and update values from database.
 */

public class QueryExecutor implements QueryProcess{
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
	
	// This method is used to insert account into the account table.
	public void insertAccount(Account accountObject) {
		try {
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
	
	//This method is used to insert user into the user table.
	public void insertUser(User userObject) {
		try {
			query = "insert into user values(?,?,?,?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, userObject.userId);
			statement.setString(2, userObject.userName);
			statement.setString(3, userObject.getPassword());
			statement.setString(4,userObject.defaultAccount);
			statement.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	//This method is used to insert transaction done by user into the transaction table.
	public int insertTransaction(Transaction transactionObject ) {
		try {
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
			return statement.executeUpdate();
			
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return 0;
	}
	
	//This method is used to insert Request into the request table.
	public void insertRequest(Request requestObject) {
		try {
			query = "insert into request(from_user,to_user,amount,status) values (?,?,?,false);";
			statement = connection.prepareStatement(query);
			statement.setString(1, requestObject.fromUser);
			statement.setString(2, requestObject.toUser);
			statement.setDouble(3,requestObject.amount);
			statement.executeUpdate();
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
	
	// This method is used to select the user from the user table.
	public User selectUser (String userId) {
		try {
			query = "select * from user where user_id = ?;";
			statement = connection.prepareStatement(query);
			statement.setString(1, userId);
			ResultSet result =  statement.executeQuery();
			result.next();
			return new User(result.getString(1),result.getString(2), result.getString(3), result.getString(4));
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		return null;
	}
	
	//This method is used to select the account from the account table. 
	public Account selectAccount (String accountNo) {
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

	//This method is used to select the request from the y
	public Request selectRequest(int requestId) {
		try {
			query = "select * from request where req_id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, requestId);
			ResultSet result =  statement.executeQuery();
			result.next();
			return new Request(result.getInt(1),result.getString(2), result.getString(3), result.getDouble(4), result.getBoolean(5));
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
	
	//This method is to get the transaction done by the user.
	public ResultSet showTransaction(String userId) {
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
	
	
	// This method is used to close the Database connection.
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	
	
}
