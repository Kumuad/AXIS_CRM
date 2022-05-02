package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonutilities.CommonMethods;
import testbase.TestBase;

public class HomePage extends TestBase {

	// Object Repository

	@FindBy(xpath = "//td[contains(text(),'User: kumud sagar')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//div[@class='page-title__link']/a")
	WebElement ServiceRequestTabIcon;

	@FindBy(xpath = ".//div[@class='menu-list__item']/div[2]/a")
	WebElement StandardWorkFlow;

	@FindBy(xpath = "(//a[@name='ProfileImage_header'])[1]")
	WebElement profileimage;

	// @FindBy(xpath = "//select[@name='Administrator']")
	@FindBy(xpath = "(//select[@class='selectbox'])[2]")
	WebElement rolesdropdown;

	// ************xpath side tabs********

	
	@FindBy(xpath = "//a[@data-autoid='New_0']")
	WebElement newButton;

	@FindBy(xpath = "(//li[@class='side-nav-list__item quicklink-bg quicklink'])[2]")
	WebElement recentItems;

	@FindBy(xpath = "//div[@id='QuickLinksDiv']/ul/li[1]")
	WebElement recentfirstItems;

	@FindBy(xpath = "//div[@id='topnavdiv']/ul/li[3]/div/div[1]/a")
	WebElement salesTab;

	@FindBy(xpath = "//span[contains(text(),'Customers')]")
	WebElement customerslink;

	@FindBy(xpath = "//span[contains(text(),'Leads')]")
	WebElement leadslink;

	@FindBy(xpath = "//div[@id='topnavdiv']/ul/li[1]/div/div[1]/a")
	WebElement homeTab;

	@FindBy(xpath = "//div[@id='topnavdiv']/ul/li[1]/div/div[2]/ul/li[1]/a")
	WebElement summarylink;

	@FindBy(xpath = "//div[@id='topnavdiv']/ul/li[1]/div/div[2]/ul/li[2]/a")
	WebElement tasklink;

	@FindBy(xpath = "//div[@id='topnavdiv']/ul/li[1]/div/div[2]/ul/li[3]/a")
	WebElement calendarlink;

	@FindBy(xpath = "//div[@id='topnavdiv']/ul/li[1]/div/div[2]/ul/li[4]/a")
	WebElement activitieslink;
	
	@FindBy(xpath = "//span[contains(text(),'Retail Appointment')]")
	WebElement retailAppointmentlink;
	

	// Initializing PageObjects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();

	}

	// click On ServiceRequest

	public RegistrationPage clickOnServiceRequest() throws Exception {
		Actions actions = new Actions(driver);

		// To mouseover on ServiceRequestTabIconu
		actions.moveToElement(ServiceRequestTabIcon).perform();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px dotted red'", StandardWorkFlow);
		Thread.sleep(2000);
		StandardWorkFlow.click();

		return new RegistrationPage();

	}

	// select roles
	public void selectrole(String text) throws InterruptedException {

		profileimage.click();
		Thread.sleep(2000);
		CommonMethods.selectByText(rolesdropdown, text);
	}

	// Move to Sales tab
	public void moveToSalesTab() {
		CommonMethods.mouseHover(salesTab);
		CommonMethods.highlightelement(salesTab);
	}

	// Move to Home tab
	public void moveToHomeTab() {
		CommonMethods.mouseHover(homeTab);
		CommonMethods.highlightelement(homeTab);
	}

	// move to click On Customer Link under Sales Tab
	public void clickOnCustomerLink() throws InterruptedException {

		
		CommonMethods.highlightelement(customerslink);
		customerslink.click();

	}
	
	
	//click On Leads Link
	
	public void clickOnLeadsLink() throws InterruptedException {

		
		CommonMethods.highlightelement(leadslink);
		leadslink.click();

	}

	// Move to recent items and click on recent items
	public void clickOnRecentItems() throws InterruptedException {

		CommonMethods.mouseHover(recentItems);
		CommonMethods.highlightelement(recentItems);
		Thread.sleep(2000);
		CommonMethods.highlightelement(recentfirstItems);
		recentfirstItems.click();

	}

	// move to click On Activities Link under Home Tab
	public void clickOnActivitiesLink() throws InterruptedException {

		CommonMethods.highlightelement(activitieslink);
		activitieslink.click();

	}
          //move to New Button 
	
	
	// click On New Button On Customer Page
		public void clickOnNewButton() throws InterruptedException {
			CommonMethods.mouseHover(newButton);
			CommonMethods.highlightelement(newButton);

		}
		
		
		// click on retail Appointment
		public RetailAppointmentPage clickOnRetailAppointmentLink() throws InterruptedException {
			Thread.sleep(2000);
			CommonMethods.highlightelement(retailAppointmentlink);
			Thread.sleep(1000);
			retailAppointmentlink.click();
			
			System.out.println(" Navigated To Appoitnment Page:");
			
			
			return new RetailAppointmentPage();
		}
}
