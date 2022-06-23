package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import commonutilities.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static  WebDriver driver;
	
	public static Properties prop;
	public static Logger log = Logger.getLogger(TestBase.class);

	public TestBase() {
		prop = new Properties();

		FileInputStream ip;
		try {
			ip = new FileInputStream("C:/Users/kumuad.sagar/eclipse-workspace/AxisCRM/src/main/java/configfiles/confiq.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

  
	//@BeforeClass
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Browser launched");
			
		} else if (browserName.equals("FireFox")) {
			

			driver = new FirefoxDriver();
			log.info("Browser launched");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}
	
	
	//@AfterClass
	@AfterMethod
	
	public void teardown() {
		driver.quit();
	}

}
