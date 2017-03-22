package edu.csbsju;

import dblibrary.project.csci230.*;
import java.io.*;
import java.util.*;

/** 
 * Before you compile in DrJava, go to Edit > Preferences > Resource Locations 
 * Press the Add button under Extra Path to add the following two jars:
 *    1- /usr/people/classes/CS230/handouts/project/DBLibraryCode/csci230databaselibrary.jar
 *    2- /usr/people/classes/Java/mysql-connector-java-3.1.10-bin.jar
 * 
 * To run, issue: java DBLibraryDriver "YourDatabaseName" "YourDatabaseUsername" "YourDatabasePassword" 
 * in the Interactions Pane in Dr. Java
 * 
 */ 

public class DBLibraryDriver {
	
  private DBController univDBlib;

  public  DBLibraryDriver(){
    univDBlib = new DBController();
  }
  
  /**
   * Testing addUniversity(), editUniversity(), and removeUniversity().
   */
  public void testAddEditRemoveU()
 {
	  // addUniversity()
	  ArrayList<String> emp = new ArrayList<String>();
	  emp.add("Sports");
	  emp.add("Academics");
	  University newU = new University("x","x","x","x",1,1,1,1,1,1,1,1,1,1,1,1,emp);
	  univDBlib.addUniversity(newU);
	  University ourU = univDBlib.getAUniversity("x");
	  ArrayList<String> ourEmp = (ArrayList<String>) ourU.getEmphases();
	  for(String exEmp: ourEmp)
	  {
		  System.out.println("Should be Sports and Academics " + exEmp);
	  }
	  
	  // editUniversity
	  ourU.setState("MN");
	 // univDBlib.editUniversity(ourU.getUniversityName(), ourU.getState(), ourU.getLocation, ourU.getControl(), ourU.getNumberOfStudents(),
	  // ourU.getPercentFemale(), ourU.getSatVerbal(), ourU.getSatMath(), ourU.getExpenses(), ourU.getFinancialAid(), ourU.getNumberOfApplicants(),
	  // ourU.getPercentAdmitted(), ourU.getPercentEnrolled(), ourU.getAcademicScale(), ourU.getSocialScale(), ourU.getQualityOfLife());
	  University editU = univDBlib.getAUniversity("x");
	  System.out.println("Should be MN: "+ editU.getState());
	  
	  // removeUniversity
	    
 }
  public void testSaveSchool()
  {
	  ArrayList<Account> allAccts = univDBlib.getAccounts();
	  ArrayList<String> test = (ArrayList<String>) univDBlib.getUserSavedSchools("juser");
	  if(test==null || test.isEmpty())
	  {
		  System.out.println("Test is empty 1.");
	  }
	  univDBlib.addUniversityToSavedSchools("AUGSBURG", "juser");
	  univDBlib.addUniversityToSavedSchools("STANFORD", "juser");
	  
	  test = (ArrayList<String>) univDBlib.getUserSavedSchools("juser");
	  
	  for(String s1: test)
	  {
		  System.out.println("Stanford and Augsburg "+ test);
	  }
	  
	  univDBlib.removeUniversityFromSavedSchools("AUGSBURG", "juser");
	  univDBlib.removeUniversityFromSavedSchools("STANFORD", "juser");
	  
	  test = (ArrayList<String>) univDBlib.getUserSavedSchools("juser");
	  
	  if(test.isEmpty())
	  {
		  System.out.println("Test is empty2.");
	  }
  }
  
  
  public void run()
  {
	  //this.testAddEditRemoveU();
	  
	  this.testSaveSchool();
	  
//	  // Display all university names in the database
//	  ArrayList<University> allUniv  = univDBlib.getAllUniversities();
//	  for (University row : allUniv)
//      {
//          System.out.println(row.getUniversityName());       
//      }
	  
	  // Display all accounts in the database
//	  ArrayList<Account> allAccts = univDBlib.getAccounts();
//	  for (Account row : allAccts)
//	  {
//        System.out.println(row.getUsername());       
//	  }

//	  univDBlib.removeUniversityFromSavedSchools("AUGSBURG", "luser");
//	  univDBlib.removeUniversityFromSavedSchools("STANFORD", "juser");
//	  univDBlib.getUserSavedSchools("juser");



      
  }
 
  
  public static void main(String[] args) {
      DBLibraryDriver testRun = new DBLibraryDriver();
      testRun.run();
  }
  
      //System.out.println(Arrays.deepToString(test));
      
    
      /**
      System.out.println("university_addUniversity(x,x,x,x,1,1,1,1,1,1,1,1,1,1,1,1) : " + 
                         dbld.getUnivDBlib().university_addUniversity("x","x","x","x",1,1,1,1,1,1,1,1,1,1,1,1));
      System.out.println("university_deleteUniversity(x) : " + 
                         dbld.getUnivDBlib().university_deleteUniversity("x"));
      System.out.println("university_addUniversity(x,x,x,x,1,1,1,1,1,1,1,1,1,1,1,1) : " + 
                         dbld.getUnivDBlib().university_addUniversity("x","x","x","x",1,1,1,1,1,1,1,1,1,1,1,1));
      System.out.println("university_addUniversityEmphasis(x, 1224):"+ 
                         dbld.getUnivDBlib().university_addUniversityEmphasis("x","1224"));
      System.out.println("university_addUniversityEmphasis(x, 1122):"+
                         dbld.getUnivDBlib().university_addUniversityEmphasis("x","1122"));
      System.out.println("university_deleteUniversity(x) : " + 
                         dbld.getUnivDBlib().university_deleteUniversity("x"));
      System.out.println("university_removeUniversityEmphasis(x, 1224):"+
                         dbld.getUnivDBlib().university_removeUniversityEmphasis("x","1224"));
      System.out.println("university_removeUniversityEmphasis(x, 1122):"+
                         dbld.getUnivDBlib().university_removeUniversityEmphasis("x","1122"));      
      System.out.println("university_deleteUniversity(x) : " + 
                         dbld.getUnivDBlib().university_deleteUniversity("x"));      
      System.out.println("university_addUniversity(x,x,x,x,1,1,1,1,1,1,1,1,1,1,1,1) : " + 
                         dbld.getUnivDBlib().university_addUniversity("x","x","x","x",1,1,1,1,1,1,1,1,1,1,1,1));      
     
      System.out.println("user_addUser(yy, yy, yy, yy, 'a'): " + 
                         dbld.getUnivDBlib().user_addUser("yy", "yy", "yy", "yy", 'a'));
      System.out.println("user_deleteUser(yy) : " + 
                         dbld.getUnivDBlib().user_deleteUser("yy"));
      System.out.println("user_addUser(yy, yy, yy, yy, 'a'): " + 
                         dbld.getUnivDBlib().user_addUser("yy", "yy", "yy", "yy", 'a'));

      System.out.println("user_saveSchool(yy, BARD):" + 
                         dbld.getUnivDBlib().user_saveSchool("yy","BARD") );
      System.out.println("user_saveSchool(yy, BARD):" + 
                         dbld.getUnivDBlib().user_saveSchool("yy","x") );
      System.out.println("user_deleteUser(yy) : " + 
                         dbld.getUnivDBlib().user_deleteUser("yy"));
      System.out.println("university_deleteUniversity(x) : " + 
                         dbld.getUnivDBlib().university_deleteUniversity("x"));      
      System.out.println("user_removeSchool(yy, BARD):" + 
                         dbld.getUnivDBlib().user_removeSchool("yy","BARD") );
      System.out.println("user_removeSchool(yy, BARD):" + 
                         dbld.getUnivDBlib().user_removeSchool("yy","x") );
      System.out.println("user_deleteUser(yy) : " + 
                         dbld.getUnivDBlib().user_deleteUser("yy"));
      System.out.println("university_deleteUniversity(x) : " + 
                         dbld.getUnivDBlib().university_deleteUniversity("x"));          
      
  	*/
  }
