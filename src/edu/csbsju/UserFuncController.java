package edu.csbsju;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the controller for all the functions of a User.
 * This class deals with shifting data and calling the Database, as well
 * as sending data back to the UserInterface to display to the User.
 * @author saschmidgall
 * @version 02-26-17
 */
public class UserFuncController {

	/**
	 * This instance variable is a User object. This is used to access
	 * methods inside of the User class
	 */
	 private User u;
	 /**
	  * This instance variable is a DatabaseController Object. Used to access
	  * the DBController in order to make edits to the Database
	  */
	 private DBController d;
	 /**
	  * searchController instance variable. This used in order to allow
	  * the user to search.
	  */
	 private SearchController s;
	 
	
	/**
	 * default constructor, Sets the user instance variable to null, and then
	 * sets the DBController and SearchController instance variables to new
	 * objects.
	 */
	public UserFuncController() {
		super();
		this.u = null;
		this.d = new DBController();
		this.s = new SearchController();
	}
	
	/**
	 * constructor creates a user object. Uses the user object in the parameter
	 * to set it to the user instance variable. then
	 * sets the DBController and SearchController instance variables to new
	 * objects.
	 * @param u user object
	 */
	public UserFuncController(User u) {
		super();
		this.u = u;
		this.d = new DBController();
		this.s = new SearchController();
	}
	
	/**
	 * adds a university to saved schools list.
	 * @param uni university object
	 * @return boolean, true if the addition was successful
	 */
	public boolean addUniversityToSavedSchools(String uni)
	{
		 d.addUniversityToSavedSchools(uni,u.getUsername());
		 return true;
	}
	
	/**
	 * removes university from saved schools list.
	 * @param uni university object to remove
	 * @return boolean, true if the removal was successful
	 */
	public boolean removeUniversityFromSavedSchools(String uni)
	{
		d.removeUniversityFromSavedSchools(uni,u.getUsername());
		return true; 
	}
	
	/**
	 * searches for a users universities. Given the set of parameter values, this method
	 * Calls the search method in the SearchController and which returns a list of schools
	 * that satisfy the search criteria. 
	 * @param universityName University name
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
		List<University> x = s.search(universityName, state, location, control, numberOfStudentsLOWER,
			 	numberOfStudentsUPPER, percentFemaleLOWER, percentFemaleUPPER, satVerbalLOWER, satVerbalUPPER, 
			 	satMathLOWER, satMathUPPER, expensesLOWER, expensesUPPER, financialAidLOWER, financialAidUPPER,  
			 	numberOfApplicantsLOWER,numberOfApplicantsUPPER, percentAdmittedLOWER, percentAdmittedUPPER, 
			 	percentEnrolledLOWER, percentEnrolledUPPER, academicScaleLOWER, academicScaleUPPER, socialScaleLOWER, 
			 	socialScaleUPPER, qualityOfLifeLOWER, qualityOfLifeUPPER,emphases);
		if(x.size()<1){
			u.displaySearchError();
		}
		return x;
	}
	
	
	/**
	 * view/displays a user profile
	 * @return a user object
	 */
	public User displayStudentDetails()
	{
		u.displayStudent();
		return u;
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
		d.editAccount(u.getUsername(),firstName,lastName,password,u.getType(), u.getStatus());
		u.editStudentProfile(firstName,lastName,password);
	}
	
	/**
	 * Displays the names of the schools in the student's saved schools
	 * @return A list of strings containing the names of the saved schools for the student
	 */
	public List<String> getSavedSchools(){
		List<String> x = d.getUserSavedSchools(u.getUsername());
		if(x.size()<1){
			u.displaySavedSchoolsError();
		}
		return x;
	}
	
	/**
	 * gets the 5 matches for the university
	 * @param u university
	 * @return a list of university objects
	 */
	public List<University> getFiveMatches(University u){
		return s.display5Schools(u);
	}
	
}
