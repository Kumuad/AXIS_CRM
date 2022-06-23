package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonutilities.CommonMethods;
import testbase.TestBase;

public class CheckerPage extends TestBase{
	

	//Constructor 
	public CheckerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//Object Repository
	@FindBy(xpath=".//select[@name='QueryViewId']")
	WebElement viewsAssigneTodropdown;	

	@FindBy(xpath=".//select[@name='QueryFilterId']")
	WebElement viewsStatuscodedropdown;	

	@FindBy(xpath=".//a[@class='filterGroup__button']")
	WebElement viewsArrowButton;
	
	@FindBy(xpath="(.//div[@class='react-grid-Cell__value'])[1]/div/span/a")
	WebElement viewsSRNumber;
	
	@FindBy(xpath="//i[@class='fixed-stack-icon icon icon-stack']")
	WebElement EditSRButton;
	
	@FindBy(xpath="//div[@class='overlay-button-list']/a[1]")
	WebElement EditSRLink;
	
	@FindBy(xpath="//span[contains(text(),'Closure')]")
	WebElement CLosuremilestone;
	
	@FindBy(xpath="//a[@data-autoid='cust_137035_srch']")
	WebElement substatussearch;
	
	@FindBy(xpath="//div[contains(text(),'Approved and Closed')]")
	WebElement approvedandclosedsubstatus;
	
	@FindBy(xpath="//textarea[@name='cust_120241']")
	WebElement Remarksfield;
	
	
	@FindBy(xpath="//span[contains(text(),'Save and Proceed')]")
	WebElement Saveandproceedbtn;
	
	
	
	//Page method starts--------
	
	//Select value from Views Assigned to Dropdown
	public void selectAssignedTo(int i) {
		CommonMethods.selectByIndex(viewsAssigneTodropdown,i);
		
	}
	
	
	//select value from views statuscode dropdown
	public void selectviewsStatuscodedropdown(int i) {
		CommonMethods.selectByIndex(viewsStatuscodedropdown,i);

	}
		
	//click on Views Arrow Button
	public void clickOnViewsArrowButton() {
		viewsArrowButton.click();
	}
	
	//click on views SR Number Link
		public void clickviewsSRNumberLink() {
			viewsSRNumber.click();

		}
	//click on Closure milestone
	public void clickOnCLosureMilestone() {
		CLosuremilestone.click();
		
	}

	//click on save and proceed button
	public void clickOnSaveandproceedbutton() {
		Saveandproceedbtn.click();
		
	}
	
	//click On Edit SR
	public void clickOnEditSR() {
		EditSRButton.click();

	}

	//click On Edit SR Link
	public void clickOnEditSRLink() {
		EditSRLink.click();
	}
	
	//click On sub status
		public void clickOnsubstatussearch() {
			substatussearch.click();
		}
	
    //select approved and closed substatus
		public void selectApprovedandCLosedSubStatus() {
			approvedandclosedsubstatus.click();
		}
		//Enter text in remarks fields
		public void enterremarks() {
			Remarksfield.sendKeys("test");
		}
		
}
