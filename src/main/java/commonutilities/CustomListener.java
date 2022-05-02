package commonutilities;


import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;






public class CustomListener extends TestUtil implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent = ExtentReporter.getReportsObject();
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	
	
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+" test case started");	
		test = extent.createTest(result.getMethod().getMethodName()+" test case started");
		testReport.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		
		
		System.out.println("The name of the testcase passed is :"+result.getName());	
		testReport.get().log(Status.PASS, result.getMethod().getMethodName()+" Passed");
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		testReport.get().fail(result.getThrowable());
		
		//String methodName=result.getMethod().getMethodName();
		
		try{
			
			testReport.get().addScreenCaptureFromPath(TestUtil.failScreenShot(result.getMethod().getMethodName()), result.getMethod().getMethodName());
			//failAshot(result.getInstanceName().trim());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
