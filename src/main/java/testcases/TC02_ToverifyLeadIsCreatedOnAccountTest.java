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
public class TC02_ToverifyLeadIsCreatedOnAccountTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	CustomerPage customerPage;
	OffersAndLeadPage offersAndLeadPage;
	TestUtil testutil;
	CommonMethods commonmethods;

	@Test

	public void ToverifyLeadIsCreatedOnAccount() throws Exception {

		if (!(CommonMethods.isTestRunnable("TC02_ToverifyLeadIsCreatedOnAccountTest"))) {

			throw new SkipException(
					"Skipping the test " + "ToverifyLeadIsCreatedOnAccount".toUpperCase() + "as the Run mode is NO");
		}

		initialization();
		// Excel sheet path
		String sheetname_accountlead = "accountLead";

		// loginpage = new LoginPage(driver);
		// homepage = new HomePage(driver);
		// customerPage = new CustomerPage(driver);
		// offersAndLeadPage = new OffersAndLeadPage(driver);
		testutil = new TestUtil();
		commonmethods = new CommonMethods();

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

		CommonMethods.scrollDown(400);

		log.info("************Creation of New Lead On Existing Customer/Account*************************");

		offersAndLeadPage = new OffersAndLeadPage(driver);
		// Create Lead on Existing Customer
		offersAndLeadPage.createNewLead(sheetname_accountlead);

		Thread.sleep(5000);

		CommonMethods.scrollDown(400);

		// logout
		loginpage.Logout();

	}
}
