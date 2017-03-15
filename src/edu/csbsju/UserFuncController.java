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
		this.d = new DBController();
		this.s = new SearchController();
	}
	
	/**
	 * constructor creates a user object
	 * @param u user object
	 */
	public UserFuncController(User u) {
		super();
		this.u = u;
		this.d = new DBController();
		this.s = new SearchController();
	}
	
	/**
	 * adds a university to saved schools list
	 * @param uni university object
	 * @return boolean, true if the addition was successful
	 */
	public boolean addUniversityToSavedSchools(University uni)
	{
		return false;
	}
	
	/**
	 * removes university from saved schools list
	 * @param uni university object to remove
	 * @return boolean, true if the removal was successful
	 */
	public boolean removeUniversityFromSavedSchools(University uni)
	{
		return false; 
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
		List<University> x = s.search(universityName, state, location, control, numberOfStudentsLOWER,
			 	numberOfStudentsUPPER, percentFemaleLOWER, percentFemaleUPPER, satVerbalLOWER, satVerbalUPPER, 
			 	satMathLOWER, satMathUPPER, expensesLOWER, expensesUPPER, financialAidLOWER, financialAidUPPER,  
			 	numberOfApplicantsLOWER,numberOfApplicantsUPPER, percentAdmittedLOWER, percentAdmittedUPPER, 
			 	percentEnrolledLOWER, percentEnrolledUPPER, academicScaleLOWER, academicScaleUPPER, socialScaleLOWER, 
			 	socialScaleUPPER, qualityOfLifeLOWER, qualityOfLifeUPPER,emphases);
		return x;
	}
	
	
	/**
	 * view student profile
	 */
	public User displayStudentDetails()
	{
		u.displayStudent();
		return u;
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
	public List<University> getSavedSchools(){
		return null;
	}
	
	/**
	 * gets the 5 matches for the university
	 * @param u university
	 * @return a list of university objects
	 */
	public List<University> getFiveMatches(University u){
		return s.display5Schools(u);
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
