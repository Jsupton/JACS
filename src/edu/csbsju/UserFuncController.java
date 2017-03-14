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
	public List<University> searchForSchools(String universityName, String state, String location, String control, String numberOfStudentsLOWER,
		 	String numberOfStudentsUPPER, String percentFemaleLOWER, String percentFemaleUPPER, String satVerbalLOWER, String satVerbalUPPER, 
		 	String satMathLOWER, String satMathUPPER, String expensesLOWER, String expensesUPPER, String financialAidLOWER, String financialAidUPPER,  
		 	String numberOfApplicantsLOWER, String numberOfApplicantsUPPER, String percentAdmittedLOWER,String percentAdmittedUPPER, 
		 	String percentEnrolledLOWER,  String percentEnrolledUPPER, String academicScaleLOWER, String academicScaleUPPER, String socialScaleLOWER, 
		 	String socialScaleUPPER, String qualityOfLifeLOWER, String qualityOfLifeUPPER, List<String> emphases){
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
	public void displayStudentDetails()
	{
		u.displayStudent();
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
