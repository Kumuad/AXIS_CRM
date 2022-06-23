package commonutilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import testbase.TestBase;

public class CommonMethods extends TestBase {
	


//	public  JavascriptExecutor js = (JavascriptExecutor) driver;
	 public  static JavascriptExecutor js;
	public static String parentwindow;
	public static WebElement element;

	// to scroll down the page by pixel values as Y-coordiante
	public static void scrollDown(int y) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + y + ")");
	}

	// To scroll down the page by visibility of the element
	public static void scrollByVisibilityofElement(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	// To scroll down the page at the bottom of page.
	public static void scrollAtBottom() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// Return the complete height of body (page)
	}

	//// Selection of dropdown by text
	public static void selectByText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	//// Selection of dropdown by value
	public static void selectByValue(WebElement element, String str) {
		Select sel = new Select(element);
		sel.selectByValue("str");
	}

	// Selection of dropdown by index
	public static void selectByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	// Mouse hover on element
	public static void mouseHover(WebElement toElement) {
		Actions a = new Actions(driver);
		a.moveToElement(toElement).perform();
	}

	// click element by javascript
	public  static void clickelementbyjavascript(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	// highlight the element
	public static  void highlightelement(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px dotted red'", element);
	}

	//Maximize Window
	public static void maximizeWindow() {

		driver.manage().window().maximize();
	}
	// Switch to window

	public static void switchwindow() {

		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			parentwindow = driver.getWindowHandle();
			//System.out.println(parentwindow);

			for (String handle : driver.getWindowHandles()) {
				// System.out.println(handle);
				if (!parentwindow.equalsIgnoreCase(handle)) {
					//System.out.println(handle);
					driver.switchTo().window(handle);
				}
			}

		} catch (Exception e) {
             e.getMessage();
		}

	}

	// switch to parent window

	public static void switchtoparentwindow() {

		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.switchTo().window(parentwindow);

		}

		catch (Exception e) {
			 e.getMessage();
		}
	}
	
	
	// Generate Random Mobile Number 10 digit

	public static String generateRandomMobileNumber() {
		Random random = new Random();
		//int randomInt = random.nextInt(1000000000);
		String id=String.format("%09d",random.nextInt(10000));
		String mobilenumber = String.valueOf(id);

		String s1 = "9";
		String actualmobnum = s1.concat(mobilenumber);
		return actualmobnum;
	}
   
	
	//generate Random Customer Id 9 digit
	public static String generateRandomCustomerID() {
		Random random = new Random();
		//int randomInt = random.nextInt(1000000000);
		String id=String.format("%09d",random.nextInt(10000));
		String customerid = String.valueOf(id);
		return customerid;

	}
	
	
	//generate Random Number
	
	public static int generateRandomNumber() {
		Random random = new Random();
		int randomNum = random.nextInt(1000);
		return randomNum;
		
	}
	
	
	//generate Random Email
	
	public static String generateRandomEmail() {
		int num=generateRandomNumber();
		
		String email= "test"+num+"@gmail.com";
		
		
		return email;
	}
	
	
	
	//generate random PAN Number
	
	public static String generatePANNumber() {
		Random random = new Random();
		String id=String.format("%04d",random.nextInt(10000));
		//int randomNum = random.nextInt(1000);
		//String pannumber= "ASDUY"+id+"Z";
		String pannumber= "CJJPS"+id+"Z";
		return pannumber;
	}
	//file upload
	
	public static void fileupload(String filepath) {
		try{
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Robot robo=new Robot();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			//element.click();
			Thread.sleep(3000);
			StringSelection path= new StringSelection(filepath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
			
			robo.setAutoDelay(3000);
			
			robo.keyPress(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_CONTROL);
			robo.keyRelease(KeyEvent.VK_V);
			Thread.sleep(3000);
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void PickerSelect( WebElement element, String value) throws IOException, InterruptedException {

		String data = value;

		try {

			element = driver.findElement(By.xpath("//td[contains(text(),'" + data + "')]"));
            System.out.println(data);
			element.click();
			//.info("Selected " + data);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	///
	
	
	
	public static boolean isTestRunnable(String testName) throws IOException
	{
		
		String sheetName="testsuite";
	int rows =TestUtil.getRowCount(sheetName);
	//System.out.println("No of rows : "+rows + " and test name = "+testName);

	for(int rNum=1; rNum<=rows; rNum++){

	String testCase = TestUtil.getCellData(sheetName, "TC Name", rNum);

	if(testCase.equalsIgnoreCase(testName)){

	String runmode = TestUtil.getCellData(sheetName, "RunMode", rNum);

	if(runmode.equalsIgnoreCase("Yes"))
	return true;
	else
	return false;
	}
	}
	return false;
	}
	
	
	
	
	
	
	
	
}