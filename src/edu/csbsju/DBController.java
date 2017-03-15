package edu.csbsju;

import java.util.ArrayList;
import java.util.List;

import dblibrary.project.csci230.*;

/**
 * Class used to communicate with the Database
 * @author ajdehn
 * @version 02-26-17
 */
public class DBController {
	
	/**
	 * This instance is a variable that helps us access the UniversityDBLibrary 
	 * jar that is connected to the project
	 */
	private UniversityDBLibrary univDBlib;
	
	/**
	 * Default Constructor
	 */
	 public DBController(){
		 this.univDBlib = new UniversityDBLibrary("jacs","jacs","csci230");
	 }
	 
	 /**
	  * This constructor takes in the 3 necessities that are required to log onto
	  * the UniversityDBLibrary class
	  * @param a Database
	  * @param b Username
	  * @param c Password
	  */
	 public DBController(String a, String b, String c){
		 this.univDBlib = new UniversityDBLibrary(a,b,c);
	 }
	 
	 /**
	  * Checks if a specific username exists in the database
	  * @param u the name of the username
	  * @return returns true if user with that name exists in the database
	  */
	 public boolean checkUsername(String u)
	 {
		 String[][] users = univDBlib.user_getUsers();
		 boolean found = false;
		 int count = 0;
		 while(!found && count<users.length)
		 {
			 if(users[count][2].equals(u))
			 {
				 return true;
			 }
			 count++;
		 }
		 
		 return false;
	 }
	 
	 /**
	  * Finds the password
	  * @param u Username that we need the password for
	  * @return Password of the User with specified username
	  */
	 public String findPassword(String u)
	 {
		 String[][] users = univDBlib.user_getUsers();
		 boolean found = false;
		 int count = 0;
		 while(!found && count<users.length)
		 {
			 if(users[count][2].equals(u))
			 {
				 return users[count][3];
			 }
			 count++;
		 }
		 
		 return "Not Found";
	 }
	 
	 /**
	  * Returns the type of an account
	  * @param a Account being checked
	  * @return type of account (Admin or User)
	  */
	 public char determineType(Account a)
	 {
	  return 'a';
	 }
	 
	 /**
	  * Gets a university object with a university name
	  * @param universityName Name of the university being searched
	  * @return University object with given university name
	  */
	 public University detailedUniversityInformation(String universityName)
	 {
	  return null;
	 }
	 
	 /**
	  * Obtain a list of all users in the database
	  * @return A list of all Users that exist in the database
	  */
	 public ArrayList<Account> getAccounts()
	 {
		 int i,j;
		 String[][] x = univDBlib.user_getUsers();
		 ArrayList<Account> s = new ArrayList<Account>();
		 for(i = 0; i<x.length; i++){
			 String firstName = x[i][0];
			 String lastName = x[i][1];
			 String username = x[i][2];
			 String password = x[i][3];
			 String z = x[i][4];
			 char status = z.charAt(0);
			 String y = x[i][5];
			 char type = y.charAt(0);
			 Account a = new Account(firstName, lastName, username, password, status, type);
			 s.add(a);
		 }
		 return s;
	 }
	 
	 /**
	  * Provides a list all universities in the database
	  * @return List of all universities that are in the database
	  */
	 public ArrayList<University> getAllUniversities()
	 {
		 int i,j,h;
		 String[][] x = univDBlib.university_getUniversities();
		 String[][] y = univDBlib.university_getNamesWithEmphases();
		 ArrayList<University> s = new ArrayList<University>();
		 for(i = 0;i<x.length;i++){
			String universityName = x[i][0];
			String location = x[i][1];
			String state = x[i][2];
			String control = x[i][3];
			int numberOfStudents = Integer.parseInt(x[i][4]);
			int percentFemale = Integer.parseInt(x[i][5]);
			int satVerbal = Integer.parseInt(x[i][6]);
			int satMath = Integer.parseInt(x[i][7]);
			double expenses = Double.parseDouble(x[i][8]);
			double financialAid = Double.parseDouble(x[i][9]);
			int numberOfApplicants = Integer.parseInt(x[i][10]);
			double percentAdmitted = Double.parseDouble(x[i][11]);
			double percentEnrolled = Double.parseDouble(x[i][12]);
			int academicScale = Integer.parseInt(x[i][13]);
			int socialScale = Integer.parseInt(x[i][14]);
			int qualityOfLife = Integer.parseInt(x[i][15]);
			ArrayList<String> emphases = new ArrayList<String>();
			for(h = 0;h<y.length;h++){
				if(y[h][0].equals(universityName)){
				for(j = 1;j<y[0].length;j++){
						emphases.add(y[h][j]);
					}
				}
			}
			University u = new University(universityName,location,state,control,numberOfStudents,
					percentFemale,satVerbal,satMath,expenses,financialAid,numberOfApplicants,percentAdmitted,
					percentEnrolled,academicScale,socialScale,qualityOfLife,emphases);
			s.add(u);
		 }
		 
	  return s;
	 }
	 
	 /**
	  * Returns an account related to a username
	  * @param username User name to be searched in the database.
	  * @return Account object related to provided user name.
	  */
	 public Account findAccount(String username)
	 {
		 String firstName = null;
		 String lastName = null;
		 String password = null;
		 char status = 0;
		 char type = 0;
		 
		 String[][] users = univDBlib.user_getUsers();
		 boolean found = false;
		 int count = 0;
		 while(!found && count<users.length)
		 {
			 if(users[count][2].equals(username))
			 {
				 firstName = users[count][0];
				 lastName = users[count][1];
				 password = users[count][2];
				 status = users[count][4].charAt(0);
				 type = users[count][5].charAt(0);
			 }
			 count++;
		 }
		 Account acct = new Account(firstName, lastName, username, password, type, status);
	  return acct;
	 }
	 
	 /**
	  * Changes the details of a user
	  * @param u User we would like to change details of
	  * @param a Account information we would like details of
	  */
	 public void changeStudentDetails(User u, Account a)
	 {
		 
	 }
	 
	 /**
	  * Returns a university object with that specific name
	  * @param name name of university being searched for.
	  * @return University object
	  */
	 public University getAUniversity(String name)
	 {
		 ArrayList<University> x = this.getAllUniversities();
		 University match = null;
		 for(University u:x){
				 if(u.getUniversityName().equals(name)){
					 match = u;
				 }
		 }
	  return match;
	 }
	 
	 /**
	  * Returns a specific student object
	  * @return User related to a specific student
	  */
	 public User displayStudent()
	 {
	  return null;
	 }
	 
	 /**
	  * Shows sends a university to our user
	  */
	 public void displayUniversity()
	 {
	  
	 }
	 
	 /**
	  * Edits the account details of a provided account
	  * @param fn Fist name of the user
	  * @param ln Last name of the user
	  * @param p Password of user
	  */
	 public boolean editAccount(String fn,String ln,String p,char type)
	 {
		 return false;
	 }
	 
	 /**
	  * Adds a university to the database
	  * @param u Object to be added to the database
	  */
	 public void addUniversity(University u)
	 {
		 String school = u.getUniversityName();
		 String state = u.getState();
		 String location = u.getLocation();
		 String control = u.getControl();
		 int numberOfStudents = u.getNumberOfStudents();
		 double percentFemale = u.getPercentFemale();
		 int satVerbal = u.getSatVerbal();
		 int satMath = u.getSatMath();
		 double expenses = u.getExpenses();
		 double financialAid = u.getFinancialAid();
		 int numberOfApplicants = u.getNumberOfApplicants();
		double percentAdmitted = u.getPercentAdmitted();
		double percentEnrolled = u.getPercentEnrolled();
		int academicScale = u.getAcademicScale();
		int socialScale = u.getSocialScale();
		int qualityOfLife = u.getQualityOfLife();

		 univDBlib.university_addUniversity(school, state, location, control, numberOfStudents, percentFemale, satVerbal, satMath, expenses, financialAid, numberOfApplicants, percentAdmitted, percentEnrolled, academicScale, socialScale, qualityOfLife);
	 }
	 
	 /**
	  * @param username
	  * @return 
	  * 
	  */
	 public void getUserSavedSchools(String username)
	 {
		 boolean found = false;
		 int i=0; 
		 String[][] savedSchools = univDBlib.user_getUsernamesWithSavedSchools();
		 String[] matchingSchools;
		 
		 while(!found && i<savedSchools.length)
		 {
			 
			 if(username.equals(savedSchools[i][0]))
			 {
				 found = true;
				// for(int j=0; j<)
			 }
		 }
	 }
	 
	 /**
	  * Add a university to a Users saved list
	  * @param u University object to be saved
	  * @param a Account that this university is to be saved to
	  */
	 public void addUniversityToSavedSchools(University u, Account a)
	 {
		 String school = u.getUniversityName();
		 String userName = a.getUsername();
		 univDBlib.user_saveSchool(userName, school);
	 }
	 
	 /**
	  * Remove a saved university from a specific account
	  * @param u University object that needs to be removed
	  * @param a Account that needs to be added 
	  */
	 public void removeUniversityFromSavedSchools(University u ,Account a)
	 {
		 String school = u.getUniversityName();
		 String userName = a.getUsername();
		 univDBlib.user_removeSchool(userName, school);
	 }
	 
	 /**
	  * Allows the user to confirm the changes that they have made
	  * when changing information regarding Account details.
	  */
	 public void confirmChange()
	 {
	  
	 }
	 
	 /**
	  * Checks the status of a given user
	  * @param u
	  * @return true if this user is active
	  */
	 public boolean isActive(Account a)
	 {
		 return a.getStatus()=='y';

	 }
	 
	 /**
	  * Used to deactivate a given user
	  * @param u User that you would like to deactivate
	  */
	 public void deactivate(Account a)
	 {

		 univDBlib.user_editUser(a.getUsername(), a.getFirstName(), a.getLastName(),
				 a.getPassword(), a.getType(), 'n');

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
	  * @param emphases empases of a university
	  */
	 public void editUniversity(University u)
	 {
		 String school = u.getUniversityName();
		 String state = u.getState();
		 String location = u.getLocation();
		 String control = u.getControl();
		 int numberOfStudents = u.getNumberOfStudents();
		 double percentFemale = u.getPercentFemale();
		 int satVerbal = u.getSatVerbal();
		 int satMath = u.getSatMath();
		 double expenses = u.getExpenses();
		 double financialAid = u.getFinancialAid();
		 int numberOfApplicants = u.getNumberOfApplicants();
		double percentAdmitted = u.getPercentAdmitted();
		double percentEnrolled = u.getPercentEnrolled();
		int academicScale = u.getAcademicScale();
		int socialScale = u.getSocialScale();
		int qualityOfLife = u.getQualityOfLife();
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
	
	 public static void main(String args[]){
		 DBController d = new DBController();
		 ArrayList<University> p = d.getAllUniversities();
		 ArrayList<Account> c = d.getAccounts();
		 for(Account a: c){
			 a.displayStudent();
		 }
		 //for(University u: p){
		//	 u.printString();
		// }
		 
		 
	 }
}
