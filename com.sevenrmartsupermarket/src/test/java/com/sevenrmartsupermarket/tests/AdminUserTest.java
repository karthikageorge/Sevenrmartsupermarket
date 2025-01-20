package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageNewsPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminUserTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	ManageNewsPage managenewspage;
	AdminUserPage adminuserpage;
	GeneralUtility generalutility = new GeneralUtility();

	@Test(groups = "regression")
	public void verifyNewAdminUsers() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		loginpage.login();
		homepage.clickOnTile("Admin Users");
		adminuserpage.createUser("Staff", "password", generalutility.generateRandomUserName());
		String actualAlertMessage = adminuserpage.getAlertMessage();
		String s[] = actualAlertMessage.split("\n");
		String splittedActualMsg = s[2];
		String expectedActualMsg = "User Created Successfully";
		Assert.assertEquals(splittedActualMsg, expectedActualMsg);
	}

}
