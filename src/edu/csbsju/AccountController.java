
package edu.csbsju;

import java.util.*;

import javax.swing.JOptionPane;

/**
 * This Class acts as a controller class for an Account object. This
 * Class does the techinical work and deals with interchanging data
 * in order to follow out a user's command
 * @author jsupton
 * @verson 02-26-17
 */
public class AccountController {

	/**
	 * This is an Account object instance variable
	 */
	private Account a;
	/**
	 * This is a DBController object used to access the Database
	 */
	private DBController d;
	
	 /**
	  * This is a default constructor
	  */
	 public AccountController() {
		 super();
		 this.a = null;
		 this.d = new DBController();
	 }
	 
	 /**
	  * This is a default constructor
	  * @param a Account object parameter 
	  */
	 public AccountController(Account a) {
		 super();
		 this.a = a;
		 this.d = new DBController("jacs","jacs","csci230");
	 }
	 
	 /**
	  * This is a default constructor
	  * @param a Account object parameter 
	  * @param DBCOntroller object
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
						 return a;
					 }
				 }
				 return null;
			 }
			 else{
	    	     JOptionPane.showMessageDialog(null,"Failed Login");
				 return null;
			 }
		 }
		 else{
    	     JOptionPane.showMessageDialog(null,"Failed Login");
    	     return null;
		 }
	 }
	 
	 /**
	  * This method does not take any parameters. It logs the current
	  * Account object out of the system.
	  */
	 public void logOff(){
	  
	 }
	 
	 /**
	  * This method calls the Database and returns a list of all the 
	  * universities for the user to view or for an admin to edit.
	  * @return ArrayList<University> An array list of university objects
	  */
	 public ArrayList<University> getUniversities(){
		 ArrayList<University> l = new ArrayList<University>();
		 l = d.getAllUniversities();
		 return l;
	 }
	 
	 /**
	  * This method displays all of the aspects of all university objects.
	  * It gets all attributes from the university objects and then displays
	  * them on the screen for the user.
	  */
	 public void displayUniversities(){
		 ArrayList<University> a = this.getUniversities();
		 for(University u: a){
			 u.printString();
		 }
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
	  * @param u University object
	  */
	 public void displayUniversity(String name){
		 University u = this.getAUniversity(name);
		 u.printString();
	 }
	 
	 /**
	  * This method allows the user to be able to change Account attributes.
	  * It takes in 3 paramteres, which can contain null values, and uses those
	  * values to update an Account object's attributes
	  * @param p String representing an Account's password
	  * @param ln String representing the Account's last name
	  * @param fn String representing the Account's first name
	  */
	 public void editAccount(String p, String ln, String fn){
		 boolean b = d.editAccount(fn, ln, p);
		 if(b){
			 System.out.println("Successful Change");
		 }
		 else{
			 System.out.println("The Change was unsuccessful");
		 }
	 } 
	 
	 /**
	  * This method is a method that asks the user if they would like to 
	  * continue on making the changes to this Account object, whether it is
	  * a User changing their own account information or an Admin changing
	  * another person's Account information.
	  */
	 public void confirmEdit(){
		 
	 }
	 
	 /**
	  * This method determines if the current account object is active or not
	  * Each account object has an attribute that states whether the Account is
	  * active or deactivated. If the account if Active this method will return 
	  * true, otherwise it will return false.
	  * @return Boolean, true if the Account object is active
	  */
	 public boolean isActive(){
		 if(a.getType() == ('Y'))
			 return true;
		 else
			 return false;
	 }
	 
	 /**
	  * This method if a void method that takes an account object in as a parameter
	  * It uses the account object and changes the status of the Account object to 
	  * deactivated.
	  * @param a Account object
	  */
	 public void deactivate(){
		 char x = a.getStatus();
		 if(x == 'Y')
			 d.deactivate(a);
		 else
			 System.out.println("The Account is already deactivated");
	 }
	 
	 /**
	  * This method takes an Account object as a parameter. The method uses the
	  * Account object and gets the type of that Account object. It acts as a 
	  * transfer method to transfer the Account type to display the correct UI 
	  * for the Account user. The method returns the type of the Account.
	  * @param a Account object
	  * @return char a character representing the type of the Account
	  */
	 public char returnType(){
		 if(a!=null){
		     return a.getType();}
		 else 
			 return '\0';
	 }
	 
	 /**
	  * displays the account
	  * @param args
	  */
	 public Account displayAccount(){
		 return a;
	 }
	 
	 /**
	  * MAIN METHOD
	  * @param args
	  */
	 public static void main(String args[]){
		 Account a = new Account("Jacob","Upton","Jsupton","02101997",'U','Y');
		 AccountController ac = new AccountController(a);
		 a.displayStudent();
		 if(ac.isActive())
			 System.out.println("Active?: TRUE");
		 else
			 System.out.println("Active?: FALSE");
		 ac.displayUniversities();
	 }

}
