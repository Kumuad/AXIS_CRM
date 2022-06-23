package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonutilities.TestUtil;
import testbase.TestBase;

public class CustomerSearchPage extends TestBase{
	// Constructor
		public CustomerSearchPage(WebDriver driver) {
			//super();
			this.driver = driver;
			PageFactory.initElements(driver, this);

		}
		
		
		//Excel sheet Name
		//public String customer_sheetname = "accountcreation";
		
		// Object Repository

		@FindBy(xpath = "//input[@data-autoid='17_ctrl']")
		WebElement customerIDTextBox;
		
		@FindBy(xpath ="//input[@data-autoid='10002743_ctrl']")
		WebElement mobilePhoneTextBox;
		
		@FindBy(xpath ="//input[@data-autoid='31_ctrl']")
		WebElement panNumbertextBox;
		
		@FindBy(xpath ="//input[@data-autoid='10002704_ctrl']")
		WebElement emailtextBox;
		
		@FindBy(xpath = "//a[@data-autoid='Fetch']")
		WebElement fetchButton;
		
		@FindBy(xpath = "//a[@data-autoid='Close_1']")
		WebElement closeButton;
		
		
		//Methods
		
		//verify Customer Search By Customer ID
		public String verifyCustomerSearchByCustomerID(String customer_sheetname) throws IOException, InterruptedException {
			
			String actualcustomerid = TestUtil.getCellData(customer_sheetname, "CustomerID", 1);
			customerIDTextBox.sendKeys(actualcustomerid);
			Thread.sleep(2000);
			fetchButton.click();
			TestUtil.takeScreenShot("Customer Search By Customer ID");
			//TestUtil.takeScreenShot("");
			return actualcustomerid;
			
			
			
		}

		//verify Customer Search By Mobile Phone
		public String verifyCustomerSearchByMobilePhone(String customer_sheetname) throws IOException, InterruptedException {

			String actualmobile = TestUtil.getCellData(customer_sheetname, "Mobile", 1);
			mobilePhoneTextBox.sendKeys(actualmobile);
			Thread.sleep(2000);
			fetchButton.click();
			TestUtil.takeScreenShot("Customer Search By Mobile Number");
			return actualmobile;
		}
		
		//verify Customer Search By PAN Number
		
		public String verifyCustomerSearchByPANNumber(String customer_sheetname) throws IOException, InterruptedException {

			String actualpannum = TestUtil.getCellData(customer_sheetname, "PAN", 1);
			panNumbertextBox.sendKeys(actualpannum);
			Thread.sleep(2000);
			System.out.println("Customer Search By PAN Number: "+actualpannum);
			fetchButton.click();
			TestUtil.takeScreenShot("Customer Search By PAN Number");
			return actualpannum;
		}
		
		//verify Customer Search By Email ID
		
		public String verifyCustomerSearchByEmail(String customer_sheetname) throws IOException, InterruptedException {

			String actualemail = TestUtil.getCellData(customer_sheetname, "Email", 1);
			emailtextBox.sendKeys(actualemail);
			Thread.sleep(2000);
			System.out.println("Customer Search By Email: "+actualemail);
			fetchButton.click();
			TestUtil.takeScreenShot("Customer Search By Email ID");
			return actualemail;
		}
		
}
