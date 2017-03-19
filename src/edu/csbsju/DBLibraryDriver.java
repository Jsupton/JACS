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
  
  public void run()
  {
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
