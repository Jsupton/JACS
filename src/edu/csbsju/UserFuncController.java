package edu.csbsju;
import java.util.ArrayList;

/**
 * This class is the controller for all the functions of a User.
 * This class deals with shifting data and calling the Database, as well
 * as sending data back to the UserInterface to display to the User.
 * @author saschmidgall
 * @version 02-26-17
 */
public class UserFuncController extends AccountController {

	/**
	 * This instance variable is a User object
	 */
	 private User u;
	 /**
	  * This instance variable is a DatabaseController Object
	  */
	 private DBController d;
	 /**
	  * searchController instance varibale
	  */
	 private SearchController s;
	
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
	 */
	public void addUniversityToSavedSchools(University uni)
	{
		
	}
	
	/**
	 * removes university from saved schools list
	 * @param uni university object to remove
	 */
	public void removeUniversityFromSavedSchools(University uni)
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
	 * view student profile
	 */
	public void displayStudentDetails()
	{
		
	}
	
	/**
	 * edit a student profile	
	 */
	public void editStudentProfile()
	{
		
	}
	
	/**
	 * Displays the student's saved schools
	 */
	public void getSavedSchools(){
		
	}
	
	/**
	 * prints the error if search fails
	 */
	public void getSearchError()
	{
		System.out.println("There was an error while searching.");
	}
	
	/**
	 * displays the error if display schools fails
	 */
	public void displaySavedSchoolsError()
	{
		
	}
	
}
