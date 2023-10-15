package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkReporter;  // UI of the report
	public ExtentReports extent;  //populate common info on the report
	public ExtentTest test; // creating test case entries in the report and update status of the test methods

	public void onStart(ITestContext context) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
	       Date dt = new Date();
	       String timeStamp1 = df.format(dt);
	     String  repName= "Test-Report-" + timeStamp1 +".html";			
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/repName");//specify location of the report
		//sparkReporter=new ExtentSparkReporter("\\reports\\"+repName);
		sparkReporter.config().setDocumentTitle(" opencart Automation Report"); // TiTle of report
		sparkReporter.config().setReportName("opencart Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Application","Opencart");
		extent.setSystemInfo("Module","Admin");
		extent.setSystemInfo("Tester Name","Pavan");
		extent.setSystemInfo("Operating System",System.getProperty("os.name"));
		extent.setSystemInfo("User Name",System.getProperty("user.name"));
		extent.setSystemInfo("Environment","QA");
		//extent.setSystemInfo("Browser name","Chrome,Firefox,Edge");
					
	}


	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName()); // create a new enty in the report
		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s
		
	}

	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable()); 
		
		String imgPath=new BaseClass().captureScreen(result.getName());
		
		test.addScreenCaptureFromPath(imgPath);
		}
		
					
	

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		
		
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
		test.log(Status.SKIP, result.getThrowable().getMessage());
		
	}

	
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}
		
	
}
