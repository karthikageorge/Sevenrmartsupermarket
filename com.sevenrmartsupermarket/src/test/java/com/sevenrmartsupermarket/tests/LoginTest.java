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
	public void verifySignInButtonnIsEnabled() {
		loginpage=new LoginPage(driver);
		boolean actualResult=loginpage.signInBtnIsEnabled();
		System.out.println(GeneralUtility.getRandomName());
		Assert.assertTrue(actualResult);
		
	}
	@Test(groups="smoke")
	public void verifyCheckBoxIsEnabled() {
		loginpage=new LoginPage(driver);
		boolean actualResult=loginpage.checkBoxIsEnabled();
	   	Assert.assertTrue(actualResult);
		
	}
	
	@Test
	public void verifyAlertMsgForInvalidPassword() {
		loginpage=new LoginPage(driver);
		String actualAlertMsg=loginpage.loginWithInvalidPassword("Admin","passward");
		String s[]=actualAlertMsg.split("\n");
		String splittedActualMsg=s[2];
		String expectedMsg="Invalid Username/Password";
		Assert.assertEquals(splittedActualMsg,expectedMsg);
		 
	}
	
}
