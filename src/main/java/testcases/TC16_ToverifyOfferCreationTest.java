package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonutilities.CommonMethods;
import commonutilities.CustomListener;
import commonutilities.TestUtil;
import pages.HomePage;
import pages.LoginPage;
import pages.OffersAndLeadPage;
import testbase.TestBase;
@Listeners(CustomListener.class)
public class TC16_ToverifyOfferCreationTest extends TestBase{
	
	
	
	LoginPage loginpage;
	HomePage homepage;
	OffersAndLeadPage offersAndLeadPage;
	TestUtil testutil;
	CommonMethods commonmethods;
	
	
	@Test
	public void ToverifyOfferCreation() throws Exception {
		

		if (!(CommonMethods.isTestRunnable("TC16_ToverifyOfferCreationTest"))) {
			  
			  throw new SkipException("Skipping the test " + "To verify Offer Creation".toUpperCase() + "as the Run mode is NO"); 
			  
			  }
		
		String offer_sheetname="offercreation";
		
		//loginpage = new LoginPage(driver);
		//homepage = new HomePage(driver);
		//offersAndLeadPage = new OffersAndLeadPage(driver);
		testutil = new TestUtil();
		commonmethods = new CommonMethods();
		
		initialization();
		
		loginpage = new LoginPage(driver);
		// Login to admin page
		loginpage.Login("axisadmin", "acid_qa");

		homepage = new HomePage(driver);
		// Select Administrator Role
		homepage.selectrole("Administrator");
		Thread.sleep(2000);

		// Move to sales Tab
		homepage.moveToMarketingTab();
		Thread.sleep(2000);
		
		//click On Offers Link
		homepage.clickOnOffersLink();
		
		//click On New Button
		homepage.clickOnNewButton();
		
		
		Thread.sleep(1000);
		homepage.clickOfferLink();
		Thread.sleep(3000);
		offersAndLeadPage = new OffersAndLeadPage(driver);
		
		offersAndLeadPage.createOffer(offer_sheetname);
		
		Thread.sleep(3000);
		// logout
	    loginpage.Logout();
		
		
	}
}
