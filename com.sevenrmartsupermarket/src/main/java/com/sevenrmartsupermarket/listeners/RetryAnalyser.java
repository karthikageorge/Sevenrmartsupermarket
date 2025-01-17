package com.sevenrmartsupermarket.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	int counter =0;
	int retryLimit=3;
	
	@Override
	public boolean retry(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE && counter < retryLimit) {
			counter++;
			return true;
		} else
			return false;
	}

}
