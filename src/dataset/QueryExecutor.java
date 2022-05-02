package dataset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QueryExecutor {
	public static Connection con;
	public static PreparedStatement statement;
	public String query = null;
	public ResultSet result = null;
	public QueryExecutor() {
		try {
			con = null ;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/upi_console","root","");
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	public void insertAccount(String userId,String accountNumber,String bankName,Double amount,int pin) {
		try {
			query = "insert into account(user_id, acc_no,bank_name,amount,upi_pin) values(?,?,?,?,?);";
			statement = con.prepareStatement(query);
			statement.setString(1, userId);
			statement.setString(2, accountNumber);
			statement.setString(3, bankName);
			statement.setDouble(4, amount);
			statement.setInt(5, pin);
			statement.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	public void insertUser(String phoneNumber, String userName, String password, String accountNumber) {
		try {
			query = "insert into user values(?,?,?,?)";
			statement = con.prepareStatement(query);
			statement.setString(1, phoneNumber);
			statement.setString(2, userName);
			statement.setString(3, password);
			statement.setString(4,accountNumber);
			statement.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	public int insertTransaction(String userId,String fromAccount,String toAccount,String toUser,double amount ) {
		try {
			String query =  "insert into transaction (from_user, to_user,from_acc_no, to_acc_no,amount,date) values (?,?,?,?,?,?);";
			 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			 Date date = new Date();  
			 String datetime = new String(formatter.format(date));  
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, userId);
			statement.setString(2, toUser);
			statement.setString(3, fromAccount);
			statement.setString(4, toAccount);
			statement.setDouble(5, amount);
			statement.setString(6, datetime);
			return statement.executeUpdate();
			
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return 0;
	}
	
	
	public void insertRequest(String fromUser, String toUser, double amount) {
		try {
			query = "insert into request(from_user,to_user,amount,status) values (?,?,?,false);";
			statement = con.prepareStatement(query);
			statement.setString(1, fromUser);
			statement.setString(2, toUser);
			statement.setDouble(3,amount);
			statement.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	public void deleteRow(String table , int id) {
		try {
			query = "delete from " + table + " where req_id = ? ;";
			statement = con.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	public String getDefaultAccount (String userId) {
		try {
			query = "select default_acc from user where user_id  = ?;";
			statement = con.prepareStatement(query);
			statement.setString(1, userId);
			result = statement.executeQuery();
			result.next();
			return result.getString(1);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		return null;
	}
	public ResultSet selectAll (String table, String column, String value) {
		try {
			query = "select * from "+ table+" where "+column+" = ?";
			statement = con.prepareStatement(query);
			statement.setString(1, value);
			return statement.executeQuery();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		return null;
	}
	
	public ResultSet selectAll(String table, String column, int value) {
		try {
			query = "select * from "+ table+" where "+column+" = ?";
			statement = con.prepareStatement(query);
			statement.setInt(1, value);
			return statement.executeQuery();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return null;
	}
	
	public void setAmount(String accountNumber, double amount){
		query = "update account set amount = ? where acc_no = ?";
		try {
			statement = con.prepareStatement(query);
			statement.setDouble(1, amount);
			statement.setString(2, accountNumber);
			statement.executeUpdate();
			
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	public void updateRequestStatus(int requestId) {
		try {
			query = "update request set status = true where req_id = ?;";
			statement = con.prepareStatement(query);
			statement.setInt(1, requestId);
			statement.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	public ResultSet showTransaction(String userId) {
			try {
				query = "select * from transaction where from_user = ? or to_user = ? order by transaction_id desc ;";
				statement = con.prepareStatement(query);
				statement.setString(1, userId);
				statement.setString(2, userId);
				return statement.executeQuery();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		
		
		return null;
	}
	
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	
	
}
