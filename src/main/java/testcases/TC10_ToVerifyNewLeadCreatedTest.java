package testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonutilities.CommonMethods;
import commonutilities.CustomListener;
import commonutilities.TestUtil;
import pages.CustomerPage;
import pages.HomePage;
import pages.LeadsPage;
import pages.LoginPage;
import pages.RetailAppointmentPage;
import pages.TaskPage;
import testbase.TestBase;

@Listeners(CustomListener.class)
public class TC10_ToVerifyNewLeadCreatedTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	LeadsPage leadspage;
	RetailAppointmentPage retailAppointmentPage;
	TaskPage taskpage;
	TestUtil testutil;
	CommonMethods commonmethods;

	@Test
	public void ToverifyNewLeadIsCreated() throws Exception {
		

		  if (!(CommonMethods.isTestRunnable("TC10_ToVerifyNewLeadCreatedTest"))) {
		  
		  throw new SkipException("Skipping the test " + "To verify New Lead Created".toUpperCase() + "as the Run mode is NO"); 
		  
		  }
		  
		//Excel sheet path
		  String leadcreation_sheetname = "leadcreation";

		//loginpage = new LoginPage(driver);
		//homepage = new HomePage(driver);
		//leadspage = new LeadsPage(driver);
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

		// Move to sales Tab
		homepage.moveToSalesTab();
		Thread.sleep(2000);

		// click On Leads Link
		homepage.clickOnLeadsLink();
		
		leadspage = new LeadsPage(driver);
		
		Thread.sleep(2000);
		// click on New Button
		leadspage.clickOnNewButton();
		Thread.sleep(2000);
		
		log.info("************Creation of Lead*************************");
		// create New Lead
		leadspage.createLead(leadcreation_sheetname);

		Thread.sleep(2000);
		
		
		//logout
		loginpage.Logout();

	}

	

}
