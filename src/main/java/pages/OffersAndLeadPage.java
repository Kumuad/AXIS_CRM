package pages;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import commonutilities.TestUtil;

import commonutilities.CommonMethods;
import testbase.TestBase;

public class OffersAndLeadPage extends TestBase{
	// Constructor
	public OffersAndLeadPage() {
		super();
		PageFactory.initElements(driver, this);

	}
	
	
	public String sheetname ="accountLead";
	public String sheetname1="accountOffer";
	// *********Object Repository Offers And Leads Page ****************

	

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
	
	
	// **************Methods********************

	

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
	public void createNewOffer() throws InterruptedException, IOException {
		String mainwindow = driver.getWindowHandle();
		//System.out.println(mainwindow);

		clickNewOfferLink();
		Thread.sleep(3000);

		for (String handle : driver.getWindowHandles()) {
			//System.out.println(handle);
			if (!mainwindow.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle);
				//WebElement ele = driver.findElement(By.xpath("//select[@name='OF_PRODUCT']"));
				//Select sel = new Select(ele);
				//sel.selectByVisibleText("03.Priority");
				String subproductoffer = TestUtil.getCellData(sheetname1, "SubProduct", 1);
				CommonMethods.selectByText(offerSubProduct, subproductoffer);
				//instructionTextarea.sendKeys("test");
				
				instructionTextarea.sendKeys(TestUtil.getCellData(sheetname1, "Description", 1));
				Thread.sleep(3000);
				saveButton.click();
				Thread.sleep(5000);
			}
		}
		driver.switchTo().window(mainwindow);
		System.out.println(" ============================================================       ");
		System.out.println("");
		
		
		System.out.println("New Offer Created On Existing Customer with Offer Name:  "+offerCreated.getText());
		TestUtil.takeScreenShot("Offer Creation");
	}

	
	//create New Lead on existing Customer
	
	public void createNewLead() throws InterruptedException, IOException {
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

	}

