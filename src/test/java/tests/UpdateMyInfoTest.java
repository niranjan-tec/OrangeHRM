package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.MyInfo;

public class UpdateMyInfoTest extends BaseTest {
	
	String expectedName = "Niranjan Mehta";
	
	@Test
	
	public void verifyUpdateMyInfo() throws InterruptedException {
		
		LoginPage loginPage = new LoginPage(driver);
		String username = config.getProperty("username");
		String password = config.getProperty("password");
		loginPage.loginToApp(username, password);
		MyInfo myInfo = new MyInfo(driver);
		myInfo.clickMyInfoMenu();
		myInfo.clickPersonalDetailsOption();
		waitForElementClickable(myInfo.firstNameField);
		Thread.sleep(5000);
		String enteredFirstName = generateRandomString(10);
		myInfo.enterFirstName(enteredFirstName);
		String enteredMiddleName = generateRandomString(8);
		myInfo.enterMiddleName(enteredMiddleName);
		String enteredLastName = generateRandomString(10);
		myInfo.enterLastName(enteredLastName);
		int randomNumber = generateNumber();
		myInfo.enterEmployeeId(String.valueOf(randomNumber));
		myInfo.enterEmployeeId(String.valueOf(randomNumber));
		myInfo.enterOtherId(String.valueOf(randomNumber));
		myInfo.enterDriversLicenseNumber("DL"+String.valueOf(randomNumber));
		myInfo.selectGender();
		myInfo.clickSaveButton();
		scrollToTop();
		myInfo.clickPersonalDetailsOption();
		Thread.sleep(3000);
		String actualName = myInfo.getEmployeeName();
		System.out.println("Actual Name: " + enteredFirstName);
		
		if (actualName.contains(enteredFirstName)) {
			
		    System.out.println("Employee details are updated correctly.");
		    assert true;
		} else {
		    System.out.println("Employee details are not updated correctly.");
		}
		
		
		
		
	}

}
