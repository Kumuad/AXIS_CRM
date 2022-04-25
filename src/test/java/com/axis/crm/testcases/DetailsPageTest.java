package com.axis.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonutilities.CustomListener;
import commonutilities.TestUtil;
import pages.DetailsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import testbase.TestBase;

@Listeners(CustomListener.class)
public class DetailsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	RegistrationPage registrationpage;
	DetailsPage detailspage;
	
	public DetailsPageTest(){
		super();
		
	}
	//@test-execute testcases
		@BeforeMethod
		public void setUp() throws Exception{
		initialization();
		 loginpage=new LoginPage();
		 testutil=new TestUtil();
		 //homepage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		 //registrationpage=homepage.clickOnServiceRequest();
		 
		}

		
		@Test(priority=1)
		public void verifySRNumber() throws Exception{
			String SRNumber=detailspage.getSRNumber();
			System.out.println(SRNumber);
		}
		

		@AfterMethod
		public void teardown() {
			driver.quit();
		}

}
