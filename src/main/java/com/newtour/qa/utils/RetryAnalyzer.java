package com.newtour.qa.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	int counter=0;
	int retryLimit=3;

	public boolean retry(ITestResult result) {
		if(counter<retryLimit) {
			counter++;
			return true;
		}
		return false;
	}
	
	

}


// NOTE: This IRetryAnalyzer interface is use to retry the failed test cases upto "retryLimit=3" times