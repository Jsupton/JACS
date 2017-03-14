
package edu.csbsju;

import java.util.ArrayList;

/**
 * This class acts as a User object. They are able to perform
 * different functionalities than an Admin can, thus this class allows 
 * User to perform those action.
 * @author saschmidgall
 * @version 02-26-17
 */
public class User extends Account {

	
	/**
	 * this constructor creates an user object using the constructor
	 * from User, which user extends
	 * @param firstName the name of an admin
	 * @param lastName the lastname of an admin
	 * @param username the admin's username
	 * @param password the admin's password
	 * @param status the status of the admin
	 * @param type the type of the admin
	 */
	public User(String firstName, String lastName, String username, String password, char status, char type) {
		super(firstName, lastName, username, password, type, status);
		// TODO Auto-generated constructor stub
	}

	/**
	 * this constructor creates an user object using the constructor
	 * from User, which user extends
	 * @param firstName
	 */
	public User(String firstName) {
		super(firstName);
	}

	/**
	 * displays details of student
	 * @param name string name of student to display
	 */
	public void displayStudent()
	{
		super.displayStudent();
	}
	
	/**
	 * displays schools saved
	 * @param name String representing student name
	 */
	public void displaySavedSchools(String name)
	{
		
	}
	
	
	/**
	 * displays search results
	 */
	public void displaySearchResults()
	{
		
	}
	
	/**
	 * displays search error
	 */
	public void displaySearchError()
	{
		
	}
}
