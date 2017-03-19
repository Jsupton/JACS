/**
 * 
 */
package edu.csbsju;
/**
 * 
 */
import java.util.*;

/**
 * This class acts as an Administrator object. They are able to perform
 * different functionalities than an User can, thus this class allows 
 * Adminitrator to perform those action.
 * @author cjzins
 * @version 02-26-17
 */
public class Admin extends Account{
 private AdminFuncController a;
   /**
   * This instance variable is a String that represents the 
   * first name of the Account object
   */
  private String firstName;
  /**
   * This instance variable is a String that represents the 
   * last name of the Account object
   */
  private String lastName;
  /**
   * This instance variable is a String that represents the 
   * username of the Account object
   */
  private String username;
  /**
   * This instance variable is a String that represents the 
   * password of the Account object
   */
  private String password;
  /**
   * This instance variable is a String that represents the 
   * status (active or deactive) of the Account object
   */
  protected char status;
  /**
   * This instance variable is a String that represents the 
   * type (admin or user) of the Account object
   */
  protected char type;
  
 /**
  * this constructor creates an Admin object using the constructor
  * from Account, which Admin extends
  * @param firstName the name of an admin
  * @param lastName the lastname of an admin
  * @param username the admin's username
  * @param password the admin's password
  * @param status the status of the admin
  * @param type the type of the admin
  */
 public Admin(String firstName, String lastName, String username, String password, char status, char type) {
  super(firstName, lastName, username, password, type,status);
  this.firstName = firstName;
  this.lastName = lastName;
  this.username = username;
  this.password = password;
  this.status = status;
  this.type = type;
  this.a= new AdminFuncController();
 }

 /**
  * this constructor creates an Admin object using the constructor
  * from Account, which Admin extends
  * @param firstName the name of an admin
  */
 public Admin(String firstName) {
  super(firstName);
  this.firstName = firstName;
  this.lastName = null;
    this.username = null;
    this.password = null;
    this.status = '\0';
    this.type = '\0';
    this.a= new AdminFuncController();
    
 }
}