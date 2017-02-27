/**
 * 
 */
package edu.csbsju;

import java.util.ArrayList;

/**
 * @author saschmidgall
 *
 */
public class UserUI {

	/**
	 * default constructor for a user interface
	 */
	public UserUI() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * allows user to logon
	 * @param u string representing username
	 * @param p string representing password
	 */
	public void logon(String u, String p)
	{
		
	}
	/**
	 * gets the student profile
	 * @return user object of student
	 */
	public User getStudentProfile()
	{
		return null;	
	}
	/**
	 * display student details
	 * @param name string representing name of student
	 */
	public void displayStudentDetails(String name)
	{
		
	}
	/**
	 * searches for a users universities
	 * @param u university object
	 * @return list of users saved schools
	 */
	public ArrayList<University> search(University u)
	{
		return null;
	}
	/**
	 * gets the saved schools
	 * @param u user object
	 * @return list of saved schools
	 */
	public ArrayList<University> getSavedSchools(User u)
	{
		return null;
	}
	/**
	 * displays the searched universities
	 * @param alu an arrayList of Universities
	 * @return arrayList of universities
	 */
	public ArrayList<University> displaySearchedUniversities(ArrayList<University> alu)
	{
		return null;
	}
	/**
	 * gets the error if search fails
	 * @return string representing error
	 */
	public String getSearchError()
	{
		return null;
	}
	/**
	 * edits the student profile
	 * @param u user to edit
	 */
	public void editStudentProfile(User u)
	{
		
	}
	/**
	 * displays the error if display schools fails
	 */
	public void displaySavedSchoolsError()
	{
		
	}
	/**
	 * saves the user schools
	 * @param u user object
	 * @param uni school to save
	 */
	public void saveUserSchool(User u, University uni)
	{
	
	}
}
