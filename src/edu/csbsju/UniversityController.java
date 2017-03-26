package edu.csbsju;

/**
 * Class used to manage universities. This class deals with editing and 
 * adding universities to the database. It is also in charge of adding
 * and removing emphases from a university object. It calls a university 
 * instance variable to access a univeristy object and a DBController
 * variable to save the changes to the database
 * @author ajdehn
 * @version 03-21-17
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
	 * Default controller, this controller sets the DBController instance
	 * variable to a new DBController object
	 */
	public UniversityController(){
		this.d = new DBController();
	}
	
	/**
	   * This method allows an admin to be able to add a university object
	   * The changes are sent to the Database to save the changes
	   * @param universityName The name of a university
	   * @param state The state of a university
	   * @param location The location of a university
	   * @param control The control of a university
	   * @param numberOfStudents the number of students at a university
	   * @param percentFemale the percent female of a university
	   * @param satVerbal SAT of a university
	   * @param satMath SAT of a university
	   * @param expenses The Expenses of a university
	   * @param financialAid the Financial aid at a university
	   * @param numberOfApplicants Number of Applicants of a university
	   * @param percentAdmitted The percent admitted of a university
	   * @param percentEnrolled The percent Enrolled of a university
	   * @param academicScale The academic scale of a university
	   * @param socialScale Social scale of a university
	   * @param qualityOfLife Quality of life of a university
	   */
	  public void addUniversity(String universityName, String state, String location, String control, int numberOfStudents,
	                            double percentFemale, int satVerbal, int satMath, double expenses, double financialAid, int numberOfApplicants,
	                            double percentAdmitted, double percentEnrolled, int academicScale, int socialScale, int qualityOfLife){
		  University u = new University(universityName, state, location, control, numberOfStudents, percentFemale, satVerbal, satMath, expenses, financialAid, numberOfApplicants, percentAdmitted, percentEnrolled, academicScale, socialScale, qualityOfLife,null);
		  d.addUniversity(u);
	  }
	
	/**
	 * Allows changes to be made to details of a university. These changes
	 * are then sent to the DBController in order to save them in the Database
	 * @param universityName The name of a university
	   * @param location The location of a university
	   * @param state The state of a university
	   * @param control The control of a university
	   * @param numberOfStudents the number of students at a university
	   * @param percentFemale the percent female of a university
	   * @param satVerbal SAT of a university
	   * @param satMath SAT of a university
	   * @param expenses The Expenses of a university
	   * @param financialAid the Financial aid at a university
	   * @param numberOfApplicants Number of Applicants of a university
	   * @param percentAdmitted The percent admitted of a university
	   * @param percentEnrolled The percent Enrolled of a university
	   * @param academicScale The academic scale of a university
	   * @param socialScale Social scale of a university
	   * @param qualityOfLife Quality of life of a university
	 */
	public void editUniversity(String universityName, String state, String location, String control, int numberOfStudents,
            double percentFemale, int satVerbal, int satMath, double expenses, double financialAid, int numberOfApplicants,
            double percentAdmitted, double percentEnrolled, int academicScale, int socialScale, int qualityOfLife){
		University u = d.getAUniversity(universityName);
		u.editUniversity( universityName, state, location, control, numberOfStudents,
	             percentFemale, satVerbal,  satMath, expenses, financialAid, numberOfApplicants,
	             percentAdmitted, percentEnrolled, academicScale, socialScale, qualityOfLife);
		d.editUniversity(universityName, state, location, control, numberOfStudents,
	             percentFemale, satVerbal,  satMath, expenses, financialAid, numberOfApplicants,
	             percentAdmitted, percentEnrolled, academicScale, socialScale, qualityOfLife);
	}
	
	/**
	   * This adds an emphases for the specified university object.
	   * The parameter string is then added to the University's emphases
	   * @param universityName the name of the university 
	   * @param emphases the emphases desired to added to the university
	   * @return an integer indicating the number of database records 
	   * inserted or -1 if an invalid school name is specified or if 
	   * the specified emphasis already exists for the specified school
	   * */
	  public int addEmphases(String universityName,String emphases ){
		  University u = d.getAUniversity(universityName);
		  u.addEmphases(emphases);
	     return d.addEmphases(universityName, emphases);
	  }
	  
	  /**
	   * This removes an emphases for the specified university object.
	   * The parameter string is then removed to the University's emphases
	   * @param universityName the name of the university 
	   * @param emphases the emphases desired to added to the university
	   * @return an integer indicating the number of database records 
	   * inserted or -1 if an invalid school name is specified or if 
	   * the specified emphasis already exists for the specified school
	   */
	  public int removeEmphases(String universityName,String emphases ){
		University u = d.getAUniversity(universityName);
		u.removeEmphases(emphases);
	    return d.removeEmphases(universityName, emphases);
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
