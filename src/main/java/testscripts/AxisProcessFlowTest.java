package testscripts;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonutilities.CustomListener;
import commonutilities.CommonMethods;
import commonutilities.TestUtil;
import pages.CheckerPage;
import pages.DetailsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MakerPage;
import pages.RegistrationPage;
import testbase.TestBase;
@Listeners(CustomListener.class)
public class AxisProcessFlowTest extends TestBase{

	//Constructor
	public AxisProcessFlowTest() {
		super();
	}


	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	RegistrationPage registrationpage;
	MakerPage makerpage;
	CheckerPage checkerpage;
	CommonMethods genericutils;
	DetailsPage detailspage;
	String sheetname="ServiceRequest";
	
	//String sheetname="test";
	String natureofquery;
	String category;
	//Before Method--Initialization ---launch browser
	@BeforeMethod
	public void setUp() throws Exception{
		initialization();
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		registrationpage=new RegistrationPage(driver);
		detailspage=new DetailsPage(driver);
		makerpage=new MakerPage(driver);
		checkerpage=new CheckerPage(driver);
		testutil=new TestUtil();
		//homepage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		//homepage=loginpage.Login(sheetname, sheetname);
		//registrationpage=homepage.clickOnServiceRequest();
	}

	//Process FLow for SR creation
	//
	
	
	
	
	@Test(dataProvider = "getServiceRequestTestData")

	public void processflow(String Product, String NatureofQuery, String Function, String SubFunction,
			String SubSubFunction, String AccountNumber, String Remarks) throws Exception {

		// *******************Login to application with initiator
		// login*******************
		loginpage.Login("cpuoinitiator", "acid_qa");

		// CLick On Service Request Tab
		homepage.clickOnServiceRequest();

		// Create Service Request-SR
		registrationpage.createServiceRequest(Product, NatureofQuery, Function, SubFunction, SubSubFunction,
				AccountNumber, Remarks);

		// registrationpage.uploadKYCdocument();

		// Get SR Number from details page
		String SRNumber = detailspage.getSRNumber();
		System.out.println("SR Number on Registration Page:--" + SRNumber);

		// Get Status code from details Page
		String statuscode = detailspage.getStatuscodeDetailsPage();
		System.out.println("Status Code on Registration Page:--" + statuscode);

		// Verify Actual and Expected status code
		Assert.assertEquals("Registration", statuscode, "Status code mismatch");
		Thread.sleep(3000);

		// Write the SR Number In Excel
		testutil.setCellData(sheetname, 0, 7, "SRNumber");
		testutil.setCellData(sheetname, 1, 7, SRNumber);

		Thread.sleep(3000);

		// logout
		loginpage.Logout();
		// System.out.println("Logout");

		// ***************login to application with maker Login********************

		Thread.sleep(10000);

		loginpage.Login("cpuomaker2", "acid_qa");

		Thread.sleep(3000);

		// select value from views Assigned dropdown
		makerpage.selectAssignedTo(0);

		Thread.sleep(3000);

		// click on views arrow button
		makerpage.clickviewsArrowButton();

		// click on views SR Number Link
		makerpage.clickviewsSRNumbercheckBox();

		// click on SelfAssignMakerCustomButton
		makerpage.clickSelfAssignMakerCustomButton();
		Thread.sleep(3000);

		// click On Ok Button After self Assign
		makerpage.clickOnOkButtonAfterselfAssign();
		Thread.sleep(3000);

		// select value from views Assigned dropdown
		makerpage.selectAssignedTo(1);

		Thread.sleep(2000);
		// click on views arrow button
		makerpage.clickviewsArrowButton();
		Thread.sleep(2000);

		// click on views SR Number Link
		makerpage.clickviewsSRNumberLink();

		Thread.sleep(2000);

		// Get SR Number from details page
		String SRNumberMaker = detailspage.getSRNumber();
		System.out.println("SR Number on Maker Page:--" + SRNumberMaker);

		// Get Status code from details Page
		String statuscodemaker = detailspage.getStatuscodeDetailsPage();
		System.out.println("Status Code on Maker Page:----" + statuscodemaker);

		// Verify Actual and Expected status code
		Assert.assertEquals("Sent For Processing", statuscodemaker, "statuscode mismatch");

		// click on Edit SR
		makerpage.clickOnEditSR();
		Thread.sleep(2000);

		// click On Edit SR link
		makerpage.clickOnEditSRLink();

		// Select Sent for verification status code
		makerpage.selectsentforverificationstatuscode();

		// click on checker Search icon
		makerpage.clickOnCheckersearchicon();

		Thread.sleep(2000);

		// select checker user
		makerpage.selectcheckeruser();
		Thread.sleep(2000);

		// Enter text in remark field
		makerpage.enterremarks();

		// CLick on save and proceed button
		makerpage.clickOnSaveandProceedButton();
		Thread.sleep(3000);

		// logout
		loginpage.Logout();

		// **************Login To Application with Checker Role*************************

		Thread.sleep(10000);
		loginpage.Login("cpuochecker1", "acid_qa");

		//// Select value from Views Assigned to Dropdown
		checkerpage.selectAssignedTo(0);

		// select value from views statuscode dropdown
		checkerpage.selectviewsStatuscodedropdown(1);

		// click on Views Arrow Button
		checkerpage.clickOnViewsArrowButton();
		Thread.sleep(3000);

		// click on views SR Number Link
		checkerpage.clickviewsSRNumberLink();
		Thread.sleep(3000);

		// Get SR Number from details page
		String SRNumberChecker = detailspage.getSRNumber();
		System.out.println("SR Number on Checker Page:--" + SRNumberChecker);

		// Get Status code from details Page
		String statuscodchecker = detailspage.getStatuscodeDetailsPage();
		System.out.println("Status Code on Checker Page:--" + statuscodchecker);

		// Verify Actual and Expected status code
		Assert.assertEquals("Sent For Verification", statuscodchecker, "statuscode mismatch");

		// click On Edit SR
		checkerpage.clickOnEditSR();

		// click On Edit SR Link
		checkerpage.clickOnEditSRLink();

		// click on Closure milestone
		checkerpage.clickOnCLosureMilestone();

		// click On sub status
		checkerpage.clickOnsubstatussearch();
		Thread.sleep(2000);

		// select approved and closed substatus
		checkerpage.selectApprovedandCLosedSubStatus();

		// Enter text in remarks fields
		checkerpage.enterremarks();

		// click on save and proceed button
		checkerpage.clickOnSaveandproceedbutton();
		Thread.sleep(4000);

		// Get SR Number from details page
		String SRNumberclosure = detailspage.getSRNumber();
		System.out.println("SR Number on Checker Page after SR Closure:--" + SRNumberclosure);

		// Get Status code from details Page
		String statuscodeclosure = detailspage.getStatuscodeDetailsPage();
		System.out.println("Status Code on Checker Page after SR Closure:--" + statuscodeclosure);

		// Verify Actual and Expected status code
		Assert.assertEquals("Closed", statuscodeclosure, "statuscode mismatch");

		Thread.sleep(3000);

		// logout
		loginpage.Logout();

	}


	
	

	//DataProvider to create SR
	@DataProvider(name="getServiceRequestTestData")
	public Object[][] getServiceRequestTestData() throws Exception{

		Object data[][]=TestUtil.getTestData(sheetname);
		return data;

	}


	//After Method--browser closed
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}



