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
public class AccountTest {
	private Account a,b,c;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		a = new Account("Jacob","Upton","JSU","Jsu--2019",'u','Y');
		b = new Account("Jesse","Upton","JWU","jesse",'a','N');
	}

	/**
	 * Test method for {@link edu.csbsju.Account#Account(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, char)}.
	 */
	@Test
	public void testAccountStringStringStringStringCharChar() {
		a = new Account("Jesse","Upton","JWU","jesse",'a','Y');
	}

	/**
	 * Test method for {@link edu.csbsju.Account#Account(java.lang.String)}.
	 */
	@Test
	public void testAccountString() {
		
	}

	/**
	 * Test method for {@link edu.csbsju.Account#getUsername()}.
	 */
	@Test
	public void testGetUsername() {
		String expResult = "JSU";
		String result = a.getUsername();
		assertEquals("Username is " + expResult,expResult, result);
	}

	/**
	 * Test method for {@link edu.csbsju.Account#getPassword()}.
	 */
	@Test
	public void testGetPassword() {
		String expResult = "Jsu--2019";
		String result = a.getPassword();
		assertEquals("Password is " + expResult,expResult, result);
	}

	/**
	 * Test method for {@link edu.csbsju.Account#getType()}.
	 */
	@Test
	public void testGetType() {
		char expResult = 'u';
		char result = a.getType();
		assertEquals("Type is " + expResult,expResult, result);
	}

	/**
	 * Test method for {@link edu.csbsju.Account#getStatus()}.
	 */
	@Test
	public void testGetStatus() {
		char expResult = 'Y';
		char result = a.getStatus();
		assertEquals("Status is " + expResult,expResult, result);
	}

	/**
	 * Test method for {@link edu.csbsju.Account#getFirstName()}.
	 */
	@Test
	public void testGetFirstName() {
		String expResult = "Jacob";
		String result = a.getFirstName();
		assertEquals("First Name is " + expResult,expResult, result);
	}

	/**
	 * Test method for {@link edu.csbsju.Account#setFirstName(java.lang.String)}.
	 */
	@Test
	public void testSetFirstName() {
		String expResult = "Jesse";
		a.setFirstName("Jesse");
		String result = a.getFirstName();
		assertEquals("First Name is " + expResult,expResult, result);
	}

	/**
	 * Test method for {@link edu.csbsju.Account#getLastName()}.
	 */
	@Test
	public void testGetLastName() {
		String expResult = "Upton";
		String result = a.getLastName();
		assertEquals("Last Name is " + expResult,expResult, result);
	}

	/**
	 * Test method for {@link edu.csbsju.Account#setLastName(java.lang.String)}.
	 */
	@Test
	public void testSetLastName() {
		String expResult = "Stadick";
		a.setLastName("Stadick");
		String result = a.getLastName();
		assertEquals("Last Name is " + expResult,expResult, result);
	}

	/**
	 * Test method for {@link edu.csbsju.Account#setPassword(java.lang.String)}.
	 */
	@Test
	public void testSetPassword() {
		String expResult = "1111";
		a.setPassword("1111");
		String result = a.getPassword();
		assertEquals("Password Name is " + expResult,expResult, result);
	}

	/**
	 * Test method for {@link edu.csbsju.Account#logOff()}.
	 */
	@Test
	public void testLogOff() {
		
	}

	/**
	 * Test method for {@link edu.csbsju.Account#logOn(edu.csbsju.Account)}.
	 */
	@Test
	public void testLogOn() {
		
	}

	/**
	 * Test method for {@link edu.csbsju.Account#displayStudent()}.
	 */
	@Test
	public void testDisplayStudent() {
		String expResult = "[FirstName=Jacob, LastName=Upton, Username=JSU, Password=Jsu--2019, Type=u, Status=Y]\n";
		String result = a.displayStudent();
		assertEquals("The User is " + expResult, expResult, result );
	}

	/**
	 * Test method for {@link edu.csbsju.Account#displayMenu(char)}.
	 */
	@Test
	public void testDisplayMenu() {
		
	}

	/**
	 * Test method for {@link edu.csbsju.Account#displayLoginError()}.
	 */
	@Test
	public void testDisplayLoginError() {
		
	}

	/**
	 * Test method for {@link edu.csbsju.Account#isActive()}.
	 */
	@Test
	public void testIsActive() {
		
	}

	/**
	 * Test method for {@link edu.csbsju.Account#returnType()}.
	 */
	@Test
	public void testReturnType() {
		
	}

}
