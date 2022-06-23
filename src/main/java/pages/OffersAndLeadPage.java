package pages;



import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import commonutilities.TestUtil;

import commonutilities.CommonMethods;
import testbase.TestBase;

public class OffersAndLeadPage extends TestBase{
	// Constructor
	public OffersAndLeadPage(WebDriver driver) {
		//super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	//public String sheetname ="accountLead";
	//public String sheetname1="accountOffer";
	public String offer_sheetname="offercreation";
	// *********Object Repository Offers And Leads Page ****************

	
	@FindBy(xpath = "//a[@data-autoid='New_0']")
	WebElement newButton;

	//@FindBy(xpath ="//span[contains(text(),'New Offer')]")
	@FindBy(xpath ="//a[@data-autoid='LNK_NEWOFFERAC_OFFER0']")
	WebElement newOffer;

	@FindBy(xpath = "//a[@data-autoid='LINK_NEW_LEADAC_RELATED_LEADS0']")
	WebElement newLead;
	
	@FindBy(xpath ="//textarea[@data-autoid='cust_130908_ctrl']")
	WebElement instructionTextarea;
	
	@FindBy(xpath ="//input[@data-autoid='cust_248_ctrl']")
	WebElement alternateMobileLead;
	
	@FindBy(xpath ="//input[@name='LE_PRODUCTCATEGORY']")
	WebElement productLead;
	
	@FindBy(xpath ="//select[@name='LE_PRODUCT']")
	WebElement subProductDropdown;
	
	@FindBy(xpath ="//input[@name='LE_TERRITORY']")
	WebElement branchLead;
	
	@FindBy(xpath ="//select[@name='LE_LEADSOURCE']")
	WebElement leadSourcedropdown;
	
	@FindBy(xpath ="//textarea[@data-autoid='cust_531_ctrl']")
	WebElement leadDescription;
	
	@FindBy(xpath ="//select[@name='OF_PRODUCT']")
	WebElement offerSubProduct;
	
	@FindBy(xpath ="//textarea[@data-autoid='cust_130908_ctrl']")
	WebElement offerDescription;
	
	@FindBy(xpath ="(//span[@class='acd-link-text'])[5]")
	WebElement offerCreated;
	
	@FindBy(xpath ="(//span[@class='acd-link-text'])[5]")
	WebElement leadCreated;
	
	@FindBy(xpath ="//a[@data-autoid='Save']")
	WebElement saveButton;
	
	
	@FindBy(xpath ="//div[@class='ui-dialog-content card-scroll custom--filters ddddddd']/ul/li/ul/li")
	WebElement leadErrorMessages;
	
	
	@FindBy(xpath ="//span[@class='close-icon']")
	WebElement closepopup;
	
	
	
	//***************offers***************
	@FindBy(xpath ="//span[contains(text(),'Offer')]")
	WebElement offer;
	
	@FindBy(xpath ="//input[@data-autoid='cust_464_ctrl']")
	WebElement offercustomerID;

	@FindBy(xpath ="//select[@data-autoid='cust_577_ctrl']")
	WebElement priorityDropdown;
	
	@FindBy(xpath ="//input[@name='OF_PRODUCTCATEGORY']")
	WebElement offerProduct;
	
	@FindBy(xpath ="//input[@name='cust_469']")
	WebElement description;
	
	@FindBy(xpath ="//select[@name='cust_1891']")
	WebElement offerStatusDropdown;
	
	@FindBy(xpath ="//input[@name='OF_COMPANY']")
	WebElement offerCustomerName;
	
	@FindBy(xpath ="//textarea[@data-autoid='cust_481_ctrl']")
	WebElement offerTermsAndConditions;
	
	@FindBy(xpath ="//input[@name='OF_TERRITORY']")
	WebElement branch;
	
	@FindBy(xpath ="//a[@data-autoid='OF_VALIDTILL_today']")
	WebElement offerTillDate;
	
	@FindBy(xpath ="//a[@data-autoid='OF_VALIDFROM_today']")
	WebElement offerFromDate;
	
	@FindBy(xpath ="//a[@data-autoid='OF_TERRITORY_srch']")
	WebElement branchsearch;
	@FindBy(xpath ="//input[@data-autoid='Grid_SearchTextBox_ctrl']")
	WebElement branchinputTextBox;
	
	@FindBy(xpath ="//a[@data-autoid='gridHF_OF_TERRITORY']")
	WebElement brancharrowbutton;
	
	@FindBy(xpath = "//div[contains(text(),'AlternateBranch004: Mumbai')]")
	WebElement Territorytable;
	
	@FindBy(xpath ="//a[@data-autoid='OF_PRODUCTCATEGORY_srch']")
	WebElement productsearch;
	@FindBy(xpath ="//input[@data-autoid='Grid_SearchTextBox_ctrl']")
	WebElement productinputTextBox;
	
	@FindBy(xpath ="//a[@data-autoid='gridHF_OF_PRODUCTCATEGORY']")
	WebElement productarrowbutton;
	
	
	@FindBy(xpath = "//div[@data-autoid='Name_0']")
	WebElement productTable;
	
	@FindBy(xpath ="//span[contains(text(),'History')]")
	WebElement historyTab;
	
	// **************Methods********************

	// click On New Button On Home Page
	public void clickOnNewButton() throws InterruptedException {
		CommonMethods.mouseHover(newButton);
		CommonMethods.highlightelement(newButton);

		newButton.click();

	}

	
	
	// click on New Offer Link
	public void clickNewOfferLink() {
		CommonMethods.highlightelement(newOffer);
		newOffer.click();
		
		
	}

	// click on New Lead Link
	public void clickNewLeadLink() {
		CommonMethods.highlightelement(newLead);
		newLead.click();
	}

	// create New Offer on existing Customer
	public void createNewOffer(String sheetname1) throws InterruptedException, IOException {
		String mainwindow = driver.getWindowHandle();
		//System.out.println(mainwindow);

		clickNewOfferLink();
		Thread.sleep(3000);

		for (String handle : driver.getWindowHandles()) {
			//System.out.println(handle);
			if (!mainwindow.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle);
				
				//maximize window
				CommonMethods.maximizeWindow();
				
				//WebElement ele = driver.findElement(By.xpath("//select[@name='OF_PRODUCT']"));
				//Select sel = new Select(ele);
				//sel.selectByVisibleText("03.Priority");
				String subproductoffer = TestUtil.getCellData(sheetname1, "SubProduct", 1);
				CommonMethods.selectByText(offerSubProduct, subproductoffer);
				//instructionTextarea.sendKeys("test");
				
				instructionTextarea.sendKeys(TestUtil.getCellData(sheetname1, "Description", 1));
				Thread.sleep(3000);
				saveButton.click();
				Thread.sleep(10000);
			}
		}
		driver.switchTo().window(mainwindow);
		System.out.println(" ============================================================       ");
		System.out.println("");
		
		
		System.out.println("New Offer Created On Existing Customer with Offer Name:  "+offerCreated.getText());
		TestUtil.takeScreenShot("Offer Creation");
	}
	
	

	//verify New Offer with Invalid Data
	public void verifyNewOfferInvalidData(String sheetname1) throws InterruptedException, IOException{
		
		String mainwindow = driver.getWindowHandle();
		//System.out.println(mainwindow);

		clickNewOfferLink();
		Thread.sleep(3000);

		for (String handle : driver.getWindowHandles()) {
			//System.out.println(handle);
			if (!mainwindow.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle);
				
				//maximize window
				CommonMethods.maximizeWindow();
				
				//create New offer Invalid data
				createNewOfferInvalidData();
				Thread.sleep(2000);
				
				//verify Offer Page error msgs for Invalid data
				verifyErrorMgsNewOfferInvalidData();
				Thread.sleep(2000);
				
				TestUtil.takeScreenShot("Error Messages New Offer");
				
				closepopup.click();
				//WebElement ele = driver.findElement(By.xpath("//select[@name='OF_PRODUCT']"));
				//Select sel = new Select(ele);
				//sel.selectByVisibleText("03.Priority");
				String subproductoffer = TestUtil.getCellData(sheetname1, "SubProduct", 1);
				CommonMethods.selectByText(offerSubProduct, subproductoffer);
				//instructionTextarea.sendKeys("test");
				
				instructionTextarea.sendKeys(TestUtil.getCellData(sheetname1, "Description", 1));
				Thread.sleep(3000);
				saveButton.click();
				Thread.sleep(10000);
			}
		}
		driver.switchTo().window(mainwindow);
		System.out.println(" ============================================================       ");
		System.out.println("");
		
		
		System.out.println("New Offer Created On Existing Customer with Offer Name:  "+offerCreated.getText());
		TestUtil.takeScreenShot("Offer Creation");
		
		
		
		
	}
	
	// create New Offer with invalid data
	public void createNewOfferInvalidData() throws InterruptedException {

		CommonMethods.selectByText(offerSubProduct, "");

		saveButton.click();
	}

	//verify Error Messages for New Offer Page
	public void verifyErrorMgsNewOfferInvalidData()
	{
		WebElement ele=driver.findElement(By.xpath("//div[@class='ui-dialog-content card-scroll custom--filters ddddddd']/ul/li/ul/li"));
		String errormsg=ele.getText();
		System.out.println("Error Message on New Offer Page: "+errormsg);
	}
	
	
	 
	 //create New Lead on existing customer with invalid data 
	 
		public void createNewLeadInvalidData() throws InterruptedException {

			saveButton.click();

		}
		
		
		//verify error messages on New Lead
		
		public void verifyErrorMessagesCreateLeadInvalidData() {
			
			List<WebElement> errormsgs = driver.findElements(By.xpath("//div[@class='ui-dialog-content card-scroll custom--filters ddddddd']/ul/li/ul/li"));

	        System.out.println(errormsgs.size());

	        for (WebElement ele : errormsgs) {
	            String errormsgnames = ele.getText();
	            System.out.println("Error messages on Lead page: "+errormsgnames);
	            
	            
	        }
			
		}
	
	//create New Lead on existing Customer
	
	public void createNewLead(String sheetname) throws InterruptedException, IOException {
		String mainwindow = driver.getWindowHandle();
		//System.out.println(mainwindow);
		
		clickNewLeadLink();
		Thread.sleep(3000);

		for (String handle : driver.getWindowHandles()) 
		{
			//System.out.println(handle);
			if (!mainwindow.equalsIgnoreCase(handle)) 
			{
				driver.switchTo().window(handle);
				CommonMethods.maximizeWindow();
				
				alternateMobileLead.sendKeys(TestUtil.getCellData(sheetname, "AlternateMobile", 1));
				
				Thread.sleep(3000);
				productLead.sendKeys(TestUtil.getCellData(sheetname, "Product", 1));
				Thread.sleep(3000);
				WebElement ele=driver.findElement(By.xpath("(//div[@class='griddle-body shadow-4 autocomplete-table']/table/tbody/tr/td)[1]"));
				try{
					ele.click();
				}
				catch(StaleElementReferenceException e)
				{
					ele.click();
				}
				
				Thread.sleep(3000);
				String subproduct = TestUtil.getCellData(sheetname, "Subproduct", 1);
				CommonMethods.selectByText(subProductDropdown, subproduct);
				Thread.sleep(3000);
				branchLead.sendKeys(TestUtil.getCellData(sheetname, "Branch", 1));
				
				
				try{
					ele.click();
				}
				catch(StaleElementReferenceException e)
				{
					ele=driver.findElement(By.xpath("(//div[@class='griddle-body shadow-4 autocomplete-table']/table/tbody/tr/td)[1]"));
					ele.click();
				}
				Thread.sleep(3000);
				String leadsource = TestUtil.getCellData(sheetname, "LeadSource", 1);
				try{
					CommonMethods.selectByText(leadSourcedropdown, leadsource);
				}
				catch(StaleElementReferenceException e)
				{
					CommonMethods.selectByText(leadSourcedropdown, leadsource);
				}
				
				Thread.sleep(3000);
				
				CommonMethods.scrollDown(400);
				leadDescription.sendKeys(TestUtil.getCellData(sheetname, "Description", 1));
				
				Thread.sleep(3000);
				saveButton.click();
				Thread.sleep(5000);
			}
		}
		driver.switchTo().window(mainwindow);
		
		System.out.println(" ============================================================       ");
		System.out.println("");
		
		
		System.out.println("New Lead Created On Existing Customer with Lead Name:  "+leadCreated.getText());
		
		TestUtil.takeScreenShot("Lead Creation");
	}
	
	
	
	//verify New lead On existing customer with Invalid Data
	public void verifyNewLeadInvalidData(String sheetname) throws InterruptedException, IOException {
		String mainwindow = driver.getWindowHandle();
		//System.out.println(mainwindow);
		
		clickNewLeadLink();
		Thread.sleep(3000);

		for (String handle : driver.getWindowHandles()) 
		{
			//System.out.println(handle);
			if (!mainwindow.equalsIgnoreCase(handle)) 
			{
				driver.switchTo().window(handle);
				CommonMethods.maximizeWindow();
				createNewLeadInvalidData();
				Thread.sleep(2000);
				
				verifyErrorMessagesCreateLeadInvalidData();
				TestUtil.takeScreenShot("Error Messages New Lead");
				Thread.sleep(2000);
				
				closepopup.click();
				alternateMobileLead.sendKeys(TestUtil.getCellData(sheetname, "AlternateMobile", 1));
				
				Thread.sleep(3000);
				productLead.sendKeys(TestUtil.getCellData(sheetname, "Product", 1));
				Thread.sleep(3000);
				WebElement ele=driver.findElement(By.xpath("(//div[@class='griddle-body shadow-4 autocomplete-table']/table/tbody/tr/td)[1]"));
				try{
					ele.click();
				}
				catch(StaleElementReferenceException e)
				{
					ele.click();
				}
				
				Thread.sleep(3000);
				String subproduct = TestUtil.getCellData(sheetname, "Subproduct", 1);
				CommonMethods.selectByText(subProductDropdown, subproduct);
				Thread.sleep(3000);
				branchLead.sendKeys(TestUtil.getCellData(sheetname, "Branch", 1));
				
				
				try{
					ele.click();
				}
				catch(StaleElementReferenceException e)
				{
					ele=driver.findElement(By.xpath("(//div[@class='griddle-body shadow-4 autocomplete-table']/table/tbody/tr/td)[1]"));
					ele.click();
				}
				Thread.sleep(3000);
				String leadsource = TestUtil.getCellData(sheetname, "LeadSource", 1);
				try{
					CommonMethods.selectByText(leadSourcedropdown, leadsource);
				}
				catch(StaleElementReferenceException e)
				{
					CommonMethods.selectByText(leadSourcedropdown, leadsource);
				}
				
				Thread.sleep(3000);
				
				CommonMethods.scrollDown(400);
				leadDescription.sendKeys(TestUtil.getCellData(sheetname, "Description", 1));
				
				Thread.sleep(3000);
				saveButton.click();
				Thread.sleep(5000);
			}
		}
		driver.switchTo().window(mainwindow);
		
		System.out.println(" ============================================================       ");
		System.out.println("");
		
		
		System.out.println("New Lead Created On Existing Customer with Lead Name:  "+leadCreated.getText());
		
		TestUtil.takeScreenShot("Lead Creation");
		
		
	}
	
             //create offer

	      public void createOffer(String offer_sheetname) throws IOException, InterruptedException {
	    	  
				// Enter CustomerID
				String customerid = CommonMethods.generateRandomCustomerID();
				System.out.println("Customer ID Entered: " + customerid);
				System.out.println();
				offercustomerID.sendKeys(customerid);
				TestUtil.writeToExcel(offer_sheetname, 1, 1, customerid);

				// Select Priority value
				String priority = TestUtil.getCellData(offer_sheetname, "Priority", 1);
				CommonMethods.selectByText(priorityDropdown, priority);
				System.out.println("Priority Selected: " + priority);
				System.out.println();


				// Enter branch /territory value
				String branchvalue = TestUtil.getCellData(offer_sheetname, "Branch", 1);
				branchsearch.click();
				Thread.sleep(2000);
				branchinputTextBox.sendKeys(TestUtil.getCellData(offer_sheetname, "Branch", 1));
				Thread.sleep(2000);
				brancharrowbutton.click();
				System.out.println("Territory Selected: " + branchvalue);
				System.out.println();
				Thread.sleep(3000);
				//WebElement ele = driver.findElement(By.xpath("//div[@class='griddle-body shadow-4 autocomplete-table']/table/tbody/tr/td[1]"));
				//ele.click();
				Territorytable.click();
	    	  
	    	    //Enter offer Description	
				String offersdescription = TestUtil.getCellData(offer_sheetname, "OfferDescription", 1);
				description.sendKeys(TestUtil.getCellData(offer_sheetname, "OfferDescription", 1));
				System.out.println("Offer Description Entered: " + offersdescription);
				System.out.println();
				
				 //Enter offer Terms and Conditions
				String offerstermsandconditions = TestUtil.getCellData(offer_sheetname, "offersTermsAndConditions", 1);
				offerTermsAndConditions.sendKeys(TestUtil.getCellData(offer_sheetname, "offersTermsAndConditions", 1));
				System.out.println("Offers terms and Conditions Entered: " + offerstermsandconditions);
				System.out.println();
				
				//Select offer Status
				String offerstatus = TestUtil.getCellData(offer_sheetname, "OfferStatus", 1);
				CommonMethods.selectByText(offerStatusDropdown, offerstatus);
				System.out.println("offer Status  Selected: " + offerstatus);
				System.out.println();
				
				
				//Select Product
				String productvalue = TestUtil.getCellData(offer_sheetname, "Product", 1);
			    productsearch.click();
				Thread.sleep(2000);
				productinputTextBox.sendKeys(TestUtil.getCellData(offer_sheetname, "Product", 1));
				Thread.sleep(2000);
				productarrowbutton.click();
				Thread.sleep(2000);
				productTable.click();
				System.out.println("Product  Selected: " + productvalue);
				System.out.println();
				Thread.sleep(3000);
				
				

				// Enter sub Product
				String subproduct = TestUtil.getCellData(offer_sheetname, "SubProduct", 1);
				CommonMethods.selectByText(offerSubProduct, subproduct);
				System.out.println("Sub Product Selected: " + subproduct);
				System.out.println();
				Thread.sleep(3000);
				
				
				
				//select from date 
				
				CommonMethods.scrollByVisibilityofElement(offerFromDate);
				offerFromDate.click();
				Thread.sleep(2000);
				
				//Select to date 
	    	     offerTillDate.click();
	    	     Thread.sleep(2000);
	    	   //Click On Save Button
	    	   saveButton.click();
	    	   
	    	   Thread.sleep(2000);
	    	   TestUtil.takeScreenShot("Offer Created Details Page");
	    	   
	    	   
	    	   //click on History Tab
	    	   
	    	   historyTab.click();
	    	   
	    	   TestUtil.takeScreenShot("Offer Created History Page");
	    	  
	    	  

	           }
}
