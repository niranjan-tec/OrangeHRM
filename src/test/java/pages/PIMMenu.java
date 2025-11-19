package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object for PIM module interactions.
 * Encapsulates Add Employee, Employee List, search and delete actions.
 */
public class PIMMenu {

	WebDriver driver;

	public PIMMenu(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	// Locators for PIM module UI elements
	@FindBy(xpath = "//span[text()='PIM']")
	WebElement pimOption;

	@FindBy(xpath = "//a[normalize-space()='Add Employee']")
	WebElement addEmployeeOption;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstNameField;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastNameField;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//h6[normalize-space()='Personal Details']")
	WebElement personalDetailsText;

	@FindBy(xpath = "//a[normalize-space()='Employee List']")
	WebElement employeeListField;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement employeeNameField;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement searchButton;

	@FindBy(xpath = "//div[contains(@class,'orangehrm-horizontal-padding')]")
	WebElement getEmployeeRecord;

	@FindBy(xpath = "(//input)[3]")
	WebElement idField;

	@FindBy(xpath = "//div[@role='row']")
	public List<WebElement> rowCount;

	@FindBy(xpath = "(//div[@class='oxd-table-card']/div/div)[3]")
	WebElement employeeID;

	@FindBy(xpath = "(//i[@class='oxd-icon bi-trash'])[1]")
	WebElement deleteIcon;

	@FindBy(xpath = "//i[@class='oxd-icon bi-trash oxd-button-icon']")
	WebElement deleteButtonFromPopUp;

	// Actions for interacting with the PIM UI
	public void clickPIM() {
		pimOption.click();
	}

	public void clickAddEmployee() {
		addEmployeeOption.click();
	}

	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}

	public void clickSave() {
		saveButton.click();
	}

	public String getPersonalDetailsText() {
		return personalDetailsText.getText();
	}

	public void clickEmployeeList() {
		employeeListField.click();
	}

	public void enterEmployeeName(String employeeName) {
		employeeNameField.sendKeys(employeeName);
	}

	public void clickSearch() {
		searchButton.click();
	}

	public String getEmployeeRecord() {
		return getEmployeeRecord.getText();
	}

	public void enterId(String id) {
		idField.sendKeys(id);
	}

	public int getRowCount() {
		return rowCount.size();
	}

	public String getEmployeeID() {
		return employeeID.getText();
	}

	public void clickDeleteIcon() {
		deleteIcon.click();
	}

	public void clickDeleteButtonFromPopUp() {
		deleteButtonFromPopUp.click();
	}

}