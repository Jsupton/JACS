
package edu.csbsju;

import java.util.*;

import javax.swing.JOptionPane;

/**
 * This Class acts as a controller class for an Account object. This
 * Class does the techinical work and deals with interchanging data
 * in order to follow out a user's command
 * @author jsupton
 * @version 03-21-17
 */
public class AccountController {

	/**
	 * This is an Account object instance variable, used to 
	 * keep track of the current account object
	 */
	private Account a;
	/**
	 * This is a DBController object used to access the Database
	 */
	private DBController d;
	
	 /**
	  * This is a default constructor, sets the account object to
	  * null and creates a new DBController object
	  */
	 public AccountController() {
		 super();
		 this.a = null;
		 this.d = new DBController();
	 }
	 
	 /**
	  * This is the first constructor. It takes in an account object 
	  * and sets that parameter to the account instance variable.
	  * @param a Account object parameter 
	  */
	 public AccountController(Account a) {
		 super();
		 this.a = a;
		 this.d = new DBController("jacs","jacs","csci230");
	 }
	 
	 /**
	  * This is a Second constructor, it takes both an account object
	  * and a databaseController object in as parameters and then sets them
	  * to their corresponding instance variable
	  * @param a Account object parameter 
	  * @param d DBController object
	  */
	 public AccountController(Account a, DBController d) {
		 super();
		 this.a = a;
		 this.d = d;
	 }
	 
	 /**
	  * This method takes a username and a password as String parameters
	  * and uses them to log the Account object into the system
	  * @param u String, a username for the Account object
	  * @param p String, a password for the Account object
	  * @return an account object for the account being logged in. This is
	  * null if there is no account found.
	  */
	 public Account logOn(String u, String p){
		 boolean b = d.checkUsername(u);
		 if(b){
			 String p2 = d.findPassword(u);
			 if(p.equals(p2)){
				 ArrayList<Account> l = d.getAccounts();
				 for(Account x:l){
					 if(x.getUsername().equals(u)){
						 this.a = x;
						 boolean active = a.isActive();
						 if(active){
							 a.logOn(a);
							 return a;}
						 else
							 return null;
					 }
				 }
				 return null;
			 }
			 else{
				 return null;
			 }
		 }
		 else{
    	     return null;
		 }
	 }
	 
	 /**
	  * This method does not take any parameters. It logs the current
	  * Account object out of the system.
	  */
	 public void logOff(){
		 a.logOff();
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
		 University u = d.getAUniversity(name);
		 return u;
	 }
	 
	 /**
	  * This method displays all of the aspects of a given university object.
	  * It gets all attributes from the university object and then displays
	  * those on the screen for the user.
	  * @param name University object
	  */
	 public void displayUniversity(String name){
		 University u = this.getAUniversity(name);
		 u.printString();
	 }
	 
	 /**
	  * This method is a method that asks the user if they would like to 
	  * continue on making the changes to this Account object, whether it is
	  * a User changing their own account information or an Admin changing
	  * another person's Account information.
	  * @return boolean, if it is confirmed it is true
	  */
	 public boolean confirmEdit(){
		  String answer = JOptionPane.showInputDialog("Are You sure you want to confirm change? (Y/N)");
		  if(answer == "y"|| answer == "Y"){
			  return true;
		  }
		  else{
			  JOptionPane.showMessageDialog(null,"The changes were not saved");
			  return false;
		  }
	 }
	 
	 /**
	  * This method determines if the current account object is active or not
	  * Each account object has an attribute that states whether the Account is
	  * active or deactivated. If the account if Active this method will return 
	  * true, otherwise it will return false.
	  * @return Boolean, true if the Account object is active
	  */
	 public boolean isActive(){
		 return a.isActive();
	 }
	 
	 
	 /**
	  * This method takes an Account object as a parameter. The method uses the
	  * Account object and gets the type of that Account object. It acts as a 
	  * transfer method to transfer the Account type to display the correct UI 
	  * for the Account user. The method returns the type of the Account.
	  * @return char a character representing the type of the Account
	  */
	 public char returnType(){
		 return a.returnType();
	 }
	 
	 /**
	  * gets the account instance variable that is in this controller and 
	  * returns that to the UI to be used.
	  * @return An account object
	  */
	 public Account displayAccount(){
		 return a;
	 }
	 
	 /**
	  * MAIN METHOD, this is used to test the function of the methods
	  * in this individual class ALONE
	  * @param args parameter for the main method
	  */
	 public static void main(String args[]){
		 Account a = new Account("Jacob","Upton","Jsupton","02101997",'U','Y');
		 AccountController ac = new AccountController(a);
		 a.displayStudent();
		 if(ac.isActive())
			 System.out.println("Active?: TRUE");
		 else
			 System.out.println("Active?: FALSE");
	 }

}
