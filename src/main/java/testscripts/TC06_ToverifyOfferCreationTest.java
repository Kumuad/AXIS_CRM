package testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
public class TC06_ToverifyOfferCreationTest extends TestBase{
	
	
	
	LoginPage loginpage;
	HomePage homepage;
	OffersAndLeadPage offersAndLeadPage;
	TestUtil testutil;
	CommonMethods commonmethods;
	
	
	@Test
	public void toverifyOfferCreation() throws Exception {
		
		
		
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		offersAndLeadPage = new OffersAndLeadPage(driver);
		testutil = new TestUtil();
		commonmethods = new CommonMethods();
		
		
		// Login to admin page
		loginpage.Login("axisadmin", "acid_qa");

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
		
		offersAndLeadPage.createOffer();
		
		Thread.sleep(3000);
		// logout
	    loginpage.Logout();
		
		
	}
}
