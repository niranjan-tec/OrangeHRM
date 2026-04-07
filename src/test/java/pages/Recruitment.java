package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Recruitment {
	
	WebDriver driver;

	// 3️⃣ Constructor (to connect driver from test class)
	public Recruitment(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Recruitment']")
	WebElement recruitmentMenu;
	
	@FindBy(xpath = "//a[normalize-space()='Vacancies']")
	WebElement vacanciesOption;
	
	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement addButton;
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement enterVacancyName;
	
	@FindBy(xpath = "//div[@class='oxd-select-text-input']")
	public WebElement selectJobTitle;	
	
	@FindBy(xpath = "//div[@role='option']")
	public List<WebElement> jobTitleOptions;
	
	@FindBy(xpath = "//textarea[@placeholder='Type description here']")
	WebElement enterVacancyDescription;
	
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement enterHiringManager;
	
	@FindBy(xpath = "//div/div[@role='option']")
	public List<WebElement> giveHiringManagerOptions;
	
	@FindBy(xpath = "(//div/input[@class='oxd-input oxd-input--active'])[3]")
	public WebElement enterNumberOfPositions;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	public WebElement saveButton;
	
	@FindBy(xpath = "//span[contains(.,'Records Found')]")
	public WebElement recordFoundMessage;
	
	public void clickRecruitmentMenu() {
		recruitmentMenu.click();
	}
	
	public void clickVacanciesOption() {
		vacanciesOption.click();
	}
	
	public void clickAddButton() {
		addButton.click();
	}
		
	public void enterVacancyName(String vacancyName) {
		enterVacancyName.sendKeys(vacancyName);
	}
	
	public void selectJobTitle() {
		selectJobTitle.click();
	}

	public List<WebElement> getJobTitleOptions() {
		return jobTitleOptions;
	}
	
	public void enterVacancyDescription(String description) {
		enterVacancyDescription.sendKeys(description);
	}
	
	public void enterHiringManager(String hiringManager) {
		enterHiringManager.sendKeys(hiringManager);
	}
	
	public List<WebElement> getHiringManagerOptions() {
		return giveHiringManagerOptions;
	}
	
	public void enterNumberOfPositions(String numberOfPositions) {
		enterNumberOfPositions.sendKeys(numberOfPositions);
	}
	
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public String getRecordFoundMessage() {
		return recordFoundMessage.getText();
	}
	

	
}
