/**
 * 
 */
package edu.csbsju;

import java.util.ArrayList;
import java.util.List;

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
	public List<University> searchForSchools(String universityName, String state, String location, String control, String numberOfStudentsLOWER,
		 	String numberOfStudentsUPPER, String percentFemaleLOWER, String percentFemaleUPPER, String satVerbalLOWER, String satVerbalUPPER, 
		 	String satMathLOWER, String satMathUPPER, String expensesLOWER, String expensesUPPER, String financialAidLOWER, String financialAidUPPER,  
		 	String numberOfApplicantsLOWER, String numberOfApplicantsUPPER, String percentAdmittedLOWER,String percentAdmittedUPPER, 
		 	String percentEnrolledLOWER,  String percentEnrolledUPPER, String academicScaleLOWER, String academicScaleUPPER, String socialScaleLOWER, 
		 	String socialScaleUPPER, String qualityOfLifeLOWER, String qualityOfLifeUPPER, List<String> emphases){
		List<University> x = userFunc.searchForSchools(universityName, state, location, control, numberOfStudentsLOWER,
			 	numberOfStudentsUPPER, percentFemaleLOWER, percentFemaleUPPER, satVerbalLOWER, satVerbalUPPER, 
			 	satMathLOWER, satMathUPPER, expensesLOWER, expensesUPPER, financialAidLOWER, financialAidUPPER,  
			 	numberOfApplicantsLOWER,numberOfApplicantsUPPER, percentAdmittedLOWER, percentAdmittedUPPER, 
			 	percentEnrolledLOWER, percentEnrolledUPPER, academicScaleLOWER, academicScaleUPPER, socialScaleLOWER, 
			 	socialScaleUPPER, qualityOfLifeLOWER, qualityOfLifeUPPER,emphases);
		return x;
	}
	
	/**
	 * gets the saved schools
	 */
	public void getSavedSchools()
	{
	
	}
	
	/**
	 * gets the 5 matches for the university
	 * @param u university
	 * @return a list of university objects
	 */
	public List<University> getFiveMatches(University u){
		return userFunc.getFiveMatches(u);
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
