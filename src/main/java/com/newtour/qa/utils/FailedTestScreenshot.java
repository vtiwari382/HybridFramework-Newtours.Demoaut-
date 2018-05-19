package com.newtour.qa.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.newtour.qa.testbase.TestBase;

public class FailedTestScreenshot extends TestBase implements ITestListener{
	
	public void takeScreenShotOnFailure(String methodName) throws Exception {
//		if (methodName.getStatus() == ITestResult.FAILURE) {
			File scr=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String filename =  new SimpleDateFormat("dd-MM-yyyy hh-mm-ss").format(new Date());
			String currentdir = System.getProperty("user.dir")+"/Screenshots/";
			File dest = new File(currentdir+ filename +".png");
			FileUtils.copyFile(scr, dest);
		}
//	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error "+result.getName()+" test has failed *****");
		try {
			String methodName = result.getName().toString().trim();
			takeScreenShotOnFailure(methodName);
		} catch (Exception e) {
			e.printStackTrace();
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

// Note: ITestListener interface is use to take the screenshot of failed test cases, it has different pre-defined methods for the screenshots.
