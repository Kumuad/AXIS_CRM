package testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonutilities.CommonMethods;
import commonutilities.CustomListener;
import commonutilities.TestUtil;
import pages.HomePage;
import pages.LeadsPage;
import pages.LoginPage;
import pages.RetailAppointmentPage;
import testbase.TestBase;
@Listeners(CustomListener.class)
public class TC05_ToverifyLeadCreationInvalidDataTest extends TestBase{
	// Constructor
		public TC05_ToverifyLeadCreationInvalidDataTest() {
			super();
		}

		
		
		LoginPage loginpage;
		HomePage homepage;
		LeadsPage leadspage;
		RetailAppointmentPage retailAppointmentPage;
		TestUtil testutil;
		CommonMethods commonmethods;

		

	
		
		
		@Test
		public void toverifyInvalidDataLeadCreation() throws Exception {
			

			loginpage = new LoginPage(driver);
			homepage = new HomePage(driver);
			leadspage=new LeadsPage(driver);
			retailAppointmentPage = new RetailAppointmentPage(driver);
			testutil = new TestUtil();
			commonmethods=new CommonMethods();
			
			// Login to admin page
			loginpage.Login("axisadmin", "acid_qa");

			// Select Administrator Role
			homepage.selectrole("CSO");
			Thread.sleep(2000);

			// Move to sales Tab
			homepage.moveToSalesTab();
			Thread.sleep(2000);
			
			
			//click On Leads Link
			homepage.clickOnLeadsLink();
			Thread.sleep(2000);
			// click on New Button
			leadspage.clickOnNewButton();
			Thread.sleep(2000);
			
			//create New Lead
			leadspage.createLeadInvalidData();
			Thread.sleep(2000);
			leadspage.verifyErrorMessages();
			
		}

		

		
	

}
