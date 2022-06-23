package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import commonutilities.CommonMethods;
import commonutilities.TestUtil;
import pages.HomePage;
import pages.LoginPage;
import pages.MakerPage;
import testbase.TestBase;

public class DPDIS_TC01Test extends TestBase{
	// Constructor
		public DPDIS_TC01Test() {
			super();

		}

		LoginPage loginpage;
		HomePage homepage;
		MakerPage makerpage;
		TestUtil testutil;
		CommonMethods commonmethods;
		@Test
		public void toverifyLeadIsCreated() throws Exception {
			
			

			//loginpage = new LoginPage();
			homepage = new HomePage(driver);
			makerpage=new MakerPage(driver);
			testutil = new TestUtil();
			commonmethods = new CommonMethods();
			
			// Login to admin page
			loginpage.Login("dpdismaker", "axis@123");
			Thread.sleep(2000);
			
		//	makerpage.selectdpdisViewsStatuscodedropdown("DPDIS Maker Unassigned tray");
			Thread.sleep(2000);
			
			//makerpage.clickviewsSRNumbercheckBox();
			
		//	makerpage.clickSelfAssignMakerCustomButton();
			Thread.sleep(2000);
			
		//	makerpage.clickOnOkButtonAfterselfAssign();
			Thread.sleep(2000);
			
			makerpage.selectdpdisViewsStatuscodedropdown("Assigned To Me");
			Thread.sleep(2000);
			
			
			//click On Sr Link under Assigned to Me
			makerpage.clickviewsSRNumberLink();
			
			
			//verify status code As 'Categorize SR'
			//String expStatusCode=makerpage.expStatusCode();
			//Assert.assertEquals("Categorize SR", expStatusCode, "Status code mismatch");
			
			
			//verify Assigned To as Maker
			//String expAssignedTo=makerpage.expAssignedTo();
			//Assert.assertEquals("Maker", expAssignedTo, "Assigned To mismatch");
			
			
			//Get SR Number from details page
			String SRNumber=makerpage.getSRNumber();
			System.out.println("SR Number on DPDIS Maker Page:--" + SRNumber);
			
			
			makerpage.clickOnEditSR();
			Thread.sleep(2000);
			
			makerpage.clickOnEditSRLink();
			Thread.sleep(2000);
			
			//verify next statuscode Sent to checker , Sent to Authorizer
			
			makerpage.verifyNextPossibleStatusCode();
			
			
			
		
			
			//Sent SR to 'Sent to authorizer'  from maker
			
			makerpage.sentSRToAuthorizer();
			
			//verify status code As  'Sent to Authorizer'
			
			
			
			//verify Assigned To 'DPDIS Unassigned'
			
			
			
			//Log in to DPDIS Authorizer
			
			
			//verify SR is vible under DPDIS authorizer unassigned tray
			
			
			
			
			
			

		}

}
