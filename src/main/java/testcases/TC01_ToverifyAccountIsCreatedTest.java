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
public class TC01_ToverifyAccountIsCreatedTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	CustomerPage customerPage;
	OffersAndLeadPage offersAndLeadPage;
	TestUtil testutil;
	CommonMethods commonmethods;

	@Test

	public void ToverifyAccountIsCreated() throws Exception {

		if (!(CommonMethods.isTestRunnable("TC01_ToverifyAccountIsCreatedTest"))) {

			throw new SkipException(
					"Skipping the test " + "To verify Account Is Created".toUpperCase() + "as the Run mode is NO");

		}

		// Excel sheet path
		String accountcreation_sheetname = "accountcreation";

		// loginpage = new LoginPage(driver);
		// homepage = new HomePage(driver);
		// customerPage = new CustomerPage(driver);
		testutil = new TestUtil();
		commonmethods = new CommonMethods();

		initialization();
		// Login to admin page
		loginpage = new LoginPage(driver);
		loginpage.Login("axisadmin", "acid_qa");

		log.info("Logged in to  Home Page");

		homepage = new HomePage(driver);

		// Select Administrator Role
		homepage.selectrole("Administrator");
		Thread.sleep(2000);

		// Move to sales Tab
		homepage.moveToSalesTab();
		Thread.sleep(2000);

		// click On customer Link in Sales Tab
		homepage.clickOnCustomerLink();

		customerPage = new CustomerPage(driver);

		// click on New Button
		customerPage.clickOnNewButton();

		// CLick On Customer Link under New Button
		customerPage.clickOnRetailCustomerLink();
		// TestUtil.takeScreenShot("Account Creation");
		Thread.sleep(2000);

		log.info("************Account/Customer Creation Started*************************");

		// create customer/ account
		customerPage.createaccount(accountcreation_sheetname);
		Thread.sleep(2000);

		// logout
		loginpage.Logout();
	}
}
