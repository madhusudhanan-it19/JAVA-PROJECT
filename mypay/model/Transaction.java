package model;

import java.util.Date;

public class Transaction {
	public int transactionId;
	public String fromUser;
	public String toUser;
	public String fromAccount;
	public String toAccount;
	public double amount;
	public Date date;
	public Transaction (String fromUser, String toUser, String fromAccount, String toAccount, double amount) {
		this.fromUser = fromUser;
		this.fromAccount = fromAccount;
		this.toUser = toUser;
		this.toAccount = toAccount;
		this.amount = amount;
		date = new Date();
	}
}
