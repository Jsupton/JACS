package edu.csbsju;

/**
 * Class used to manage universities
 * @author ajdehn
 * @version 02-26-17
 */
public class UniversityController {
	
	/**
	 * This instance variable represents a university object
	 */
	private University university;
	
	/**
	 * This is a DBController object used to access the Database
	 */
	private DBController d;
	
	
	/**
	 * Adds a university to the database
	 * @param u New University to be added to the database
	 */
	public void addUniversity(University u)
	{
		d.addUniversity(u);
	}
	
	/**
	 * Allows changes to be made to details of a university
	 * @param u University to be edited
	 */
	public void editUniversity(University u)
	{
		d.editUniversity(u);
	}
	
	/**
	 * Shows details of a university
	 * @param u University object requested
	 */
	public void displayUniversity(University u)
	{
		u.printString();
	}
	
}
