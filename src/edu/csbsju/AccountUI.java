
package edu.csbsju;

import java.util.*;

import javax.swing.JOptionPane;

/**
 * This class is used as a user interface to pass data to the Account Controller
 * and to pass back data to the user. This class deals with displaying information
 * to the User.
 * @author jsupton 
 * @version 03-21-17
 */
public class AccountUI {

	/**
	 * This is an AccountController Object instance variable. Used
	 * to be able to access methods in the Account function controller
	 */
	private AccountController accountFunc;
	
	 /**
	  * Default Constructor. The accountFunc instance variable is set to 
	  * a new AccountController object
	  */
	 public AccountUI() {
		 super();
		 this.accountFunc = new AccountController();
	 }
	 
	 /**
	  * First Constructor. The accountFunc instance variable is set to
	  * a new account controller object that uses the Account parameter
	  * @param a Account object
	  */
	 public AccountUI(Account a) {
		 super();
		 this.accountFunc = new AccountController(a);
	 }
	 
	 /**
	  * Second Constructor. The accountFunc instance variable is set to
	  * the AccountController parameter 
	  * @param a AccountController parameter
	  */
	 public AccountUI(AccountController a) {
		 super();
		 this.accountFunc = a;
	 }
	 
	 /**
	  * This method takes a username and a password as String parameters
	  * and uses them to log the Account object into the system
	  * @param u String, a username for the Account object
	  * @param p String, a password for the Account object
	  * @return an account object of the user signing in. This is null
	  * if no user was found with the username and password combination
	  */
	 public Account logOn(String u, String p){
		 Account a = accountFunc.logOn(u,p);
		 if(a != null){
			 JOptionPane.showMessageDialog(null,"Successful Login");
		 }
		 else
			 JOptionPane.showMessageDialog(null,"Unsuccessful Login");
		 return a;
	 }
	 
	 /**
	  * This method takes an Account object as a parameter. The method uses the
	  * Account object and gets the type of that Account object. It acts as a 
	  * transfer method to transfer the Account type to display the correct UI 
	  * for the Account user. The method returns the type of the Account.
	  * @return char a character representing the type of the Account
	  */
	 public char returnType(){
		 return accountFunc.returnType();
	 }
	 
	 /**
	  * This method does not take any parameters. It logs the current
	  * Account object out of the system.
	  */
	 public void logout(){
	    accountFunc.logOff();
	 }
	 
	 /**
	  * This method takes a university name as a parameter and uses that
	  * to search the database and then it returns either null if the university
	  * was not found in the system, or it creates a university object out of the
	  * the specified information
	  * @param name String, a name of a university
	  * @return University a university object
	  */
	 public University getAUniversity(String name){
		 University u = accountFunc.getAUniversity(name);
		 return u;
	 }
	 
	 /**
	  * This method displays all of the aspects of a given university object.
	  * It gets all attributes from the university object and then displays
	  * those on the screen for the user.
	  * @param name University object
	  */
	 public void displayUniversity(String name){
		 accountFunc.displayUniversity(name);
	 }
	 
	 /**
	  * This method is a method that asks the user if they would like to 
	  * continue on making the changes to this Account object, whether it is
	  * a User changing their own account information or an Admin changing
	  * another person's Account information.
	  * @return a boolean. True if the user confirms the edit they are about 
	  * to perform
	  */
	 public boolean confirmEdit(){
		 return accountFunc.confirmEdit();
	 }
	 
	 /**
	  * displays the current account object
	  * @return an account object representing the current object
	  */
	 public Account displayAccount(){
		 Account a = accountFunc.displayAccount();
		 return a;
	 }

}
