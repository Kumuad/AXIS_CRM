package testscripts;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonutilities.CommonMethods;
import commonutilities.CustomListener;
import commonutilities.TestUtil;
import pages.CustomerPage;
import pages.DetailsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OffersAndLeadPage;
import testbase.TestBase;

@Listeners(CustomListener.class)
public class TC01_ToVerifyAccountIsCreatedTest extends TestBase {

	// Constructor
	public TC01_ToVerifyAccountIsCreatedTest() {
		super();
	}

	/*
	 * LoginPage loginpage; HomePage homepage; TestUtil testutil; CustomerPage
	 * customerPage; OffersAndLeadPage offersAndLeadPage; CommonMethods
	 * commonmethods;
	 */

	LoginPage loginpage;
	HomePage homepage;
	CustomerPage customerPage;
	OffersAndLeadPage offersAndLeadPage;
	TestUtil testutil;
	CommonMethods commonmethods;

	// LoginPage loginpage = new LoginPage(driver);
	// HomePage homepage = new HomePage(driver);
	// CustomerPage customerPage = new CustomerPage(driver);
	// OffersAndLeadPage offersAndLeadPage = new OffersAndLeadPage(driver);
	// TestUtil testutil = new TestUtil();
	// CommonMethods commonmethods=new CommonMethods();

	@Test
	public void tocreateaccount() throws Exception {
		String sheetname="accountcreation";
		String sheetname2 ="accountLead";

		// initialization();
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		customerPage = new CustomerPage(driver);
		offersAndLeadPage = new OffersAndLeadPage(driver);
		testutil = new TestUtil();
		commonmethods = new CommonMethods();

		/*
		 * loginpage = new LoginPage(); homepage = new HomePage(); customerPage = new
		 * CustomerPage(); offersAndLeadPage = new OffersAndLeadPage(); testutil = new
		 * TestUtil(); commonmethods=new CommonMethods();
		 */

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
		// TestUtil.takeScreenShot("Account Creation");
		Thread.sleep(2000);
		log.info("************Account/Customer Creation Started*************************");

		// create customer/account with Invalid data

		// create customer/ account
		customerPage.createaccount();

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

		// Create New offer On Existing Customer
		offersAndLeadPage.createNewOffer();
		Thread.sleep(2000);
		CommonMethods.scrollDown(400);

		log.info("************Creation of New Lead On Existing Customer*************************");

		// Create Lead on Existing Customer
		offersAndLeadPage.createNewLead();

		Thread.sleep(5000);

		CommonMethods.scrollDown(400);

		Thread.sleep(3000);
		
		
		//verify Tab visible on Customer
		customerPage.verifyTabsVisibleOnCustomer();
		// logout
		loginpage.Logout();
	}

}