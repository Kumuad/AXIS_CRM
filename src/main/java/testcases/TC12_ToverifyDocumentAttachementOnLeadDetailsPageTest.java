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
public class TC12_ToverifyDocumentAttachementOnLeadDetailsPageTest extends TestBase{
	
	
	LoginPage loginpage;
	HomePage homepage;
	LeadsPage leadspage;
	RetailAppointmentPage retailAppointmentPage;
	TaskPage taskpage;
	TestUtil testutil;
	CommonMethods commonmethods;

	@Test
	public void ToverifyDocumentAttachementOnLeadDetailsPage() throws Exception {
		
		if (!(CommonMethods.isTestRunnable("TC12_ToverifyDocumentAttachementOnLeadDetailsPageTest"))) {
			  
			  throw new SkipException("Skipping the test " + "To verify Document Attachement On Lead Details Page".toUpperCase() + "as the Run mode is NO"); 
			  
			  }
			 

		//loginpage = new LoginPage(driver);
		//homepage = new HomePage(driver);
		//leadspage = new LeadsPage(driver);
		//retailAppointmentPage = new RetailAppointmentPage(driver);
		//taskpage = new TaskPage(driver);
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
		
		
		// click On attachements Tab on Leads Details Page
		leadspage.clickOnAttachementstab();
		Thread.sleep(2000);

		// click On New Attachements Link
		leadspage.clickOnNewAttachementsLink();
		Thread.sleep(3000);

		log.info("************verify Document is getting attached in Attachement Tab*************");
		leadspage.verifyDocumentsAttachedOnDetailsPage();
		
		//logout
		loginpage.Logout();

	}
}
