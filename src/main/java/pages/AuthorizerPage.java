package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonutilities.CommonMethods;
import testbase.TestBase;

public class AuthorizerPage extends TestBase {

	// Constructor
	public AuthorizerPage() {
		super();
		PageFactory.initElements(driver, this);

	}

	// Object Repository
	@FindBy(xpath = ".//select[@name='QueryViewId']")
	WebElement viewsAssigneTodropdown;

	// Page method starts--------

	// Select value from Views Assigned to Dropdown
	public void selectAssignedTo(int i) {
		CommonMethods.selectByIndex(viewsAssigneTodropdown, i);

	}
}
