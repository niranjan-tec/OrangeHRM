package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class MyInfo extends BaseTest {

	WebDriver driver;

	public MyInfo(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// Locators for update profile personal details

	@FindBy(xpath = "//span[normalize-space()='My Info']")
	public WebElement myInfoMenu;

	// @FindBy(xpath = "//a[contains(@href,'viewPersonalDetails')]")
	@FindBy(xpath = "//div[@role='tab']//a[normalize-space()='Personal Details']")
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
	
	// Locators for update profile contact details

	@FindBy(xpath = "//a[normalize-space()='Contact Details']")
	public WebElement contactDetailsOption;

	@FindBy(xpath = "//label[text()='Street 1']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	public WebElement street1Field;

	@FindBy(xpath = "//label[text()='Street 2']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	public WebElement street2Field;

	@FindBy(xpath = "//label[text()='City']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	public WebElement cityField;

	@FindBy(xpath = "//label[text()='State/Province']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	public WebElement stateProvinceField;

	@FindBy(xpath = "//label[text()='Zip/Postal Code']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	public WebElement zipPostalCodeField;

	@FindBy(xpath = "(//div[contains(@class,'oxd-select-text')])[1]")
	public WebElement countryDropdown;

	@FindBy(xpath = "//div[@role='listbox']//div[@role='option']")
	public java.util.List<WebElement> options;
	
	@FindBy(xpath = "//label[text()='Home']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	public WebElement homeField;
	
	@FindBy(xpath = "//label[text()='Mobile']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	public WebElement mobileField;
	
	@FindBy(xpath = "//label[text()='Work']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	public WebElement workField;
	
	@FindBy(xpath = "//label[text()='Work Email']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	public WebElement workEmailField;
	
	@FindBy(xpath = "//label[text()='Other Email']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	public WebElement otherEmailField;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	public WebElement contactDetailsSaveButton;
	
	@FindBy(xpath = "//p[contains(@class,'oxd-text oxd-text--p oxd-text--toast-message')]")
	public WebElement updatedSuccessMessage;
	


	public void clickMyInfoMenu() {
		myInfoMenu.click();
	}


	
	public void updatePersonalDetails() throws InterruptedException {

	    // Click Personal Details option
		
	    personalDetailsOption.click();
		Thread.sleep(2000);
		
	    // First Name
	    waitForElementClickable(firstNameField);
	    firstNameField.click();
	    firstNameField.sendKeys(Keys.CONTROL + "a");
	    firstNameField.sendKeys(Keys.DELETE);
	    firstNameField.sendKeys(generateRandomString(10));

	    // Middle Name
	    middleNameField.click();
	    middleNameField.sendKeys(Keys.CONTROL + "a");
	    middleNameField.sendKeys(Keys.DELETE);
	    middleNameField.sendKeys(generateRandomString(10));

	    // Last Name
	    lastNameField.click();
	    lastNameField.sendKeys(Keys.CONTROL + "a");
	    lastNameField.sendKeys(Keys.DELETE);
	    lastNameField.sendKeys(generateRandomString(10));

	    // Employee ID
	    employeeIdField.click();
	    employeeIdField.sendKeys(Keys.CONTROL + "a");
	    employeeIdField.sendKeys(Keys.DELETE);
	    employeeIdField.sendKeys(generateNumber() + "");

	    // Other ID
	    otherIdField.click();
	    otherIdField.sendKeys(Keys.CONTROL + "a");
	    otherIdField.sendKeys(Keys.DELETE);
	    otherIdField.sendKeys(generateNumber() + "");

	    // Driver's License Number
	    driversLicenseNumberField.click();
	    driversLicenseNumberField.sendKeys(Keys.CONTROL + "a");
	    driversLicenseNumberField.sendKeys(Keys.DELETE);
	    driversLicenseNumberField.sendKeys(generateNumber() + "");

	    // Gender Selection
	    if (maleGenderOption.isSelected()) {
	        femaleGenderOption.click();
	    } else {
	        maleGenderOption.click();
	    }

	    // Save Button
	    saveButton.click();
	}
	
	
	// Method for updating contact details

	public void updateContactDetails() throws InterruptedException {
		
		contactDetailsOption.click();
		Thread.sleep(2000);

		// Street 1
		waitForElementClickable(street1Field);
		street1Field.click();
		street1Field.sendKeys(Keys.CONTROL + "a");
		street1Field.sendKeys(Keys.DELETE);
		String street1 = generateRandomString(20);
		street1Field.sendKeys(street1);

		// Street 2
		street2Field.click();
		street2Field.sendKeys(Keys.CONTROL + "a");
		street2Field.sendKeys(Keys.DELETE);
		String street2 = generateRandomString(20);
		street2Field.sendKeys(street2);

		// City
		cityField.click();
		cityField.sendKeys(Keys.CONTROL + "a");
		cityField.sendKeys(Keys.DELETE);
		String city = generateRandomString(10);
		cityField.sendKeys(city);

		// State/Province
		stateProvinceField.click();
		stateProvinceField.sendKeys(Keys.CONTROL + "a");
		stateProvinceField.sendKeys(Keys.DELETE);
		String stateProvince = generateRandomString(10);
		stateProvinceField.sendKeys(stateProvince);

		// Zip Code
		zipPostalCodeField.click();
		zipPostalCodeField.sendKeys(Keys.CONTROL + "a");
		zipPostalCodeField.sendKeys(Keys.DELETE);
		String zipPostalCode = generateNumber() + "";
		zipPostalCodeField.sendKeys(zipPostalCode);

		// Country
		countryDropdown.click();

		for (WebElement option : options) {
		    if (option.getText().equalsIgnoreCase("India")) {
		        option.click();
		        break;
		    }
		}

		// Home
		homeField.click();
		homeField.sendKeys(Keys.CONTROL + "a");
		homeField.sendKeys(Keys.DELETE);
		String home = generateNumber() + "/(110)";
		homeField.sendKeys(home);

		// Mobile
		mobileField.click();
		mobileField.sendKeys(Keys.CONTROL + "a");
		mobileField.sendKeys(Keys.DELETE);
		String mobile = generateNumber() + "4333";
		mobileField.sendKeys(mobile);

		// Work
		workField.click();
		workField.sendKeys(Keys.CONTROL + "a");
		workField.sendKeys(Keys.DELETE);
		String work = generateNumber() + "";
		workField.sendKeys(work);

		// Work Email
		workEmailField.click();
		workEmailField.sendKeys(Keys.CONTROL + "a");
		workEmailField.sendKeys(Keys.DELETE);
		String workEmail = generateRandomString(10) + "@gmail.com";
		workEmailField.sendKeys(workEmail);

		// Other Email
		otherEmailField.click();
		otherEmailField.sendKeys(Keys.CONTROL + "a");
		otherEmailField.sendKeys(Keys.DELETE);
		String otherEmail = generateRandomString(10) + "@gmail.com";
		otherEmailField.sendKeys(otherEmail);

		contactDetailsSaveButton.click();		
		
	}
	
	// Method to get the success message after updating personal/contact details
	
	public String getUpdatedSuccessMessage() {
		waitForElementVisible(updatedSuccessMessage);
		return updatedSuccessMessage.getText();
	}

}
