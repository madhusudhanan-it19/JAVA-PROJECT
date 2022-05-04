package view;
import controller.UserProcess;
import model.Account;
import model.User;

public class Authentication extends UserProcess {
	
	// this method is to create a new user.
	void signUp() {
			System.out.println("Enter your phone Number: ");
			String phoneNumber = stringScanner.next();
			stringScanner.nextLine();
			if(Validation.checkphoneNumber(phoneNumber)) { 
				if(!isUserAvailable(phoneNumber)) {
				System.out.println("Enter your Name: ");
				String userName = stringScanner.nextLine();
				System.out.println("Enter longin Password: ");
				String password = stringScanner.next();
				System.out.println("Enter account Number: ");
				String accountNumber = stringScanner.next();
				if(Validation.checkAccount(accountNumber)) {
					if(!Validation.checkAccountExits(accountNumber)) {
					System.out.println("Enter Bank Name: ");
					stringScanner.nextLine();
					String bankName = stringScanner.nextLine();
					System.out.println("Enter balance amount: ");
					double amount = Validation.getDouble();
					System.out.println("Enter Upi pin: ");
					int pin = Validation.getInteger();
					if(Validation.checkValidPin(pin)) {
						userObject = new User(phoneNumber,userName,password,accountNumber);
						accountObject = new Account(phoneNumber,accountNumber,bankName,amount,pin);
						accountExecutor.insert(accountObject);
						userExecutor.insert(userObject);
						System.out.println("User Created successfully!");
						isSignIn = true;
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
	
	
	// this method is to sign in to the account.
	void signIn() {
		if(!isSignIn) {
		System.out.println("Enter your Phone number: ");
		String userId = stringScanner.next();
		if(isUserAvailable(userId)) {
		System.out.println("Enter Password: ");
		String password = stringScanner.next();
		if(Validation.checkPassword(userId, password)) {
			isSignIn = true;
			userObject = (User)userExecutor.select(userId);
			String defAccount = executorObject.getDefaultAccount(userId);
			accountObject = (Account)accountExecutor.select(defAccount);
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
	
	// this method is to get sign out from the application.
	void signOut() {
		isSignIn = false;
		userObject = null;
		accountObject = null;
		System.out.println("Signed out!");
	}
	
	// this method is call the method which will close the Database connection.
	void closeConnection() {
		executorObject.closeConnection();
	}
}
