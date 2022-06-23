package testscripts;

import org.testng.annotations.Test;

import commonutilities.CommonMethods;
import commonutilities.TestUtil;
import pages.CustomerPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OffersAndLeadPage;
import testbase.TestBase;

public class TocreateNewOfferOnExistingCustomerTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	CustomerPage customerPage;
	OffersAndLeadPage offersAndLeadPage;
	TestUtil testutil;
	CommonMethods commonmethods;
	
	@Test
	
	public void tocreateNewOfferOnExistingCustomer() throws Exception {
		// Login to admin page
				loginpage.Login("axisadmin", "acid_qa");

				log.info("Logged in to  Home Page");

				// Select Administrator Role
				homepage.selectrole("Administrator");
				Thread.sleep(2000);
				
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
				
				// logout
				loginpage.Logout();
		
	}
}
