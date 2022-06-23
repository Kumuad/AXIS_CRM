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
public class TC14_ToverifyTaskCreatedOnLeadTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	LeadsPage leadspage;
	RetailAppointmentPage retailAppointmentPage;
	TaskPage taskpage;
	TestUtil testutil;
	CommonMethods commonmethods;

	@Test
	public void ToverifyTaskCreatedOnLead() throws Exception {
		
		if (!(CommonMethods.isTestRunnable("TC14_ToverifyTaskCreatedOnLeadTest"))) {
			  
			  throw new SkipException("Skipping the test " + "To verify Task Created On Lead".toUpperCase() + "as the Run mode is NO"); 
			  
			  }
		//Excel sheet path
		String task_sheetname ="taskcreation";

		//loginpage = new LoginPage(driver);
		//homepage = new HomePage(driver);
		//leadspage = new LeadsPage(driver);
		//taskpage = new TaskPage(driver);
		testutil = new TestUtil();
		commonmethods = new CommonMethods();
		
		
		
		initialization();
		loginpage = new LoginPage(driver);
		log.info("************Login to Home Page*************************");
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

		// click On New Task Link
		leadspage.clickOnNewTaskLink();

		// Create Task On Lead
		log.info("************Creation of Task On Lead*************************");
		taskpage = new TaskPage(driver);
		taskpage.createTaskOnLead(task_sheetname);
		
		//logout
		loginpage.Logout();
	}
}
