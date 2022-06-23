package testscripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonutilities.CommonMethods;
import commonutilities.CustomListener;
import commonutilities.TestUtil;
import pages.CustomerPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OffersAndLeadPage;
import testbase.TestBase;

@Listeners(CustomListener.class)
public class TC01a_ToverifyAccountCreationInvalidDataTest extends TestBase {

	// Constructor
	public TC01a_ToverifyAccountCreationInvalidDataTest() {
		super();
	}

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	CustomerPage customerPage;
	OffersAndLeadPage offersAndLeadPage;
	CommonMethods commonmethods;

	@Test
	public void tocreateaccount() throws Exception {
	
		
		
		loginpage = new LoginPage(driver);

		homepage = new HomePage(driver);
		customerPage = new CustomerPage(driver);
		offersAndLeadPage = new OffersAndLeadPage(driver);
		testutil = new TestUtil();
		commonmethods = new CommonMethods();
		
		
		
		// Login to admin page
		loginpage.Login("axisadmin", "acid_qa");
		log.info("Logged in to  Home Page");
		// Select Administrator Role
		homepage.selectrole("Administrator");
		Thread.sleep(2000);

		// Move to sales Tab
		homepage.moveToSalesTab();
		Thread.sleep(2000);

		// click On customer Link in Sales Tab
		homepage.clickOnCustomerLink();

		// click on New Button
		customerPage.clickOnNewButton();

		// CLick On Customer Link under New Button
		customerPage.clickOnRetailCustomerLink();
		Thread.sleep(2000);
		log.info("************Account/Customer Creation Started*************************");

		// create customer/account with Invalid data

		// verify create customer/ account with Invalid Data
		customerPage.verifyAccountCreationInvalidData();

		// Click On Recent Items
		homepage.clickOnRecentItems();
		Thread.sleep(2000);

		// click on Toggle Button on Details Page
		customerPage.clickToggleButton();
		Thread.sleep(2000);

		// click On Offers And Lead tab
		customerPage.clickoffersandLeadTab();

		Thread.sleep(5000);
		log.info("************Creation of Offer On Existing Customer*************************");

		// verify New offer with Invalid Data On Existing Customer
		offersAndLeadPage.verifyNewOfferInvalidData();
		Thread.sleep(2000);
		CommonMethods.scrollDown(400);

		log.info("************Creation of New Lead On Existing Customer*************************");

		// verify Lead with Invalid Data on Existing Customer
		offersAndLeadPage.verifyNewLeadInvalidData();

		Thread.sleep(5000);

		CommonMethods.scrollDown(400);

		Thread.sleep(3000);
		// logout
		loginpage.Logout();
	}

}
