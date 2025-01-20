package com.sevenrmartsupermarket.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	
	
	@Test(groups = {"smoke", "regression"})
	public void verifySignInButtonIsEnabled() {
		loginpage=new LoginPage(driver);
		boolean actualResult=loginpage.signInBtnIsEnabled();
		Assert.assertTrue(actualResult);
		
	}
	@Test(groups="smoke")
	public void verifyRememberMeCheckBoxIsEnabled() {
		loginpage=new LoginPage(driver);
		boolean actualResult=loginpage.checkBoxIsEnabled();
	   	Assert.assertTrue(actualResult);
		
	}
	
	@Test
	public void verifyAlertMessageForInvalidPassword() {
		loginpage=new LoginPage(driver);
		String actualAlertMsg=loginpage.loginWithInvalidPassword("Admin","passward");
		String s[]=actualAlertMsg.split("\n");
		String splittedActualMsg=s[2];
		String expectedMsg="Invalid Username/Password";
		Assert.assertEquals(splittedActualMsg,expectedMsg);
		 
	}
	@Test
	public void verifyColorOfSignInButton() {
		loginpage=new LoginPage(driver);
		String actualColor=loginpage.getLoginButtonColor("background-color");
		String expectedColor="rgba(52, 58, 64, 1)";
		System.out.println(actualColor);
		Assert.assertEquals(actualColor, expectedColor);
	}
	
}
