package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.PIMMenu;

/**
 * Test: SearchEmployeeIDTest
 * Purpose: Verifies the ability to search employees by ID and validate the returned ID.
 */
public class SearchEmployeeIDTest extends BaseTest {

	String employeeID = "0312";
	String actual_empID;

	/**
	 * Test: verifySearchEmployeeID
	 * - Logs in
	 * - Navigates to Employee List
	 * - Searches by employee ID and validates the retrieved ID
	 */
	@Test(priority = 4, enabled =false, description = "Verify Search By Employee ID")

	public void verifySearchEmployeeID() throws InterruptedException {

		// Login

		LoginPage loginPage = new LoginPage(driver);

		String username = config.getProperty("username");
		String password = config.getProperty("password");

		loginPage.loginToApp(username, password);

		PIMMenu searchEmployee = new PIMMenu(driver);

		// Search Employee
		searchEmployee.clickPIM();
		searchEmployee.clickEmployeeList();
		searchEmployee.enterId(employeeID);

		Thread.sleep(2000);
		searchEmployee.clickSearch();

		if (searchEmployee.rowCount.size() > 1) {

			System.out.println("Imployee Id : " + searchEmployee.getEmployeeID());

			scrollToTop();
			actual_empID = searchEmployee.getEmployeeID();

		}

		Assert.assertEquals(actual_empID, employeeID, "Employee ID does not match");

		
	}
	
}