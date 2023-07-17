package com.obsqura.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class reportListners implements ITestListener{
	public ExtentSparkReporter spark;
	public ExtentTest logger;
	public ExtentReports extent;
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
		}
	
	public void onStart(ITestContext iTestContext) {
		String path = System.getProperty("user.dir");
		spark = new ExtentSparkReporter(path+"\\Sparks.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Host Name","localhost");
		extent.setSystemInfo("Environemnt", "QA");
	}
	
	public void onFinish(ITestContext iTestContext) {
		extent.flush();
	}
	
	public void onTestStart(ITestResult iTestResult) {
		logger = extent.createTest(iTestResult.getName());
		Reporter.log(iTestResult.getName()+" test case started",2,true);
	}
	
	public void onTestSuccess(ITestResult iTestResult ) {
		logger.log(Status.PASS, iTestResult.getName()+"has been successfully tested");
	}
	
	public void onTestFailure(ITestResult iTestResult) {
		logger.log(Status.FAIL, iTestResult.getName()+"validation failed");
		}
	
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("The name of the testcase skipped is :"+iTestResult.getName());
		}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		}

}
