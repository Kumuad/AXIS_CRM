package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import commonutilities.CommonMethods;
import commonutilities.CustomListener;
import commonutilities.TestUtil;
import pages.HomePage;
import pages.LeadSearchPage;
import pages.LeadsPage;
import pages.LoginPage;

import pages.TaskPage;
import testbase.TestBase;

@Listeners(CustomListener.class)
public class TC15_LeadSearchTest extends TestBase {
	

	LoginPage loginpage;
	HomePage homepage;
	LeadsPage leadspage;
	LeadSearchPage leadsearchPage;
	TaskPage taskpage;
	TestUtil testutil;
	CommonMethods commonmethods;

	@Test
	public void ToverifyLeadSearch() throws Exception {
		
		if (!(CommonMethods.isTestRunnable("TC15_LeadSearchTest"))) {
			  
			  throw new SkipException("Skipping the test " + "To verify Lead Search".toUpperCase() + "as the Run mode is NO"); 
			  
			  }
		
		String leadcsearch_sheetname = "leadcreation";
		//loginpage = new LoginPage(driver);
		//homepage = new HomePage(driver);
		//leadspage = new LeadsPage(driver);
		//leadsearchPage = new LeadSearchPage(driver);
		testutil = new TestUtil();
		commonmethods = new CommonMethods();
		
		
		initialization();
		log.info("************Login to Home Page*************************");
		
		loginpage = new LoginPage(driver);
		
		// Login to admin page
		loginpage.Login("axisadmin", "acid_qa");

		
		homepage = new HomePage(driver);
		
		// Select Administrator Role
		homepage.selectrole("CSO");
		Thread.sleep(2000);

		// move to Quick Link
		homepage.moveToQuickLink();

		Thread.sleep(2000);

		// click On Lead Search tab Under Quick Link
		//homepage.clickOnLeadSearchTab();
		Thread.sleep(2000);
		
		leadsearchPage = new LeadSearchPage(driver);
		
		// Verify Lead Search By Lead ID
		String actualleadid = leadsearchPage.verifyLeadSearchByLeadID(leadcsearch_sheetname);
		System.out.println("Actual Lead ID Entered on Lead Search Page: " + actualleadid);
		System.out.println();
		CustomListener.testReport.get().log(Status.INFO,
				"Actual Lead ID Entered on Lead Search Page:  : " + actualleadid );
		leadspage = new LeadsPage(driver);
		
		String expleadidnum = leadspage.leadIdNumber();
		System.out.println("Expected Lead ID Fetched on Lead  Page: " + expleadidnum);

		Assert.assertEquals(actualleadid, expleadidnum, "Lead ID mismatched");

		driver.navigate().back();
		Thread.sleep(2000);
		
		// Verify Lead Search By Lead Mobile Number
		String actualmobilenum = leadsearchPage.verifyLeadSearchByMobilePhone(leadcsearch_sheetname);
		System.out.println("Actual Mobile Number Entered on Lead Search Page: " + actualmobilenum);
		System.out.println();

		String expmobilenum = leadspage.verifymobileNumberOnLeadPage();
		System.out.println("Expected Mobile Number Entered on Lead Search Page: " + expmobilenum);

		Assert.assertEquals(actualmobilenum, expmobilenum, "Mobile Number mismatched");
		driver.navigate().back();

		Thread.sleep(2000);

		// Verify Lead Search By Lead PAN Number
		leadsearchPage.verifyLeadSearchByPANNumber(leadcsearch_sheetname);

		driver.navigate().back();

		Thread.sleep(2000);
		
		//logout
		loginpage.Logout();


	}

}
