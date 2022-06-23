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
public class TC05_ToverifyTabsVisibleOnAccountTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	CustomerPage customerPage;
	OffersAndLeadPage offersAndLeadPage;
	TestUtil testutil;
	CommonMethods commonmethods;

	@Test

	public void ToverifyTabsVisibleOnAccount() throws Exception {

		if (!(CommonMethods.isTestRunnable("TC05_ToverifyTabsVisibleOnAccountTest"))) {

			throw new SkipException(
					"Skipping the test " + "To verify Tabs Visible On Account".toUpperCase() + "as the Run mode is NO");

		}

		// loginpage = new LoginPage(driver);
		// homepage = new HomePage(driver);
		// customerPage = new CustomerPage(driver);
		testutil = new TestUtil();
		commonmethods = new CommonMethods();

		initialization();

		loginpage = new LoginPage(driver);

		// Login to admin page
		loginpage.Login("axisadmin", "acid_qa");

		log.info("Logged in to  Home Page");
		
		homepage = new HomePage(driver);
		
		// Select Administrator Role
		homepage.selectrole("CSO");
		Thread.sleep(2000);

		Thread.sleep(2000);

		// Click On Recent Items
		homepage.clickOnRecentItems();
		Thread.sleep(2000);
		
		customerPage = new CustomerPage(driver);
		
		// click on Toggle Button on Details Page
		customerPage.clickToggleButton();
		Thread.sleep(2000);

		// verify Tab visible on Customer
		customerPage.verifyTabsVisibleOnCustomer();

		// logout
		loginpage.Logout();

	}

}
