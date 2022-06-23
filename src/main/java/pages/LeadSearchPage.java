package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonutilities.CommonMethods;
import commonutilities.TestUtil;
import testbase.TestBase;

public class LeadSearchPage extends TestBase {
	// Constructor
	public LeadSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public String leadcreation_sheetname = "leadcreation";
	// Object Repository

	@FindBy(xpath = "//input[@data-autoid='10001661_ctrl']")
	WebElement leadIDtextBox;
	
	@FindBy(xpath = "//input[@data-autoid='10001680_ctrl']")
	WebElement MobiletextBox;
	
	@FindBy(xpath = "//input[@data-autoid='192_ctrl']")
	WebElement PANtextBox;
	
	@FindBy(xpath = "//a[@data-autoid='Fetch']")
	WebElement fetchButton;
	
	@FindBy(xpath = "//a[@data-autoid='Close_1']")
	WebElement closeButton;


	// Methods
	//verify Lead Search By Lead ID
	
	public String verifyLeadSearchByLeadID(String leadcreation_sheetname) throws IOException, InterruptedException {

		String atualleadid = TestUtil.getCellData(leadcreation_sheetname, "LeadID", 1);
		leadIDtextBox.sendKeys(atualleadid);
		fetchButton.click();
		TestUtil.takeScreenShot("Lead Search By Lead ID");
		return atualleadid;

	}
	//verify Lead Search By Mobile Phone
	public String verifyLeadSearchByMobilePhone(String leadcreation_sheetname) throws IOException, InterruptedException {

		String actualmobile = TestUtil.getCellData(leadcreation_sheetname, "Mobile", 1);
		MobiletextBox.sendKeys(actualmobile);
		fetchButton.click();
		TestUtil.takeScreenShot("Lead Search By Mobile Number");
		return actualmobile;

	}
	
	//verify Lead Search By PAN Number
	public void verifyLeadSearchByPANNumber(String leadcreation_sheetname) throws IOException, InterruptedException {
		String pannum = TestUtil.getCellData(leadcreation_sheetname, "PAN", 1);
		PANtextBox.sendKeys(pannum);
		System.out.println("Lead Search By PAN Number: "+pannum);
		fetchButton.click();
		TestUtil.takeScreenShot("Lead Search By PAN Number");
	}
}
