package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object: LoginPage
 * Encapsulates elements and actions for the login page of OrangeHRM.
 */
public class LoginPage {
	WebDriver driver;

	// 3️⃣ Constructor (to connect driver from test class)
	public LoginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// Locators
	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameField;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	WebElement profilelink;

	@FindBy(xpath = "//ul[@role='menu']")
	List<WebElement> profileOptions;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	WebElement invalidCredentialsMessage;
	

	// 🔹 3. Actions (methods to interact with page)
	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickLogin() {
		loginButton.click();
	}

	public void clickProfile() {
		profilelink.click();
	}

	public void clickLogout() {
		for (WebElement option : profileOptions) {
			if (option.getText().equalsIgnoreCase("Logout")) {
				option.click();
				break;
			}
		}
	}
	
	
	/**
	 * Convenience method to perform full login flow: username -> password -> submit
	 */
	public void loginToApp(String username, String password) {
		enterUsername(username);

		enterPassword(password);

		clickLogin();

	}

	
	/**
	 * Get the invalid credentials message text displayed after a failed login attempt.
	 */
	public String getInvalidCredentialsMessage() {
		return invalidCredentialsMessage.getText();
	}
}