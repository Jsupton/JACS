
package edu.csbsju;

import java.util.ArrayList;

/**
 * This class acts as a User object. They are able to perform
 * different functionalities than an Admin can, thus this class allows 
 * User to perform those action.
 * @author saschmidgall
 * @version 03-21-17
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
	}

	/**
	 * this constructor creates an user object using the constructor
	 * from User, which user extends
	 * @param firstName the name of a user to create a new User object
	 */
	public User(String firstName) {
		super(firstName);
	}

	/**
	 * displays details of student
	 */
	public String displayStudent()
	{
		return super.displayStudent();
	}
	
	/**
	 * displays error if displays fails. If there is an error in getting the saved
	 * Schools of a User, then this error is displayed
	 */
	public void displaySavedSchoolsError()
	{
		System.out.println("There are no saved Schools in your Saved Schools List.");
	}
	
	/**
	 * displays search error. If there is an error in searching, then this error
	 * is displayed to the user.
	 */
	public void displaySearchError()
	{
		System.out.println("No schools were found. Please try again.");
	}
	
	/**
	 * Allows the current user to edit their profile. The can choose to edit their first name,
	 * last name, or password. The three parameter values are the new value for the user. If a value 
	 * if left null, the old value is kept.
	 * @param firstName the first name of the user
	 * @param lastName the last name of the user
	 * @param password the password for the user's account
	 */
	public void editStudentProfile(String firstName, String lastName, String password)
	{
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPassword(password);
	}
}
