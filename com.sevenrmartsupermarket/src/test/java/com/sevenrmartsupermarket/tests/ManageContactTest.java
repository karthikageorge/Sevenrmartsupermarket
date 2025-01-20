package com.sevenrmartsupermarket.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarke.dataproviders.ContactUsDataProviders;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageContactPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class ManageContactTest extends Base {
	HomePage homepage;
	LoginPage loginpage;
	ManageContactPage managecontactpage;
	ExcelReader excelreader = new ExcelReader();

	@Test(dataProvider = "Contact Information", dataProviderClass = ContactUsDataProviders.class)
	public void verifyEmailOfContactInfo(String phone, String email, String adress, String time, String charge) {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		managecontactpage = new ManageContactPage(driver);
		loginpage.login();
		homepage.clickOnTile("Manage Contact");
		managecontactpage.clickOnEditButton();
		managecontactpage.enterData(phone, email, adress, time, charge);
		String actualEmail = email;
		String expectedEmail = "john@example.com";
		Assert.assertEquals(actualEmail, expectedEmail);
	}

	@Test
	public void verifyContactUsHeading() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		managecontactpage = new ManageContactPage(driver);
		loginpage.login();
		homepage.clickOnTile("Manage Contact");
		managecontactpage.clickOnEditButton();
		String actualHeading = managecontactpage.getHeading("title");
		System.out.println(actualHeading);
		String expectedHeading = "Contact Us Informations";
		Assert.assertEquals(actualHeading, expectedHeading);
	}

}
