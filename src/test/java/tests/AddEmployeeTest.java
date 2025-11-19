package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.PIMMenu;

/**
 * Test: AddEmployeeTest
 * Purpose: Verifies that a new employee can be added via PIM -> Add Employee.
 */
public class AddEmployeeTest extends BaseTest {

	/**
	 * Test: verifyAddEmployee
	 * - Logs in using valid credentials
	 * - Navigates to Add Employee and fills details
	 * - Saves and verifies Personal Details page is shown
	 */
	@Test(priority=2)
	public void verifyAddEmployee() {
		// Login
		
		LoginPage loginPage = new LoginPage(driver);
		
		String username = config.getProperty("username");
		String password = config.getProperty("password");
		
		// Logging into the application with valid credentials
		loginPage.loginToApp(username, password);
		
		PIMMenu addEmployee = new PIMMenu(driver); 
		// Add Employee
		addEmployee.clickPIM();
		addEmployee.clickAddEmployee();
		// Entering employee's personal details
		addEmployee.enterFirstName("Niranjan");
		addEmployee.enterLastName("Verma");
		// Saving the new employee details
		addEmployee.clickSave();
		
		// Verification
		String personalDetails = addEmployee.getPersonalDetailsText();
		
		// Check if the personal details page is displayed for the new employee
		if(personalDetails.equals("Personal Details")) {
			System.out.println("Test Passed: Employee added successfully.");
		} else {
			System.out.println("Test Failed: Employee not added.");
		}
		
		// Asserting that the personal details page is displayed
		Assert.assertEquals(personalDetails, "Personal Details");
		
	}
	
}