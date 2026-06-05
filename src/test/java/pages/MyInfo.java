package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class MyInfo extends BaseTest{

	WebDriver driver;

	public MyInfo(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='My Info']")
	public WebElement myInfoMenu;

	@FindBy(xpath = "//a[normalize-space()='Personal Details']")
	public WebElement personalDetailsOption;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	public WebElement firstNameField;

	@FindBy(xpath = "//input[@placeholder='Middle Name']")
	public WebElement middleNameField;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	public WebElement lastNameField;

	@FindBy(xpath = "//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	public WebElement employeeIdField;

	@FindBy(xpath = "//label[text()='Other Id']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	public WebElement otherIdField;

	@FindBy(xpath = "//label[normalize-space()=\"Driver's License Number\"]/parent::div/following-sibling::div//input")
	public WebElement driversLicenseNumberField;

	@FindBy(xpath = "//label[normalize-space()='Male']")
	public WebElement maleGenderOption;

	@FindBy(xpath = "//label[normalize-space()='Female']")
	public WebElement femaleGenderOption;

	@FindBy(xpath = "(//button[@type='submit' and normalize-space()='Save'])[1]")
	public WebElement saveButton;
	@FindBy(xpath = "//div[@class='orangehrm-edit-employee-name']")
	public WebElement employeeNameDisplay;

	public void clickMyInfoMenu() {
		myInfoMenu.click();
	}

	public void clickPersonalDetailsOption() {
		personalDetailsOption.click();

	}

	public void enterFirstName(String string) throws InterruptedException {
		firstNameField.click();
		firstNameField.sendKeys(Keys.CONTROL + "a");
		firstNameField.sendKeys(Keys.DELETE);
		firstNameField.sendKeys(string);
	}

	public void enterMiddleName(String string) throws InterruptedException {
		middleNameField.click();
		middleNameField.sendKeys(Keys.CONTROL + "a");
		middleNameField.sendKeys(Keys.DELETE);
		middleNameField.sendKeys(string);
	}

	public void enterLastName(String string) throws InterruptedException {
		lastNameField.click();
		lastNameField.sendKeys(Keys.CONTROL + "a");
		lastNameField.sendKeys(Keys.DELETE);
		lastNameField.sendKeys(string);
	}

	public void enterEmployeeId(String string) throws InterruptedException {
		employeeIdField.click();
		employeeIdField.sendKeys(Keys.CONTROL + "a");
		employeeIdField.sendKeys(Keys.DELETE);
		employeeIdField.sendKeys(string);
	}

	public void enterOtherId(String string) throws InterruptedException {
		otherIdField.click();
		otherIdField.sendKeys(Keys.CONTROL + "a");
		otherIdField.sendKeys(Keys.DELETE);
		otherIdField.sendKeys(string);
	}

	public void enterDriversLicenseNumber(String string) throws InterruptedException {
		driversLicenseNumberField.click();
		driversLicenseNumberField.sendKeys(Keys.CONTROL + "a");
		driversLicenseNumberField.sendKeys(Keys.DELETE);
		driversLicenseNumberField.sendKeys(string);
	}

	public void selectGender() {

		if (maleGenderOption.isEnabled()) {

			femaleGenderOption.click();
		} else {
			maleGenderOption.click();

		}

	}

	public void clickSaveButton() {
		saveButton.click();
	}
	
	public String getEmployeeName() {
		return employeeNameDisplay.getText();
	}

}