package controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

public class UserExecutor extends QueryExecutor implements QueryProcess {
	//This method is used to insert user into the user table.
	public void insert(Object user) {
		try {
			User userObject  = (User)user;
			query = "insert into user values(?,?,?,?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, userObject.userId);
			statement.setString(2, userObject.userName);
			statement.setString(3, userObject.getPassword());
			statement.setString(4,userObject.defaultAccount);
			statement.executeUpdate();
			} 
		catch (SQLException exception) {
			exception.printStackTrace();
			}
	}
	
	
	//This method is used to select the user from the user table. 
	public User select(String userId) {
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
}
