package practice_test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hotelogix3_o {

	WebDriver driver;
	WebDriverWait wait;

	// -------------------- Locators --------------------

	By hotelId = By.cssSelector("input[formcontrolname='hotel_id']");
	By username = By.cssSelector("input[formcontrolname='username']");
	By password = By.cssSelector("input[formcontrolname='password']");
	By signInBtn = By.xpath("//span[text()='Sign In']");

	By sessionConflictText = By.xpath("//h3[normalize-space()='Session Conflict']");
	By forceLoginBtn = By.xpath("//button[normalize-space()='Force Login']");

	By selectCounter = By.xpath("//mat-label[normalize-space()='Select Counter']");
	By defaultCounter = By.xpath("//span[normalize-space()='Default Counter (Open)']");
	By continueBtn = By.xpath("//span[contains(text(),'Continue')]");

	By overlappingReservationText = By.xpath("//h3[normalize-space()='Overlapping Reservations']");
	By okBtn = By.xpath("//button[normalize-space()='OK']");

	By cancelBtn = By.xpath("//span[normalize-space()='Cancel']");
	By profileIcon = By.xpath("//span[@class='guest-first-letter']");
	By logoutBtn = By.xpath("//span[contains(text(),'Logout')]");
	By confirmLogoutBtn = By.xpath("//button[normalize-space()='Yes, Logout']");

	// --------------------------------------------------

	@BeforeMethod
	public void setUp() {

		driver = new ChromeDriver();
		driver.get("https://hotelogix3qa.staygrid.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}

	//@Test(priority = 1, description = "Login and Logout")
	public void loginAndLogout() throws InterruptedException {

		driver.findElement(hotelId).clear();
		driver.findElement(hotelId).sendKeys("78999");
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys("harjit12@gmail.comqa");
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys("Test@1234567");
		driver.findElement(signInBtn).click();

		// Session Conflict

		String confText = driver.findElement(sessionConflictText).getText();
		System.out.println(confText);

		if (confText.equals("Session Conflict")) {

			driver.findElement(forceLoginBtn).click();

		} else {

			System.out.println("No session conflict");

		}

		// Counter Selection

		wait.until(ExpectedConditions.visibilityOfElementLocated(selectCounter));
		driver.findElement(selectCounter).click();
		driver.findElement(defaultCounter).click();
		driver.findElement(continueBtn).click();

		// Overlapping Reservation

		wait.until(ExpectedConditions.visibilityOfElementLocated(overlappingReservationText));
		String overLappText = driver.findElement(overlappingReservationText).getText();
		
		if (overLappText.equals("Overlapping Reservations")) {

			System.out.println(overLappText);

			driver.findElement(okBtn).click();

		} else {

			System.out.println("No overlapping reservations");

		}

		// Logout

		driver.findElement(cancelBtn).click();
		Thread.sleep(2000);
		driver.findElement(profileIcon).click();
		Thread.sleep(2000);
		driver.findElement(logoutBtn).click();
		Thread.sleep(2000);
		driver.findElement(confirmLogoutBtn).click();
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "HotelogixPms");

	}
	
	
	@Test(priority = 2, description = "Create Reservation")
	public void createReservation() throws InterruptedException {
		driver.findElement(hotelId).clear();
		driver.findElement(hotelId).sendKeys("78999");
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys("harjit12@gmail.comqa");
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys("Test@1234567");
		driver.findElement(signInBtn).click();

		// Session Conflict

		String confText = driver.findElement(sessionConflictText).getText();
		System.out.println(confText);

		if (confText.equals("Session Conflict")) {

			driver.findElement(forceLoginBtn).click();

		} else {

			System.out.println("No session conflict");

		}

		// Counter Selection
		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(selectCounter));
		driver.findElement(selectCounter).click();
		driver.findElement(defaultCounter).click();
		driver.findElement(continueBtn).click();

		// Overlapping Reservation

		wait.until(ExpectedConditions.visibilityOfElementLocated(overlappingReservationText));
		String overLappText = driver.findElement(overlappingReservationText).getText();
		
		if (overLappText.equals("Overlapping Reservations")) {

			System.out.println(overLappText);

			driver.findElement(okBtn).click();

		} else {

			System.out.println("No overlapping reservations");

		}

		// Logout
		Thread.sleep(2000);
		driver.findElement(cancelBtn).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//mat-icon[normalize-space()='anchor']")).click();
	
		
		
		
	}

	

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

}