package testscripts;

import org.testng.Assert;
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
import pages.RetailAppointmentPage;
import testbase.TestBase;
@Listeners(CustomListener.class)
public class TC03_ActivityCreatedOnExistingCustomerTest extends TestBase {
	// Constructor
		public TC03_ActivityCreatedOnExistingCustomerTest() {
			super();
		}

		LoginPage loginpage;
		HomePage homepage;
		TestUtil testutil;
		CustomerPage customerPage;
		RetailAppointmentPage retailAppointmentPage;
		CommonMethods commonmethods;

	
			
		
		
		
		
		@Test
		public void activitycreatedonexistingcustomer() throws Exception {
			
			loginpage = new LoginPage();
			homepage = new HomePage();
			customerPage = new CustomerPage();
			retailAppointmentPage = new RetailAppointmentPage();
			testutil = new TestUtil();

			// Login to admin page
			loginpage.Login("axisadmin", "acid_qa");

			// Select Administrator Role
			homepage.selectrole("Administrator");
			Thread.sleep(2000);

			// Move to sales Tab
			homepage.moveToSalesTab();
			Thread.sleep(2000);

			// click On customer Link in Sales Tab
			homepage.clickOnCustomerLink();

			// click on New Button
			customerPage.clickOnNewButton();

			// CLick On Customer Link under New Button
			customerPage.clickOnRetailCustomerLink();
			Thread.sleep(2000);

			// create customer/ account
			customerPage.createaccount();

			Thread.sleep(2000);
			// Select Administrator Role
			homepage.selectrole("CSO");
			
			Thread.sleep(2000);
			// Click On Recent Items
			homepage.clickOnRecentItems();
			Thread.sleep(2000);

			// click on Toggle Button on Details Page
			customerPage.clickToggleButton();
			Thread.sleep(2000);
			
			//click On Activities and Interaction Tab on customer details Page
			customerPage.clickactivitiesandinteractionTab();
			
			Thread.sleep(2000);
			//click On New Activity Tab
			customerPage.clickOnNewActivityTab();
			Thread.sleep(2000);
			
			//create  Activity/Appointment on existing Customer
			retailAppointmentPage.createappointment();
			Thread.sleep(2000);
			
			
			//Get Text Exp appointment/activity created on Customer Page
			String expappointment=customerPage.getSubjectText();
			
			System.out.println("Exp appointment on Customer page: "+expappointment);
			
			//Get Text actual appointmentonRetail Appointment Page
			String actualappointment=retailAppointmentPage.getactualSubject();
			
			System.out.println("Exp appointment on Retail Appointment page: "+expappointment);
			//Verify Actaul and expected Appointment 
			Assert.assertEquals(expappointment, actualappointment, "Appointment created mismatched");
			
			//logout
			loginpage.Logout();
			
			
			
		}
		
		
		
		
		
		
		
		
		

}
