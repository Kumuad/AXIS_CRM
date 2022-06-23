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
public class TC11_ToverifyAppointmentCreatedOnLeadTest extends TestBase {
	
	
	LoginPage loginpage;
	HomePage homepage;
	LeadsPage leadspage;
	RetailAppointmentPage retailAppointmentPage;
	TaskPage taskpage;
	TestUtil testutil;
	CommonMethods commonmethods;

	@Test
	public void ToverifyAppointmentCreatedOnLead() throws Exception {

		  if (!(CommonMethods.isTestRunnable("TC11_ToverifyAppointmentCreatedOnLeadTest"))) {
		  
		  throw new SkipException("Skipping the test " + "To verify Appointment Created On Lead".toUpperCase() + "as the Run mode is NO"); 
		  
		  }
		 
		
		
		
		//Excel sheet path
		String sheetname ="appointment";
		
		
		//loginpage = new LoginPage(driver);
		//homepage = new HomePage(driver);
		//leadspage = new LeadsPage(driver);
		//retailAppointmentPage = new RetailAppointmentPage(driver);
		testutil = new TestUtil();
		commonmethods = new CommonMethods();

		log.info("************Login to Home Page*************************");
		
		initialization();
		
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

		Thread.sleep(2000);

		// click On Activities Tab
		leadspage.clickOnActivitiestab();
		Thread.sleep(2000);

		// click On New Activity
		leadspage.clickOnNewActivityLink();

		Thread.sleep(2000);
		
		// create Activity/Appointment on existing Lead
		log.info("************Creation of Appointment On Lead*************************");
		
		retailAppointmentPage = new RetailAppointmentPage(driver);
		retailAppointmentPage.createappointment(sheetname);
		Thread.sleep(2000);
		
		//logout
		loginpage.Logout();

	}
}