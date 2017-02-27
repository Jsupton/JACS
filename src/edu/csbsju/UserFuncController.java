package edu.csbsju;
import java.util.ArrayList;

/**
 * @author saschmidgall
 * @version 02-26-17
 */
public class UserFuncController {

	//@param u user object
	User u;
	
	/**
	 * default constructor
	 */
	public UserFuncController() {
		super();
		this.u = null;
	}
	
	/**
	 * constructor creates a user object
	 * @param u user object
	 */
	public UserFuncController(User u) {
		super();
		this.u = u;
	}
	
	/**
	 * adds a university to saved schools list
	 * @param uni university object
	 * @param u user object
	 */
	public void addUniversityToSavedSchools(University uni, User u)
	{
		
	}
	
	/**
	 * removes university from saved schools list
	 * @param uni university object to remove
	 * @param u user object to remove from
	 */
	public void removeUniversityFromSavedSchools(University uni, User u)
	{
		
	}
	
	/**
	 * searches for a school
	 * @param uni university to search for
	 * @return arraylist of universities
	 */
	public ArrayList<University> searchForSchools(University uni)
	{
		return null;
	}
	
	/**
	 * view university details
	 * @param u university to view
	 */
	public void viewUniversityDetails(University u)
	{
		
	}
	
	/**
	 * view student profile
	 * @param u user object to view
	 */
	public void viewStudentProfile(User u)
	{
		
	}
	
	/**
	 * edit a student profile	
	 * @param u user to edit
	 */
	public void editStudentProfile(User u)
	{
		
	}
	
	/**
	 * Displays the student's saved schools
	 * @param u user to view saved schools
	 */
	public void viewSavedSchools(User u){
		
	}
	
}
