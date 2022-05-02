package commonutilities;

import testbase.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter extends TestBase{
	
	 static ExtentReports extent;
	public static ExtentReports getReportsObject()
	{
		
		//ExtentReports extent = null;
		String folderDate = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss").format(new Date());
		try {
		String reportPath = System.getProperty("user.dir")+"\\Reports\\TestReport_"+folderDate+".html";
		
		
		ExtentSparkReporter reporter =new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name","Kumuad Sagar");
		extent.setSystemInfo(" "," ");
		
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return extent;
	}
}
