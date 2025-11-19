package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

/**
 * Test: LoginInvalidTest
 * Purpose: Verify application shows an error message on invalid login attempt.
 */
public class LoginInvalidTest extends BaseTest {
	
	/**
	 * Test: verifyInvalidLogin
	 * - Attempts login with incorrect credentials
	 * - Asserts the invalid credentials message is displayed
	 */
	@Test(priority=0)
	public void verifyInvalidLogin() {
		
		
		LoginPage loginPage = new LoginPage(driver);
			
		loginPage.loginToApp("Adminm", "admin1235");
		String invalidMessage=loginPage.getInvalidCredentialsMessage();
		
		System.out.println("Invalid credentials message is: " + invalidMessage);
		
		assert invalidMessage.contains("Invalid credentials");
		
		
	}

}