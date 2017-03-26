package edu.csbsju;
import java.util.*;

/**
 * This class is the UserInterface for an Administrator. This class
 * controls what is displayed to the user at specific points in time.
 * The controller will send data back to this class to display to the Admin.
 * @author cjzins
 * @version 03-21-17
 */
public class AdminUI extends AccountUI{

 /**
  * a AdminFuncController object instance variable. Allows this class
  * to be able to interact with the adminFunction Controller class
  */
 private AdminFuncController adminFunc;
 
 /**
  * This default constructor initiates the Admin to null. It also makes
  * a new AdminFuncController using the Admin parameter value.
  * @param a an admin object
  */
 public AdminUI(Admin a) {
  super();
  this.adminFunc = new AdminFuncController(a);
 }
 
 /**
  * This default constructor initiates the Admin to null. It also sets
  * the adminFun instance variable to a new AdminFuncController object.
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
  * This method calls the Database and returns a list of all the 
  * universities for the user to view or for an admin to edit.
  * @return ArrayList<University> An array list of university objects
  */
 public ArrayList<University> getUniversities(){
	 return adminFunc.getUniversities();
 }
 
 /**
  * This method displays all of the aspects of all university objects.
  * It gets all attributes from the university objects and then displays
  * them on the screen for the user.
  */
 public void displayUniversities(){
	 adminFunc.displayUniversities();
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
   * @return an array list of all the account objects in the database
   */
  public ArrayList<Account> getAccounts(){
   return adminFunc.getAccounts();
  }
  
  /**
   * This method allows an admin to be able to edit a university object.
   * The parameters are used to update the values of the specified university
   * in the Database. These changes are first sent to the UniversityController
   * Class.Then the changes are sent to the Database to save the changes
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
  public void addUniversity(String universityName, String state, String location, String control, int numberOfStudents,
    double percentFemale, int satVerbal, int satMath, double expenses, double financialAid, int numberOfApplicants,
    double percentAdmitted, double percentEnrolled, int academicScale, int socialScale, int qualityOfLife){
   adminFunc.addUniversity(universityName, state, location, control, numberOfStudents, percentFemale, satVerbal, satMath, expenses, financialAid,  numberOfApplicants,
     percentAdmitted, percentEnrolled, academicScale, socialScale, qualityOfLife);
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
   * @param name a String representing a user's username
   * @return an account object. this is null if an account witht he corresponding 
   * username doesn't exist.
   */
  public Account viewAccount(String name){
   return adminFunc.findAccount(name);
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
   adminFunc.editUniversity(universityName, state, location, control, numberOfStudents,
   percentFemale, satVerbal, satMath, expenses, financialAid, numberOfApplicants,
   percentAdmitted, percentEnrolled, academicScale, socialScale, qualityOfLife);
  }
  
  /**
   * This method is used to edit the account. It takes all attributes of an account
   * object in as parameters and then, using the username as a key, it finds the right account
   * object in the database and then updates it
   * @param firstname the firstname of the account
   * @param lastname the lastname of the account
   * @param username the username of the account
   * @param password the password of the account
   * @param type the type of the account
   * @param status the status of the account
   */
  public void editAccount(String firstname, String lastname, String username, String password, char type, char status){
   adminFunc.editAccount(firstname, lastname, username, password, type, status);
  }
  
  /**
   * This method is used to add a new the account. It takes in all attributes
   * of an account object and then uses those to create a new account. This method
   * will fail if an account already exists with the same username
   * @param firstname the firstname of the new account
   * @param lastname the lastname of the new account
   * @param username the username of the new account
   * @param password the password of the new account
   * @param type the type of the new account
   * @param status the status of the new account
   */
  public void addAccount(String firstname,String lastname, String username, String password, char type, char status){
   adminFunc.addAccount(firstname, lastname, username, password, type, status);
  }
  
  /**
   * This adds an emphases for the specified university object.
   * The parameter string is then added to the University's emphases
   * @param universityName a name of a university 
   * @param emphases the desired emphases to add to the university
   * @return an integer indicating the number of database records 
   * inserted or -1 if an invalid school name is specified or if 
   * the specified emphasis already exists for the specified school
   * */
  public int addEmphases(String universityName,String emphases ){
   return adminFunc.addEmphases(universityName, emphases);
  }
  
  /**
   * This removes an emphases for the specified university object.
   * The parameter string is then removed to the University's emphases
   * @param universityName a name of a university
   * @param emphases the desired emphases to remove from the university
   * @return an integer indicating the number of database records 
   * inserted or -1 if an invalid school name is specified or if 
   * the specified emphasis already exists for the specified school
   */
  public int removeEmphases(String universityName,String emphases ){
   return adminFunc.removeEmphases(universityName, emphases);
  }
  
}
 
