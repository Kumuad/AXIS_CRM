package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class LoginPage extends TestBase {

	// PageFactory Object Repository

	// Username textbox
	@FindBy(xpath = "//input[@id='TxtName']")
	WebElement username;

	// Password textbox
	@FindBy(xpath = "//input[@id='TxtPassword']")
	WebElement password;

	// Login Button
	@FindBy(xpath = "//input[@name='command']")
	WebElement loginbtn;

	// logout button
	@FindBy(xpath = "//a[@data-autoid='Logout_link']")
	WebElement logoutbtn;

	//@FindBy(xpath = "//a[@name='ProfileImage_header']")
	@FindBy(xpath = "(//a[@name='ProfileImage_header'])[1]")
	WebElement profileimage;
	
	@FindBy(xpath = "//select[@name='Administrator']")
	WebElement rolesdropdown;
	
	
	
	// constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Methods

	// To login to page

	/*
	 * public HomePage Login(String uname,String pwd) throws Exception {
	 * username.sendKeys(uname); password.sendKeys(pwd); loginbtn.click();
	 * Thread.sleep(2000); return new HomePage();
	 * 
	 * 
	 * }
	 */

	public void Login(String uname, String pwd) throws Exception {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginbtn.click();
		Thread.sleep(2000);

	}

	public void Logout() {

		profileimage.click();
		logoutbtn.click();

	}

}
