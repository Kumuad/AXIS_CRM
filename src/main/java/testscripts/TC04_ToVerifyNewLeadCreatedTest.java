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
	TestUtil testutil;
	CommonMethods commonmethods;

	@Test
	public void toverifyLeadIsCreated() throws Exception {

		loginpage = new LoginPage();
		homepage = new HomePage();
		leadspage = new LeadsPage();
		retailAppointmentPage = new RetailAppointmentPage();
		testutil = new TestUtil();
		commonmethods = new CommonMethods();

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
		// create New Lead
		leadspage.createLead();

		Thread.sleep(2000);
		leadspage.clickToggleButton();

		Thread.sleep(2000);
		// leadspage.clickOnAttachementstab();
		// Thread.sleep(2000);
		// leadspage.clickOnNewAttachementsLink();

		// click On Activities Tab
		leadspage.clickOnActivitiestab();
		Thread.sleep(2000);

		// click On New Activity
		leadspage.clickOnNewActivityLink();

		Thread.sleep(2000);
		// create Activity/Appointment on existing Lead
		retailAppointmentPage.createappointment();
		Thread.sleep(2000);
		
		//logout
		loginpage.Logout();

	}

	/*
	 * @AfterMethod public void teardown() { driver.quit(); }
	 */

}
