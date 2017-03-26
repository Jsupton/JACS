
package edu.csbsju;

import java.util.*;

/**
 * This class acts as an Administrator object. They are able to perform
 * different functionalities than an User can, thus this class allows 
 * Adminitrator to perform those action.
 * @author cjzins
 * @version 03-21-17
 */
public class Admin extends Account{
	
	/**
	 * This instance variable represents the status of an Admin
	 */
	private char status;
	/**
	 * This instance variable represents the type of an Admin
	 */
	private char type;
  
 /**
  * this constructor creates an Admin object using the constructor
  * from Account, which Admin extends. Also sets the status and type instance
  * variables to the corresponding values so they can be changed later
  * @param firstName the name of an admin
  * @param lastName the lastname of an admin
  * @param username the admin's username
  * @param password the admin's password
  * @param status the status of the admin
  * @param type the type of the admin
  */
 public Admin(String firstName, String lastName, String username, String password, char status, char type) {
  super(firstName, lastName, username, password, type,status);
  this.status = status;
  this.type = type;
 }

 /**
  * this constructor creates an Admin object using the constructor
  * from Account, which Admin extends. This constructor only uses a username
  * and then creates an admin from that. Sets status and type to null values
  * @param userName the name of an admin
  */
 public Admin(String userName) {
    super(userName);    
    this.status = '\0';
    this.type = '\0';
 }
 
 /**
  * This method sets the status character to the parameter value
  * @param s character indicating the status of the user
  */
 public void setStatus(char s){
	 this.status = s;
 }
 
 /**
  * This method sets the type character to the parameter value
  * @param t character indicating the type of the user
  */
 public void setType(char t){
	 this.type = t;
 }
 
 /**
  * This method is used to edit the account. It takes all attributes of an account
  * object in as parameters and then, using the username as a key, it finds the right account
  * object in the database and then updates it
  * @param firstname the firstname of the account
  * @param lastname the lastname of the account
  * @param username the username of the account
  * @param password the password of the account
  * @param type the type of the account
  * @param status the status of the account
  */
 public void editAccount(String firstname, String lastname, String username, String password, char type, char status){
		 this.setFirstName(firstname);
		 this.setLastName(lastname);
		 this.setPassword(password);
		 this.setType(type);
		 this.setStatus(status);
		 
	 }
 
 /**
  * This method is used to add a new the account. It takes in all attributes
  * of an account object and then uses those to create a new account. This method
  * will fail if an account already exists with the same username
  * @param firstname the firstname of the new account
  * @param lastname the lastname of the new account
  * @param username the username of the new account
  * @param password the password of the new account
  * @param type the type of the new account
  * @param status the status of the new account
  * @return a new Account object
  */
 public Account addAccount(String firstname, String lastname, String username, String password, char type, char status){
	 Account a = new Account(firstname,lastname,username,password,type,status);
	 return a;
 }
 
 /**
  * TEST MAIN METHOD. This main method has been used to ensure that the 
  * methods in this call alone work and perform their function correctly 
  * @param args this is parameter value for the main method
  */
 public static void main(String args[]){
	 Admin a = new Admin("Jacob","Upton","Jsupton","114179",'a','Y');
	 a.displayStudent();
 }
}