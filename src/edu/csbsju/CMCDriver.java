
package edu.csbsju;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;

/**
 * @author jsupton
 * @version 03-02-17
 */
public class CMCDriver {
	private UserUI user;
	private AccountUI account;
	private AdminUI admin;
	
	public CMCDriver(){
		this.user = new UserUI();
		this.account = new AccountUI();
		this.admin = new AdminUI();
	}
	
	public CMCDriver(Account a){
		this.user = new UserUI((User)a);
		this.account = new AccountUI(a);
		this.admin = new AdminUI((Admin)a);
	}
	
	public void runSystem() throws ClassNotFoundException {
		String username = JOptionPane.showInputDialog("Please Enter Username: ");
		String password = JOptionPane.showInputDialog("Please Enter Password: ");
	    Account a = account.logOn(username,password);
	    this.account = new AccountUI(a);
	    char cmd = '\0';
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
	
	private void userMenu(){
		System.out.println();
	    System.out.println("\tS: Search For Schools");
	    System.out.println("\tM: Manage My Saved Schools");
	    System.out.println("\tP: Search For Schools");
	    System.out.println("\tQ: To Quit");
	    System.out.println();
	}
	
	private void adminMenu(){
		System.out.println();
	    System.out.println("\tU: Manage Universities");
	    System.out.println("\tZ: Manage Users");
	    System.out.println("\tQ: To Quit");
	    System.out.println();
	}
	
	private char acceptCommand() {
		char cmd;
	    String s = JOptionPane.showInputDialog("Enter command: ");
		cmd = s.charAt(0);
		return cmd;
	}
	
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
	
	
	public static void main(String args[])throws ClassNotFoundException{
	    CMCDriver cmc = new CMCDriver();
	    cmc.runSystem();
	}
}
