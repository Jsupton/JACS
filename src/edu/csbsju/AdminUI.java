package edu.csbsju;

import java.util.*;

/**
 * This class is the UserInterface for an Administrator. This class
 * controls what is displayed to the user at specific points in time.
 * The controller will send data back to this class to display to the Admin.
 * @author cjzins
 * @version 02-26-17
 */
public class AdminUI {

	//a variable for admin
	Admin admin;
	
	/**
	 * This default constructor initiates the Admin to null
	 */
	public AdminUI() {
		super();
		this.admin = null;
	}
	
	/**
	 * This constructor initiates the Admin instance variable
	 * to a specific Admin object
	 * @param admin
	 */
	public AdminUI(Admin admin) {
		super();
		this.admin = admin;
	}

	/**
	 * This method is used to get all the universities that reside in the database.
	 * This method will call the AdminFuncController.
	 * @return an array list of the universitys
	 */
	public ArrayList<University> getUniversities(){
		ArrayList<University> u = new ArrayList();
		return u;
	 }
	 
	/**
	  * This method is responsible for displaying all of the universities
	  * to the Admin.
	  * @param u an arrayList of University Objects
	  */
	 public void displayUniversities(ArrayList<University> u){
	  
	 }
	 
	 /**
	  * This is a method used to display the accounts of all of the Account
	  * objects that are in the database.
	  * @return an array list of accounts
	  */
	 public ArrayList<Account> displayAccounts(){
		 ArrayList<Account> a = new ArrayList();
		 return a;
	 }
	 
	 /**
	  * This method is responsible for adding a specific university to the 
	  * database. It takes a university and updates the database.
	  * @param an university that is being added
	  */
	 public void addUniversity(University u){
	  
	 }
	 
	 /**
	  * This method displays an error method. It is used when there is
	  * an error when searching the database.
	  * @return a String representing the error
	  */
	 public String getSearchError(){
	   return null;
	 }
}
	
