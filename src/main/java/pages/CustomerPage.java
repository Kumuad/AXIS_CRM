package pages;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import commonutilities.CommonMethods;
import commonutilities.TestUtil;
import testbase.TestBase;

public class CustomerPage extends TestBase {

	// Constructor
	public CustomerPage() {
		super();
		PageFactory.initElements(driver, this);

	}

	public String sheetname = "accountcreation";
	public String outputsheetname = "accountoutput";
	// *********Object Repository Customer Page/Account ****************

	@FindBy(xpath = "//a[@data-autoid='New_0']")
	WebElement newButton;

	@FindBy(xpath = "//span[contains(text(),'Retail Customer')]")
	WebElement retailCustomer;

	@FindBy(xpath = "//input[@name='AC_NAME']")
	WebElement accountName;

	//@FindBy(xpath = "//input[@name='AC_SHORTNAME']")
	@FindBy(xpath ="//input[@data-autoid='AC_SHORTNAME_ctrl']")
	WebElement accountShortname;

	@FindBy(xpath = "//select[@name='AC_TYPE']")
	WebElement accountCustomerTypeDropdown;

	@FindBy(xpath = "//input[@name='AC_MOBILE']")
	WebElement accountMobileNumber;

	@FindBy(xpath = "//input[@name='AC_EMAIL']")
	WebElement accountEmail;

	@FindBy(xpath = "//select[@name='AC_LEAD_SOURCE']")
	WebElement accountLeadSourceDropdown;
	
	@FindBy(xpath = "//input[@name='AC_TERRITORY']")
	WebElement accountTerritory;
	
	@FindBy(xpath ="//input[@name='cust_31']")
	WebElement PANNumberfield;
	
	@FindBy(xpath = "//td[contains(text(),'AlternateBranch004: Mumbai')]")
	WebElement accountTerritorytable;
	@FindBy(xpath = "(//span[contains(text(),'Save')])[1]")
	WebElement saveButton;

	@FindBy(xpath = "//a[@data-autoid='btn_toggle']")
	WebElement toggleButton;

	
	@FindBy(xpath ="(//span[contains(text(),'Profiler')])[2]")
	WebElement profilerTab;
	
	@FindBy(xpath ="//span[contains(text(),'Products')]")
	WebElement productsTab;
	
	@FindBy(xpath ="(//span[contains(text(),'Service Requests')])[2]")
	WebElement serviceRequestTab;
	
	
	@FindBy(xpath ="//span[contains(text(),'Transaction Analysis')]")
	WebElement transactionAnalysistTab;
	
	
	@FindBy(xpath = "//span[contains(text(),'Offers & Leads')]")
	WebElement offersandLeadTab;

	@FindBy(xpath = "//span[contains(text(),'Activities & Interaction')]")
	WebElement activitiesandinteractionTab;
	
	@FindBy(xpath ="//a[@data-autoid='Subject_0']/span[2]")
	WebElement subjectText;
	
	@FindBy(xpath ="//a[@data-autoid='LINK_NEW_APPOINTMENTAC_OPEN_ACTIVITIES1']")
	WebElement newActivityTab;	
	
	@FindBy(xpath ="//span[@data-autoid='AC_NAME_ctrl']")
	WebElement customernametext;
	
	@FindBy(xpath ="//input[@data-autoid='cust_438_ctrl']")
	WebElement accountTitle;
	
	@FindBy(xpath ="//select[@data-autoid='cust_384_ctrl']")
	WebElement accountGenderdropdown;
	
	@FindBy(xpath ="//input[@data-autoid='cust_17_ctrl']")
	WebElement accountCustomerID;
	
	
	// **************Methods********************

	// click On New Button On Customer Page
	public void clickOnNewButton() throws InterruptedException {
		CommonMethods.mouseHover(newButton);
		CommonMethods.highlightelement(newButton);

	}

	// click on retail Customer
	public void clickOnRetailCustomerLink() throws InterruptedException {
		Thread.sleep(2000);
		CommonMethods.highlightelement(retailCustomer);
		retailCustomer.click();
	}

	// click On offers and Lead Tab on details page
	public void clickoffersandLeadTab() {
		CommonMethods.highlightelement(offersandLeadTab);
		offersandLeadTab.click();
	}

	// click On offers and Lead Tab on details page
	public void clickactivitiesandinteractionTab() {
		CommonMethods.highlightelement(activitiesandinteractionTab);
		activitiesandinteractionTab.click();
	}
	
	//click On New Activity Tab
	public void clickOnNewActivityTab() {
		CommonMethods.highlightelement(newActivityTab);
		newActivityTab.click();
	}
	// click On toggle button on details page
	public void clickToggleButton() {
		
		CommonMethods.highlightelement(toggleButton);
		toggleButton.click();
	}
		
	
	
	// Get Text of Subject on Customer Page

	public  String getSubjectText() {

		return subjectText.getText();

	}
	// Account/Customer Creation
	public void createaccount() throws IOException, InterruptedException {

		// Generate Random Number
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		
		//CommonMethods.generateRandomNumber();
		String accountname = TestUtil.getCellData(sheetname, "Name", 1);
		String actualaccountname = accountname + randomInt;
		System.out.println("Acctual account name:  " + actualaccountname);

		// enter Customer Name
		accountName.sendKeys(actualaccountname);
		
		TestUtil.writeToExcel(outputsheetname,1, 0, actualaccountname);
		// accountName.sendKeys(TestUtil.getCellData(sheetname, "Name", 1));

		accountShortname.sendKeys("test");
		accountShortname.clear();

		// Enter Short Name
		accountShortname.sendKeys(TestUtil.getCellData(sheetname, "ShortName", 1));

		// TestUtil.setCellData(sheetname, 1, 0, accountname1);

		// Select Customer Type
		String customertype = TestUtil.getCellData(sheetname, "CustomerType", 1);
		CommonMethods.selectByText(accountCustomerTypeDropdown, customertype);

		// Enter Email
		accountEmail.sendKeys(TestUtil.getCellData(sheetname, "Email", 1));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 150)");
		Thread.sleep(1000);

		// Enter Mobile
		//int randomobileno = random.nextInt(1000000000);
		//System.out.println(randomobileno);
		String mobilenumber=CommonMethods.generateRandomMobileNumber();
		//String mobilenumber=String.valueOf(mobile);
		//String s1="9";
		//String actualmobnum=s1.concat(mobilenumber);
		System.out.println("Actual mobile no: "+mobilenumber);
		
		//accountMobileNumber.sendKeys(TestUtil.getCellData(sheetname, "Mobile", 1));
		accountMobileNumber.sendKeys(mobilenumber);
		TestUtil.writeToExcel(sheetname, 1, 4, mobilenumber);

		// Select Territory
		accountTerritory.sendKeys(TestUtil.getCellData(sheetname, "Territory", 1));
		accountTerritorytable.click();
		Thread.sleep(3000);

		// Select Lead source
		String leadsource = TestUtil.getCellData(sheetname, "LeadSource", 1);
		CommonMethods.selectByText(accountLeadSourceDropdown, leadsource);

		//Enter customer ID
		
		//int randomcustomerid=random.nextInt(1000000000);
		//String customerid=String.valueOf(randomcustomerid);
		//System.out.println(customerid);
		//accountCustomerID.sendKeys(TestUtil.getCellData(sheetname, "CustomerID", 1));
		String customerid=CommonMethods.generateRandomCustomerID();
		System.out.println(customerid);
		accountCustomerID.sendKeys(customerid);
		
		TestUtil.writeToExcel(sheetname, 1, 9, customerid);

		//Enter account title
		accountTitle.sendKeys(TestUtil.getCellData(sheetname, "Title", 1));
		
         //Select Gender from dropdown
		String gender = TestUtil.getCellData(sheetname, "Gender", 1);
		CommonMethods.selectByText(accountGenderdropdown, gender);
		Thread.sleep(3000);

		// click on Save Button
		//CommonMethods.highlightelement(saveButton);
		
	
		//saveButton.click(); Thread.sleep(2000);

		
		  //TestUtil.writeToExcel(outputsheetname,0, 0, "CustomerName");
		  //TestUtil.writeToExcel(outputsheetname,0, 1, "Result");
		  
		 // TestUtil.writeToExcel(outputsheetname,1, 0, actualaccountname);
		  
		 // TestUtil.writeToExcel(outputsheetname,0, 1, "Result");
		 // TestUtil.writeToExcel(outputsheetname,1, 1, "PASS");
		  
		 

		// click on Save Button
		CommonMethods.highlightelement(saveButton);
		
	
		saveButton.click(); Thread.sleep(2000);
		  
		  // click On Toggle button on Details Page 
		  clickToggleButton();
		  Thread.sleep(5000);
		  
		  //Get exp account name from details page 
			String expaccountname = customernametext.getText();
			System.out.println("Account Name on Details Page:  " + expaccountname);

			if (actualaccountname.equalsIgnoreCase(expaccountname)) {

				TestUtil.writeToExcel(outputsheetname, 0, 0, "CustomerName");
				TestUtil.writeToExcel(outputsheetname, 0, 1, "Result");
				TestUtil.writeToExcel(outputsheetname, 1, 0, expaccountname);
				TestUtil.writeToExcel(outputsheetname, 1, 1, "PASS");

			} else 
			{
				TestUtil.writeToExcel(outputsheetname, 0, 0, "CustomerName");
				TestUtil.writeToExcel(outputsheetname, 0, 1, "Result");
				TestUtil.writeToExcel(outputsheetname, 1, 0, expaccountname);
				TestUtil.writeToExcel(outputsheetname, 1, 1, "FAIL");

			}
			

			System.out.println(" ============================================================       ");
			System.out.println("");
			
			
          System.out.println("Customer is created with Customer Name: "+expaccountname);
			Assert.assertEquals(actualaccountname, expaccountname, "Customer Name mismatched");

		}
	
	
	public void verifyTabsVisibleOnCustomer() {
		
		boolean offersLead=offersandLeadTab.isDisplayed();
		
	}

	}
