
package edu.csbsju;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;

/**
 * Driver for the CMC Class
 * @author jsupton
 * @version 03-02-17
 */
public class CMCDriver {
	/**
	 * This instance variable allows this class to access the userUI
	 */
	private UserUI user;
	/**
	 * This instance variable allows this class to access the AccountUI
	 */
	private AccountUI account;
	/**
	 * This instance variable allows this class to access the AdminUI
	 */
	private AdminUI admin;
	
	/**
	 * Default Constructor
	 */
	public CMCDriver(){
		this.user = new UserUI();
		this.account = new AccountUI();
		this.admin = new AdminUI();
	}
	
	/**
	 * This constructor takes in an Account object 
	 * @param a
	 */
	public CMCDriver(Account a){
		this.user = new UserUI((User)a);
		this.account = new AccountUI(a);
		this.admin = new AdminUI((Admin)a);
	}
	
	/**
	 * This is the main system that runs the basis of the CMC Program. It
	 * Starts by logging in the user, and depending on if the account is a user
	 * or an admin it takes them to their perspective screen.
	 * @throws ClassNotFoundException
	 */
	public void runSystem() throws ClassNotFoundException {
		//User enters a username and password
		String username = JOptionPane.showInputDialog("Please Enter Username: ");
		String password = JOptionPane.showInputDialog("Please Enter Password: ");
		//An account object is returned using the username and password when logging in
	    Account a = account.logOn(username,password);
	    //The accountUI is initialized with that new account object
	    this.account = new AccountUI(a);
	    char cmd = '\0';
	    //If the Account object is a user this is followed
	    if(account.returnType()=='u' && a != null){
	    	Account acc = account.displayAccount();
	    	User u = new User(acc.getUsername(),acc.getPassword(),acc.getFirstName(),acc.getLastName(),acc.getType(),acc.getStatus());
	    	this.user = new UserUI(u);
	    	do
	    	{
	    		userMenu();
	    		cmd = acceptCommand();
	    		doCommand(cmd);
	    	}
	    	while ((cmd != 'q') && (cmd != 'Q'));
	    }
	    //if the account object is an admin this is followed
	    else if(account.returnType()=='a' && a != null){
	    	do
	    	{
	    		adminMenu();
	    		cmd = acceptCommand();
	    		doCommand(cmd);
	    	}
	    	while ((cmd != 'q') && (cmd != 'Q'));
	    }
	  }
	
	/**
	 * USER MENU, displayed when the user wants to perform a command after logging in
	 */
	private void userMenu(){
		System.out.println();
  	    System.out.println("--------------------------------------------------------");
	    System.out.println("\tS: Search For Schools");
	    System.out.println("\tM: Manage My Saved Schools");
	    System.out.println("\tP: Manage My Profile");
	    System.out.println("\tQ: To Quit");
	    System.out.println();
	}
	
	/**
	 * ADMIN MENU, displayed when the admin wants to perform a command after logging in
	 */
	private void adminMenu(){
		System.out.println();
  	    System.out.println("--------------------------------------------------------");
	    System.out.println("\tU: Manage Universities");
	    System.out.println("\tZ: Manage Users");
	    System.out.println("\tQ: To Quit");
	    System.out.println();
	}
	
	/**
	 * This method accepts a command. It asks the user to enter a command. Then the command
	 * is changed to a character and then sends that back to the run method to interpret
	 * that character and determine what the user wants to do
	 * @return cmd, a character
	 */
	private char acceptCommand() {
		char cmd;
	    String s = JOptionPane.showInputDialog("Enter command: ");
		cmd = s.charAt(0);
		return cmd;
	}
	
	/**
	 * This method is responsible for performing the action that the User/Admin wanted
	 * to perform. If he is a user he can search, manage profile, or manage his saved schools.
	 * If he is an admin, he can manage universities or manage users.
	 * @param cmd
	 * @throws ClassNotFoundException
	 */
	private void doCommand(char cmd)throws ClassNotFoundException  {
	    switch (cmd)
	    {
	    	//Allows admin to Manage Universities
	      case 'U': case 'u':
	        
	        break;
	    	//Allows admin to Manage Users
	      case 'Z': case 'z':
	        
	        break;
	    	//Allows User to Manage his/her saved Schools
	      case 'M': case 'm':
	        
	        break;
	    	//Allows User to Manage search for Schools
	      case 's': case 'S':
	    	searchMenu();
    		String un, s, l, c, nosl, nosu , pfl, pfu, svl, svu, sml, smu, el, eu, fal, fau,  noal, noau, pal, pau, pel, peu, asl, asu, ssl, ssu, qoll, qolu;
    		un= s= l= c= nosl= nosu= pfl= pfu= svl= svu= sml= smu= el= eu= fal= fau=  noal= noau= pal= pau= pel= peu= asl= asu= ssl= ssu= qoll= qolu= null;
    		do
		    {
	    		cmd = '\0';
	    	    String x = JOptionPane.showInputDialog("Please Enter an attribute to add a search value: ");
	    		cmd = x.charAt(0);
	    		switch (cmd)
	    	    {
	    	    	//Add university name search criteria
	    	      case 'A': case 'a':
	  	    	    un = JOptionPane.showInputDialog("Please enter a university name: ");
	  	    	    un = un.toUpperCase();
	    	        break;
	    	    	//add state
	    	      case 'B': case 'b':
		  	    	s = JOptionPane.showInputDialog("Please enter the state of a desired university: ");
		  	    	s = s.toUpperCase();
		  	    	break;
	    	    	//add location search criteria
	    	      case 'C': case 'c':
			  	    l = JOptionPane.showInputDialog("Please Enter the location of a desired university: ");
			  	  	l = l.toUpperCase();
			  	    break;
			  	    //add Control
	    	      case 'D': case 'd':
	  	    	    c = JOptionPane.showInputDialog("Please Enter a Control: ");
	  	    	    c = c.toUpperCase();
	  	    	    break;
	    	    	//add number of students
	    	      case 'E': case 'e':
		  	    	nosl = JOptionPane.showInputDialog("Please Enter a lower bound for the number of students: ");
		  	    	nosu = JOptionPane.showInputDialog("Please Enter an upper bound for the number of students: ");
		  	    	break;
	    	    	//add Percent female
	    	      case 'F': case 'f':
	    	    	pfl = JOptionPane.showInputDialog("Please Enter alower bound for the percent female: ");
			  	    pfu = JOptionPane.showInputDialog("Please Enter an upperbound for the percent female: ");
			  	    //add SAT Verbal
	    	      case 'G': case 'g':
	    	    	svl = JOptionPane.showInputDialog("Please Enter a lower bound for verbal SAT scores: ");
			  	    svu = JOptionPane.showInputDialog("Please Enter and upper bound for verbal SAT scores: ");	    	        
			  	    break;
	    	    	//add SAT Math
	    	      case 'H': case 'h':
	    	    	sml = JOptionPane.showInputDialog("Please Enter a lower bound for math sat scores: ");
			  	    smu = JOptionPane.showInputDialog("Please Enter an upper bound for math sat scores: ");	    	        
			  	    break;
	    	    	//add Expenses
	    	      case 'I': case 'i':
	    	    	el = JOptionPane.showInputDialog("Please Enter a lower bound for expenses ");
			  	    eu = JOptionPane.showInputDialog("Please Enter an upper bound for expenses: ");
	    	        // add financial Aid
	    	      case 'J': case 'j':
	    	    	fal = JOptionPane.showInputDialog("Please Enter a lower bound for financial aid: ");
			  	    fau = JOptionPane.showInputDialog("Please Enter an upper bound for financial aid: ");	    	        
			  	    break;
	    	    	//add Number of applicants
	    	      case 'K': case 'k':
	    	    	noal = JOptionPane.showInputDialog("Please Enter a lower bound for the number of applicants: ");
			  	    noau = JOptionPane.showInputDialog("Please Enter an upper bound for the number of applicants: ");	    	        
			  	    break;
	    	    	//add Percent Admitted
	    	      case 'L': case 'l':
	    	    	pal = JOptionPane.showInputDialog("Please Enter a lower bound for the percent admitted: ");
			  	    pau = JOptionPane.showInputDialog("Please Enter an upper bound for the percent admitted: ");			  	    
			  	    // add percent enrolled
	    	      case 'M': case 'm':
	    	    	pel = JOptionPane.showInputDialog("Please Enter a lower bound for the percent enrolled: ");
			  	    peu = JOptionPane.showInputDialog("Please Enter an upper bound for the percent enrolled: ");	    	        
			  	    break;
	    	    	//add Academic Scale
	    	      case 'O': case 'o':
	    	    	asl = JOptionPane.showInputDialog("Please Enter a lower bound for the academic scale: ");
			  	    asu = JOptionPane.showInputDialog("Please Enter an upper bound for the academic scale: ");			  	    
			  	    //Add Social Scale
	    	      case 'p': case 'P':
	    	    	ssl = JOptionPane.showInputDialog("Please Enter a lower bound for the social scale: ");
			  	    ssu = JOptionPane.showInputDialog("Please Enter an upper bound for the social scale: ");	    	        
			  	    break;
	    	    	//add Quality of life
	    	      case 'Q': case 'q':
	    	    	qoll = JOptionPane.showInputDialog("Please Enter a lower bound for the quality of life: ");
			  	    qolu = JOptionPane.showInputDialog("Please Enter an upper bound for the quality of life: ");	    	        
			  	    break;
	    	    	//Quit
	    	      case 'R': case 'r':
	    	    	break;
			  	    //SEARCH
	    	      case 'S': case 's':
	    	    	  //Prints the search results that the user entered
	    	    	  System.out.print("SEARCH CRITERIA ARE:\nName: " + un+"\nState: "+ s +"\nLocation: "+ l +"\nControl: "+ c +"\n# of Studnets:"+
	    	          nosl +" to "+ nosu +"\n% Female:"+ pfl +" to "+ pfu +"\nSAT Verbal: "+ svl +" to "+ svu +"\nSAT Math: "+ sml +" to "+ smu +"\nExpenses: "+
	    	          el +" to "+ eu +"\nFinancial Aid: "+ fal +" to "+ fau +"\n# applicants: "+ noal +" to "+ noau +"\n% Accepted: "+ pal +" to "+ 
	    	          pau +"\n% Enrolled: "+pel +" to "+ peu +"\nAcademic Scale: "+asl +" to "+asu +"\nSocial Scale: "+ssl +" to "+ssu +"\nQualit of Life: "+
	    	          qoll +" to "+qolu+"\n");
	    	    	  //The search criteria is used to search through all the list
	    	    	  List<University> y = user.searchForSchools(un, s, l, c, nosl, nosu , pfl, pfu, svl, svu, sml, smu, el, eu, fal, fau,  noal, noau, pal, pau, pel, peu, asl, asu, ssl, ssu, qoll, qolu, null);
	    	    	  //The list is traversed and displayed
	    	    	  System.out.println("--------------------------------------------------------");
	    	    	  System.out.println("\tSEARCH RESULTS");
	    	    	  for(University u:y){
	    	    		  System.out.println(u.getUniversityName());
	    	    	  }
	    	    	  displayOptions();
	    	  	      char ch = acceptCommand();
	    	  		  viewAndSave(ch);
	    	  		  cmd = 'R';
	    	    }
		    }
		    while ((cmd != 'R') && (cmd != 'r'));
	        break;
	    	//Allows User to Manage his/her profile
	      case 'p': case 'P':
	    	System.out.println("ACCOUNT DETIALS:");	
	        user.displayStudentDetails();
	        break;
	        //Allows for the user to quit out
	      case 'q': case 'Q':
	        
	        break;
	      default:
	        System.out.println("Invalid command--try again");
	    }
	  }
	
	/**
	 * This method controls the viewing of a school and displaying the 5
	 * matches of that school, along with also being able to save that school
	 * to a student's saved schools list.
	 */
	private void viewAndSave(char cmd){
		if(cmd=='V' || cmd=='v'){
			 String school = JOptionPane.showInputDialog("Enter A Name of the University: ");
			 school = school.toUpperCase();
			 University u = user.getAUniversity(school); 
			 List<University> matches = user.getFiveMatches(u);
			 System.out.println("-----------------------------------------------------");
			 u.printString();
			 System.out.println("-----------------5 SIMILAR SCHOOLS-------------------");
			 for(University uni:matches){
				 uni.printString();
			 }
			 displayOptions();
			 char ch = acceptCommand();
			 viewAndSave(ch); 
		  }
		  else if(cmd=='A' || cmd=='a'){
			 String school = JOptionPane.showInputDialog("Enter A Name of the University you would like to save: ");
		     school = school.toUpperCase();
			 University u = user.getAUniversity(school); 
			 if(u!=null){
				 user.addUniversityToSavedSchools(u);
				 JOptionPane.showMessageDialog(null,"School Successfully Saved to Saved Schools List");}
			 else{
				 JOptionPane.showMessageDialog(null,"School not found, there was an error adding " + school + " to your saved schools list");}
		  }
		  else if(cmd=='R' || cmd=='r'){
			  cmd = 'R';
		  }
	}
	
	/**
	 * SEARCH MENU, displayed when the user wants to perform a command after logging in
	 */
	private void searchMenu(){
		System.out.println();
		System.out.println("-------------------------------------------------------------------------");
	    System.out.println("\tSearch Options");
	    System.out.println("\tA: UniversityName");
	    System.out.println("\tB: State");
	    System.out.println("\tC: Location");
	    System.out.println("\tD: Control");
	    System.out.println("\tE: Number of Students");
	    System.out.println("\tF: PercentFemale");
	    System.out.println("\tG: Sat Verbal");
	    System.out.println("\tH: Sat Math");
	    System.out.println("\tI: Expenses");
	    System.out.println("\tJ: Financial Aid");
	    System.out.println("\tK: Number of Applicants");
	    System.out.println("\tL: Percent Admitted");
	    System.out.println("\tM: Percent Enrolled");
	    System.out.println("\tN: Percent Admitted");
	    System.out.println("\tO: Academic Scale");
	    System.out.println("\tP: Social Scale");
	    System.out.println("\tQ: Quality of Life");
	    System.out.println("\tR: Quit");
	    System.out.println("\tS: SEARCH");
	    System.out.println();
	}
	
	/**
	 * This method displays options for a student to view a school
	 * more in depth or to add that to their saved schools
	 */
	private void displayOptions(){
		System.out.println();
		System.out.println("-------------------------------------------------------------------------");
	    System.out.println("\tOptions");
	    System.out.println("\tV:View School");
	    System.out.println("\tA:Add School to Saved Schools");
	    System.out.println("\tR:Return to main menu");
	    System.out.println();
	}
	
	/**
	 * Main method for the CMC System
	 * @param args
	 * @throws ClassNotFoundException
	 */
	public static void main(String args[])throws ClassNotFoundException{
	    CMCDriver cmc = new CMCDriver();
	    cmc.runSystem();
	}
}
