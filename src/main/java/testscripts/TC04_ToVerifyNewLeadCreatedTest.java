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
import pages.LeadsPage;
import pages.LoginPage;
import pages.RetailAppointmentPage;
import pages.TaskPage;
import testbase.TestBase;

@Listeners(CustomListener.class)
public class TC04_ToVerifyNewLeadCreatedTest extends TestBase {
	// Constructor
	public TC04_ToVerifyNewLeadCreatedTest() {
		super();

	}

	LoginPage loginpage;
	HomePage homepage;
	LeadsPage leadspage;
	RetailAppointmentPage retailAppointmentPage;
	TaskPage taskpage;
	TestUtil testutil;
	CommonMethods commonmethods;

	@Test
	public void toverifyLeadIsCreated() throws Exception {

		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		leadspage = new LeadsPage(driver);
		retailAppointmentPage = new RetailAppointmentPage(driver);
		taskpage = new TaskPage(driver);
		testutil = new TestUtil();
		commonmethods = new CommonMethods();
		log.info("************Login to Home Page*************************");
		// Login to admin page
		loginpage.Login("axisadmin", "acid_qa");

		// Select Administrator Role
		homepage.selectrole("CSO");
		Thread.sleep(2000);

		// Move to sales Tab
		homepage.moveToSalesTab();
		Thread.sleep(2000);

		// click On Leads Link
		homepage.clickOnLeadsLink();
		Thread.sleep(2000);
		// click on New Button
		leadspage.clickOnNewButton();
		Thread.sleep(2000);
		
		log.info("************Creation of Lead*************************");
		// create New Lead
		leadspage.createLead();

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
		retailAppointmentPage.createappointment();
		Thread.sleep(2000);
		
		//click On New Task Link
		leadspage.clickOnNewTaskLink();
		
		
		//Create Task On Lead
		log.info("************Creation of Task On Lead*************************");
		taskpage.createTaskOnLead();
		
		//click On attachements Tab on Leads Details Page
		leadspage.clickOnAttachementstab();
		 Thread.sleep(2000);
		 
		 //click On New Attachements Link
		 leadspage.clickOnNewAttachementsLink();
		 Thread.sleep(3000);
		 
		 log.info("************verify Document is getting attached in Attachement Tab*************************");
		leadspage. verifyDocumentsAttachedOnDetailsPage();
		
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
