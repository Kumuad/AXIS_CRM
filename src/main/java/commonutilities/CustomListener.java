package commonutilities;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class CustomListener extends TestUtil implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		try{
			passScreenshot(result.getMethod().getMethodName());
					
					
		}
		catch(Exception e) {
			
		}
		
		
	}

	public void onTestFailure(ITestResult result) {
		/*
		 * // TODO Auto-generated method stub WebDriver driver=null; //Screenshot code
		 * String testMethodName=result.getMethod().getMethodName(); try {
		 * driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField(
		 * "driver").get(result.getInstance()); } catch (Exception e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * try { takeScreenshotAtEndOfTest(testMethodName, driver); } catch (Exception
		 * e) {
		 * 
		 * e.printStackTrace(); }
		 * 
		 */
		
		/*
		 * try { takeScreenshot(result.getMethod().getMethodName()); } catch (Exception
		 * e) {
		 * 
		 * e.printStackTrace(); }
		 */
		
		try{
			failScreenshot(result.getMethod().getMethodName());
		}
		catch(Exception e) {
			
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
		// TODO Auto-generated method stub
		
	}

}
