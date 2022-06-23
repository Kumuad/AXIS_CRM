package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import commonutilities.CommonMethods;
import testbase.TestBase;

public class MakerPage extends TestBase {

	// Constructor
	public MakerPage(WebDriver driver) {
		//super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Object Repository
	
	@FindBy(xpath=".//div[@class='summaryband__item'][1]/div/div/div/span")
    WebElement SRNumberDetailsPage;

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
	
	
	
	
	
	
	
	//*************DPDIS xpath start here*****************
	@FindBy(xpath ="//select[@data-autoid='QueryViewId_ctrl']")
	WebElement dpdisViewsDropdown;
	
	@FindBy(xpath ="(//div[@class='react-grid-Cell__value'])[1]/div/span/a")
	WebElement dpdisViewsUnassignedSRNumberLink;

	
	@FindBy(xpath ="(//div[@class='react-grid-checkbox-container checkbox-align'])[1]/input")
	WebElement dpdisViewsUnassignedSRNumberCheckBox;
	
	@FindBy(xpath ="(//div[@class='custom-btn-listing button-list'])[1]/a")
	WebElement dpdisSelfAssignButton;
	
	@FindBy(xpath=".//input[@name='CASE_CATEGORY']")
	WebElement dpdisfunction;
	
	@FindBy(xpath=".//input[@name='CASE_SUBCATEGORY']")
     WebElement dpdisSubFunction;

	@FindBy(xpath=".//input[@name='CASE_SUBCATEGORY1']")
    WebElement dpdisSubsubFunction;
	
	@FindBy(xpath="//select[@data-autoid='CASE_TYPE_ctrl']")
	WebElement dpdisNatureOfQuery;
	
	@FindBy(xpath=".//div[@class='nav-stage__item unlocked']/span")
	WebElement dpdisNextPossibleStatusCode;
	
	
	@FindBy(xpath="//span[contains(text(),'Sent To Authorizer')]/preceding-sibling::i[@class='icon icon-unlocked']")
	WebElement dpdisSentToAuthorizerStatusCode;
	
	@FindBy(xpath="//span[contains(text(),'Sent to Checker')]/preceding-sibling::i[@class='icon icon-unlocked']")
	WebElement dpdisSentToCheckerStatusCode;
	
	@FindBy(xpath="//select[@data-autoid='cust_120281_ctrl']")
	WebElement dpdisDigitallySignedDocumentDropdown;
	
	@FindBy(xpath="//input[@data-autoid='cust_136981_ctrl']")
	WebElement dpdisClientIDTextBox;
	
	@FindBy(xpath="//input[@data-autoid='cust_137425_ctrl']")
	WebElement dpdisSlipSeriesTextBox;
	
	@FindBy(xpath="//input[@data-autoid='cust_130095_ctrl']")
	WebElement dpdisSerialNoTextBox;
	
	//********************Methods Starts*************************************
	

	//get SR Number from Details Page
	public String getSRNumber() {
		return SRNumberDetailsPage.getText();
	}
	
	
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
	
	
	//Select value from dropdown from views for dpdis
	public void selectdpdisViewsStatuscodedropdown(String text) {
		CommonMethods.selectByText(dpdisViewsDropdown, text);

	}
	
	
	//get Status code from  DPDIS Maker Page
	public String expStatusCode() {
		return statuscode.getText();
	}
	
	//get assigned To From Maker Page
	public String expAssignedTo() {
		return assignedTo.getText();
	}
	
	
	
	//verify next possible status code
	public void verifyNextPossibleStatusCode() {
		
		String[] expstatuscode= {"Sent to Checker","Sent To Authorizer"};
		
		List<WebElement> alloptions= driver.findElements(By.xpath(".//div[@class='nav-stage__item unlocked']/span"));
		for(WebElement ele:alloptions) {
			System.out.println("Actual Possible Status Code:"+ele.getText());
			
			boolean match = false;
			  for (int i=0; i<expstatuscode.length; i++){
			      if (ele.getText().equals(expstatuscode[i])){
			        match = true;
			      }
			    }
			  Assert.assertTrue(match);
			 }  
			
		}
		
	
	
	// Sent SR to 'Sent to Authorizer'
	
	// Select Sent for verification status code
		public void sentSRToAuthorizer() {
			dpdisSentToAuthorizerStatusCode.click();
		}
	
	
}
