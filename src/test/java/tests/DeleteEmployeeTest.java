package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.PIMMenu;

/**
 * Test: DeleteEmployeeTest
 * Purpose: Verify employee deletion functionality from the Employee List.
 */
public class DeleteEmployeeTest extends BaseTest {

	/**
	 * Test: verifyDeleteEmployeeTest
	 * - Logs in
	 * - Searches for the recently added employee by name
	 * - Deletes the first result and validates the deletion
	 */
	@Test(priority = 5, dependsOnMethods = { "verifyAddEmployee" }, description = "Verify Delete Employee")

	public void verifyDeleteEmployeeTest() throws InterruptedException {

		// Login with valid credentials
		LoginPage loginPage = new LoginPage(driver);
		String username = config.getProperty("username");
		String password = config.getProperty("password");
		loginPage.loginToApp(username, password);

		// Navigate to Employee List and search for the employee
		PIMMenu searchEmployee = new PIMMenu(driver);
		searchEmployee.clickPIM();
		searchEmployee.clickEmployeeList();
		searchEmployee.enterEmployeeName("Niranjan");
		searchEmployee.clickSearch();
		Thread.sleep(2000);

		// Delete the first result and confirm
		searchEmployee.clickDeleteIcon();
		Thread.sleep(2000);
		searchEmployee.clickDeleteButtonFromPopUp();
		
		// Verify deletion by checking the results summary
		String employeeRecord = searchEmployee.getEmployeeRecord();
		System.out.println("Employee Record after deletion: " + employeeRecord);
		
		if (employeeRecord.equalsIgnoreCase("No Records Found")) {

			assert true;
		} else if (employeeRecord.equalsIgnoreCase("Records Found")) {

			assert false;
		}
		
	}

}