
package edu.csbsju;
 
 
/**
 * This class is the class that encompasses the similarities of a User 
 * and an Administrator. Account represents a user object, with corresponding
 * instance variables such as name, username, password and other fields. These
 * attributes allow the user to log into the system. This Class has two 
 * subclasses, which are User and Administrator.
 * @author jsupton 
 * @version 03-21-17
 */
public class Account {
 
	 /**
	  * This instance variable is a String that represents the 
	  * first name of the Account object
	  */
	 private String firstName;
	 /**
	  * This instance variable is a String that represents the 
	  * last name of the Account object
	  */
	 private String lastName;
	 /**
	  * This instance variable is a String that represents the 
	  * username of the Account object
	  */
	 private String username;
	 /**
	  * This instance variable is a String that represents the 
	  * password of the Account object
	  */
	 private String password;
	 /**
	  * This instance variable is a String that represents the 
	  * status (active or deactive) of the Account object
	  */
	 private char status;
	 /**
	  * This instance variable is a String that represents the 
	  * type (admin or user) of the Account object
	  */
	 private char type;
	 
	 /**
	  * This constructor takes in the 6 parameters of an Account object from the user
	  * It sets each of the parameters to the corresponding instance variable 
	  * @param firstName String, The first name of the account object
	  * @param lastName String, The last name of the account object
	  * @param username String, The Username of the account object
	  * @param password String, The password of the account object
	  * @param status Char, The status (active or deactivated) of the account object
	  * @param type Char, The type (User or admin) of the account object
	  */
	 public Account(String firstName, String lastName, String username, String password, char type, char status) {
	  super(); 
	  this.firstName = firstName;
	  this.lastName = lastName;
	  this.username = username;
	  this.password = password;
	  this.status = status;
	  this.type = type;
	 }
	
	 /**
	  * This constructor takes only a single parameter. All that is necessary for a successful
	  * Account to be created is a unique username. Thus a username String is passed to the 
	  * constructor and all other instance variables are set to a null value.
	  * @param userName String, The Username of the account object
	  */
	 public Account(String userName) {
	  this.firstName = null;
	  this.lastName = null;
	  this.username = userName;
	  this.password = null;
	  this.status = '\0';
	  this.type = '\0';
	 }
	
	 /**
	  * gets the username for the Account object
	  * @return the username
	  */
	 public String getUsername() {
	  return username;
	 }
	
	 /**
	  * gets the password for the Account object
	  * @return the password
	  */
	 public String getPassword() {
	  return password;
	 }
	
	 /**
	  * gets the type for the Account object
	  * @return the type
	  */
	 public char getType() {
	  return type;
	 }
	 
	 /**
	  * gets the status for the Account object
	  * @return the status
	  */
	 public char getStatus() {
		 return status;
	 }
	 
	 /**
	  * Gets the firstname of the account
	  * @return the first name of the account object
	  */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the firstname of the account
	 * @param firstName the first name of the account
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * gets the lastname of the Account
	 * @return lastname
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the lastname of the account
	 * @param lastName the lastname of the account
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Sets the password of the account
	 * @param password the password of the account
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	 /**
	  * The method allows the user to log out of the system
	  * The Current Account information is cleared from this system.
	  */
	 public void logOff(){
		 this.username = null;
		 this.firstName = null;
		 this.lastName = null;
		 this.password = null;
		 this.status = '\0';
		 this.type = '\0';
	 }
	 
	 /**
	  * The method allows the user to log into the system
	  * The current user's Account information creates a new Account
	  * object and their detailed information is loaded into the instance variables
	  * @param a an account object to log into the system
	  */
	 public void logOn(Account a){
		 this.username = a.getUsername();
		 this.firstName = a.getFirstName();
		 this.lastName = a.getLastName();
		 this.password = a.getPassword();
		 this.status = a.getStatus();
		 this.type = a.getType();
	 }
	 
	 /**void
	  * This method gets all the details for the Account object
	  * This method acts like a toString method.
	  */
	 //public void displayStudent(){
	//  System.out.println("[FirstName=" + firstName + ", LastName=" + lastName + 
	 //   ", Username=" + username + ", Password=" + password+", Type=" + type + ", Status=" + status+"]\n");
	// }
	 
	 /**void
	  * This method gets all the details for the Account object
	  * This method acts like a toString method.
	  */
	 public String displayStudent(){
	  return "[FirstName=" + firstName + ", LastName=" + lastName + 
	    ", Username=" + username + ", Password=" + password+", Type=" + type + ", Status=" + status+"]\n";
	 }
	 
	 
	 /**
	  * This method displays the correct menu to the user when he or she
	  * logs into the system. Depending on if the user is an admin or student,
	  * They will be brought to their prospective screen
	  * @param t char The type (admin or user) of the Account object
	  */
	 public void displayMenu(char t){
		 if(t == 'u'){
				System.out.println();
		  	    System.out.println("--------------------------------------------------------");
			    System.out.println("\tS: Search For Schools");
			    System.out.println("\tM: Manage My Saved Schools");
			    System.out.println("\tP: Manage My Profile");
			    System.out.println("\tQ: To Quit");
			    System.out.println();
		 }
		 else if(t == 'a'){
				System.out.println();
		  	    System.out.println("--------------------------------------------------------");
			    System.out.println("\tU: Manage Universities");
			    System.out.println("\tZ: Manage Users");
			    System.out.println("\tQ: To Quit");
			    System.out.println();
			}
	 }
	 
	 /**
	  * This method is used when there is an error in the login process. This
	  * method displays an error message for the user when there is an error
	  * when logging in. This error is often because the user input a wrong
	  * username or password
	  */
	 public void displayLoginError(){
		 System.out.println("There was an error Loggin in. Please Try again.");
	 }
	 
	 /**
	  * This method determines if the current account object is active or not
	  * Each account object has an attribute that states whether the Account is
	  * active or deactivated. If the account if Active this method will return 
	  * true, otherwise it will return false.
	  * @return Boolean, true if the Account object is active
	  */
	 public boolean isActive(){
		 if(this.getType() == ('Y'))
			 return true;
		 else
			 return false;
	 }
	 
	 /**
	  * The method uses the current Account object and gets the type of that Account object. It acts as a 
	  * transfer method to transfer the Account type to display the correct UI 
	  * for the Account user. The method returns the type of the Account.
	  * @return char a character representing the type of the Account
	  */
	 public char returnType(){
		 return this.getType();
	 }
	 

}
