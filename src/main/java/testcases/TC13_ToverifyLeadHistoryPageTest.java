package testcases;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonutilities.CommonMethods;
import commonutilities.CustomListener;
import commonutilities.TestUtil;
import pages.HomePage;
import pages.LeadsPage;
import pages.LoginPage;
import pages.RetailAppointmentPage;
import pages.TaskPage;
import testbase.TestBase;
@Listeners(CustomListener.class)
public class TC13_ToverifyLeadHistoryPageTest extends TestBase{
	

	LoginPage loginpage;
	HomePage homepage;
	LeadsPage leadspage;
	RetailAppointmentPage retailAppointmentPage;
	TaskPage taskpage;
	TestUtil testutil;
	CommonMethods commonmethods;

	@Test
	public void ToverifyLeadHistoryPage() throws Exception {
		
		if (!(CommonMethods.isTestRunnable("TC13_ToverifyLeadHistoryPageTest"))) {
			  
			  throw new SkipException("Skipping the test " + "To verify Lead History Page".toUpperCase() + "as the Run mode is NO"); 
			  
			  }
			 

		//loginpage = new LoginPage(driver);
		//homepage = new HomePage(driver);
		//leadspage = new LeadsPage(driver);
		//retailAppointmentPage = new RetailAppointmentPage(driver);
		//taskpage = new TaskPage(driver);
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
		
		// Click On Recent Items
		homepage.clickOnRecentItems();

		leadspage = new LeadsPage(driver);
		
		Thread.sleep(2000);
		leadspage.clickToggleButton();

		log.info("************verify lead  History Tab Details*************************");
		//click On history Tab
		leadspage.clickOnHistoryTab();
		Thread.sleep(3000);
		
		 //verify Lead History Details Page
		leadspage.verifyLeadHistoryDetails();
		
		
		
		//logout
		loginpage.Logout();

	}

}
