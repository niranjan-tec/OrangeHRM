package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.PIMMenu;

/**
 * Test class: SearchEmployeeTest
 * Verifies searching for an employee by name in the Employee List.
 */
public class SearchEmployeeTest extends BaseTest {

	/**
	 * Test: verifySearchEmployee
	 * Steps:
	 * 1. Login to the application using credentials from config
	 * 2. Navigate to PIM -> Employee List
	 * 3. Search for employee by name and assert whether records are found
	 */
	@Test(priority = 3)

	public void verifySearchEmployee() throws InterruptedException {

		// Login to the application
		LoginPage loginPage = new LoginPage(driver);

		String username = config.getProperty("username");
		String password = config.getProperty("password");

		loginPage.loginToApp(username, password);

		// Navigate to PIM -> Employee List
		PIMMenu searchEmployee = new PIMMenu(driver);

		searchEmployee.clickPIM();

		searchEmployee.clickEmployeeList();

		// Enter employee name to search and submit
		searchEmployee.enterEmployeeName("Niranjan");

		searchEmployee.clickSearch();

		// Wait for results (consider replacing with explicit wait)
		Thread.sleep(2000);

		String employeeRecord = searchEmployee.getEmployeeRecord();

		System.out.println("Employee Record: " + employeeRecord);

		// Assert based on result text
		if (employeeRecord.equalsIgnoreCase("Records Found")) {

			Assert.assertTrue(true);
		} else if (employeeRecord.equalsIgnoreCase("No Records Found")) {

			Assert.assertTrue(false);
		}

	}
}