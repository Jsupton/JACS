package edu.csbsju;

import java.util.*;

/**
 * This class is the controller for all the functions of an administrator.
 * This class deals with shifting data and calling the Database, as well
 * as sending data back to the UserInterface to display to the Admin. 
 * @author cjzins
 * @version 02-26-17
 */
public class AdminFuncController {

  //a variable for admin
	Admin admin;
 
 /**
  * This method calls on the database and gets all of the accounts that are
  * in the system. It then returns an arrayList of those accounts
  * @return an array list of the accounts
  */
 public ArrayList getAccounts(){
	 ArrayList<Account> a = new ArrayList();
	 return a;
 }
 /**
  * This method calls on the database and gets all of the universities that are
  * in the system. It then returns an arrayList of those Universities
  * @return and array list of universities
  */
 public ArrayList getUniversities(){
	 ArrayList<University> u = new ArrayList();
	 return u;
 }
 
}
