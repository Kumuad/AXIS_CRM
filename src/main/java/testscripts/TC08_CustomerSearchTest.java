package testscripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonutilities.CommonMethods;
import commonutilities.CustomListener;
import commonutilities.TestUtil;
import pages.CustomerPage;
import pages.CustomerSearchPage;
import pages.HomePage;
import pages.LeadSearchPage;
import pages.LeadsPage;
import pages.LoginPage;
import pages.OffersAndLeadPage;
import pages.TaskPage;
import testbase.TestBase;

@Listeners(CustomListener.class)
public class TC08_CustomerSearchTest extends TestBase{
	//Constructor
	public TC08_CustomerSearchTest() {
		super();

	}

	LoginPage loginpage;
	HomePage homepage;
	CustomerPage customerPage;
	OffersAndLeadPage offersAndLeadPage;
	CustomerSearchPage customerSearchPage;
	TaskPage taskpage;
	TestUtil testutil;
	CommonMethods commonmethods;
	
	
	@Test
	public void verifyCustomerSearch() throws Exception {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		customerPage = new CustomerPage(driver);
		offersAndLeadPage = new OffersAndLeadPage(driver);
		customerSearchPage=new CustomerSearchPage(driver);
		testutil = new TestUtil();
		commonmethods = new CommonMethods();
		
		
		
		log.info("************Login to Home Page*************************");
		// Login to admin page
		loginpage.Login("axisadmin", "acid_qa");

		// Select Administrator Role
		homepage.selectrole("CSO");
		Thread.sleep(2000);

		// move to Quick Link
		homepage.moveToQuickLink();
		
		//click On Customer Search Tab under quick Links 
		homepage.clickOnCustomerSearchTab();
		
		
		//verify Customer Search By Customer ID
		String actualcustomerid = customerSearchPage.verifyCustomerSearchByCustomerID();
		System.out.println("Actual Customer ID Entered on Customer Search Page: " + actualcustomerid);
		System.out.println();
		
		//get Customer ID after Customer Search on Details Page
		String expcustomerid=customerPage.getcustomerID();
		System.out.println("Expected Customer ID Fetched on Customer Search Page: " + expcustomerid);
		
		Assert.assertEquals(actualcustomerid, expcustomerid, "Customer ID mismatched");
		driver.navigate().back();
		Thread.sleep(3000);
		
		//verify Customer Search By Mobile Phone
		String actualmobile=customerSearchPage.verifyCustomerSearchByMobilePhone();
		System.out.println("Actual Mobile Phone Entered on Customer Search Page: " + actualmobile);
		System.out.println();
		
		
		//get Mobile Phone after Customer Search On detail Page
		String expmobile=customerPage.getMobilePhone();
         System.out.println("Expected Mobile Phone Fetched on Customer Search Page: " + expmobile);
		
		Assert.assertEquals(actualmobile, expmobile, "Mobile Phone mismatched");
		
		driver.navigate().back();
		Thread.sleep(3000);
		
		//verify Customer Search By Email ID
		String actualemailid=customerSearchPage.verifyCustomerSearchByEmail();
		System.out.println("Actual Email ID Entered on Customer Search Page: " + actualemailid);
		System.out.println();
		
		//get Email Id after Customer Search On detail Page
		String expemailid=customerPage.getEmailId();
		System.out.println("Expected Email ID Fetched on Customer Search Page: " + expemailid);
				
		Assert.assertEquals(actualemailid, expemailid, "Email ID mismatched");
		driver.navigate().back();
		Thread.sleep(3000);
		
		
		
		//verify Customer Search By PAN Number
		String actualpannumber=customerSearchPage.verifyCustomerSearchByPANNumber();
		System.out.println("Actual PAN Number Entered on Customer Search Page: " + actualpannumber);
		System.out.println();
		
		//get PAN Number after Customer Search On detail Page
		String exppannumber=customerPage.getPANNumber();
		System.out.println("Expected PAN Number Fetched on Customer Search Page: " + exppannumber);
						
		Assert.assertEquals(actualpannumber, exppannumber, "PAN Number mismatched");
		driver.navigate().back();
		Thread.sleep(3000);
	}

}
