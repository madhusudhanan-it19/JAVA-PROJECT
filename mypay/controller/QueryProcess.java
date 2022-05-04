package controller;

import java.sql.ResultSet;

import model.Account;
import model.Request;
import model.Transaction;
import model.User;

public interface QueryProcess {
	void insertAccount(Account accountObj);
	void insertUser(User userObj);
	int insertTransaction(Transaction transactionObj);
	void insertRequest(Request requestObj);
	void deleteRow(String table , int id);
	String getDefaultAccount (String userId);
	User selectUser(String userId);
	Account selectAccount(String accountNo);
	Request selectRequest(int requestId);
	ResultSet selectAll (String table, String column, String value);
	void updateAmount(Account account);
	void updateRequestStatus(int requestId);
	ResultSet showTransaction(String userId);
	void closeConnection();
}
