package testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonutilities.CommonMethods;
import commonutilities.CustomListener;
import commonutilities.TestUtil;
import pages.CustomerPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OffersAndLeadPage;
import pages.RetailAppointmentPage;
import testbase.TestBase;

@Listeners(CustomListener.class)
public class TC02_AppointmentCreationTest extends TestBase {

	// Constructor
	public TC02_AppointmentCreationTest() {
		super();
	}

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	CommonMethods commonmethods;
	RetailAppointmentPage retailAppointmentPage;

	// LoginPage loginpage = new LoginPage(driver);
	// HomePage homepage = new HomePage(driver);
	// CustomerPage customerPage = new CustomerPage(driver);
	// OffersAndLeadPage offersAndLeadPage = new OffersAndLeadPage(driver);
	// TestUtil testutil = new TestUtil();
	// CommonMethods commonmethods=new CommonMethods();

	@Test
	public void appointmentcreation() throws Exception {
		/*
		 * loginpage = new LoginPage(); homepage = new HomePage(); retailAppointmentPage
		 * = new RetailAppointmentPage(); testutil = new TestUtil(); commonmethods=new
		 * CommonMethods();
		 */

		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		retailAppointmentPage = new RetailAppointmentPage(driver);
		// CustomerPage customerPage = new CustomerPage(driver);
		// OffersAndLeadPage offersAndLeadPage = new OffersAndLeadPage(driver);
		testutil = new TestUtil();
		commonmethods = new CommonMethods();

		// *****************To create independent Appointment/Activity***********************

		// initialization();
		Thread.sleep(1000);
		// Login to admin page
		loginpage.Login("axisadmin", "acid_qa");

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
		//TestUtil.takeScreenShot("Appointment Creation");
		// create independent Activity/Appointment
		retailAppointmentPage.createappointment();
		
		

		
		  Thread.sleep(2000);
		  
		  // click on Arrow button Under Views
		  retailAppointmentPage.clickOnArrowButton();
		  Thread.sleep(2000);
		  
		  // Mouse Hover On Appointment Close Edit link in Views
		  retailAppointmentPage.movehoverOnCLoseEditLink(); 
		  Thread.sleep(2000);
		  
		  // click on Edit Link under Views
		  retailAppointmentPage.clickOnEditViewLink();
		  Thread.sleep(2000);
		  
		  // Edit Appointment 
		  retailAppointmentPage.editAppointment();
		  Thread.sleep(2000);
		 
		// logout
		loginpage.Logout();

	}

}
