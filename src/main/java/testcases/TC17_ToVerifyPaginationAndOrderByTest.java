package testcases;

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
public class TC17_ToVerifyPaginationAndOrderByTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	CommonMethods commonmethods;
	RetailAppointmentPage retailAppointmentPage;

	@Test
	public void ToVerifyPaginationAndOrderByTest() throws Exception {

		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		retailAppointmentPage = new RetailAppointmentPage(driver);
		testutil = new TestUtil();
		commonmethods = new CommonMethods();
		initialization();
		// Login to admin page
		loginpage.Login("axisadmin", "acid_qa");

		// Select Administrator Role
		homepage.selectrole("CSO");
		Thread.sleep(2000);

		// Move to Home Tab
		homepage.moveToHomeTab();

		Thread.sleep(3000);
		// CLick On Activities Link
		homepage.clickOnActivitiesLink();

		// click on Arrow button Under Views
		retailAppointmentPage.clickOnArrowButton();
		Thread.sleep(10000);

		//retailAppointmentPage.verifyPaginationDropDownValues();
		Thread.sleep(3000);
		retailAppointmentPage.verifypaginationGoToTextBox();

	}
}