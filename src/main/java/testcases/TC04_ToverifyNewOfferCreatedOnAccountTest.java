package testcases;

import org.testng.SkipException;
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
public class TC04_ToverifyNewOfferCreatedOnAccountTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	CustomerPage customerPage;
	OffersAndLeadPage offersAndLeadPage;
	TestUtil testutil;
	CommonMethods commonmethods;

	@Test

	public void ToverifyNewOfferCreatedOnAccount() throws Exception {

		if (!(CommonMethods.isTestRunnable("TC04_ToverifyNewOfferCreatedOnAccountTest"))) {

			throw new SkipException("Skipping the test " + "To verify New Offer Created On Account".toUpperCase()
					+ "as the Run mode is NO");

		}

		// Excel sheet path
		String sheetname = "accountOffer";

		// loginpage = new LoginPage(driver);
		// homepage = new HomePage(driver);
		// customerPage = new CustomerPage(driver);
		// offersAndLeadPage = new OffersAndLeadPage(driver);
		testutil = new TestUtil();
		commonmethods = new CommonMethods();
		initialization();

		loginpage = new LoginPage(driver);
		
		// Login to admin page
		loginpage.Login("axisadmin", "acid_qa");

		log.info("Logged in to  Home Page");
		
		homepage = new HomePage(driver);
		
		// Select Administrator Role
		homepage.selectrole("Administrator");
		Thread.sleep(2000);

		// Click On Recent Items
		homepage.clickOnRecentItems();
		Thread.sleep(2000);
		
		customerPage = new CustomerPage(driver);
		
		// click on Toggle Button on Details Page
		customerPage.clickToggleButton();
		Thread.sleep(2000);

		// click On Offers And Lead tab
		customerPage.clickoffersandLeadTab();

		Thread.sleep(5000);
		log.info("************Creation of Offer On Existing Customer*************************");
		
		offersAndLeadPage = new OffersAndLeadPage(driver);
		
		// Create New offer On Existing Customer
		offersAndLeadPage.createNewOffer(sheetname);
		Thread.sleep(2000);

		// logout
		loginpage.Logout();

	}
}
