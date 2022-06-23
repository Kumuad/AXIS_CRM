package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonutilities.CommonMethods;
import commonutilities.TestUtil;
import testbase.TestBase;

public class TaskPage extends TestBase {

	// Constructor
	public TaskPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	//public static String task_sheet ="taskcreation";
	
	public static String fileupload_task_path=  "C:\\Users\\kumuad.sagar\\eclipse-workspace\\AxisCRM\\src\\main\\java\\commonutilities\\Test.docx";
	
	//public static String fileupload_task_path=  "C:\\Users\\Kumuad Sagar\\eclipse-workspace\\AxisCRM\\src\\main\\java\\commonutilities\\Test.docx";
	// *********Object Repository Retail Appointment Page***************
	
	//Task Page
		@FindBy(xpath ="//input[@data-autoid='ACT_SUBJECT_ctrl']")
		WebElement taskSubjectTextBox;
		
		@FindBy(xpath ="//textarea[@data-autoid='Act_Detail_ctrl']")
		WebElement taskDescriptionTextBox;
		
		
		@FindBy(xpath ="//input[@name='qqfile']")
		WebElement attachementTab;
		
		@FindBy(xpath = "(//span[contains(text(),'Save')])[1]")
		WebElement saveButton;
		
		
		
		
		public void createTaskOnLead(String task_sheet) throws InterruptedException, IOException {
			
			CommonMethods.switchwindow();
			Thread.sleep(3000);
			//Enter Subject
			taskSubjectTextBox.sendKeys(TestUtil.getCellData(task_sheet, "Subject", 1));
			String subject=TestUtil.getCellData(task_sheet, "Subject", 1);
			System.out.println("Subject Entered: "+subject);
			System.out.println();
			
			
			//Enter Description
			taskDescriptionTextBox.sendKeys(TestUtil.getCellData(task_sheet, "Description", 1));
			String description=TestUtil.getCellData(task_sheet, "Subject", 1);
			System.out.println("Description Entered: "+description);
			System.out.println();
			
            CommonMethods.clickelementbyjavascript(attachementTab);
			
			Thread.sleep(3000);
			
			
			// upload file on Task page
			CommonMethods.fileupload(fileupload_task_path);
			Thread.sleep(2000);
			
			
			//click On Save Button
			saveButton.click();
			Thread.sleep(5000);
			
			
			CommonMethods.switchtoparentwindow();
			
			TestUtil.takeScreenShot("Task Creation");
		}
		
		
		

}