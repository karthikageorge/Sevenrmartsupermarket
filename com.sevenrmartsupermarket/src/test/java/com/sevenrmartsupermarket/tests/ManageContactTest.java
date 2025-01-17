package com.sevenrmartsupermarket.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
	
	
	@Test(dataProvider = "Contact Information",dataProviderClass = ContactUsDataProviders.class)
	public void getContactInfo(String phone,String email,String adress,String time,String charge ) 
	{
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		managecontactpage =new ManageContactPage(driver);
		loginpage.login();
		homepage.clickOnTile("Manage Contact");
		managecontactpage.clickOnEditButton();
		managecontactpage.enterData(phone, email, adress, time, charge);
		
		
		}
	

}
