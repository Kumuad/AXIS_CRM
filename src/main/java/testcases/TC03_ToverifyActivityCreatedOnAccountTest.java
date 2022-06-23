package testcases;

import org.testng.Assert;
import org.testng.SkipException;
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
public class TC03_ToverifyActivityCreatedOnAccountTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	CustomerPage customerPage;
	RetailAppointmentPage retailAppointmentPage;
	CommonMethods commonmethods;

	@Test
	public void ToverifyActivityCreatedOnAccount() throws Exception {

		if (!(CommonMethods.isTestRunnable("TC03_ToverifyActivityCreatedOnAccountTest"))) {

			throw new SkipException(
					"Skipping the test " + "ToverifyActivityCreatedOnAccount".toUpperCase() + "as the Run mode is NO");
		}

		// Excel sheet path
		String sheetname = "appointment";

		// loginpage = new LoginPage(driver);
		/// homepage = new HomePage(driver);
		// customerPage = new CustomerPage(driver);
		// retailAppointmentPage = new RetailAppointmentPage(driver);
		testutil = new TestUtil();
		commonmethods = new CommonMethods();
		
		initialization();

		loginpage = new LoginPage(driver);
		// Login to admin page
		loginpage.Login("axisadmin", "acid_qa");

		// Select Administrator Role
		// homepage.selectrole("Administrator");
		// Thread.sleep(2000);

		homepage = new HomePage(driver);

		Thread.sleep(2000);
		// Select Administrator Role
		homepage.selectrole("CSO");

		Thread.sleep(2000);
		// Click On Recent Items
		homepage.clickOnRecentItems();
		Thread.sleep(2000);

		customerPage = new CustomerPage(driver);
		// click on Toggle Button on Details Page
		customerPage.clickToggleButton();
		Thread.sleep(2000);

		// click On Activities and Interaction Tab on customer details Page
		customerPage.clickactivitiesandinteractionTab();

		Thread.sleep(2000);
		// click On New Activity Tab
		customerPage.clickOnNewActivityTab();
		Thread.sleep(2000);

		retailAppointmentPage = new RetailAppointmentPage(driver);

		// create Activity/Appointment on existing Customer
		retailAppointmentPage.createappointment(sheetname);
		Thread.sleep(2000);

		// Get Text Exp appointment/activity created on Customer Page
		String expappointment = customerPage.getSubjectText();

		System.out.println("Exp appointment on Customer page: " + expappointment);

		// Get Text actual appointmentonRetail Appointment Page
		String actualappointment = retailAppointmentPage.getactualSubject();

		System.out.println("Exp appointment on Retail Appointment page: " + expappointment);
		// Verify Actaul and expected Appointment
		Assert.assertEquals(expappointment, actualappointment, "Appointment created mismatched");

		// logout
		loginpage.Logout();

	}

}
