package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonutilities.CommonMethods;
import commonutilities.CustomListener;
import commonutilities.TestUtil;
import pages.CustomerPage;
import pages.CustomerSearchPage;
import pages.HomePage;
import pages.LeadSearchPage;
import pages.LeadsPage;
import pages.LoginPage;
import pages.OffersAndLeadPage;
import pages.TaskPage;
import testbase.TestBase;

@Listeners(CustomListener.class)
public class TC06_CustomerSearchTest extends TestBase {
	// Constructor
	public TC06_CustomerSearchTest() {
		super();

	}

	LoginPage loginpage;
	HomePage homepage;
	CustomerPage customerPage;
	OffersAndLeadPage offersAndLeadPage;
	CustomerSearchPage customerSearchPage;
	TaskPage taskpage;
	TestUtil testutil;
	CommonMethods commonmethods;

	@Test

	public void TOverifyCustomerSearch() throws Exception {

		if (!(CommonMethods.isTestRunnable("TC06_CustomerSearchTest"))) {

			throw new SkipException(
					"Skipping the test " + "To verify Customer Search".toUpperCase() + "as the Run mode is NO");

		}

		// Excel sheet Name
		String customer_sheetname = "accountcreation";

		// loginpage = new LoginPage(driver);
		// homepage = new HomePage(driver);
		// customerPage = new CustomerPage(driver);
		// offersAndLeadPage = new OffersAndLeadPage(driver);
		// customerSearchPage=new CustomerSearchPage(driver);
		testutil = new TestUtil();
		commonmethods = new CommonMethods();

		initialization();

		loginpage = new LoginPage(driver);

		log.info("************Login to Home Page*************************");
		// Login to admin page
		loginpage.Login("axisadmin", "acid_qa");

		homepage = new HomePage(driver);
		
		// Select Administrator Role
		homepage.selectrole("CSO");
		Thread.sleep(2000);

		// move to Quick Link
		homepage.moveToQuickLink();
		Thread.sleep(2000);
		
		// click On Customer Search Tab under quick Links
		homepage.clickOnCustomerSearchTab();

		customerSearchPage = new CustomerSearchPage(driver);
		
		// verify Customer Search By Customer ID
		String actualcustomerid = customerSearchPage.verifyCustomerSearchByCustomerID(customer_sheetname);
		System.out.println("Actual Customer ID Entered on Customer Search Page: " + actualcustomerid);
		System.out.println();

		customerPage = new CustomerPage(driver);

		// get Customer ID after Customer Search on Details Page
		String expcustomerid = customerPage.getcustomerID();
		System.out.println("Expected Customer ID Fetched on Customer Search Page: " + expcustomerid);

		Assert.assertEquals(actualcustomerid, expcustomerid, "Customer ID mismatched");
		driver.navigate().back();
		Thread.sleep(3000);

		// verify Customer Search By Mobile Phone
		String actualmobile = customerSearchPage.verifyCustomerSearchByMobilePhone(customer_sheetname);
		System.out.println("Actual Mobile Phone Entered on Customer Search Page: " + actualmobile);
		System.out.println();

		// get Mobile Phone after Customer Search On detail Page
		String expmobile = customerPage.getMobilePhone();
		System.out.println("Expected Mobile Phone Fetched on Customer Search Page: " + expmobile);

		Assert.assertEquals(actualmobile, expmobile, "Mobile Phone mismatched");

		driver.navigate().back();
		Thread.sleep(3000);

		// verify Customer Search By Email ID
		String actualemailid = customerSearchPage.verifyCustomerSearchByEmail(customer_sheetname);
		System.out.println("Actual Email ID Entered on Customer Search Page: " + actualemailid);
		System.out.println();

		// get Email Id after Customer Search On detail Page
		String expemailid = customerPage.getEmailId();
		System.out.println("Expected Email ID Fetched on Customer Search Page: " + expemailid);

		Assert.assertEquals(actualemailid, expemailid, "Email ID mismatched");
		driver.navigate().back();
		Thread.sleep(3000);

		// verify Customer Search By PAN Number
		String actualpannumber = customerSearchPage.verifyCustomerSearchByPANNumber(customer_sheetname);
		System.out.println("Actual PAN Number Entered on Customer Search Page: " + actualpannumber);
		System.out.println();

		// get PAN Number after Customer Search On detail Page
		String exppannumber = customerPage.getPANNumber();
		System.out.println("Expected PAN Number Fetched on Customer Search Page: " + exppannumber);

		Assert.assertEquals(actualpannumber, exppannumber, "PAN Number mismatched");
		driver.navigate().back();
		Thread.sleep(3000);
	}

}
