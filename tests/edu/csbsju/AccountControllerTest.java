/**
 * 
 */
package edu.csbsju;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author jsupton
 *
 */
public class AccountControllerTest {

	private AccountController ac;
	/**
	 * @throws java.lang.Exception
	 * sets up the new account controller object
	 */
	@Before
	public void setUp() throws Exception {
		ac = new AccountController(new Account("Jacob","Upton","JSU","Jsu--2019",'u','Y'));
	}

	/**
	 * Test method for {@link edu.csbsju.AccountController#AccountController()}.
	 * Tests the first constructor for the Account Controller Class
	 */
	@Test
	public void testAccountController() {
		AccountController a = new AccountController();
		Account actual = a.displayAccount();
		assertEquals("The account object is null", null, actual);
	}

	/**
	 * Test method for {@link edu.csbsju.AccountController#AccountController(edu.csbsju.Account)}.
	 * Tests the next constructor, this constructor takes in an account
	 * object as a parameter and then initializes that value to an account
	 * instance variable
	 */
	@Test
	public void testAccountControllerAccount() {
		AccountController a = new AccountController(new Account("Jacob","Upton","JSU","Jsu--2019",'u','Y'));
		Account exp = a.displayAccount();
		assertEquals("Password is " + exp.getPassword(),exp.getPassword(), "Jsu--2019");
		assertEquals("UserName is " + exp.getUsername(),exp.getUsername(), "JSU");
		assertEquals("First Name is " + exp.getFirstName(),exp.getFirstName(), "Jacob");
		assertEquals("Last Name is " + exp.getLastName(),exp.getLastName(), "Upton");
		assertEquals("Type is " + exp.getType(),exp.getType(),'u');
		assertEquals("Status is " + exp.getStatus(),exp.getStatus(),'Y');
	
	}

	/**
	 * Test method for {@link edu.csbsju.AccountController#AccountController(edu.csbsju.Account, edu.csbsju.DBController)}.
	 * Tests the next constructor, this constructor takes in an account
	 * object as a parameter and a DBController object as a parameter
	 * and then initializes them both to instance variables in the AccountController
	 * class
	 */
	@Test
	public void testAccountControllerAccountDBController() {
		AccountController a = new AccountController(new Account("Jacob","Upton","JSU","Jsu--2019",'u','Y'),new DBController());
		Account exp = a.displayAccount();
		assertEquals("Password is " + exp.getPassword(),exp.getPassword(), "Jsu--2019");
		assertEquals("UserName is " + exp.getUsername(),exp.getUsername(), "JSU");
		assertEquals("First Name is " + exp.getFirstName(),exp.getFirstName(), "Jacob");
		assertEquals("Last Name is " + exp.getLastName(),exp.getLastName(), "Upton");
		assertEquals("Type is " + exp.getType(),exp.getType(),'u');
		assertEquals("Status is " + exp.getStatus(),exp.getStatus(),'Y');
	}

	/**
	 * Test method for {@link edu.csbsju.AccountController#logOn(java.lang.String, java.lang.String)}.
	 * Tests that the logon method is successful for a good combination of
	 * usernames and password and the account object is not deactivated
	 */
	@Test
	public void testLogOnSuccessful() {
		Account a = ac.logOn("juser", "user");
		String p = a.getPassword();
		assertEquals("Password is " + p,p, "user");
		String u = a.getUsername();
		assertEquals("UserName is " + u,u, "juser");
		String f = a.getFirstName();
		assertEquals("First Name is " + f,f, "Jackson");
		String l = a.getLastName();
		assertEquals("Last Name is " + l,l, "User");
		char t = a.getType();
		assertEquals("Type is " + t,t,'u');
		char s = a.getStatus();
		assertEquals("Status is " + s,s,'Y');
	}
	
	/**
	 * Test method for {@link edu.csbsju.AccountController#logOn(java.lang.String, java.lang.String)}.
	 * This logOn method is used to test if the logon method
	 * will fail for an invalid username
	 */
	@Test (expected=Error.class)
	public void testLogOnFailsForInvalidUsername() {
		ac.logOn("JJJJ", "user");
	}
	
	/**
	 * Test method for {@link edu.csbsju.AccountController#logOn(java.lang.String, java.lang.String)}.
	 * This logOn method is used to test if the logon method
	 * will fail for an invalid password
	 */
	@Test (expected=Error.class)
	public void testLogOnFailsForInvalidPassword() {
		ac.logOn("juser", "JJJJJ");
	}
	
	/**
	 * Test method for {@link edu.csbsju.AccountController#logOn(java.lang.String, java.lang.String)}.
	 * This logOn method is used to test if the logon method
	 * will fail for a deactivated account
	 */
	@Test (expected=Error.class)
	public void testLogOnFailsForDeactivatedAccount() {
		ac.logOn("luser", "luser");
	}

	/**
	 * Test method for {@link edu.csbsju.AccountController#logOff()}.
	 * Ensures that when a user logs off, the Account instance variable
	 * is set back to its null value.
	 */
	@Test
	public void testLogOff() {
		Account a = ac.logOff();
		String p = a.getPassword();
		assertEquals("Password is " + p,p, null);
		String u = a.getUsername();
		assertEquals("UserName is " + u,u, null);
		String f = a.getFirstName();
		assertEquals("First Name is " + f,f, null);
		String l = a.getLastName();
		assertEquals("Last Name is " + l,l, null);
		char t = a.getType();
		assertEquals("Type is " + t,t, '\0');
		char s = a.getStatus();
		assertEquals("Status is " + s,s, '\0');
	}

	/**
	 * Test method for {@link edu.csbsju.AccountController#getAUniversity(java.lang.String)}.
	 */
	@Test
	public void testGetAUniversity() {
		String expResult = ("Name: \t\t\tWALLA WALLA COLLEGE\nLocation: \t\tSMALL-CITY\nState: \t\t\tWASHINGTON"+
		"\nControl: \t\tPRIVATE\nNumber Of Students: \t10000\nPercent Female: \t46.0"+
		"\nSAT Verbal: \t\t400\nSAT Math: \t\t400\nExpenses: \t\t26177.0\nfinancialAid: \t\t"
		+ "70.0\nNumber Of Applicants: \t4000\nPercent Admitted: \t70.0"+
		"\nPercent Enrolled: \t60.0\nAcademic Scale: \t2\nSocial Scale: \t\t"+
		"2\nQuality Of Life: \t5\nEmphases: \t\t[BIBLICAL-LANGUAGES, ENGLISH, INDUSTRIAL-ARTS]]\n");
		University x = ac.getAUniversity("WALLA WALLA COLLEGE");
		assertEquals("This is the university: " +expResult, expResult, x.printString());
	}
	
	/**
	 * Test method for {@link edu.csbsju.AccountController#getAUniversity(java.lang.String)}.
	 */
	@Test (expected=Error.class)
	public void testGetAUniversityFailsForInvalidName() {
		ac.getAUniversity("Jacob");
	}

	/**
	 * Test method for {@link edu.csbsju.AccountController#displayUniversity(java.lang.String)}.
	 */
	@Test
	public void testDisplayUniversity() {
		String expResult = ("Name: \t\t\tWALLA WALLA COLLEGE\nLocation: \t\tSMALL-CITY\nState: \t\t\tWASHINGTON"+
		"\nControl: \t\tPRIVATE\nNumber Of Students: \t10000\nPercent Female: \t46.0"+
		"\nSAT Verbal: \t\t400\nSAT Math: \t\t400\nExpenses: \t\t26177.0\nfinancialAid: \t\t"
		+ "70.0\nNumber Of Applicants: \t4000\nPercent Admitted: \t70.0"+
		"\nPercent Enrolled: \t60.0\nAcademic Scale: \t2\nSocial Scale: \t\t"+
		"2\nQuality Of Life: \t5\nEmphases: \t\t[BIBLICAL-LANGUAGES, ENGLISH, INDUSTRIAL-ARTS]]\n");
		String x = ac.displayUniversity("WALLA WALLA COLLEGE");
		assertEquals("This is the university: " +expResult, expResult, x);
	}
	
	/**
	 * Test method for {@link edu.csbsju.AccountController#displayUniversity(java.lang.String)}.
	 */
	@Test (expected=Error.class)
	public void testDisplayUniversityFailsForInvalidName() {
		ac.displayUniversity("Jacob");
	}
	/**
	 * Test method for {@link edu.csbsju.AccountController#confirmEdit()}.
	 */
	@Test
	public void testConfirmEditTrue() {
		boolean expResult = true;
		boolean result = ac.confirmEdit("y");
		assertEquals("Confirm edit is " + expResult,expResult, result);
	}
	
	/**
	 * Test method for {@link edu.csbsju.AccountController#confirmEdit()}.
	 */
	@Test
	public void testConfirmEditFalse() {
		boolean expResult = false;
		boolean result = ac.confirmEdit("n");
		assertEquals("Confirm edit is " + expResult,expResult, result);
	}
	
	/**
	 * Test method for {@link edu.csbsju.AccountController#confirmEdit()}.
	 */
	@Test (expected = Error.class)
	public void testConfirmEditInvalid() {
		ac.confirmEdit("g");
		}

	/**
	 * Test method for {@link edu.csbsju.AccountController#isActive()}.
	 */
	@Test
	public void testIsActive() {
		boolean expResult = true;
		boolean result = ac.isActive();
		assertEquals("Is this Account active? -->" + expResult,expResult, result);
	}

	/**
	 * Test method for {@link edu.csbsju.AccountController#returnType()}.
	 */
	@Test
	public void testReturnType() {
		char expResult = 'u';
		char result = ac.returnType();
		assertEquals("Type is " + expResult,expResult, result);
	}

	/**
	 * Test method for {@link edu.csbsju.AccountController#displayAccount()}.
	 */
	@Test
	public void testDisplayAccount() {
		Account expResult = new Account("Jacob","Upton","JSU","Jsu--2019",'u','Y');
		Account result = ac.displayAccount();
		String p = expResult.getPassword();
		assertEquals("Password is " + p,p, result.getPassword());
		String u = expResult.getUsername();
		assertEquals("UserName is " + u,u, result.getUsername());
		String f = expResult.getFirstName();
		assertEquals("First Name is " + f,f, result.getFirstName());
		String l = expResult.getLastName();
		assertEquals("Last Name is " + l,l, result.getLastName());
		char t = expResult.getType();
		assertEquals("Type is " + t,t, result.getType());
		char s = expResult.getStatus();
		assertEquals("Status is " + s,s, result.getStatus());
	}

}
