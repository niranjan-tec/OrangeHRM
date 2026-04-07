package base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import utils.ConfigReader;

/**
 * BaseTest
 *
 * Responsibilities: - Initialize and quit the WebDriver used across tests. -
 * Provide shared utilities (config reader, screenshot capture, scrolling
 * helpers). - Serve as a parent class for test classes so they inherit common
 * setup/teardown.
 */
public class BaseTest {

	public WebDriver driver;
	public ConfigReader config;

	/**
	 * Runs once before any tests in the class. - Initializes ConfigReader and
	 * WebDriver - Maximizes window, sets implicit wait, and navigates to baseUrl
	 */
	@BeforeClass
	public void setUp() {

		config = new ConfigReader();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get(config.getProperty("baseUrl"));
	}

	/**
	 * Runs once after all tests in the class. - Pauses briefly then quits the
	 * WebDriver if it exists.
	 */
	@AfterClass
	public void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		if (driver != null) {

			driver.quit();
		}
	}

	/**
	 * Capture a screenshot and return the saved file path. Useful for attaching to
	 * reports on failure.
	 */
	public String captureScreen(String tname) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);
		return targetFilePath;

	}

	// Scroll to the bottom of the page
	public void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	// Scroll the page until the given element is visible
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Scroll to the top (or near top) of the page
	public void scrollToTop() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 500);");
	}

	// Explicit wait method to wait for an element to be visible
	public void waitForElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}