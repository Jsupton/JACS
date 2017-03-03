
package edu.csbsju;

import java.util.*;
/**
 * This class Class the responsible for searching the database for a University.
 * This method works hand in hand with the Database in order to search and 
 * return to the user a list of universities that meet the Search criteria 
 * that the user entered 
 * @author jsupton
 * @version 02-26-17
 */
public class SearchController {
	
	/**
	 * This is an Account object instance variable
	 */
	private Account a;
	/**
	 * This is a DBController object used to access the Database
	 */
	private DBController d;
	/**
	 * This is a University object used to access a University
	 */
	private University u;
	
	 /**
	  * Default Constructor
	  */
	 public SearchController() {
		 super();
	 }
	
	 /**
	  * This method allows the user to search for a specific university. It takes 
	  * in a University object as a parameter. The attributes for the university object are
	  * the search criteria that the user input. The search criteria is used to search the 
	  * Database. All universities that match the attributes of the search criteria are 
	  * gathered into an arrayList.
	  * @return ArrayList<University>
	  */
	 public List<University> search(University u){
		 List<University> matches = new ArrayList<University>();
 		 List<University> s = new ArrayList<University>();
		 s = d.getAllUniversities();
		 for(University university:s){
			 boolean b = true;
			 if(u.getUniversityName()!=null && b == true)
				 b = university.getUniversityName().contains(u.getUniversityName());
			 else if(u.getState()!=null && b == true)
				 b = university.getState().equals(u.getState());
			 else if(u.getLocation()!=null && b == true)
				 b = university.getLocation().equals(u.getLocation());
			 else if(u.getControl()!=null && b == true)
				 b = university.getControl().equals(u.getControl());
		 }
	  return matches;
	 }
	 
	 /**
	  * This method allows the user to search for a specific university. It takes 
	  * in a University object as a parameter. The attributes for the university object are
	  * the search criteria that the user input. The search criteria is used to search the 
	  * Database. All universities that match the attributes of the search criteria are 
	  * gathered into an arrayList.
	  * @return ArrayList<Account>
	  */
	 public ArrayList<Account> search(Account a){
		 ArrayList<Account> s = new ArrayList();
	  return s;
	 }
	 
}
