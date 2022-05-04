package model;

public class Account {
	public String userId;
	public String accountNo;
	public String bankName;
	public double amount;
	private int upiPin;
	public Account (String userId, String accountNo, String bankName, double amount, int upiPin) {
			this.userId = userId;
			this.accountNo = accountNo;
			this.bankName = bankName;
			this.amount = amount;
			this.upiPin = upiPin;
		}
	public boolean checkPin(int pin) {
		if(pin == upiPin) {
			return true;
		}
		return false;
	}
	public int getPin() {
		return upiPin;
	}
}
