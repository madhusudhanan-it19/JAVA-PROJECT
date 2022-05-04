package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Request;

public class RequestExecutor extends QueryExecutor implements QueryProcess {
	
	//This method is used to insert Request into the request table.
		public void insert(Object request) {
			try {
				Request requestObject = (Request) request; 
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

	//This method is used to select the request from the request table.
		public Request select(String request) {
			try {
				int requestId = Integer.parseInt(request);
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

}
