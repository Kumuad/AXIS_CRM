package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonutilities.CommonMethods;
import testbase.TestBase;

public class MakerPage extends TestBase {

	// Constructor
	public MakerPage() {
		super();
		PageFactory.initElements(driver, this);

	}

	// Object Repository

	@FindBy(xpath = ".//select[@name='QueryViewId']")
	WebElement viewsAssigneTodropdown;

	@FindBy(xpath = ".//select[@name='QueryFilterId']")
	WebElement viewsStatuscodedropdown;

	@FindBy(xpath = ".//a[@class='filterGroup__button']")
	WebElement viewsArrowButton;

	@FindBy(xpath = "(.//div[@class='react-grid-Cell__value'])[1]/div/span/a")
	WebElement viewsSRNumber;

	// @FindBy(xpath="(.//input[@class='react-grid-checkbox'])[2]")

	@FindBy(xpath = "//label[@for='checkbox0']")
	WebElement viewsSRNumbercheckBox;

	@FindBy(xpath = "(//div[@class='custom-btn-listing button-list'])[1]/a[1]")
	WebElement SelfAssignMakerCustomButton;

	@FindBy(xpath = "//div[@class='footer--popup']/button")
	WebElement OkButtonSelAssign;

	@FindBy(xpath = "//i[@class='fixed-stack-icon icon icon-stack']")
	WebElement EditSRButton;

	@FindBy(xpath = "//div[@data-autoid='CASE_CURRENTOWNER']/div/div/span")
	WebElement assignedTo;

	@FindBy(xpath = "(//div[@data-autoid='CASE_STATUSCODE']/div/div/span)[1]")
	WebElement statuscode;

	@FindBy(xpath = "(//div[@class='flex-1 date-time-label'])[1]/div/div/span")
	WebElement expectedclosuredate;

	@FindBy(xpath = "//div[@class='overlay-button-list']/a[1]")
	WebElement EditSRLink;

	@FindBy(xpath = "//span[contains(text(),'Sent For Verification')]/preceding-sibling::i[@class='icon icon-unlocked']")
	WebElement sentforverificationstatuscode;

	@FindBy(xpath = "//a[@data-autoid='cust_136966_srch']")
	WebElement checkersearchicon;

	@FindBy(xpath = "//div[@data-autoid='shortname_1']")
	WebElement selectcheckeruser;

	// @FindBy(xpath="(//textarea[@class='textarea field__item
	// textarea--charlimit'])[1]")
	@FindBy(xpath = "//textarea[@name='cust_120241']")
	WebElement remarksfield;

	@FindBy(xpath = "//span[contains(text(),'Save and Proceed')]")
	WebElement Saveandproceedbtn;

	// to get registration page title
	public String verifyregistrationPageTitle() {
		return driver.getTitle();

	}

	// select value from views Assigned dropdown
	public void selectAssignedTo(int i) {
		CommonMethods.selectByIndex(viewsAssigneTodropdown, i);
		

	}

	// select value from views statuscode dropdown
	public void selectviewsStatuscodedropdown(int i) {
		CommonMethods.selectByIndex(viewsStatuscodedropdown, i);

	}

	// click on views arrow button
	public void clickviewsArrowButton() {
		viewsArrowButton.click();

	}

	// click on views SR Number Link
	public void clickviewsSRNumberLink() {
		viewsSRNumber.click();

	}

	// click on views SR Number Link
	public void clickviewsSRNumbercheckBox() {

		try {
			viewsSRNumbercheckBox.click();
		} catch (StaleElementReferenceException e) {
			viewsSRNumbercheckBox.click();
		}

	}

	// click on SelfAssignMakerCustomButton

	public void clickSelfAssignMakerCustomButton() {
		SelfAssignMakerCustomButton.click();

	}

	// click On Ok Button After self Assign
	public void clickOnOkButtonAfterselfAssign() {
		OkButtonSelAssign.click();

	}

	// click On Edit SR
	public void clickOnEditSR() {
		EditSRButton.click();

	}

	// click On Edit SR Link
	public void clickOnEditSRLink() {
		EditSRLink.click();
	}

	// Select Sent for verification status code
	public void selectsentforverificationstatuscode() {
		sentforverificationstatuscode.click();
	}

	// click on checker Search icon
	public void clickOnCheckersearchicon() {
		checkersearchicon.click();
	}

	// select checker user
	public void selectcheckeruser() {

		CommonMethods.clickelementbyjavascript(selectcheckeruser);
		// selectcheckeruser.click();
	}

	// Enter text in remark field
	public void enterremarks() {
		remarksfield.sendKeys("test");
	}

	// CLick on save and proceed button
	public void clickOnSaveandProceedButton() {
		Saveandproceedbtn.click();
	}
}
