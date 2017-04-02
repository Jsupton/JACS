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
		String p = a.getPassword();
		assertEquals("Password is " + p,p, "jesse");
		String u = a.getUsername();
		assertEquals("UserName is " + u,u, "JWU");
		String f = a.getFirstName();
		assertEquals("First Name is " + f,f, "Jesse");
		String l = a.getLastName();
		assertEquals("Last Name is " + l,l, "Upton");
		char t = a.getType();
		assertEquals("Type is " + t,t, 'a');
		char s = a.getStatus();
		assertEquals("Status is " + s,s, 'Y');
	}

	/**
	 * Test method for {@link edu.csbsju.Account#Account(java.lang.String)}.
	 */
	@Test
	public void testAccountString() {
		a = new Account("JESSE");
		String p = a.getPassword();
		assertEquals("Password is " + p,p, null);
		String u = a.getUsername();
		assertEquals("UserName is " + u,u, "JESSE");
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
		assertEquals("Password is " + expResult,expResult, result);
	}

	/**
	 * Test method for {@link edu.csbsju.Account#logOff()}.
	 */
	@Test
	public void testLogOff() {
		a.logOff();
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
	 * Test method for {@link edu.csbsju.Account#logOn(edu.csbsju.Account)}.
	 */
	@Test
	public void testLogOnCase1() {
		a.logOn(b);
		String p = b.getPassword();
		assertEquals("Password is " + p,p, "jesse");
		String u = b.getUsername();
		assertEquals("UserName is " + u,u, "JWU");
		String f = b.getFirstName();
		assertEquals("First Name is " + f,f, "Jesse");
		String l = b.getLastName();
		assertEquals("Last Name is " + l,l, "Upton");
		char t = b.getType();
		assertEquals("Type is " + t,t, 'a');
		char s = b.getStatus();
		assertEquals("Status is " + s,s, 'N');
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
	public void testDisplayMenuCase1() {
		String expResult = "\tS: Search For Schools\n\tM: Manage My Saved Schools\n\tP: Manage My Profile\n\tQ: To Quit\n";
		String s = a.displayMenu(a.getType());
		assertEquals("The User menu is: \n" + expResult, expResult, s );
	}
	
	/**
	 * Test method for {@link edu.csbsju.Account#displayMenu(char)}.
	 */
	@Test
	public void testDisplayMenuCase2() {
		String expResult ="\tU: Manage Universities\n\tZ: Manage Users\n\tQ: To Quit";
		String s = a.displayMenu(b.getType());
		assertEquals("The Admin menu is: \n" + expResult, expResult, s );
	}
	
	/**
	 * Test method for {@link edu.csbsju.Account#displayMenu(char)}.
	 */
	@Test
	public void testDisplayMenuCase3() {
		String expResult = null;
		String s = a.displayMenu('z');
		assertEquals("Null menu: \n" + expResult, expResult, s );
	}

	/**
	 * Test method for {@link edu.csbsju.Account#displayLoginError()}.
	 */
	@Test
	public void testDisplayLoginError() {
		String expResult = "There was an error Loggin in. Please Try again.";
		String x = a.displayLoginError();
		assertEquals("Login Error is : \n" + expResult, expResult, x );
	}

	/**
	 * Test method for {@link edu.csbsju.Account#isActive()}.
	 */
	@Test
	public void testIsActiveCase1() {
		assertTrue("This Account is active", a.isActive());
	}
	
	/**
	 * Test method for {@link edu.csbsju.Account#isActive()}.
	 */
	@Test
	public void testIsActiveCase2() {
		assertFalse("This Account is not active",b.isActive());
	}

	/**
	 * Test method for {@link edu.csbsju.Account#returnType()}.
	 */
	@Test
	public void testReturnTypeCase1() {
		char x = a.returnType();
		char expResult = 'u';
		assertEquals("The expected Type is : \n" + expResult, expResult, x );
	}
	
	/**
	 * Test method for {@link edu.csbsju.Account#returnType()}.
	 */
	@Test
	public void testReturnTypeCase2() {
		char x = b.returnType();
		char expResult = 'a';
		assertEquals("The expected Type is : \n" + expResult, expResult, x );
	}

}
