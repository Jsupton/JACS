/**
 * @author jsupton
 * 
 */
public class AccountUI {

	/**
	 * 
	 */
	public AccountUI() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This method takes a username and a password as String parameters
	 * and uses them to log the Account object into the system
	 * @param u String, a username for the Account object
	 * @param p String, a password for the Account object
	 */
	public void logOn(String u, String p){
		
	}
	
	/**
	 * 
	 */
	public void returnType(char t){
		
	}
	
	/**
	 * This method does not take any parameters. It logs the current
	 * Account object out of the system.
	 */
	public void logOff(){
		
	}
	
	/**
	 * 
	 */
	public void displayLoginError(){
		
	}
	
	/**
	 * This method calls the Database and returns a list of all the 
	 * universities for the user to view or for an admin to edit.
	 * @return ArrayList<University> An array list of university objects
	 */
	public ArrayList<University> getUniversities(){
		return null;
	}
	
	/**
	 * 
	 */
	public void displayAccount(){
		
	}
	
	/**
	 * This method takes a university name as a parameter and uses that
	 * to search the database and then it returns either null if the university
	 * was not found in the system, or it creates a university object out of the
	 * the specified information
	 * @param name String, a name of a university
	 * @return University a university object
	 */
	public University getUniversity(String name){
		return null;
	}
	
	/**
	 * This method displays all of the aspects of a given university object.
	 * It gets all attributes from the university object and then displays
	 * those on the screen for the user.
	 * @param u University object
	 */
	public void displayUniversity(University u){
		
	}
	
	/**
	 * This method takes a username as a parameter, then searches the database
	 * to find an Account that matches the username. If there is no account that matches
	 * the method returns null, otherwise the method returns the Account object with 
	 * that specified username.
	 * @param u String, a username of an Account
	 * @return Account object
	 */
	public Account findAccount(String u){
		return null;
	}
	
	/**
	 * This Method displays all of the information about a specified Account object.
	 * It gathers all of the attributes for an account objet and then displays
	 * that information for the user to see
	 */
	public void displayStudent(Account a){
		
	}
	
	/**
	 * This method allows the user to be able to change Account attributes.
	 * It takes in 3 paramteres, which can contain null values, and uses those
	 * values to update an Account object's attributes
	 * @param p String representing an Account's password
	 * @param ln String representing the Account's last name
	 * @param fn String representing the Account's first name
	 */
	public void editAccount(String p, String ln, String fn){
		
	}
	
	/**
	 * 
	 */
	public void save(){
		
	}
	
	/**
	 * This method is a method that asks the user if they would like to 
	 * continue on making the changes to this Account object, whether it is
	 * a User changing their own account information or an Admin changing
	 * another person's Account information.
	 */
	public void confirmEdit(){
		
	}
	
	/**
	 * This method determines if the current account object is active or not
	 * Each account object has an attribute that states whether the Account is
	 * active or deactivated. If the account if Active this method will return 
	 * true, otherwise it will return false.
	 * @return Boolean, true if the Account object is active
	 */
	public boolean isActive(Account a){
		
	}
	
	/**
	 * This method if a void method that takes an account object in as a parameter
	 * It uses the account object and changes the status of the Account object to 
	 * deactivated.
	 * @param a Account object
	 */
	public void deactivate(Account a){
		
	}

}
