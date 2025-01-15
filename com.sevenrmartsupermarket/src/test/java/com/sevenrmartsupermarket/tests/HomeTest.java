package com.sevenrmartsupermarket.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class HomeTest extends Base {
	LoginPage loginpage;
	HomePage homepage;

	@Test
	public void verifyProfileName() {
		homepage=new HomePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.login();
		String actualPofileName=homepage.getProfileName();
		String expectedPofileName="Admin";
		System.out.println(actualPofileName);
		Assert.assertEquals(actualPofileName, expectedPofileName);
	}
}
