/**
 * 
 */
package edu.csbsju;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is the UserInterface for a User. It allows
 * The user to interact with the interface in order to call
 * the Controller classes to make a desired task happen
 * @author saschmidgall
 * @version 03-21-17
 */
public class UserUI extends AccountUI{

	/**
	 * This is a UserFuncController instance variable. This instance variable
	 * is used in order to access the functions in the UnserFuncController Class
	 */
	private UserFuncController userFunc;
	
	/**
	 * default constructor for a user interface. It sets the UserFuncController
	 * variable to a new UserFuncController.
	 */
	public UserUI() {
		super();
		this.userFunc = new UserFuncController();
	}
	
	/**
	 * First constructor for a user interface. It sets the UserFuncController
	 * variable to a new UserFuncController using the user parameter object as
	 * a parameter.
	 * @param u A user object
	 */
	public UserUI(User u) {
		super();
		this.userFunc = new UserFuncController(u);
	}
	
	/**
	 * Second constructor for a user interface. Uses the UserFuncController parameter 
	 * to set the Instance variable.
	 * @param u UserFuncController object parameter 
	 */
	public UserUI(UserFuncController u) {
		super();
		this.userFunc = u;
	}
	
	/**
	 * allows user to logon, it takes in a username and a password and then 
	 * calls the logon function in the Account class
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
	 * @return a user object to display
	 */
	public User displayStudentDetails()
	{
		return userFunc.displayStudentDetails();
	}
	
	/**
	 * searches for a users universities. This function takes in all attributes of 
	 * a university (with some extra specifying upper and lower bound for all of the 
	 * attributes that are integers or doubles) and then uses those to search for universities
	 * that match the criteria.
	 * @param universityName Univeristy name
	 * @param state university state
	 * @param location location of the university
	 * @param control control of the university
	 * @param numberOfStudentsLOWER lower bound number of students
	 * @param numberOfStudentsUPPER upper bound number of students
	 * @param percentFemaleLOWER lower bound percent female
	 * @param percentFemaleUPPER upper bound percent female
	 * @param satVerbalLOWER lower bound verbal sat score
	 * @param satVerbalUPPER upper bound verbal sat score
	 * @param satMathLOWER lower bound math sat score
	 * @param satMathUPPER upper bound math sat
	 * @param expensesLOWER lower bound expenses
	 * @param expensesUPPER upper bound expenses
	 * @param financialAidLOWER lower bound financial aid
	 * @param financialAidUPPER upper bound financial aid
	 * @param numberOfApplicantsLOWER lower bound number of applicants
	 * @param numberOfApplicantsUPPER upper bound number of applicants
	 * @param percentAdmittedLOWER percent admitted lower
	 * @param percentAdmittedUPPER percent admitted upper
	 * @param percentEnrolledLOWER percent enrolled lower
	 * @param percentEnrolledUPPER percent enrolled upper
	 * @param academicScaleLOWER academic scale lower
	 * @param academicScaleUPPER academic scale upper
	 * @param socialScaleLOWER social scale lower
	 * @param socialScaleUPPER social scale upper
	 * @param qualityOfLifeLOWER quality of life lower
	 * @param qualityOfLifeUPPER quality of life upper
	 * @param emphases list of emphases
	 * @return A list of university objects that meet the criteria
	 */
	public List<University> searchForSchools(String universityName, String state, String location, String control, int numberOfStudentsLOWER,
		 	int numberOfStudentsUPPER, double percentFemaleLOWER, double percentFemaleUPPER, int satVerbalLOWER, int satVerbalUPPER, 
		 	int satMathLOWER, int satMathUPPER, double expensesLOWER, double expensesUPPER, double financialAidLOWER, double financialAidUPPER,  
		 	double numberOfApplicantsLOWER, int numberOfApplicantsUPPER, double percentAdmittedLOWER,double percentAdmittedUPPER, 
		 	double percentEnrolledLOWER,  double percentEnrolledUPPER, int academicScaleLOWER, int academicScaleUPPER, int socialScaleLOWER, 
		 	int socialScaleUPPER, int qualityOfLifeLOWER, int qualityOfLifeUPPER, List<String> emphases){
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
	 * @return List<University> a list of the student's saved schools
	 */
	public List<String> getSavedSchools()
	{
		return userFunc.getSavedSchools();
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
	 * Allows the current user to edit their profile. The can choose to edit their first name,
	 * last name, or password. The three parameter values are the new value for the user. If a value 
	 * if left null, the old value is kept.
	 * @param firstName the first name of the user
	 * @param lastName the last name of the user
	 * @param password the password for the user's account
	 */
	public void editStudentProfile(String firstName, String lastName, String password)
	{
		userFunc.editStudentProfile(firstName, lastName, password);
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
	 * @return boolean, true if the addition was successful
	 */
	public boolean addUniversityToSavedSchools(String uni)
	{
		userFunc.addUniversityToSavedSchools(uni);
		return true;
	}
	
	/**
	 * removes university from saved schools list
	 * @param uni university object to remove
	 * @return boolean, true if the removal was successful
	 */
	public boolean removeUniversityFromSavedSchools(String uni)
	{
		userFunc.removeUniversityFromSavedSchools(uni);
		return true;
	}
}
