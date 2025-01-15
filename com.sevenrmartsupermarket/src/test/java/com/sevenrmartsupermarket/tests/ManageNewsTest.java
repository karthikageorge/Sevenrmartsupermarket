package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageNewsPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class ManageNewsTest extends Base {
	ExcelReader excelreader = new ExcelReader();
	ManageNewsPage managenewspage;
	LoginPage loginpage;
	HomePage homepage;

	@Test
	public void verifyEnterNews() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		managenewspage = new ManageNewsPage(driver);
		loginpage.login();
		// homepage.acceptMainAlertMsg();
		homepage.clickOnTile("Manage News");
		//managenewspage.sendNews("New Heading");
		excelreader.setExcelFile("NewsExcelData", "NewsData");
		String data = excelreader.getCellData(1, 0);
		System.out.println(data);
		managenewspage.sendNews(data);
		managenewspage.clickSaveBtn();
	}

	@Test
	public void verifyAlertMsg() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		managenewspage = new ManageNewsPage(driver);
		loginpage.login();
		homepage.clickOnTile("Manage News");
		managenewspage.sendNews("New Heading");
		managenewspage.clickSaveBtn();
		String AlertMessage = managenewspage.getAlert();
		String s[] = AlertMessage.split("\n");
		String actualAlertMsg = s[2];
		String expectedAlertMsg = "News Created Successfully";
		Assert.assertEquals(actualAlertMsg, expectedAlertMsg);

	}
}
