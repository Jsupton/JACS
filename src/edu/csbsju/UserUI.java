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
	public User displayStudentDetails()
	{
		return userFunc.displayStudentDetails();
	}
	
	/**
	 * searches for a users universities
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
	 * edits the student profile
	 */
	public void editStudentProfile()
	{
		userFunc.editStudentProfile();
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
	public boolean addUniversityToSavedSchools(University uni)
	{
		userFunc.addUniversityToSavedSchools(uni);
		return true;
	}
	
	/**
	 * removes university from saved schools list
	 * @param uni university object to remove
	 * @return boolean, true if the removal was successful
	 */
	public boolean removeUniversityFromSavedSchools(University uni)
	{
		userFunc.removeUniversityFromSavedSchools(uni);
		return true;
	}
}
