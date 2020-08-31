package com.w2a.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;

import com.w2a.base.page;

import com.w2a.utilities.Utilities;

public class CustomListeners extends page

implements ITestListener
{

	public void onTestStart(ITestResult result) {
		
		//Starting extentreporting for the testcase
		test=rep.startTest(result.getName().toUpperCase(), "Starting the test");
		//Checking the runmode of the testcase
		if(!Utilities.isTestRunnable(result.getName()))
		{
			throw new SkipException("Skipping the testcase "+result.getName().toUpperCase()+"as runmode is \"NO\"");
		}
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(LogStatus.PASS, result.getName().toUpperCase()+"Passed");	
		rep.endTest(test);
		rep.flush();
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		Utilities.captureScreenShot();
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		test.log(LogStatus.FAIL,result.getName()+"failed with "+result.getThrowable());
		test.log(LogStatus.FAIL,test.addScreenCapture(Utilities.screenshotName));
		Reporter.log("Capturing screens shot");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		
		Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+">ScreenShot</a>");
		
		rep.endTest(test);
		rep.flush();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(LogStatus.SKIP,result.getName()+"Skipped as the runmode is no ");
		rep.endTest(test);
		rep.flush();
		
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
