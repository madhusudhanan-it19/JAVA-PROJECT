package employeedetails;
/*
 * this is the interface that holds all the common properties of class which implements this.

 */
interface ValueChanger {
	public void change(String value, int choice); 
	public void change(long phNo); 
	public void change(double salary); 
	public  boolean checkPassword(String password); 
	public boolean checkAdmin();
	public  void setPassword(String newPassword);
	public  String getPassword();
}