package testcases;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonutilities.CommonMethods;
import commonutilities.CustomListener;
import commonutilities.TestUtil;
import pages.HomePage;
import pages.LoginPage;
import pages.RetailAppointmentPage;
import testbase.TestBase;
@Listeners(CustomListener.class)
public class TC08_ToverifyCreatedActivityClosedTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	CommonMethods commonmethods;
	RetailAppointmentPage retailAppointmentPage;
	
	
	@Test
	public void TtoverifyCreatedActivityClosed() throws Exception {
		if (!(CommonMethods.isTestRunnable("TC08_ToverifyCreatedActivityClosedTest"))) {
			  
			  throw new SkipException("Skipping the test " + "To verify Created Activity Closed".toUpperCase() + "as the Run mode is NO"); 
			  
			  }
		
		
		//Excel sheet path
		String sheetname ="appointment";
		
		//loginpage = new LoginPage(driver);
		//homepage = new HomePage(driver);
		//retailAppointmentPage = new RetailAppointmentPage(driver);
		testutil = new TestUtil();
		commonmethods = new CommonMethods();

		// *****************To create independent Appointment/Activity***********************
		initialization();
		
		loginpage = new LoginPage(driver);
		Thread.sleep(1000);
		// Login to admin page
		loginpage.Login("axisadmin", "acid_qa");

		
		homepage = new HomePage(driver);
		
		// Select Administrator Role
		homepage.selectrole("CSO");
		Thread.sleep(2000);

		// Move to Home Tab
		homepage.moveToHomeTab();
		
		

		Thread.sleep(10000);
		// CLick On Activities Link
		homepage.clickOnActivitiesLink();

		Thread.sleep(4000);
		// click On New Button
		homepage.clickOnNewButton();

		Thread.sleep(2000);
		// click On Retail Appointment link
		homepage.clickOnRetailAppointmentLink();
		
		// TestUtil.takeScreenShot("Appointment Creation");
		
		retailAppointmentPage = new RetailAppointmentPage(driver);
		// create independent Activity/Appointment
		retailAppointmentPage.createappointment(sheetname);
		
	

		Thread.sleep(2000);

		// click on Arrow button Under Views
		retailAppointmentPage.clickOnArrowButton();
		Thread.sleep(2000);
		
		// Mouse Hover On Appointment Close Edit link in Views
		retailAppointmentPage.movehoverOnCLoseEditLink();
		Thread.sleep(2000);

		//click On CLose view Link
		retailAppointmentPage.clickOnCLoseViewLink();
		
		//close the appointment
		
		retailAppointmentPage.closeAppointment();
		Thread.sleep(2000);
		
		// click on Arrow button Under Views
		//retailAppointmentPage.clickOnArrowButton();
		Thread.sleep(5000);
				
		// logout
		loginpage.Logout();
		
		
	}

}
