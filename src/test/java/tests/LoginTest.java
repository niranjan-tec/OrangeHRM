package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

/**
 * Test: LoginTest
 * Purpose: Verify valid login and logout functionality.
 */
public class LoginTest extends BaseTest {

	/**
	 * Test: verifyLogin
	 * - Logs in with valid credentials
	 * - Asserts the page title
	 * - Performs logout via profile menu
	 */
	@Test(priority = 1)
	public void verifyLogin() throws InterruptedException {
		// Create LoginPage object
		LoginPage loginPage = new LoginPage(driver);

		String username = config.getProperty("username");
		String password = config.getProperty("password");

		// Perform login
		loginPage.loginToApp(username, password);

		// Verify landing page title after login
		String title = driver.getTitle();

		Assert.assertEquals(title, "OrangeHRM");
		System.out.println("Title of the page is: " + title);

		// Logout flow: open profile and click logout
		loginPage.clickProfile();
		loginPage.clickLogout();

		Thread.sleep(2000);
		Assert.assertEquals(title, "OrangeHRM");
		System.out.println("Title of the page is: " + title);

	}
}