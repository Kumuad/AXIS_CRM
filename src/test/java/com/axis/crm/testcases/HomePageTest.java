package com.axis.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonutilities.CustomListener;
import commonutilities.TestUtil;
import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;

@Listeners(CustomListener.class)
public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;

	public HomePageTest() {
		super();

	}

	// @test-execute testcases
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		// homepage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void homePageTitle() throws Exception {
		String homepagetitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMnext - Smart.Easy.Complete", "Home PageTitle not matched");

	}

	/*
	 * @Test(priority=2) public void clickServiceRequestTest() throws Exception{
	 * 
	 * try { homepage.clickOnServiceRequest(); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * homepage.clickOnServiceRequest(); }
	 */

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
