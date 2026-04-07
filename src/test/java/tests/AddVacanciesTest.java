package tests;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.Recruitment;

public class AddVacanciesTest extends BaseTest {

	@Test(priority = 3)
	public void verifyAddVacancy() throws InterruptedException {

		Random random = new Random();

		// Login
		LoginPage loginPage = new LoginPage(driver);

		String username = config.getProperty("username");
		String password = config.getProperty("password");

		// Logging into the application with valid credentials
		loginPage.loginToApp(username, password);

		Recruitment recruitment = new Recruitment(driver);
		recruitment.clickRecruitmentMenu();
		recruitment.clickVacanciesOption();
		recruitment.clickAddButton();
		recruitment.enterVacancyName("Software Engineer " + random.nextInt(1000));
		
		recruitment.selectJobTitle();
		Thread.sleep(2000);

		for (WebElement option : recruitment.jobTitleOptions) {

			// System.out.println(option.getText());

			if (option.getText().equalsIgnoreCase("Chief Executive Officer")) {
				option.click();
				break;
			}
		}

		recruitment.enterVacancyDescription("Automation Tester is responsible for designing");

		recruitment.enterHiringManager("a");
		Thread.sleep(2000);

	
		recruitment.giveHiringManagerOptions.get(0);
		
		if (!recruitment.giveHiringManagerOptions.isEmpty()) {
			
			Thread.sleep(2000);
			
			recruitment.giveHiringManagerOptions.get(0).click();
		}
		

		// recruitment.giveHiringManagerOptions.get(0).click();

		recruitment.enterNumberOfPositions("5");
		recruitment.saveButton.click();

		Thread.sleep(2000);

		recruitment.clickVacanciesOption();
		String text = recruitment.recordFoundMessage.getText();
		System.out.println(text);
		Assert.assertTrue(text.contains("Records Found"));

	}

}














