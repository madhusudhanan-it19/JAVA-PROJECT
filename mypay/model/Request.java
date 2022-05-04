package model;


//This is a model class of Request table.

public class Request {
	public int requsetId;
	public String fromUser;
	public String toUser;
	public double amount;
	public boolean status;
	public Request (String fromUser, String toUser, double amount, boolean status){
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.amount = amount;
		this.status = status;
	}
	
	public Request (int requestId, String fromUser, String toUser, double amount, boolean status){
		this.requsetId = requestId;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.amount = amount;
		this.status = status;
	}
}
