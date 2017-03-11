/**
 * 
 */
package edu.csbsju;

import java.util.ArrayList;

/**
 * @author saschmidgall
 *
 */
public class UserUI extends AccountUI{

	/**
	 * This is a UserFuncController instance variable
	 */
	private UserFuncController userFunc;
	
	/**
	 * default constructor for a user interface
	 */
	public UserUI() {
		super();
		this.userFunc = new UserFuncController();
	}
	
	/**
	 * default constructor for a user interface
	 */
	public UserUI(User u) {
		super();
		this.userFunc = new UserFuncController(u);
	}
	
	/**
	 * default constructor for a user interface
	 * @param u UserFuncController object parameter 
	 */
	public UserUI(UserFuncController u) {
		super();
		this.userFunc = u;
	}
	
	/**
	 * allows user to logon
	 * @param u string representing username
	 * @param p string representing password
	 */
	public Account logOn(String u, String p)
	{
		Account b = super.logOn(u,p);
		return b;
	}
	
	/**
	 * display student details
	 */
	public void displayStudentDetails()
	{
		userFunc.displayStudentDetails();
	}
	
	/**
	 * searches for a users universities
	 * @param u university object
	 */
	public void searchForSchools(University u)
	{
		
	}
	
	/**
	 * gets the saved schools
	 */
	public void getSavedSchools()
	{
	
	}
	
	/**
	 * edits the student profile
	 */
	public void editStudentProfile()
	{
		
	}
	
	/**
	 * displays the error if display schools fails
	 * @param name the name of a university
	 */
	public void viewUniversityDetials(String name)
	{
		super.displayUniversity(name);
	}
	
	/**
	 * saves the user schools
	 * @param uni school to save
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
}
