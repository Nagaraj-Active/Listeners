package Listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class listner_amzone implements ITestListener
{
public ExtentSparkReporter sparkReporter; //UI of the report
             public ExtentReports extent; //populate common information on the report
                  public ExtentTest test; //create the entry of the report & update status of test methods
                  
 public void onStart(ITestContext context)
 {
	 //sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Parklens/reports/myreports.html");
	 sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myreport3.html");
	 
	 sparkReporter.config().setDocumentTitle("automation testing");
	 sparkReporter.config().setReportName("functional testing");
	 sparkReporter.config().setTheme(Theme.DARK);
   
	 extent=new ExtentReports();
     extent.attachReporter(sparkReporter);
     extent.setSystemInfo("computername",    "dell");
     extent.setSystemInfo("Environment" ,      "QA");
     extent.setSystemInfo( "testername" , "nagaraj");
     extent.setSystemInfo(        " Os" ,   "linux");
     extent.setSystemInfo("browserName" ,  "chrome");
 }
 public void onTestSuccess(ITestResult result)
 {
	 test=extent.createTest(result.getName());//crete new entry in the report
	 test.log(Status.PASS, "passed testcase is: "+result.getName());
 }
public void onTestFailure(ITestResult result)
{
	
	test=extent.createTest(result.getName());
	test.log(Status.FAIL,"failed test case is: "+ result.getName());
	test.log(Status.FAIL,"test case is failed because of:"+result.getThrowable());
}
public void onTestSkipped(ITestResult result)
{
	test=extent.createTest(result.getName());
	test.log(Status.SKIP, "test case is skipped: "+ result.getName());
}
public void onFinish(ITestContext context) 
{
	extent.flush();
}
}
