package com.axis.crm.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonutilities.CustomListener;
import commonutilities.TestUtil;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import testbase.TestBase;


@Listeners(CustomListener.class)
public class RegistrationPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	RegistrationPage registrationpage;
	String sheetname="ServiceRequest";
	//public static String TEST_DATA_SHEET_PATH="C:\\Users\\Kumuad Sagar\\eclipse-workspace\\AxisCRM\\src\\main\\java\\com\\axis\\crm\\testdata\\ServiceRequest.xlsx";
	
	
	//Constructor
	public RegistrationPageTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() throws Exception{
		initialization();
		loginpage=new LoginPage();

		testutil=new TestUtil();
		//homepage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		//homepage=loginpage.Login("username","password");
		registrationpage=homepage.clickOnServiceRequest();
	}
	
	
	
	
	  @Test(priority=1) public void registrationPageTitleTest() throws Exception{
	  String registrationPageTitle=registrationpage.verifyregistrationPageTitle();
	  Assert.assertEquals(registrationPageTitle,
	  "CRMnext - Smart.Easy.Complete","Registration PageTitle not matched");
	  
	  
	  }
	 
	
	/*
	 * @Test(priority=2) public void selectProductTest() throws InterruptedException
	 * { registrationpage.selectProduct(); }
	 */
	
	@DataProvider
	public Object[][] getServiceRequestTestData() throws Exception{
		
		Object data[][]=TestUtil.getTestData(sheetname);
		return data;
		
	}
	@Test(dataProvider="getServiceRequestTestData", priority=2)
	public void createServiceRequestTest(String Product ,String NatureofQuery,String Function
			,String SubFunction,String SubSubFunction,String AccountNumber,String Remarks) throws InterruptedException, IOException {
		registrationpage.createServiceRequest(Product ,NatureofQuery, Function
				, SubFunction,SubSubFunction, AccountNumber,Remarks);

	}

	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
