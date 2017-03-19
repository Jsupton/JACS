package edu.csbsju;

import java.util.*;

/**
 * This class is the UserInterface for an Administrator. This class
 * controls what is displayed to the user at specific points in time.
 * The controller will send data back to this class to display to the Admin.
 * @author cjzins
 * @version 02-26-17
 */
public class AdminUI extends AccountUI{

	/**
	 * a AdminFuncController object instance variable
	 */
	private AdminFuncController adminFunc;
	/**
	 * a DB controller object instance variable
	 */
	private DBController DB;
	
	/**
	 * This default constructor initiates the Admin to null
	 */
	public AdminUI(Admin a) {
		super();
		this.adminFunc = new AdminFuncController(a);
	}
	
	/**
	 * This default constructor initiates the Admin to null
	 */
	public AdminUI() {
		super();
		this.adminFunc = new AdminFuncController();
	}
	
	/**
	 * This constructor initiates the AdminFuncController instance variable
	 * to a specific AdminFuncController object
	 * @param admin AdminFuncController instance variable
	 */
	public AdminUI(AdminFuncController admin) {
		super();
		this.adminFunc = admin;
	}

	/**
	 * This method is used to get all the universities that reside in the database.
	 * This method will call the AdminFuncController.
	 * @return an array list of the universitys
	 */
	public ArrayList<University> getUniversities(){
		return super.getUniversities();
	 }
	 
	/**
	  * This method is responsible for displaying all of the universities
	  * to the Admin.
	  * @param u an arrayList of University Objects
	  */
	 public void displayUniversities(){
		 super.displayUniversities();
	 }
	 
	 /**
	  * This is a method used to display the accounts of all of the Account
	  * objects that are in the database.
	  */
	 public void displayAccounts(){
		 adminFunc.displayAccounts();
	 }
	 
	 /**
	  * This is a method used to display the accounts of all of the Account
	  * objects that are in the database.
	  */
	 public ArrayList<Account> getAccounts(){
		 return adminFunc.getAccounts();
	 }
	 
	 /**
	  * This method allows an admin to be able to edit a university object
	  * The changes are sent to the Database to save the changes
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
<<<<<<< HEAD
	 public void addUniversity(University u){
		 DB.addUniversity(u);
=======
	 public void addUniversity(String universityName, String state, String location, String control, int numberOfStudents,
				double percentFemale, int satVerbal, int satMath, double expenses, double financialAid, int numberOfApplicants,
				double percentAdmitted, double percentEnrolled, int academicScale, int socialScale, int qualityOfLife){
		 
	 }
	 
	 /**
	  * This method displays an error method. It is used when there is
	  * an error when searching the database.
	  * @return a String representing the error
	  */
	 public void getSearchError(){
	   
>>>>>>> branch 'master' of https://github.com/Jsupton/JACS
	 }
	 
	 /**
	  * This method if a void method that takes an account object in as a parameter
	  * It uses the account object and changes the status of the Account object to 
	  * deactivated.
	  * @param a Account object
	  */
	 public void deactivate(Account a){
		 adminFunc.deactivate(a);
	 }
	 
	 /**
	  * This Method displays all of the information about a specified Account object.
	  * It gathers all of the attributes for an account object and then displays
	  * that information for the user to see
	  */
<<<<<<< HEAD
	 public void viewAccount(String name){
		 DB.findAccount(name);
=======
	 public Account viewAccount(String name){
		 return null;
	 }
	 
	 /**
	  * This method allows an admin to be able to edit a university object
	  * The changes are sent to the Database to save the changes
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
		 
>>>>>>> branch 'master' of https://github.com/Jsupton/JACS
	 }
	 
	 /**
	  * This method is used to edit the account
	  * @param firstname the firstname of the account
	  * @param lastname the lastname of the account
	  * @param username the username of the account
	  * @param password the password of the account
	  * @param type the type of the account
	  * @param status the status of the account
	  */
	 public void editAccount(String firstname,String lastname, String username, String password, char type, char status){
		 
	 }
	 
	 /**
	  * This method is used to edit the account
	  * @param firstname the firstname of the new account
	  * @param lastname the lastname of the new account
	  * @param username the username of the new account
	  * @param password the password of the new account
	  * @param type the type of the new account
	  * @param status the status of the new account
	  */
	 public void addAccount(String firstname,String lastname, String username, String password, char type, char status){
		 
	 }
	 
	 /**
	  * This adds an emphases for the specified university object.
	  * The parameter string is then added to the University's emphases
	  * @param universityName
	  * @param emphases
	  * @return an integer indicating the number of database records 
	  * inserted or -1 if an invalid school name is specified or if 
	  * the specified emphasis already exists for the specified school
	  * */
	 public int addEmphases(String universityName,String emphases ){
		 return -1;
	 }
	 
	 /**
	  * This removes an emphases for the specified university object.
	  * The parameter string is then removed to the University's emphases
	  * @param universityName
	  * @param emphases
	  * @return an integer indicating the number of database records 
	  * inserted or -1 if an invalid school name is specified or if 
	  * the specified emphasis already exists for the specified school
	  */
	 public int removeEmphases(String universityName,String emphases ){
		 return -1;
	 }
	 
}
	
