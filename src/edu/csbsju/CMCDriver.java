
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
	    	User u = new User(acc.getFirstName(),acc.getLastName(),acc.getUsername(),acc.getPassword(),acc.getStatus(),acc.getType());
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
	    	Account acc = account.displayAccount();
	    	Admin ad = new Admin(acc.getFirstName(),acc.getLastName(),acc.getUsername(),acc.getPassword(),acc.getStatus(),acc.getType());
	    	this.admin = new AdminUI(ad);
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
		        List<University> univer = admin.getUniversities();
		        for(University u:univer){
		        	System.out.println(u.getUniversityName());
		        }
		        manageUniversityMenu();
		        char ch = acceptCommand();
		        //If the user wants to edit an existing university
	        	if(ch == 'E'||ch=='e'){
	   		 		editAndAddUniversity(ch);
	        	}
	        	//If the user wants to add a new university
	        	else if(ch =='A' || ch=='a'){
	        		editAndAddUniversity(ch);
	        	}
	        break;
	        
	        
	 
	    	//Allows admin to Manage Users
	        case 'Z': case 'z':
	        	char type = '\0';
		        ArrayList<Account> acc = admin.getAccounts();
		        for(Account a: acc){
		        	a.displayStudent();
		   		}
		        editAccountMenu();
		        ch = acceptCommand();
		        //If the admin wants to edit a user
		        if(ch=='A'||ch=='a'){
		        	editAndAddAccount(ch); 	 	
		        }
		        //If the admin wants to add a new user
		        else if(ch=='B'||ch=='b'){
		        	editAndAddAccount(ch); 	
		        }
		        //If the admin wants to deactivate a user     
		        else if(ch=='C'||ch=='c'){
		        	Account a = admin.viewAccount(JOptionPane.showInputDialog("Please enter an Account username: "));
		        	admin.deactivate(a);
			    	JOptionPane.showMessageDialog(null,"The Account was successfully deactivated");
		        }
	        break;
	        
	        
	        
	    	//Allows User to Manage his/her saved Schools
	        //The user can view a specific school, or remove a school from their list
	        case 'M': case 'm':
	        	List<String> saved = user.getSavedSchools();
	        	if(saved!=null){
	        		for(String u: saved){
	        			System.out.println(u);
	        		}
	        	}
	        	schoolMenu();
	        	do
	        	{
		        	ch = acceptCommand();
		        	if(ch == 'V'||ch=='v'){
		        		 University u = user.getAUniversity((JOptionPane.showInputDialog("Please enter a university name: ")).toUpperCase());
		        		 if(u!=null){
		        			 u.printString();
		        			 schoolMenu();}
		        		 else{
		        			 JOptionPane.showMessageDialog(null,"THIS SCHOOL DOES NOT EXIST");
		        			 schoolMenu();}
		        	}
		        	else if(ch == 'R'||ch=='r'){
		        		 University u = user.getAUniversity((JOptionPane.showInputDialog("Please enter a university name: ")).toUpperCase());
		        		 if(u!=null){
			        		 boolean b = user.removeUniversityFromSavedSchools(u);
			        		 if(b){
			        			 JOptionPane.showMessageDialog(null,"The university was successfully removed");
			        		 }
			        		 else{
			        			 JOptionPane.showMessageDialog(null,"UNSUCCESSFUL REMOVAL");
			        			 schoolMenu();
			        		 }
		        		 }
		        		 else{
		        			 JOptionPane.showMessageDialog(null,"UNSUCCESSFUL REMOVAL");
		        			 schoolMenu();
		        		 }
		        	}
	        	}
	        	while(ch!='Q');
	        	
	        	cmd = 'R';
	        break;
	        
	        
	        
	        //Allows User to Manage search for Schools
	        case 's': case 'S':
		    	searchMenu();
	    		String un,s,l,c,e;
	    		int nosl, nosu, svl, svu, sml, smu, noal, noau, asl, asu, ssl, ssu, qoll, qolu;
	    		double pfl, pfu, el, eu, fal, fau, pal, pau, pel, peu;
	    		un=s=l=c=null;
	    		nosl=nosu=svl=svu=sml=smu=noal=noau=asl=asu=ssl=ssu=qoll=qolu=0;
	    		pfl=pfu=el=eu=fal=fau=pal=pau=pel=peu=0.0;
	    		List<String> emphases = new ArrayList<String>();
	    		JOptionPane.showMessageDialog(null,"To Browse All Schools, Search without any criteria.");
	    		//This populates the variables in order for the person to search
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
			  	    	nosl = Integer.parseInt(JOptionPane.showInputDialog("Please Enter a lower bound for the number of students: "));
			  	    	nosu = Integer.parseInt(JOptionPane.showInputDialog("Please Enter an upper bound for the number of students: "));
			  	    	break;
		    	    	//add Percent female
		    	      case 'F': case 'f':
		    	    	pfl = Double.parseDouble(JOptionPane.showInputDialog("Please Enter alower bound for the percent female (0-100): "));
				  	    pfu = Double.parseDouble(JOptionPane.showInputDialog("Please Enter an upperbound for the percent female (0-100): "));
				  	    //add SAT Verbal
		    	      case 'G': case 'g':
		    	    	svl = Integer.parseInt(JOptionPane.showInputDialog("Please Enter a lower bound for verbal SAT scores (0-800): "));
				  	    svu = Integer.parseInt(JOptionPane.showInputDialog("Please Enter and upper bound for verbal SAT scores (0-800): "));	    	        
				  	    break;
		    	    	//add SAT Math
		    	      case 'H': case 'h':
		    	    	sml = Integer.parseInt(JOptionPane.showInputDialog("Please Enter a lower bound for math sat scores (0-800): "));
				  	    smu = Integer.parseInt(JOptionPane.showInputDialog("Please Enter an upper bound for math sat scores (0-800): "));	    	        
				  	    break;
		    	    	//add Expenses
		    	      case 'I': case 'i':
		    	    	el = Double.parseDouble(JOptionPane.showInputDialog("Please Enter a lower bound for expenses "));
				  	    eu = Double.parseDouble(JOptionPane.showInputDialog("Please Enter an upper bound for expenses: "));
		    	        // add financial Aid
		    	      case 'J': case 'j':
		    	    	fal = Double.parseDouble(JOptionPane.showInputDialog("Please Enter a lower bound for financial aid: "));
				  	    fau = Double.parseDouble(JOptionPane.showInputDialog("Please Enter an upper bound for financial aid: "));	    	        
				  	    break;
		    	    	//add Number of applicants
		    	      case 'K': case 'k':
		    	    	noal = Integer.parseInt(JOptionPane.showInputDialog("Please Enter a lower bound for the number of applicants: "));
				  	    noau = Integer.parseInt(JOptionPane.showInputDialog("Please Enter an upper bound for the number of applicants: "));	    	        
				  	    break;
		    	    	//add Percent Admitted
		    	      case 'L': case 'l':
		    	    	pal = Double.parseDouble(JOptionPane.showInputDialog("Please Enter a lower bound for the percent admitted (0-100): "));
				  	    pau = Double.parseDouble(JOptionPane.showInputDialog("Please Enter an upper bound for the percent admitted (0-100): "));			  	    
				  	    // add percent enrolled
		    	      case 'M': case 'm':
		    	    	pel = Double.parseDouble(JOptionPane.showInputDialog("Please Enter a lower bound for the percent enrolled (0-100): "));
				  	    peu = Double.parseDouble(JOptionPane.showInputDialog("Please Enter an upper bound for the percent enrolled (0-100)  : "));	    	        
				  	    break;
		    	    	//add Academic Scale
		    	      case 'O': case 'o':
		    	    	asl = Integer.parseInt(JOptionPane.showInputDialog("Please Enter a lower bound for the academic scale (0-5): "));
				  	    asu = Integer.parseInt(JOptionPane.showInputDialog("Please Enter an upper bound for the academic scale (0-5): "));			  	    
				  	    //Add Social Scale
		    	      case 'p': case 'P':
		    	    	ssl = Integer.parseInt(JOptionPane.showInputDialog("Please Enter a lower bound for the social scale (0-5): "));
				  	    ssu = Integer.parseInt(JOptionPane.showInputDialog("Please Enter an upper bound for the social scale (0-5): "));	    	        
				  	    break;
		    	    	//add Quality of life
		    	      case 'Q': case 'q':
		    	    	qoll = Integer.parseInt(JOptionPane.showInputDialog("Please Enter a lower bound for the quality of life (0-5): "));
				  	    qolu = Integer.parseInt(JOptionPane.showInputDialog("Please Enter an upper bound for the quality of life (0-5): "));	    	        
				  	    break;
		    	      case 't': case 'T':
			    	    e = (JOptionPane.showInputDialog("Please Enter an emphases: ")).toUpperCase();
			    	    emphases.add(e);
			    	    break;
		    	    	//Quit
		    	      case 'R': case 'r':
		    	    	break;
				  	    //SEARCH
		    	      case 'S': case 's':
		    	    	//Prints the search results that the user entered
		    	    	System.out.print("SEARCH CRITERIA ARE:\nName: " + un+"\nState: "+ s +"\nLocation: "+ l +"\nControl: "+ c +"\n# of Studnets:"+ nosl +" to "+ nosu +"\n% Female:"+ pfl +" to "+ pfu +"\nSAT Verbal: "+ svl +" to "+ svu +"\nSAT Math: "+ sml +" to "+ smu +"\nExpenses: "+
		    	        el +" to "+ eu +"\nFinancial Aid: "+ fal +" to "+ fau +"\n# applicants: "+ noal +" to "+ noau +"\n% Accepted: "+ pal +" to "+ pau +"\n% Enrolled: "+pel +" to "+ peu +"\nAcademic Scale: "+asl +" to "+asu +"\nSocial Scale: "+ssl +" to "+ssu +"\nQualit of Life: "+
		    	        qoll +" to "+qolu+"\n");
		    	    	//The search criteria is used to search through all the list
		    	    	List<University> y = user.searchForSchools(un, s, l, c, nosl, nosu , pfl, pfu, svl, svu, sml, smu, el, eu, fal, fau,  noal, noau, pal, pau, pel, peu, asl, asu, ssl, ssu, qoll, qolu, emphases);
		    	    	//The list is traversed and displayed
		    	    	System.out.println("--------------------------------------------------------");
		    	    	System.out.println("\tSEARCH RESULTS");
		    	    	for(University u:y){
		    	    		System.out.println(u.getUniversityName());
		    	    	}
		    	    	displayOptions();
		    	  	    ch = acceptCommand();
		    	  		viewAndSave(ch);
		    	  		cmd = 'R';
		    	    }
			    }
			    while ((cmd != 'R') && (cmd != 'r'));
	        break;
	        
	        
	        
	      //Allows User to Manage his/her profile
	      case 'p': case 'P':
	    	  String fn,ln,p = null;
	    	  System.out.println("ACCOUNT DETIALS:");	
	    	  User u = user.displayStudentDetails();
	    	  fn = u.getFirstName();
	    	  ln = u.getLastName();
	    	  p = u.getPassword();
	    	  userEditMenu(u);
	    	  do{
	        		ch = acceptCommand();
		        	if(ch == 'F'||ch=='f'){
		        		fn = JOptionPane.showInputDialog("Please Enter new First Name: ");
		        	}
		        	if(ch == 'L'||ch=='l'){
		        		ln = JOptionPane.showInputDialog("Please Enter new Last Name: ");
		        	}
		        	if(ch == 'P'||ch=='p'){
		        		p = JOptionPane.showInputDialog("Please Enter new password: ");
		        	}
		        	if(ch == 'R'||ch=='r'){
		        		fn = u.getFirstName();
		    	        ln = u.getLastName();
		    	        p = u.getPassword();
		    	        JOptionPane.showMessageDialog(null,"The changes were reset");
		        	}
	        	}
	           while((ch!='Q') && (ch!='q'));
	           user.editStudentProfile(fn,ln,p);
		       break;
	        
	        
	      
		  //Allows for the user to quit out
	      case 'q': case 'Q':
	    	  JOptionPane.showMessageDialog(null,"Logging Out of the System");
	    	  break;
	      default:
	        System.out.println("Invalid command--try again");
	    }
	  }
	
	
	/**
	 * This method allows the user to be able to choose to either edit an account
	 * or to add an account. If the user edits an account, all of the variables are
	 * initialized to their previous values, so if the user saves and doesn't edit
	 * one value, its old value is kept. If the Admin decides to add a new user they are
	 * asked for a user name and then can edit the other attributes.
	 * @param ch a character telling what command to perform
	 */
	private void editAndAddAccount(char ch){
		String first,last,pass;
    	first = last = pass = null;
    	char type,status, cmd;
    	type = status = '\0';
		if(ch == 'A'||ch == 'a'){
			Account a = admin.viewAccount(JOptionPane.showInputDialog("Please enter an Account username: "));
        	first = a.getFirstName();
        	last = a.getLastName();
        	pass = a.getPassword();
        	type = a.getType();
        	status = a.getStatus();
        	a.displayStudent();
        	accountEditMenu(a);
		}
		else if(ch == 'B'||ch == 'b'){
			String username = JOptionPane.showInputDialog("Please enter an Account username: ");
        	Account otherA = new Account(username);
        	first = otherA.getUsername();
            type = 'u';
            status = 'Y';
        	accountEditMenu(otherA);
		}
        do
	    {
	    	String x = JOptionPane.showInputDialog("Please Enter a command for an attribute: ");
	    	cmd = x.charAt(0);
	    	switch (cmd)
	    	{
	    	    	//add state
	    		case 'F': case 'f':
		  	    	first = JOptionPane.showInputDialog("Please enter a new name for the Account ");
		  	    	break;
	    	    	//add location search criteria
	    	    case 'L': case 'l':
			  	    last = JOptionPane.showInputDialog("Please Enter a new lastname for the account ");
			  	    break;
			  	    //add Control
	    	    case 'P': case 'p':
	  	    	    pass = JOptionPane.showInputDialog("Please Enter a new password for the acount ");
	  	    	    break;
	    	    	//add number of students
	    	    case 'T': case 't':
		  	    	type = (JOptionPane.showInputDialog("Please Enter a type for the account: ")).charAt(0);
		  	    	break;
		  	    	//QUIT
			    case 'R': case 'r':
			    	JOptionPane.showMessageDialog(null,"Any Aditional Changes WERE NOT saved");
		    	    cmd = 'R';
				  	break;
			      //save changes
			    case 'Q': case 'q':
				    admin.editAccount(first, last, first, pass, type, status);
			    	JOptionPane.showMessageDialog(null,"The Changes were saved successfully");
			    	cmd = 'R';
				    break;
	    	    }
		    }
		    while ((cmd != 'R') && (cmd != 'r'));
		}
	
	
	
	/**
	 * This method controls the viewing of a school and displaying the 5
	 * matches of that school, along with also being able to save that school
	 * to a student's saved schools list.
	 * @param cmd, a character telling what command to perform
	 */
	private void viewAndSave(char cmd){
		//The user can view a school that was just searched for. If they view a school, the getFiveMatches
		//Method is used on it to get the 5 schools that are close to it
		if(cmd=='V' || cmd=='v'){
			 String school = (JOptionPane.showInputDialog("Enter A Name of the University: ")).toUpperCase();
			 University u = user.getAUniversity(school); 
			 List<University> matches = user.getFiveMatches(u);
			 System.out.println("-----------------------------------------------------");
			 if(u!=null){
					 u.printString();
				 System.out.println("-----------------5 SIMILAR SCHOOLS-------------------");
				 for(University uni:matches){
					 uni.printString();
				 }
			 }
			 else if(u==null){
				 System.out.println("No schools matched the university name "+ school);
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
	 * This is the method that allows the user to edit a university or add a new university
	 * If the admin decides to edit a University all attributes are set to their previous values
	 * So if the user saves and doesn't edit a value, it isn't left blank. The admin can also choose
	 * to add a new University in which they are asked for a university name and then they can save
	 * @param ch, a character telling what command to perform
	 */
	private void editAndAddUniversity(char ch){
		String un, s, l, c, emp;
    	un=s=l=c=emp=null;
    	int nos, sv, sm, noa,as, ss, qol;
    	nos=sv=sm=noa=as=ss=qol=0;
    	double pf, e, fa,pa ,pe;
    	pf=e=fa=pa=pe=0.0;
    	char cmd;
    	List<String> emphases = null;
    	if(ch == 'E'|| ch == 'e'){
    			University univ = user.getAUniversity(JOptionPane.showInputDialog("Please enter a university name: ").toUpperCase());
		 		un = univ.getUniversityName(); 
		 		s = univ.getState();
		 		l = univ.getLocation();
		 		c = univ.getControl();
		 		nos = univ.getNumberOfStudents(); 
		 		sv = univ.getSatVerbal();
		 		sm = univ.getSatMath();
		 		noa = univ.getNumberOfApplicants();
		 		as = univ.getAcademicScale(); 
		 		ss = univ.getSocialScale();
		 		qol = univ.getQualityOfLife();
		 		pf = univ.getPercentFemale();
		 		e = univ.getExpenses(); 
		 		fa = univ.getFinancialAid();
		 		pa = univ.getPercentAdmitted();
		 		pe = univ.getPercentEnrolled();
		 		emphases = univ.getEmphases();
		 		System.out.println();
   		 		univ.printString();
   		 		universityMenu();
    	}
    	else if(ch == 'A'||ch == 'a'){
    		universityMenu();
    		cmd = '\0';
    	    un = JOptionPane.showInputDialog("Please enter a university name: ").toUpperCase();
    	}
		do
	    {
    	    String x = JOptionPane.showInputDialog("Please Enter an attribute value to add to the University: ");
    	    cmd = x.charAt(0);
    		switch (cmd)
    	    {
    	    	//add state
    	      case 'B': case 'b':
	  	    	s = JOptionPane.showInputDialog("Please enter the state of a desired university: ").toUpperCase();
	  	    	break;
    	    	//add location search criteria
    	      case 'C': case 'c':
		  	    l = JOptionPane.showInputDialog("Please Enter the location of a desired university: ").toUpperCase();
		  	    break;
		  	    //add Control
    	      case 'D': case 'd':
  	    	    c = JOptionPane.showInputDialog("Please Enter a Control: ").toUpperCase();
  	    	    break;
    	    	//add number of students
    	      case 'E': case 'e':
	  	    	nos = Integer.parseInt(JOptionPane.showInputDialog("Please Enter a number of students: "));
	  	    	break;
    	    	//add Percent female
    	      case 'F': case 'f':
		  	    pf = Double.parseDouble(JOptionPane.showInputDialog("Please Enter a percent Female: "));
		  	    break;
		  	    //add SAT Verbal
    	      case 'G': case 'g':
    	    	sv = Integer.parseInt(JOptionPane.showInputDialog("Please Enter a verbal sat score: "));	    	        
		  	    break;
    	    	//add SAT Math
    	      case 'H': case 'h':
    	    	sm = Integer.parseInt(JOptionPane.showInputDialog("Please Enter a math sat score: "));   	        
		  	    break;
    	    	//add Expenses
    	      case 'I': case 'i':
    	    	e = Double.parseDouble(JOptionPane.showInputDialog("Please Enter expenses: "));
    	        // add financial Aid
    	      case 'J': case 'j':
    	    	fa = Double.parseDouble(JOptionPane.showInputDialog("Please Enter financial aid: "));	    	        
		  	    break;
    	    	//add Number of applicants
    	      case 'K': case 'k':
    	    	noa = Integer.parseInt(JOptionPane.showInputDialog("Please Enter the number of applicants: "));	    	        
		  	    break;
    	    	//add Percent Admitted
    	      case 'L': case 'l':
    	    	pa = Double.parseDouble(JOptionPane.showInputDialog("Please Enter percent admitted: "));			  	    
		  	    // add percent enrolled
    	      case 'M': case 'm':
    	        pe = Double.parseDouble(JOptionPane.showInputDialog("Please Enter percent enrolled: "));	    	        
		  	    break;
    	    	//add Academic Scale
    	      case 'O': case 'o':
    	    	as = Integer.parseInt(JOptionPane.showInputDialog("Please Enter an academic scale: "));		  	    
		  	    //Add Social Scale
    	    	break;
    	      case 'p': case 'P':
    	    	ss = Integer.parseInt(JOptionPane.showInputDialog("Please Enter a social scale: "));	    	        
		  	    break;
    	    	//add Quality of life
    	      case 'Q': case 'q':
    	    	qol = Integer.parseInt(JOptionPane.showInputDialog("Please Enter a quality of life: "));	    	        
		  	    break;
    	      case 'U': case 'u':
    	    	    String input = JOptionPane.showInputDialog("Please enter wether you would like to Add an Emphases (x) or remove an emphases (y): ");
    	    	    cmd = input.charAt(0);
    	    	    if(cmd == ('x')){
    	    	    	emp = JOptionPane.showInputDialog("Please Enter an emphases to Add: ").toUpperCase();
    	    	    	input = JOptionPane.showInputDialog("Are You sure You want to Add This Ephases? (y/n)");
        	    	    cmd = input.charAt(0);
        	    	    if(cmd == 'y'){
        	    	    	int i = admin.addEmphases(un, emp);
        	    	    	if(i==-1){
            	    	    	JOptionPane.showMessageDialog(null,"There was an error adding the Emphases");
        	    	    	}
        	    	    	else
            	    	    	JOptionPane.showMessageDialog(null,"The Emphases was added successfully");
        	    	    }
    	    	    }
    	    	    else if(cmd == ('y')){
    	    	    	emp = JOptionPane.showInputDialog("Please Enter an emphases to remove: ").toUpperCase();
    	    	    	input = JOptionPane.showInputDialog("Are You sure You want to Remove This Ephases? (y/n)");
        	    	    cmd = input.charAt(0);
        	    	    if(cmd == 'y'){
        	    	    	int i = admin.addEmphases(un, emp);
        	    	    	if(i==-1){
            	    	    	JOptionPane.showMessageDialog(null,"There was an error adding the Emphases");
        	    	    	}
        	    	    	else
            	    	    	JOptionPane.showMessageDialog(null,"The Emphases was added successfully");
        	    	    }
    	    	    }
    	    	break;
    	      case 'S': case 's':
    	    	admin.editUniversity(un, s, l, c, nos, pf, sv,sm,e,fa,noa,pa,pe,as,ss,qol);
    	    	cmd = 'R';
    	    	break;
    	      case 'T': case 't':
    	    	System.out.print("SCHOOL PREVIEW:\nName: " + un+"\nState: "+ s +"\nLocation: "+ l +"\nControl: "+ c +"\n# of Studnets:"+ nos +"\n% Female:"+ pf +"\nSAT Verbal: "+ sv +"\nSAT Math: "+ sm +"\nExpenses: "+
  		    	e +"\nFinancial Aid: "+ fa +"\n# applicants: "+ noa +"\n% Accepted: "+ pa +"\n% Enrolled: "+pe +"\nAcademic Scale: "+as +"\nSocial Scale: "+ss +"\nQualit of Life: "+ qol +"\n");
    	    	System.out.print("Emphases: [");
    	    	if(emphases!=null){
    	    		for(String emph:emphases){
    	    			System.out.print(emph+"   ");
    	    		}
    	    	}
    	    	System.out.print("]\n");
    	    	break;
    	      case 'R': case 'r':
    	    	JOptionPane.showMessageDialog(null,"The Changes WERE NOT saved");
    	    	cmd = 'R';
    	    }
	    }
	    while ((cmd != 'R') && (cmd != 'r'));
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
	    System.out.println("\tT: Emphases");
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
	 * This is the menu for Users to deal with their saved schools list
	 */
	private void schoolMenu(){
		System.out.println();
  	    System.out.println("--------------------------------------------------------");
	    System.out.println("\tR: Remove school");
	    System.out.println("\tV: View School");
	    System.out.println("\tQ: Return to main menu");
	    System.out.println();
	}
	
	/**
	 * This is displayed when a user is editing their profile
	 */
	private void userEditMenu(User u){
		System.out.println();
  	    System.out.println("--------------------------------------------------------");
	    System.out.println("\tF: First Name: "+ u.getFirstName());
	    System.out.println("\tL: Last Name: "+ u.getLastName());
	    System.out.println("\t   Username: "+ u.getUsername()+ "  <-- CANNOT EDIT --");
	    System.out.println("\tP: Password: "+ u.getPassword());
	    System.out.println("\tR: Reset ");
	    System.out.println("\tQ: Save Changes/Return to main menu ");
	    System.out.println();
	}
	
	/**
	 * This menu is displayed for admins when dealing with universities
	 */
	private void manageUniversityMenu(){
		System.out.println();
  	    System.out.println("--------------------------------------------------------");
	    System.out.println("\tE: Edit a University");
	    System.out.println("\tA: Add a University");
	    System.out.println("\tQ: Return to main menu");
	}
	
	
	/**
	 * this is a menu displayed for Admins adding a university
	 */
	private void universityMenu(){
		System.out.println();
		System.out.println("-------------------------------------------------------------------------");
	    System.out.println("\tUniversity Options");
	    System.out.println("\t   UniversityName  <-- CANNOT EDIT --");
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
	    System.out.println("\tU: Emphases");
	    System.out.println("\tR: Quit");
	    System.out.println("\tT: PREVIEW NEW SCHOOL");
	    System.out.println("\tS: SAVE NEW SCHOOL");
	    System.out.println();
	}
	
	/**
	 * This is the menu for an admin to see their options for dealing with accounts
	 */
	private void editAccountMenu(){
		System.out.println();
		System.out.println("-------------------------------------------------------------------------");
	    System.out.println("\tEdit User Options");
	    System.out.println("\tA: Edit User");
	    System.out.println("\tB: Add User");
	    System.out.println("\tC: Deactivate User");
	    System.out.println("\tR: Quit");
	    System.out.println();
	}
	
	/**
	 * This is the menu for an admin to edit an account
	 */
	private void accountEditMenu(Account a){
		System.out.println();
  	    System.out.println("--------------------------------------------------------");
	    System.out.println("\tF: First Name: "+ a.getFirstName());
	    System.out.println("\tL: Last Name: "+ a.getLastName());
	    System.out.println("\t   Username: "+ a.getUsername()+ "  -- CANNOT EDIT --");
	    System.out.println("\tP: Password: "+ a.getPassword());
	    System.out.println("\t   Status: "+ a.getStatus()+ "  -- CANNOT EDIT FROM HERE --");
	    System.out.println("\tT: Type: "+ a.getType());
	    System.out.println("\tR: Reset/Return to main menu ");
	    System.out.println("\tQ: Save Changes ");
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
