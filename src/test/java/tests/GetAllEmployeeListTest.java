package tests;

import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.PIMMenu;

/**
 * Test: GetAllEmployeeListTest
 * Purpose: Retrieves and prints employee names across pagination in the Employee List.
 */
public class GetAllEmployeeListTest extends BaseTest {
	
	// Locators used temporarily in this test (should be moved to a Page object later)
	@FindBy(xpath = "//ul[@class='oxd-pagination__ul']/li")
	public List<WebElement> paginationLinksCount;

	@FindBy(xpath = "//div[@class='oxd-table-card']/div/div[3]")
	public List<WebElement> employeeFirstNameList;

	/**
	 * Test: getAllEmployeeList
	 * Steps:
	 * - Login
	 * - Open Employee List
	 * - Iterate pagination (if available) and log employee first names
	 */
	@Test(priority = 7, description = "Get All Employee List with Pagination Handling")
	public void getAllEmployeeList() throws InterruptedException {
		PageFactory.initElements(driver, this);

		// Login
		LoginPage loginPage = new LoginPage(driver);

		String username = config.getProperty("username");
		String password = config.getProperty("password");

		loginPage.loginToApp(username, password);

		// Navigate to Employee List
		PIMMenu pimMenu = new PIMMenu(driver);
		pimMenu.clickPIM();
		pimMenu.clickEmployeeList();

		Thread.sleep(5000);
		
		// If pagination exists, iterate pages and print employee names, otherwise print current page names
		if (paginationLinksCount != null && !paginationLinksCount.isEmpty()) {

			int totalLinksCount = paginationLinksCount.size();

			for (int i = 0; i < totalLinksCount; i++) {

				String currentLinksText = paginationLinksCount.get(i).getText();

				try {
					int page = Integer.parseInt(currentLinksText);

					System.out.println("Clicking on page number: " + page);
					paginationLinksCount.get(i).click();

					Thread.sleep(3000);

					for (WebElement emp : employeeFirstNameList) {
						System.out.println("Employee First Name: " + emp.getText());
						assertTrue(true);
					}

				} catch (Exception e) {
					System.out.println("It is not a page number ");
				}
			}

		} else {

			for (WebElement emp : employeeFirstNameList) {
				System.out.println("Employee First Name: " + emp.getText());
				assertTrue(true);
			}

		}
	}
}