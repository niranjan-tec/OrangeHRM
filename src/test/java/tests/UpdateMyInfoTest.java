package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.MyInfo;

public class UpdateMyInfoTest extends BaseTest {


	@Test(priority =2,description = "Verify that user is able to update personal details in My Info page")

	public void verifyUpdatePersonalDetails() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		String username = config.getProperty("username");
		String password = config.getProperty("password");
		loginPage.loginToApp(username, password);
		MyInfo myInfo = new MyInfo(driver);
		myInfo.clickMyInfoMenu();
		Thread.sleep(2000);
		myInfo.updatePersonalDetails();
		String updateMessg = myInfo.getUpdatedSuccessMessage();
		Assert.assertEquals(updateMessg, "Successfully Updated");

	}	
	

	@Test(priority=9,description = "Verify that user is able to update personal details in My Info page")
	public void verifyUpdateContactDetails() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		String username = config.getProperty("username");
		String password = config.getProperty("password");
		loginPage.loginToApp(username, password);
		MyInfo myInfo = new MyInfo(driver);
		myInfo.clickMyInfoMenu();
		myInfo.updateContactDetails();
		String updateMessg = myInfo.getUpdatedSuccessMessage();
		Assert.assertEquals(updateMessg, "Successfully Updated");

	}

}
