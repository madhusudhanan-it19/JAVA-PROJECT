package userinterface;
import dataset.UserProcess;
public class Authentication extends UserProcess {
	void signUp() {
			System.out.println("Enter your phone Number: ");
			String phoneNumber = strScanner.next();
			strScanner.nextLine();
			if(Validation.checkphoneNumber(phoneNumber)) { 
				if(!isUserAvailable(phoneNumber)) {
				System.out.println("Enter your Name: ");
				String userName = strScanner.nextLine();
				System.out.println("Enter longin Password: ");
				String password = strScanner.next();
				System.out.println("Enter account Number: ");
				String accountNumber = strScanner.next();
				if(Validation.checkAccount(accountNumber)) {
					if(!Validation.checkAccountExits(accountNumber)) {
					System.out.println("Enter Bank Name: ");
					strScanner.nextLine();
					String bankName = strScanner.nextLine();
					System.out.println("Enter balance amount: ");
					double amount = Validation.getDouble();
					System.out.println("Enter Upi pin: ");
					int pin = Validation.getInteger();
					if(Validation.checkValidPin(pin)) {
						executorObject.insertAccount(phoneNumber,accountNumber,bankName,amount,pin);
						executorObject.insertUser(phoneNumber, userName, password, accountNumber);
						System.out.println("User Created successfully!");
					}
			}
			else {
				System.out.println("Account already exits!");
			}
			}
			}
				else {
					System.out.println("User Already exists! please sign in!");
				}
			}
	}
	
	void signIn() {
		if(!isSignIn) {
		System.out.println("Enter your Phone number: ");
		userId = strScanner.next();
		if(isUserAvailable(userId)) {
		System.out.println("Enter Password: ");
		String password = strScanner.next();
		if(Validation.checkPassword(userId, password)) {
			isSignIn = true;
			fromAccount = executorObject.getDefaultAccount(userId);
			System.out.println("Signed In!");
		}
		}
		else {
			System.out.println("No user found!");
		}
		}
		else {
			System.out.println("Signed In! please sign out!");
		}
	}
	void signOut() {
		isSignIn = false;
		userId = null;
		fromAccount = null;
		System.out.println("Signed out!");
	}
	
	void closeConnection() {
		executorObject.closeConnection();
	}
}
