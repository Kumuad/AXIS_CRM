package com.axis.crm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonutilities.TestUtil;
import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;

	String sheetname="Logins";

	public LoginPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginpage=new LoginPage();
	}
	
	@DataProvider(name="Login")
	public Object[][] getLoginTestData() throws Exception{
		
		Object data[][]=TestUtil.getTestData(sheetname);
		return data;
		
	}
	@Test(priority=1)
	/*public void LoginTest() throws Exception{
		//homepage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		
		//loginpage.Login("uname", "pwd");
		//return login;
	}*/
	
	
	
	public void LoginTest(String username,String password) throws Exception
	{
		loginpage.Login(username, password);
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}



}
