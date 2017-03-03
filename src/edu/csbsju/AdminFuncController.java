package edu.csbsju;

import java.util.*;

/**
 * This class is the controller for all the functions of an administrator.
 * This class deals with shifting data and calling the Database, as well
 * as sending data back to the UserInterface to display to the Admin. 
 * @author cjzins
 * @version 02-26-17
 */
public class AdminFuncController extends AccountController {

	/**
	 * a Admin object variable
	 */
	private Admin admin;
	/**
	 * This is a DBController object used to access the Database
	 */
	private DBController d;
		
	/**
	 * This default constructor initiates the Admin to null
	 */
	public AdminFuncController() {
		super();
		this.admin = null;
	}
	
	 /**
	  * This constructor initiates the Admin instance variable
	  * to a specific Admin object
	  * @param admin
	  */
	 public AdminFuncController(Admin admin) {
			super();
			this.admin = admin;
		}
	/**
	  * This method calls on the database and gets all of the accounts that are
	  * in the system. It then returns an arrayList of those accounts
	  * @return an array list of the accounts
	  */
	 public ArrayList getAccounts(){
		 ArrayList<Account> a = new ArrayList();
		 return a;
	 }
	 
	 /**
	  * This is a method used to display the accounts of all of the Account
	  * objects that are in the database.
	  */
	 public void displayAccounts(){

	 }
	 
	 /**
	  * This method calls on the database and gets all of the universities that are
	  * in the system. It then returns an arrayList of those Universities
	  * @return and array list of universities
	  */
	 public ArrayList getUniversities(){
		 ArrayList<University> u = new ArrayList();
		 return u;
	 }
	 
	 /**
	  * This is a method used to display the accounts of all of the University
	  * objects that are in the database.
	  */
	 public void displayUniversities(){
		 
	 }
	 
	 /**
	  * This method if a void method that takes an account object in as a parameter
	  * It uses the account object and changes the status of the Account object to 
	  * deactivated.
	  * @param a Account object
	  */
	 public void deactivate(){
		 d.deactivate(admin);
	 }
	 
	 /**
	  * This method takes a username as a parameter, then searches the database
	  * to find an Account that matches the username. If there is no account that matches
	  * the method returns null, otherwise the method returns the Account object with 
	  * that specified username.
	  * @param u String, a username of an Account
	  * @return Account object
	  */
	 public Account findAccount(String u){
		 Account a = d.findAccount(u);
	  return a;
	 }
	 
	 /**
	  * This Method displays all of the information about a specified Account object.
	  * It gathers all of the attributes for an account object and then displays
	  * that information for the user to see
	  */
	 public void viewAccount(String name){
		 Account a = this.findAccount(name);
		 a.getMembershipDetials();
	 }
	 
	}
