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
	private DBController d;
	
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
		this.firstName = firstName;
		 this.lastName = lastName;
		 this.username = username;
		 this.password = password;
		 this.status = status;
		 this.type = type;
		 this.d= new DBController();
	}

	/**
	 * this constructor creates an Admin object using the constructor
	 * from Account, which Admin extends
	 * @param firstName the name of an admin
	 */
	public Admin(String firstName) {
		super(firstName);
		this.firstName = firstName;
		this.lastName = null;
		  this.username = null;
		  this.password = null;
		  this.status = '\0';
		  this.type = '\0';
		  this.d= new DBController();
				
	}


	/**
	 * a method to display all of the accounts
	 */
	public void displayAccounts(){
		
		System.out.println(d.getAccounts())
	}
	
	/**
	 * displays all of the universities
	 */
	public void displayUniversities(){
		System.out.println(d.getAllUniversities())
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
