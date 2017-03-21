
package edu.csbsju;

import java.util.*;

/**
 * This class acts as an Administrator object. They are able to perform
 * different functionalities than an User can, thus this class allows 
 * Adminitrator to perform those action.
 * @author cjzins
 * @version 02-26-17
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
  this.status = status;
  this.type = type;
 }

 /**
  * this constructor creates an Admin object using the constructor
  * from Account, which Admin extends
  * @param firstName the name of an admin
  */
 public Admin(String firstName) {
    super(firstName);    
    this.status = '\0';
    this.type = '\0';
 }
 
 /**
  * This method sets the status character to the parameter value
  * @param a character indicating the status of the user
  */
 public void setStatus(char s){
	 this.status = s;
 }
 
 /**
  * This method sets the type character to the parameter value
  * @param a character indicating the type of the user
  */
 public void setType(char t){
	 this.type = t;
 }
 
 /**
  * TEST MAIN METHOD 
  * @param args
  */
 public static void main(String args[]){
	 Admin a = new Admin("Jacob","Upton","Jsupton","114179",'a','Y');
	 a.displayStudent();
 }
}