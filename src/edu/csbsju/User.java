
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
	DBController dataBase;
	SearchController searchController;
	
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
		dataBase.getUserSavedSchools(this.getUsername());
	}
	
	/**
	 * displays error if displays fails
	 */
	public void displaySavedSchoolsError()
	{
		System.out.println("There was an error with your saved schools. Please try again.");
	}
	
	/**
	 * saves the schools
	 */
	public void saveSchool(University u)
	{
		dataBase.addUniversityToSavedSchools(u, this);
	}
	/**
	 * edit profile
	 */
	public void editProfile()
	{
		dataBase.editAccount(this.getFirstName(), this.getLastName(), this.getPassword(), this.getType());
	}
	/**
	 * gets the saved schools
	 * @return arrayList of Universities
	 */
	public ArrayList<String> getSavedSchools()
	{
		return dataBase.getUserSavedSchools(this.getUsername());
	}
	/**
	 * removes a saved school
	 * @param u university object
	 */
	public void removeSavedSchool(University u)
	{
		dataBase.removeUniversityFromSavedSchools(u, this);
	}
	/**
	 * displays search results
	 */
	public void displaySearchResults(University u)
	{
		System.out.println(searchController.search(u));
		System.out.println(searchController.display5Schools(u));
	}
	
	/**
	 * displays search error
	 */
	public void displaySearchError()
	{
		System.out.println("There was an error in the search. Please try again.");
	}
}
