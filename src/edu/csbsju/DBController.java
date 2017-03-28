package edu.csbsju;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import dblibrary.project.csci230.*;

/**
 * Class used to communicate with the Database. this class is called by
 * Contorller classes that are in need of accessing the DBLibrary. In general,
 * this class is used when these controller classes want to save edited information,
 * add an account object or university object, or display data that is in the
 * DBLibrary
 * @author ajdehn
 * @version 03-21-17
 */
public class DBController {
	
	/**
	 * This instance is a variable that helps us access the UniversityDBLibrary 
	 * jar that is connected to the project
	 */
	private UniversityDBLibrary univDBlib;
	
	/**
	 * Default Constructor, It creates a new UniversityDBLibrary object
	 * with the specified login information for our group. This new object
	 * is set to the univDBlib instance variable
	 */
	 public DBController(){
		 this.univDBlib = new UniversityDBLibrary("jacs","jacs","csci230");
	 }
	 
	 /**
	  * This constructor takes in the 3 necessities that are required to log onto
	  * the UniversityDBLibrary class
	  * @param a Database name that our group was given
	  * @param b Username that our group was given
	  * @param c Password that was assigned to our group
	  */
	 public DBController(String a, String b, String c){
		 this.univDBlib = new UniversityDBLibrary(a,b,c);
	 }
	 
	 /**
	  * Checks if a specific username exists in the database. If the username
	  * does, then this method returns true.
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
	  * Finds the password with a corresponding username. The username
	  * is passed as a parameter and the password for that account
	  * is then returned.
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
	  * Returns the type of an account object that is passed as a parameter
	  * to this method.
	  * @param a Account being checked
	  * @return type of account (Admin or User)
	  */
	 public char determineType(Account a)
	 {
	  return a.getType();
	 }
	 
	 /**
	  * Obtain a list of all users in the database. This accesses the
	  * DBLibrary to get a 2D array list of all Accounts, then this
	  * method converts that into an array list of Account objects
	  * @return An arrayList of all Users that exist in the database
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
	  * Provides a list all universities in the database.This accesses the
	  * DBLibrary to get a 2D array list of all universities, then this
	  * method converts that into an array list of University objects
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
	  * Returns an account related to a username. The username is taken
	  * in as a parameter and the corresponding Account is returned. If no
	  * account matches this, the method returns null.
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
				 password = users[count][3];
				 type = users[count][4].charAt(0);
				 status = users[count][5].charAt(0);
			 }
			 count++;
		 }
		 Account acct = new Account(firstName, lastName, username, password, type, status);
	  return acct;
	 }
	 
	 /**
	  * Returns a university object with that specific name. The name of a 
	  * university is taken in as a parameter and then used to find a 
	  * specific university. if a university with the specified name isn't found,
	  * the method returns null.
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
	  * Edits the account details of a provided account. The parameters are
	  * used to update the account object that is specified by the username
	  * If such account doesn't exist, the method returns false, indicating that
	  * the edit did not properly work.
	  * @param u user name of the user
	  * @param fn Fist name of the user
	  * @param ln Last name of the user
	  * @param p Password of user
	  * @param type, character representing the user's type
	  * @param status, character representing the user's status
	  * @return boolean depending on it the edit was successful.
	  */
	 public boolean editAccount(String u, String fn,String ln,String p,char type, char status)
	 {
		 int i = univDBlib.user_editUser(u, fn, ln, p, type, status);
		 if(i!=-1){
			 return true;
		 }
		 return false;
	 }
	 
	 /**
	  * Adds a university to the database, using the university object,
	  * It gets all the attributes for the new university and then calls the DBController
	  * to update the database with the new university
	  * @param u University Object to be added to the database
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
		
		// Add University emphasis if it exists.
		List<String> allEmphases = u.getEmphases();
		if(allEmphases!=null)
		{
			for(String emphases: allEmphases)
			{
				this.addEmphases(school,emphases);
			}
		}
		

		 univDBlib.university_addUniversity(school, state, location, control, numberOfStudents,
				 percentFemale, satVerbal, satMath, expenses, financialAid, numberOfApplicants,
				 percentAdmitted, percentEnrolled, academicScale, socialScale, qualityOfLife);
	 }
	 
	 /**
	  * This method gets a list of all users and their saved schools from
	  * the DBLibrary. Then, it goes through that list and finds the desired
	  * user. Then it adds all of their saved schools to an array list
	  * @param username the username for a specific student
	  * @return List<String> of all university names of all the saved schools
	  */
	 public List<String> getUserSavedSchools(String username)
	 {
		 int i=0;
		 int j = 0;
		 String[][] savedSchools = univDBlib.user_getUsernamesWithSavedSchools();
		 //String[][] users = univDBlib.user_getUsers();
		 
		 ArrayList<String> matchingSchools = new ArrayList<String>();
		 if(savedSchools == null)
		 {
			 return matchingSchools;
		 }
		 while(i<savedSchools.length)
		 {
			 if(username.equals(savedSchools[i][0]))
			 {
				 for(j = 1; j<savedSchools[i].length; j++)
				 {
					 matchingSchools.add(savedSchools[i][j]);
				 }
			 }
			 i++;
		 }
		 return matchingSchools;
	 }
	 
	 /**
	  * Add a university to a Users saved list. The username parameter
	  * is used to find the desired Account object and the school name
	  * is used to add that school to the Account.
	  * @param school String object to be saved
	  * @param userName String that this university is to be saved to
	  */
	 public void addUniversityToSavedSchools(String school, String userName)
	 {
		 String uppercase = school.toUpperCase();
		 univDBlib.user_saveSchool(userName, uppercase);
	 }
	 
	 /**
	  * Remove a saved university from a specific account. The username parameter
	  * is used to find the desired Account object and the school name
	  * is used to remove that school from the Account.
	  * @param u String University name of school to be removed
	  * @param a String username that to remove school
	  */
	 public void removeUniversityFromSavedSchools(String u ,String a)
	 {
		 String upperCaseUniversity = u.toUpperCase();
		 String lowerCaseUser = a.toLowerCase();
		 univDBlib.user_removeSchool(lowerCaseUser, upperCaseUniversity);
	 }
	 
	 /**
	  * This method is a method that asks the user if they would like to 
	  * continue on making the changes to this Account object, whether it is
	  * a User changing their own account information or an Admin changing
	  * another person's Account information.
	  * @return boolean, a boolean indicating whether or not the user confirms
	  * that they want to edit
	  */
	 public boolean confirmEdit(){
		  String answer = JOptionPane.showInputDialog("Are You sure you want to confirm change? (Y/N)");
		  if(answer == "y"|| answer == "Y"){
			  return true;
		  }
		  else{
			  JOptionPane.showMessageDialog(null,"The changes were not saved");
			  return false;
		  }
	 }
	 
	 /**
	  * Checks the status of a given user
	  * @param a Account object
	  * @return true if this user is active
	  */
	 public boolean isActive(Account a)
	 {
		 return a.getStatus()=='Y';

	 }
	 
	 /**
	  * Used to deactivate a given user
	  * @param a Account that you would like to deactivate
	  */
	 public void deactivate(Account a)
	 {
		 a.displayStudent();
		 univDBlib.user_editUser(a.getUsername(), a.getFirstName(), a.getLastName(),
				 a.getPassword(), a.getType(), 'N');

	 }
	 
	 /**
	  * This method is used to add an account. It takes in all the attributes of 
	  * an account object, and then uses those to create a new account object in the
	  * database
	  * @param firstName the firstname of the new account
	  * @param lastName the lastname of the new account
	  * @param username the username of the new account
	  * @param password the password of the new account
	  * @param type the type of the new account
	  * @param status the status of the new account
	  */
	 public void addAccount(String firstName,String lastName, String username, String password, char type, char status){
		 univDBlib.user_addUser(firstName, lastName, username, password, type);
	 }
	 
	 
	   /**
		* Allows changes to be made to details of a university. The Specified parameter
		* values are used to call to the DBLibrary and edit the University with the 
		* specified University Name.
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
		
		univDBlib.university_editUniversity(universityName, state, location, control, numberOfStudents, percentFemale,
				satVerbal, satMath, expenses, financialAid, numberOfApplicants,
				 percentAdmitted, percentEnrolled, academicScale, socialScale, qualityOfLife);
		
	 }
	 
	 /**
	  * This adds an emphases for the specified university object.
	  * The parameter string is then added to the University's emphases
	  * @param universityName the name of a university
	  * @param emphases the emphases desired to add to the university
	  * @return an integer indicating the number of database records 
	  * inserted or -1 if an invalid school name is specified or if 
	  * the specified emphasis already exists for the specified school
	  * */
	 public int addEmphases(String universityName,String emphases ){
		 int numRecords = univDBlib.university_addUniversityEmphasis(universityName, emphases);
		 return numRecords;
	 }
	 
	 /**
	  * This removes an emphases for the specified university object.
	  * The parameter string is then removed to the University's emphases
	  * @param universityName the name of a university
	  * @param emphases desired emphases to remove from a university
	  * @return an integer indicating the number of database records 
	  * inserted or -1 if an invalid school name is specified or if 
	  * the specified emphasis already exists for the specified school
	  */
	 public int removeEmphases(String universityName,String emphases ){
		 return univDBlib.university_removeUniversityEmphasis(universityName, emphases);
	 }
	
	 /**
	  * This is the MAIN METHOD
	  * @param args the parameter for the main method
	  */
	 public static void main(String args[]){
		 DBController d = new DBController();
		 Account a = new Account("Jacob","Upton","Jsu","upton",'u','Y');
		 a.displayStudent();
		// d.addAccount(a.getFirstName(), a.getLastName(), a.getUserName(), .password, type, status);
		// ArrayList<University> p = d.getAllUniversities();
		 //ArrayList<Account> c = d.getAccounts();
		 //for(Account x: c){
		//	 x.displayStudent();
		// }
		 //for(University u: p){
		//	 u.printString();
		// }
		// University u = d.getAUniversity("x");
		// u.printString();
		 
		 
	 }
}
