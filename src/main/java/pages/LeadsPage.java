package pages;

import java.io.IOException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import commonutilities.CommonMethods;
import commonutilities.TestUtil;
import testbase.TestBase;

public class LeadsPage extends TestBase {
	// Constructor
	public LeadsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	
	//public String leadcreation_sheetname = "leadcreation";
	public static String fileupload_document_path=  "C:\\Users\\kumuad.sagar\\eclipse-workspace\\AxisCRM\\src\\main\\java\\commonutilities\\Test.docx";
	
	// *********Object Repository Leads Page ****************
	
	@FindBy(xpath = "//a[@data-autoid='New_0']")
	WebElement newButton;


	@FindBy(xpath = "//select[@data-autoid='SALUTATION_ctrl']")
	WebElement nameDropdown;

	@FindBy(xpath = "//input[@data-autoid='FIRSTNAME_ctrl']")
	WebElement firstNameTextBox;

	@FindBy(xpath = "//input[@data-autoid='LASTNAME_ctrl']")
	WebElement lastNameTextBox;

	@FindBy(xpath = "//input[@data-autoid='LE_MOBILE_ctrl']")
	WebElement mobileTextBox;

	@FindBy(xpath = "//input[@data-autoid='LE_EMAIL_ctrl']")
	WebElement emailTextBox;

	@FindBy(xpath = "//input[@data-autoid='cust_249_ctrl']")
	WebElement dobTextBox;

	@FindBy(xpath = "//input[@data-autoid='cust_192_ctrl']")
	WebElement PANTextBox;

	@FindBy(xpath = "//input[@data-autoid='LE_ADDRESS_ctrl']")
	WebElement addressTextBox;

	@FindBy(xpath = "//select[@data-autoid='LE_PRODUCTCATEGORY_ctrl']")
	WebElement productDropdown;

	@FindBy(xpath = "//select[@data-autoid='LE_PRODUCT_ctrl']")
	WebElement subProductDropdown;

	@FindBy(xpath = "//a[@data-autoid='LE_TERRITORY_srch']")
	WebElement branchSearchButton;

	@FindBy(xpath = "//input[@data-autoid='Grid_SearchTextBox_ctrl']")
	WebElement branchSearchTextBox;

	@FindBy(xpath = "//a[@data-autoid='gridHF_LE_TERRITORY']")
	WebElement arrowLink;
	
	@FindBy(xpath ="//div[@data-autoid='Name_0']")
	WebElement selectbranch;
	@FindBy(xpath = "//select[@data-autoid='LE_LEADSOURCE_ctrl']")
	WebElement leadSourceDropdown;
	
	
	@FindBy(xpath ="//a[@data-autoid='cust_533_srch']")
	WebElement subSourceSearchButton;
	
	@FindBy(xpath ="//a[@data-autoid='gridHF_cust_533']")
	WebElement arrowLinkSubSource;
	
	@FindBy(xpath ="//div[@data-autoid='Level2_0']")
	WebElement selectSubSource;
	
	@FindBy(xpath ="//textarea[@data-autoid='cust_531_ctrl']")
	WebElement leadDescription;
	
	@FindBy(xpath = "(//span[contains(text(),'Save')])[1]")
	WebElement saveButton;
	
	@FindBy(xpath = "//span[@data-autoid='LE_NUMBER_ctrl']")
	WebElement leadIDNumber;
	
	@FindBy(xpath ="//span[@data-autoid='LE_MOBILE_ctrl']")
	WebElement mobileNumber;
	
	@FindBy(xpath ="//span[contains(text(),'Details')]")
	WebElement detailsTab;
	
	
	@FindBy(xpath = "//a[@data-autoid='btn_toggle']")
	WebElement toggleButton;
	
	@FindBy(xpath ="(//span[contains(text(),'Activities')])[2]")
	WebElement activitiesTab;
	
	@FindBy(xpath ="//a[@data-autoid='LINK_NEW_APPOINTMENTLE_OPEN_ACTIVITIES1']")
	WebElement newActivitiesLink;
	
	@FindBy(xpath ="//a[@data-autoid='LINK_NEW_TASKLE_OPEN_ACTIVITIES2']")
	WebElement newTaskLink;
	
	@FindBy(xpath ="//span[contains(text(),'Attachments')]")
	WebElement attachementsTab;
	
	
	@FindBy(xpath ="//span[contains(text(),'History')]")
	WebElement historyTab;
	
	
	@FindBy(xpath ="//div[@data-autoid='LE_HISTORY_StatusCode']")
	WebElement leadStatusCodehistoryTab;
	
	@FindBy(xpath ="//a[@data-autoid='StatusCode_0']")
	WebElement leadStatusCode;
	
	@FindBy(xpath ="//div[@data-autoid='LE_HISTORY_LastModifiedBy']")
	WebElement lastmodifiedByhistoryTab;
	
	@FindBy(xpath ="//div[@data-autoid='LastModifiedBy_0']")
	WebElement lastmodifiedBy;
	
	@FindBy(xpath ="//div[@data-autoid='LE_HISTORY_RoleName']")
	WebElement roleNamehistoryTab;
	
	@FindBy(xpath ="//div[@data-autoid='RoleName_0']")
	WebElement roleName;
	
	@FindBy(xpath ="//div[@data-autoid='LE_HISTORY_LastModifiedOn']")
	WebElement lastModifiedOnhistoryTab;
	
	@FindBy(xpath ="//div[@data-autoid='LastModifiedOn_0']")
	WebElement lastModifiedOn;
	
	
	@FindBy(xpath ="//div[@data-autoid='LE_HISTORY_Comments']")
	WebElement commentshistoryTab;
	
	
	
	
	@FindBy(xpath ="//a[@data-autoid='LINK_MULTIPLE_DOCUMENTSLE_RELATED_ATTACHMENTS1']")
	WebElement attachementNewDocumentLink;
	
	@FindBy(xpath ="//a[@data-autoid='Lay_5008']")
	WebElement defaultattachement;
	
	
	//@FindBy(xpath ="//input[@name='qqfile']")
	//@FindBy(xpath ="//input[@qq-button-id='621fde09-0072-46aa-9efd-b5a321a6c665']")
	//@FindBy(xpath ="//div[@class='docUpload__wrapper']")
	@FindBy(xpath ="//i[@class='icon icon-viewattachment f4']")
	WebElement attachement;
	
	@FindBy(xpath ="//textarea[@data-autoid='DM_DESCRIPTION_ctrl']")
	WebElement dmsDescription;
	
	@FindBy(xpath ="//a[@data-autoid='AttachmentName_0']")
	WebElement documentsAttached;
	
	//Error Msgs
	@FindBy(xpath ="//span[contains(text(),'Last Name is required')]")
	WebElement lastNameErrormsg;
	
	@FindBy(xpath ="//span[contains(text(),'Enter correct Mobile Number')]")
	WebElement mobileNumberErrormsg;
	
	@FindBy(xpath ="//span[contains(text(),'Invalid Email.')]")
	WebElement emailErrormsg;
	
	@FindBy(xpath ="//span[contains(text(),'Invalid value of field Date of Birth.')]")
	WebElement dateofbirthErrormsg;
	
	@FindBy(xpath ="//span[contains(text(),'Enter valid PAN')]")
	WebElement panErrormsg;
	
	@FindBy(xpath ="//span[contains(text(),'Sub Product is required')]")
	WebElement subProductErrormsg;
	
	@FindBy(xpath ="//span[contains(text(),'Branch is required')]")
	WebElement branchErrormsg;
	
	
	
	@FindBy(xpath ="//span[contains(text(),'Product is required')]")
	WebElement productErrormsg;
	
	@FindBy(xpath ="//span[contains(text(),'Lead Source is required')]")
	
	WebElement leadsourceErrormsg;
	
	
	// **************Methods starts ********************

	
	// click On New Button On Home Page
		public void clickOnNewButton() throws InterruptedException {
			CommonMethods.mouseHover(newButton);
			CommonMethods.highlightelement(newButton);
			
			newButton.click();

		}
		
		// click On toggle button on details page
		public void clickToggleButton() {

			CommonMethods.highlightelement(toggleButton);
			toggleButton.click();
		}

		// click On Attachments Tab
		public void clickOnAttachementstab() throws InterruptedException {
			CommonMethods.mouseHover(attachementsTab);
			CommonMethods.highlightelement(attachementsTab);

			attachementsTab.click();

		}

		// click On History Tab
		public void clickOnHistoryTab() throws InterruptedException {
			CommonMethods.mouseHover(historyTab);
			CommonMethods.highlightelement(historyTab);

			historyTab.click();

		}

		// click On Activities Tab
		public void clickOnActivitiestab() throws InterruptedException {
			CommonMethods.mouseHover(activitiesTab);
			CommonMethods.highlightelement(activitiesTab);

			activitiesTab.click();

		}
		// click On New Attachments Document Link
		public void clickOnNewAttachementsLink() throws InterruptedException {
			CommonMethods.mouseHover(attachementNewDocumentLink);
			CommonMethods.highlightelement(attachementNewDocumentLink);
			Thread.sleep(2000);
			CommonMethods.highlightelement(defaultattachement);
			defaultattachement.click();

		}

		
		// click On New Activity  Link
		public void clickOnNewActivityLink() throws InterruptedException {
			
			CommonMethods.highlightelement(newActivitiesLink);

			newActivitiesLink.click();

		}
		
		// click On New Task Link
		public void clickOnNewTaskLink() throws InterruptedException {

			CommonMethods.highlightelement(newTaskLink);

			newTaskLink.click();

		}
				
		
		
	// Creation Of new Lead
	public void createLead(String leadcreation_sheetname) throws IOException, InterruptedException {
		System.out.println("************************************");
		
		//Enter Name
		String name=TestUtil.getCellData(leadcreation_sheetname, "Name", 1);
		CommonMethods.selectByText(nameDropdown, name);	
		System.out.println("Name Selected: "+name);
		System.out.println();
		
		//Enter First Name
		int randomnum=CommonMethods.generateRandomNumber();
		String FirstName= "lead"+randomnum;
		firstNameTextBox.sendKeys(FirstName);
		TestUtil.writeToExcel(leadcreation_sheetname,1, 2, FirstName);
		System.out.println("FirstName Entered: "+FirstName);
		System.out.println();
		
		//Enter Last Name
		lastNameTextBox.sendKeys(TestUtil.getCellData(leadcreation_sheetname, "LastName", 1));
		String lastName=TestUtil.getCellData(leadcreation_sheetname, "LastName", 1);
		System.out.println("LastName Entered: "+lastName);
		System.out.println();
		
		//Enter Mobile Number
		String mobilenumber=CommonMethods.generateRandomMobileNumber();
		//System.out.println("Actual mobile no: "+mobilenumber);
		mobileTextBox.sendKeys(mobilenumber);
		TestUtil.writeToExcel(leadcreation_sheetname,1, 4, mobilenumber);
		System.out.println("Mobile Number Entered: "+mobilenumber);
		System.out.println();
		
		//Enter Email
		
		String email=CommonMethods.generateRandomEmail();
		System.out.println("Email Entered: "+email);
		emailTextBox.sendKeys(email);
		TestUtil.writeToExcel(leadcreation_sheetname,1, 5, email);
		System.out.println();
		
		//ENter Date of Birth
		dobTextBox.sendKeys(TestUtil.getCellData(leadcreation_sheetname, "DateofBirth", 1));
		String dateofbirth=TestUtil.getCellData(leadcreation_sheetname, "DateofBirth", 1);
		System.out.println("Date Of Birth Entered: "+dateofbirth);
		System.out.println();
		
		
		
		//Enter PAN Number
		String pannumber=CommonMethods.generatePANNumber();
		System.out.println("PAN Number Entered: "+pannumber);
		System.out.println();
		PANTextBox.sendKeys(pannumber);
		TestUtil.writeToExcel(leadcreation_sheetname,1, 6, pannumber);
		
		
		//Enter Address
		addressTextBox.sendKeys(TestUtil.getCellData(leadcreation_sheetname, "Address", 1));
		String address=TestUtil.getCellData(leadcreation_sheetname, "Address", 1);
		System.out.println("Address Entered: "+address);
		System.out.println();
		Thread.sleep(2000);
		
		
		//Select Product
		String product=TestUtil.getCellData(leadcreation_sheetname, "Product", 1);
		CommonMethods.selectByText(productDropdown, product);
		System.out.println("Product Selected: "+product);
		System.out.println();
		Thread.sleep(2000);
		
		
		//Select Sub Product
		String subproduct=TestUtil.getCellData(leadcreation_sheetname, "SubProduct", 1);
		CommonMethods.selectByText(subProductDropdown, subproduct);
		System.out.println("Sub Product Selected: "+subproduct);
		System.out.println();
		Thread.sleep(2000);
		
		//Enter Branch
		branchSearchButton.click();
		branchSearchTextBox.sendKeys(TestUtil.getCellData(leadcreation_sheetname, "Branch", 1));
		
		String branchname=TestUtil.getCellData(leadcreation_sheetname, "Branch", 1);
		System.out.println("Branch Selected: "+branchname);
		System.out.println();
		arrowLink.click();
		try {
			selectbranch.click();
		}
		catch(StaleElementReferenceException e) {
			selectbranch.click();
		}
		Thread.sleep(2000);
		
		
		//Select lead Source
		String leadsource=TestUtil.getCellData(leadcreation_sheetname, "LeadSource", 1);
		CommonMethods.selectByText(leadSourceDropdown, leadsource);
		System.out.println("Lead Source Selected: "+leadsource);
		System.out.println();
		
		//Select  lead sub source		
		subSourceSearchButton.click();
		branchSearchTextBox.sendKeys(TestUtil.getCellData(leadcreation_sheetname, "Subsource", 1));
		String leadsubsource=TestUtil.getCellData(leadcreation_sheetname, "Subsource", 1);
		System.out.println("Lead Sub Source Selected: "+leadsubsource);
		System.out.println();
		arrowLinkSubSource.click();
		try {
		selectSubSource.click();
		}
		catch(StaleElementReferenceException e) {
			selectSubSource.click();
		}
		
		Thread.sleep(2000);
		
		//Enter lead description
		CommonMethods.scrollByVisibilityofElement(leadDescription);
		leadDescription.sendKeys(TestUtil.getCellData(leadcreation_sheetname, "LeadDescription", 1));
		
		
		Thread.sleep(2000);
		saveButton.click();
		
		
		Thread.sleep(2000);
		
		String leadid=leadIDNumber.getText();
		System.out.println("Lead is created with Lead ID Number:"+leadid);
		TestUtil.writeToExcel(leadcreation_sheetname,1, 15, leadid);
		System.out.println();
		
		System.out.println("************************************************************");
		
		TestUtil.takeScreenShot("Lead Creation");
	}
	
	
	
	
	// Creation Of Invalid new Lead
		public void createLeadInvalidData(String leadcreation_sheetname) throws IOException, InterruptedException {
			System.out.println("************************************");
			
			//Enter Name
			String name=TestUtil.getCellData(leadcreation_sheetname, "Name", 2);
			CommonMethods.selectByText(nameDropdown, name);	
			System.out.println("Name Selected: "+name);
			System.out.println();
			
			//Enter First Name
			int randomnum=CommonMethods.generateRandomNumber();
			String FirstName= "lead"+randomnum;
			firstNameTextBox.sendKeys(FirstName);
			TestUtil.writeToExcel(leadcreation_sheetname,2, 2, FirstName);
			System.out.println("FirstName Entered: "+FirstName);
			System.out.println();
			
			//Enter Last Name
			lastNameTextBox.sendKeys(TestUtil.getCellData(leadcreation_sheetname, "LastName", 2));
			String lastName=TestUtil.getCellData(leadcreation_sheetname, "LastName", 2);
			System.out.println("LastName Entered: "+lastName);
			System.out.println();
			
			//Enter Mobile Number
			
			//String mobilenumber=CommonMethods.generateRandomMobileNumber();
			//System.out.println("Actual mobile no: "+mobilenumber);
			//mobileTextBox.sendKeys(mobilenumber);
			mobileTextBox.sendKeys(TestUtil.getCellData(leadcreation_sheetname, "Mobile", 2));
			String mobilenumber=TestUtil.getCellData(leadcreation_sheetname, "Mobile", 2);
			//TestUtil.writeToExcel(leadcreation_sheetname,2, 4, mobilenumber);
			System.out.println("Mobile Number Entered: "+mobilenumber);
			System.out.println();
			
			//Enter Email
			emailTextBox.sendKeys(TestUtil.getCellData(leadcreation_sheetname, "Email", 2));
			String email=TestUtil.getCellData(leadcreation_sheetname, "Email", 2);
			//TestUtil.writeToExcel(leadcreation_sheetname,2, 5, email);
			System.out.println("Mobile Number Entered: "+email);
			System.out.println();
			
			
			
			//ENter Date of Birth
			dobTextBox.sendKeys(TestUtil.getCellData(leadcreation_sheetname, "DateofBirth", 2));
			String dateofbirth=TestUtil.getCellData(leadcreation_sheetname, "DateofBirth", 2);
		
			System.out.println("Date Of Birth Entered: "+dateofbirth);
			System.out.println();
			
			
			
			//Enter PAN Number
			PANTextBox.sendKeys(TestUtil.getCellData(leadcreation_sheetname, "PAN", 2));
			String pannumber=TestUtil.getCellData(leadcreation_sheetname, "PAN", 2);
			System.out.println("PAN Number Entered: "+pannumber);
			System.out.println();
			
			
			
			
			//Enter Address
			addressTextBox.sendKeys(TestUtil.getCellData(leadcreation_sheetname, "Address", 2));
			String address=TestUtil.getCellData(leadcreation_sheetname, "Address", 2);
			System.out.println("Address Entered: "+address);
			System.out.println();
			Thread.sleep(2000);
			
			
			//Select Product
			CommonMethods.scrollByVisibilityofElement(productDropdown);
			String product=TestUtil.getCellData(leadcreation_sheetname, "Product", 2);
			CommonMethods.selectByText(productDropdown, product);
			System.out.println("Product Selected: "+product);
			System.out.println();
			Thread.sleep(2000);
			
			
			//Select Sub Product
			CommonMethods.scrollByVisibilityofElement(subProductDropdown);
			String subproduct=TestUtil.getCellData(leadcreation_sheetname, "SubProduct", 2);
			CommonMethods.selectByText(subProductDropdown, subproduct);
			System.out.println("Sub Product Selected: "+subproduct);
			System.out.println();
			Thread.sleep(2000);
			
			/*
			 * //Enter Branch CommonMethods.scrollByVisibilityofElement(branchSearchButton);
			 * branchSearchButton.click();
			 * branchSearchTextBox.sendKeys(TestUtil.getCellData(leadcreation_sheetname,
			 * "Branch", 2));
			 * 
			 * String branchname=TestUtil.getCellData(leadcreation_sheetname, "Branch", 2);
			 * System.out.println("Branch Selected: "+branchname); System.out.println();
			 * arrowLink.click(); try { selectbranch.click(); }
			 * catch(StaleElementReferenceException e) { selectbranch.click(); }
			 */
			Thread.sleep(2000);
			
			
			//Select lead Source
			String leadsource=TestUtil.getCellData(leadcreation_sheetname, "LeadSource", 2);
			//CommonMethods.selectByText(leadSourceDropdown, leadsource);
			CommonMethods.selectByText(leadSourceDropdown, "");
			
			System.out.println("Lead Source Selected: "+leadsource);
			System.out.println();
			
			//Select  lead sub source	
			CommonMethods.scrollByVisibilityofElement(subSourceSearchButton);
			subSourceSearchButton.click();
			branchSearchTextBox.sendKeys(TestUtil.getCellData(leadcreation_sheetname, "Subsource", 2));
			String leadsubsource=TestUtil.getCellData(leadcreation_sheetname, "Subsource", 2);
			System.out.println("Lead Sub Source Selected: "+leadsubsource);
			System.out.println();
			arrowLinkSubSource.click();
			try {
			selectSubSource.click();
			}
			catch(StaleElementReferenceException e) {
				selectSubSource.click();
			}
			
			Thread.sleep(2000);
			
			//Enter lead description
			CommonMethods.scrollByVisibilityofElement(leadDescription);
			leadDescription.sendKeys(TestUtil.getCellData(leadcreation_sheetname, "LeadDescription", 2));
			
			
			Thread.sleep(2000);
			saveButton.click();
			
			
			Thread.sleep(2000);
			
			/*
			 * System.out.println("Lead is created with Lead ID Number:"+leadIDNumber.
			 * getText()); System.out.println(); System.out.println(
			 * "************************************************************");
			 */
		}
		
	
	//verify Error Messages
		public void verifyErrorMessages() {
		//last name	
         lastNameErrormsg.isDisplayed();
		 String lastnameerrormsg=lastNameErrormsg.getText();
		 System.out.println("ErrorMsg last name : "+lastnameerrormsg);
		 
		 
		 //mobilenumber
		 mobileNumberErrormsg.isDisplayed();
		 String mobilenumbererrormsg=mobileNumberErrormsg.getText();
		 System.out.println("ErrorMsg Mobile Number: "+mobilenumbererrormsg);
		 
		 //email
		 emailErrormsg.isDisplayed();
		 String emailerrormsg=emailErrormsg.getText();
		 System.out.println("ErrorMsg Email: "+emailerrormsg);
		 
		 
		//dateofbirth
		 
		 dateofbirthErrormsg.isDisplayed();
		 String dateofbirth=dateofbirthErrormsg.getText();
		 System.out.println("ErrorMsg date ofBirth: "+dateofbirth);
		 
		 
		 //pan
		 panErrormsg.isDisplayed();
		 String pannumber=panErrormsg.getText();
		 System.out.println("ErrorMsg PAN Number: "+pannumber);
		 
		 
	       //product
		 
		 productErrormsg.isDisplayed();
		 String product=productErrormsg.getText();
		 System.out.println("ErrorMsg Product: "+product);
		 
		 
		 //subproduct
		 
		
		 subProductErrormsg.isDisplayed();
		 String subproduct=subProductErrormsg.getText();
		 System.out.println("ErrorMsg Sub Product: "+subproduct);
		 
		 
		 //Branch
		
		 branchErrormsg.isDisplayed();
		 String branch=branchErrormsg.getText();
		 System.out.println("ErrorMsg Branch: "+branch);
		 
		 
	      //lead source
		 
		// leadsourceErrormsg.isDisplayed();
		// String leadsource=leadsourceErrormsg.getText();
		 //System.out.println("ErrorMsg Lead source: "+leadsource);
		}
	
	//to verify document is getting attached under attachements
	
	public void verifyDocumentsAttachedOnDetailsPage() throws InterruptedException, IOException {
		
		

		CommonMethods.switchwindow();
		Thread.sleep(10000);
		
		System.out.println("Switched to window");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//CommonMethods.clickelementbyjavascript(attachement);
		driver.navigate().refresh();
		//CommonMethods.clickelementbyjavascript(attachement);
		
		Actions a = new Actions(driver);
		a.moveToElement(attachement).click().perform();
		
		Thread.sleep(3000);
		
		
		// upload file on Task page
		CommonMethods.fileupload(fileupload_document_path);
		
		CommonMethods.scrollByVisibilityofElement(dmsDescription);
		dmsDescription.sendKeys("Document Attached");
		Thread.sleep(3000);
		saveButton.click();
		Thread.sleep(5000);
		CommonMethods.switchtoparentwindow();
		
		TestUtil.takeScreenShot("Documents attached");
		boolean value=documentsAttached.isDisplayed();
		Assert.assertTrue(value, "Document is not attached");
		
	}
	
	
	
	
	//to verify lead History details 
	
	public void verifyLeadHistoryDetails() throws IOException, InterruptedException {
		boolean leadstatuscode=leadStatusCodehistoryTab.isDisplayed();
		Assert.assertTrue(leadstatuscode, "Lead status code Tab not Present");
		
		boolean lastmodifiedby=lastmodifiedByhistoryTab.isDisplayed();
		Assert.assertTrue(lastmodifiedby, "Last modified By Tab not Present");
		
		boolean rolename=roleNamehistoryTab.isDisplayed();
		Assert.assertTrue(rolename, "Role Name Tab not Present");
		
		boolean lastModifiedon=lastModifiedOnhistoryTab.isDisplayed();
		Assert.assertTrue(lastModifiedon, "Last Modified On Tab not Present");
		
		
		boolean comments=commentshistoryTab.isDisplayed();
		Assert.assertTrue(comments, "Comments On Tab not Present");
		
		System.out.println("Lead Status Code :"+leadStatusCode.getText());
		System.out.println();
		
		System.out.println("Last modified By :"+lastmodifiedBy.getText());
		System.out.println();
		
	
		System.out.println("Role Name :"+roleName.getText());
		System.out.println();
		
		
		System.out.println("Last Modified On  :"+lastModifiedOn.getText());
		System.out.println();
		
		TestUtil.takeScreenShot("Lead History Details Tab");
	}
	
	//get leadnumber on leads Page
	public String leadIdNumber() {
		
		String expleadId=leadIDNumber.getText();
	
		
		return expleadId;
		
	}
	
	
	
	
	//get Mobile Number On Leads Page
      public String verifymobileNumberOnLeadPage() {
		
		String expmobilenumber=mobileNumber.getText();
	
		
		return expmobilenumber;
		
	}
	
}
