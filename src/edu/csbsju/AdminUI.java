package edu.csbsju;

import java.util.*;

/**
 * This class is the UserInterface for an Administrator. This class
 * controls what is displayed to the user at specific points in time.
 * The controller will send data back to this class to display to the Admin.
 * @author cjzins
 * @version 02-26-17
 */
public class AdminUI extends AccountUI{

	/**
	 * a AdminFuncController object instance variable
	 */
	private AdminFuncController adminFunc;
	/**
	 * a DB controller object instance variable
	 */
	private DBController DB;
	
	/**
	 * This default constructor initiates the Admin to null
	 */
	public AdminUI(Admin a) {
		super();
		this.adminFunc = new AdminFuncController(a);
	}
	
	/**
	 * This default constructor initiates the Admin to null
	 */
	public AdminUI() {
		super();
		this.adminFunc = new AdminFuncController();
	}
	
	/**
	 * This constructor initiates the AdminFuncController instance variable
	 * to a specific AdminFuncController object
	 * @param admin AdminFuncController instance variable
	 */
	public AdminUI(AdminFuncController admin) {
		super();
		this.adminFunc = admin;
	}

	/**
	 * This method is used to get all the universities that reside in the database.
	 * This method will call the AdminFuncController.
	 * @return an array list of the universitys
	 */
	public void getUniversities(){
		super.getUniversities();
	 }
	 
	/**
	  * This method is responsible for displaying all of the universities
	  * to the Admin.
	  * @param u an arrayList of University Objects
	  */
	 public void displayUniversities(){
		 super.displayUniversities();
	 }
	 
	 /**
	  * This is a method used to display the accounts of all of the Account
	  * objects that are in the database.
	  */
	 public void displayAccounts(){
		 adminFunc.displayAccounts();
	 }
	 
	 /**
	  * This is a method used to display the accounts of all of the Account
	  * objects that are in the database.
	  */
	 public void getAccounts(){
		 adminFunc.getAccounts();
	 }
	 
	 /**
	  * This method is responsible for adding a specific university to the 
	  * database. It takes a university and updates the database.
	  * @param an university that is being added
	  */
	 public void addUniversity(University u){
		 DB.addUniversity(u);
	 }
	 
	 /**
	  * This method if a void method that takes an account object in as a parameter
	  * It uses the account object and changes the status of the Account object to 
	  * deactivated.
	  * @param a Account object
	  */
	 public void deactivate(){
		 adminFunc.deactivate();
	 }
	 
	 /**
	  * This Method displays all of the information about a specified Account object.
	  * It gathers all of the attributes for an account object and then displays
	  * that information for the user to see
	  */
	 public void viewAccount(String name){
		 DB.findAccount(name);
	 }
	 
}
	
