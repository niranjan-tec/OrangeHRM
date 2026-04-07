package practice_test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Hotelogix {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	// @Test
	public void testDropdown() throws InterruptedException {

		WebElement dropdown = driver.findElement(By.cssSelector("#dropdown-class-example"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Option2");
		Thread.sleep(2000);
		select.selectByValue("option3");
		Thread.sleep(2000);
		select.selectByValue("option1");

	}

	// @Test
	public void testCheckbox() throws InterruptedException {

		// checkBoxOption1
		// checkBoxOption2
		// checkBoxOption3

		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#checkBoxOption2")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#checkBoxOption3")).click();

	}

	// @Test
	public void testMouseHover() throws InterruptedException {

		WebElement mouse = driver.findElement(By.cssSelector("#autocomplete"));
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.contextClick(mouse).perform();
		Thread.sleep(2000);

		// Double click
		actions.doubleClick(mouse).perform();
		Thread.sleep(2000);
		// Move to element
		actions.moveToElement(mouse).perform();

	}

	// @Test(dataProvider = "data")
	public void testDataProvider(String country, String capital) {

		System.out.println("Country: " + country + " | Capital: " + capital);
	}

	@DataProvider(name = "data")
	public Object[][] data() {

		return new Object[][] { { "India", "Delhi" }, { "USA", "Washington" }, { "UK", "London" } };
	}

	@Test
	public void testWindowHandling() throws InterruptedException {

		// Switch tp the parent window and get the title

		driver.findElement(By.id("openwindow")).click();
		Set<String> allWndow = driver.getWindowHandles();
		Iterator<String> it = allWndow.iterator();

		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("//a[normalize-space()='Access all our Courses']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search for anything']")).sendKeys("Selenium");
		Thread.sleep(2000);
		List<WebElement> allCourses = driver.findElements(By.xpath("//div[@class='card-title-module--clipped--DPJnT']"));
		for (WebElement course : allCourses) {
			System.out.println("Course : "+course.getText());
		}
		
		
		System.out.println("Child Window Title: " + driver.getTitle());
		Thread.sleep(2000);
		driver.switchTo().window(parentWindow);
		System.out.println("Parent Window Title: " + driver.getTitle());

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}