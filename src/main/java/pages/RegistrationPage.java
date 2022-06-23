package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import commonutilities.XLUtils;
import commonutilities.TestUtil;
import testbase.TestBase;

public class RegistrationPage extends TestBase{
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	String sheetname="ServiceRequest";
	//String sheetname="test";
	//Object Repository of Registration Page
	
	
	
	/*
	 * private String natureofquery = ""; private String category = "";
	 * 
	 * public String getNatureQuery() { return natureofquery; }
	 * 
	 * public void setnatureofquery(String natureofquery)
	 * 
	 * { this.natureofquery = natureofquery; }
	 * 
	 * public String getcategory() { return natureofquery; }
	 * 
	 * public void setcategory(String category)
	 * 
	 * { this.category = category; }
	 */
	
	@FindBy(xpath=".//div[@class='field__item field--textbox']")
	WebElement selectProduct;	

	@FindBy(xpath="//div[contains(text(),'Retail Liability')]")
	WebElement RetailLiabilityproduct;

	@FindBy(xpath=".//input[@name='CASE_CATEGORY']")
	WebElement function;
	
	@FindBy(xpath=".//input[@name='CASE_SUBCATEGORY']")
     WebElement subFunction;

	@FindBy(xpath=".//input[@name='CASE_SUBCATEGORY1']")
    WebElement subsubFunction;
	
	@FindBy(xpath=".//input[@name='cust_137037']")
	WebElement NatureOfQuery;
	
	@FindBy(xpath=".//textarea[@name='cust_136484']")
	WebElement remarkfield;
	
	@FindBy(xpath=".//select[@name='cust_137034']")
	WebElement accountdetailsdropdown;
	
	@FindBy(xpath=".//input[@name='cust_135018']")
	WebElement accountnumber;
	
	@FindBy(xpath=" //span[contains(text(),'Save and Proceed')]")
	WebElement saveandProceedButton;
	
	@FindBy(xpath="(//input[@name='qqfile'])[1]")
	WebElement uploadKYCdocument;
	
	@FindBy(xpath=".//div[@class='summaryband__item'][1]/div/div/div/span")
    WebElement SRNumber;
	//Constructor Initialization
	
	
	//public static String TEST_DATA_SHEET_PATH="C:\\Users\\Kumuad Sagar\\eclipse-workspace\\AxisCRM\\src\\main\\java\\com\\axis\\crm\\testdata\\ServiceRequest.xlsx";
	
	
	//PageMethods--starts
	
	
	public String verifyregistrationPageTitle(){
		return driver.getTitle();
		
	}

	
  //Create SR(Service Request)
	public void createServiceRequest(String Product ,String NatureofQuery,String Function
			,String SubFunction,String SubSubFunction,String AccountNumber,String Remarks) throws InterruptedException, IOException {

		
		
		selectProduct.click();
		Thread.sleep(2000);
		RetailLiabilityproduct.click();

		Thread.sleep(2000);
		Select accountdetails=new Select(accountdetailsdropdown);
		accountdetails.selectByVisibleText("Account Number");
		accountnumber.sendKeys(AccountNumber);
		Thread.sleep(2000);
		function.sendKeys(Function);
		Thread.sleep(1000);
		WebElement ele=driver.findElement(By.xpath(".//div[@class='griddle-body shadow-4 autocomplete-table']/table/tbody/tr/td[1]"));
		ele.click();
		subFunction.sendKeys(SubFunction);
		// WebDriverWait wait=new WebDriverWait(driver,50);
		// wait.until(ExpectedConditions.elementToBeClickable(ele));
		try {
			ele.click();
		}
		catch(StaleElementReferenceException e) {
			ele=driver.findElement(By.xpath(".//div[@class='griddle-body shadow-4 autocomplete-table']/table/tbody/tr/td[1]"));
			ele.click();
		}

		subsubFunction.sendKeys(SubSubFunction);

		WebElement ele2=driver.findElement(By.xpath(".//div[@class='griddle-body shadow-4 autocomplete-table']/table/tbody/tr[1]/td[1]"));

		try {
			ele2.click();
		}
		catch(StaleElementReferenceException e) {
			ele=driver.findElement(By.xpath(".//div[@class='griddle-body shadow-4 autocomplete-table']/table/tbody/tr/td[1]"));
			ele2.click();
		}

		Thread.sleep(2000);
		NatureOfQuery.sendKeys(NatureofQuery);

		try {
			ele.click();
		}
		catch(StaleElementReferenceException e) {
			ele=driver.findElement(By.xpath(".//div[@class='griddle-body shadow-4 autocomplete-table']/table/tbody/tr/td[1]"));
			ele.click();
		}

		remarkfield.sendKeys(Remarks);
		Thread.sleep(2000);
		
		String path="C:/Users/Kumuad Sagar/eclipse-workspace/AxisCRM/src/main/java/com/axis/crm/util/Test.docx";
		uploadKYCdocument.sendKeys(path);
		System.out.println("file uploaded");
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scroll(0, 100)");
		saveandProceedButton.click();
		String value=SRNumber.getText();
		System.out.println("SR Number" +value);

		//return new DetailsPage();
	}
	
	
	/*
	 * public void uploadKYCdocument() { String
	 * path="C:/Users/Kumuad Sagar/eclipse-workspace/AxisCRM/src/main/java/com/axis/crm/util/Test.docx"
	 * ; uploadKYCdocument.sendKeys(path); System.out.println("file uploades"); }
	 */
	
	
public void serviceRequest() throws IOException, InterruptedException {
	//select product
	selectProduct.click();
	Thread.sleep(2000);
	
	RetailLiabilityproduct.click();
	Thread.sleep(2000);
	
	//Enter account number
	Select accountdetails=new Select(accountdetailsdropdown);
	accountdetails.selectByVisibleText("Account Number");
	accountnumber.sendKeys(TestUtil.getCellData(sheetname,"AccountNumber",2));
	
	
	//Enter function
	Thread.sleep(2000);
	function.sendKeys(TestUtil.getCellData(sheetname,"Function",2));
	
	
	Thread.sleep(1000);
	WebElement ele=driver.findElement(By.xpath(".//div[@class='griddle-body shadow-4 autocomplete-table']/table/tbody/tr/td[1]"));
	ele.click();
	
	//Enter Sub Function
	subFunction.sendKeys(TestUtil.getCellData(sheetname,"SubFunction",2));
	
	try {
		ele.click();
	}
	catch(StaleElementReferenceException e) {
		ele=driver.findElement(By.xpath(".//div[@class='griddle-body shadow-4 autocomplete-table']/table/tbody/tr/td[1]"));
		ele.click();
	}
	
	
	//Enter Sub Sub function
	subsubFunction.sendKeys(TestUtil.getCellData(sheetname,"SubSubFunction",2));

	WebElement ele2=driver.findElement(By.xpath(".//div[@class='griddle-body shadow-4 autocomplete-table']/table/tbody/tr[1]/td[1]"));

	try {
		ele2.click();
	}
	catch(StaleElementReferenceException e) {
		ele=driver.findElement(By.xpath(".//div[@class='griddle-body shadow-4 autocomplete-table']/table/tbody/tr/td[1]"));
		ele2.click();
	}

	Thread.sleep(2000);
		
	//Enter Nature of query
     NatureOfQuery.sendKeys(TestUtil.getCellData(sheetname,"NatureofQuery",2));
    // System.out.println(TestUtil.getCellData(sheetname,"NatureofQuery",2));
	//System.out.println(natureofquery);
	try {
		ele.click();
	}
	catch(StaleElementReferenceException e) {
		ele=driver.findElement(By.xpath(".//div[@class='griddle-body shadow-4 autocomplete-table']/table/tbody/tr/td[1]"));
		ele.click();
	}
	
	//Enter remark fields
	remarkfield.sendKeys(TestUtil.getCellData(sheetname,"Remarks",2));
	Thread.sleep(2000);
	
	//Upload documents
	String path="C:/Users/Kumuad Sagar/eclipse-workspace/AxisCRM/src/main/java/commonutilities/Test.docx";
	uploadKYCdocument.sendKeys(path);
	System.out.println("file uploaded");
	Thread.sleep(2000);
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("scroll(0, 100)");
	
	//Click on save and proceed button 
	saveandProceedButton.click();
	
	String value=SRNumber.getText();
	System.out.println("SR Number" +value);
	
	//return new DetailsPage();
		
	}
	
}
