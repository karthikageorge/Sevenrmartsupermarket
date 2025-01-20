package com.sevenrmartsupermarket.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class HomeTest extends Base {
	LoginPage loginpage;
	HomePage homepage;

	@Test(retryAnalyzer = com.sevenrmartsupermarket.listeners.RetryAnalyser.class)
	public void verifyProfileName() {
		loginpage=new LoginPage(driver);
		homepage=loginpage.login();
		String actualPofileName=homepage.getProfileName();
		String expectedPofileName="admin";
		Assert.assertEquals(actualPofileName, expectedPofileName);
	}
}
