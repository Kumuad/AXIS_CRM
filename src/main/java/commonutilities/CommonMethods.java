package commonutilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import testbase.TestBase;

public class CommonMethods extends TestBase {

	public static JavascriptExecutor js = (JavascriptExecutor) driver;
	public static String parentwindow;

	// to scroll down the page by pixel values as Y-coordiante
	public static void scrollDown(int y) {
		js.executeScript("window.scrollBy(0," + y + ")");
	}

	// To scroll down the page by visibility of the element
	public static void scrollByVisibilityofElement(WebElement element) {
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
	public static void clickelementbyjavascript(WebElement element) {
		js.executeScript("arguments[0].click();", element);

	}

	// highlight the element
	public static void highlightelement(WebElement element) {
		js.executeScript("arguments[0].style.border='3px dotted red'", element);
	}

	// Switch to window

	public static void switchwindow() {

		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			parentwindow = driver.getWindowHandle();

			for (String handle : driver.getWindowHandles()) {
				// System.out.println(handle);
				if (!parentwindow.equalsIgnoreCase(handle)) {
					driver.switchTo().window(handle);
				}
			}

		} catch (Exception e) {

		}

	}

	// switch to parent window

	public static void switchtoparentwindow() {

		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.switchTo().window(parentwindow);

		}

		catch (Exception e) {

		}
	}
	
	
	// Generate Random Mobile Number 10 digit

	public static String generateRandomMobileNumber() {
		Random random = new Random();
		int randomInt = random.nextInt(1000000000);

		String mobilenumber = String.valueOf(randomInt);

		String s1 = "9";
		String actualmobnum = s1.concat(mobilenumber);
		return actualmobnum;
	}
   
	
	//generate Random Customer Id 9 digit
	public static String generateRandomCustomerID() {
		Random random = new Random();
		int randomInt = random.nextInt(1000000000);

		String customerid = String.valueOf(randomInt);
		return customerid;

	}
	
	
	//generate Random Number
	
	public static int generateRandomNumber() {
		Random random = new Random();
		int randomNum = random.nextInt(1000);
		return randomNum;
		
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
			
		}
	}
	
	
	
	
	
}