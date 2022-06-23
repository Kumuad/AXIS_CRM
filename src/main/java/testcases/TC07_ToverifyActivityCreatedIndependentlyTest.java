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
public class TC07_ToverifyActivityCreatedIndependentlyTest extends TestBase {
	
	

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	CommonMethods commonmethods;
	RetailAppointmentPage retailAppointmentPage;

	@Test
	public void ToverifyActivityCreatedIndependently() throws Exception {
		if (!(CommonMethods.isTestRunnable("TC07_ToverifyActivityCreatedIndependentlyTest"))) {
			  
			  throw new SkipException("Skipping the test " + "To verify Activity Created Independently".toUpperCase() + "as the Run mode is NO"); 
			  
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
		Thread.sleep(1000);
		
		loginpage = new LoginPage(driver);
		
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
		
		retailAppointmentPage = new RetailAppointmentPage(driver);

		// create independent Activity/Appointment
		retailAppointmentPage.createappointment(sheetname);

		Thread.sleep(2000);

		// logout
		loginpage.Logout();

	}

}
