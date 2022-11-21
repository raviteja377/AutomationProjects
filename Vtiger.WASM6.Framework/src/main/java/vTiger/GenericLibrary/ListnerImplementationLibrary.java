package vTiger.GenericLibrary;


import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * this method will provide implementation to all abstract methods  in itestlistener
 * @author ADMIN
 *
 */
public class ListnerImplementationLibrary implements ITestListener{
	
ExtentReports report;
ExtentTest test;
	public void onTestStart(ITestResult result) {
       String MethodName = result.getMethod().getMethodName();
    Reporter.log(" test execution  started-->"+MethodName,true);
      test=report.createTest(MethodName);//test script execution is started  in report
       test.log(Status.INFO,"test execution is started");
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		Reporter.log("test is successfull--->"+MethodName,true);
test.log(Status.PASS, MethodName+"-->pass");
	}

	public void onTestFailure(ITestResult result) {
		WebDriverLibrary wLib=new WebDriverLibrary();
		JavaLibrary jLib=new JavaLibrary();
		
		String MethodName = result.getMethod().getMethodName()+jLib.getSystemDateInFormate();
		Reporter.log("test is failed-->"+MethodName,true);
		test.log(Status.FAIL, "failed");
		test.log(Status.FAIL,result.getThrowable());
		try {
String path = wLib.takeScreenShot(BaseClass.sDriver, MethodName);
test.addScreenCaptureFromPath(path);
		}  catch (Exception e) {
	
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
	String MethodName=result.getMethod().getMethodName();  
	Reporter.log("test is skipped--e>"+MethodName,true);
	test.log(Status.SKIP,MethodName+ "-->skipped");
	test.log(Status.SKIP, result.getThrowable());
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {
		JavaLibrary jLib=new JavaLibrary();
		
Reporter.log("execution of suite started",true);
//execution of Suite Starts here,hence configure the extents reports here
//String path = ".\\ExtentReports\\re.html"+new JavaLibrary().getSystemDateFormate();
ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+jLib.getSystemDateInFormate()+".html");
	htmlReport.config().setDocumentTitle("Execution Reports for vTiger");
	htmlReport.config().setTheme(Theme.STANDARD);
	htmlReport.config().setReportName("vTiger Execution reports");
	//attach the report to extent reports
report=new ExtentReports();
	report.attachReporter(htmlReport);
	report.setSystemInfo("Base Browser", "chrome");
	report.setSystemInfo("Base Environment", "Testing");
	report.setSystemInfo("Base URL","http://localhost:8888");
	report.setSystemInfo("Base platform", "windows");
	report.setSystemInfo("Reporter name", "RaviTeja");
	
	}

	public void onFinish(ITestContext context) {
		Reporter.log("execution of suite finished",true);
		//flush the report.- here execution is finished
	report.flush();
	}

}
