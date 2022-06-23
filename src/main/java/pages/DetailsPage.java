package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class DetailsPage extends TestBase{

	
	public DetailsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Object Repository
	
	@FindBy(xpath=".//div[@class='summaryband__item'][1]/div/div/div/span")
    WebElement SRNumber;
	
	@FindBy(xpath=".//div[@class='summaryband__item'][2]/div/div/div/span")
    WebElement statuscode;
	
	//Methods--
	
	
	//get SR Number from Details Page
	public String getSRNumber() {
		return SRNumber.getText();
	}
	
	//get Status code from Details Page
	public String getStatuscodeDetailsPage() {
		return statuscode.getText();
	}
	
	
}
