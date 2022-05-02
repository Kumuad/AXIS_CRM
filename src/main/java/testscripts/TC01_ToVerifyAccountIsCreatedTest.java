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

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	CustomerPage customerPage;
	OffersAndLeadPage offersAndLeadPage;
	CommonMethods commonmethods;

	
		
	

	@Test
	public void tocreateaccount() throws Exception {
		
		loginpage = new LoginPage();

		homepage = new HomePage();
		customerPage = new CustomerPage();
		offersAndLeadPage = new OffersAndLeadPage();
		testutil = new TestUtil();


		// Login to admin page
		loginpage.Login("axisadmin", "acid_qa");

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

		// Create New offer On Existing Customer
		offersAndLeadPage.createNewOffer();
		Thread.sleep(2000);
		CommonMethods.scrollDown(400);

		// Create Lead on Existing Customer
		offersAndLeadPage.createNewLead();

		Thread.sleep(5000);

		CommonMethods.scrollDown(400);

		Thread.sleep(3000);
		//logout
		loginpage.Logout();
	}

	
}