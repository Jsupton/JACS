
package JACS.bin;

import java.util.*;

/**
 * This class is the class that encompasses the similarities of a User 
 * and an Administrator. Account represents a user object, with corresponding
 * instance variables such as name, username, password and other fields. These
 * attributes allow the user to log into the system. This Class has two 
 * subclasses, which are User and Administrator.
 * @author jsupton 
 * @version 02-25-17
 */
public class Account {
	
	//The following Instance variables make up an Account object
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private char status;
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
	public Account(String firstName, String lastName, String username, String password, char status, char type) {
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
	 * @param username String, The Username of the account object
	 */
	public Account(String firstName) {
		this.firstName = firstName;
		this.lastName = null;
		this.username = null;
		this.password = null;
		this.status = '\0';
		this.type = '\0';
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the type
	 */
	public char getType() {
		return type;
	}

	/**
	 * The method allows the user to log out of the system
	 * The Current Account information is cleared
	 */
	public void logOff(){
		
	}
	
	/**
	 * The method allows the user to log into the system
	 * The current user's Account information creates a new Account
	 * object and their detailed information is loaded into the instance variables
	 */
	public void logOn(){
		
	}
	
	/**
	 * This method gets all the details for the Account object
	 * This method acts like a toString method.
	 */
	public String getMembershipDetials(){
		return "Account [firstName=" + firstName + ", lastName=" + lastName + 
				", username=" + username + ", status=" + status + ", type=" + type + "]";
	}
	
	/**
	 * This method displays the correct menu to the user when he or she
	 * logs into the system. Depending on if the user is an admin or student,
	 * They will be brought to their prospective screen
	 * @param t char, The type (admin or user) of the Account object
	 */
	public void displayMenu(char t){
		
	}
	
	/**
	 * This method displays an error message for the user if the Login was 
	 * unsuccessful. This could happen if the User inputs a wrong username or a wrong
	 * password or both.
	 */
	public void displayLoginError(){
		
	}
	
	/**
	 * This method is responsible for displaying the detailed information of 
	 * a university object to the user.
	 */
	public void viewUniversityDetial(){
		
	}

}
