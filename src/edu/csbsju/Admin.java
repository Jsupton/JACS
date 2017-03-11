/**
 * 
 */
package edu.csbsju;

/**
 * This class acts as an Administrator object. They are able to perform
 * different functionalities than an User can, thus this class allows 
 * Adminitrator to perform those action.
 * @author cjzins
 * @version 02-26-17
 */
public class Admin extends Account{

	
	/**
	 * this constructor creates an Admin object using the constructor
	 * from Account, which Admin extends
	 * @param firstName the name of an admin
	 * @param lastName the lastname of an admin
	 * @param username the admin's username
	 * @param password the admin's password
	 * @param status the status of the admin
	 * @param type the type of the admin
	 */
	public Admin(String firstName, String lastName, String username, String password, char status, char type) {
		super(firstName, lastName, username, password, type,status);
		// TODO Auto-generated constructor stub
	}

	/**
	 * this constructor creates an Admin object using the constructor
	 * from Account, which Admin extends
	 * @param firstName the name of an admin
	 */
	public Admin(String firstName) {
		super(firstName);
		// TODO Auto-generated constructor stub
	}


	/**
	 * a method to display all of the accounts
	 */
	public void displayAccounts(){
		
	}
	
	/**
	 * displays all of the universities
	 */
	public void displayUniversities(){
		
	}
	
	/**
	 * Sets the status of the account
	 * @param status the status of the account
	 */
	public void setStatus(char status) {
		super.status = status;
	}

	/**
	 * Sets the type of the account
	 * @param firstName the type of the account
	 */
	public void setType(char type) {
		super.type = type;
	}

}
