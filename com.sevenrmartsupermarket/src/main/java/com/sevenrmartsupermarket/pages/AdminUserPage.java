package com.sevenrmartsupermarket.pages;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class AdminUserPage {
	WebDriver driver;

	PageUtility pageutility;
	GeneralUtility generalutility;
	
	@CacheLookup
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButtonElement;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameFieldElement;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordFieldElement;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userTypeFieldElement;
	@FindBy(xpath = "//select[@id='user_type']//option")
	private WebElement listOfUserTypeElement;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveButtonElement;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessageElement;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnNewBtn() {
		newButtonElement.click();
	}

	public void sendUsername(String userName ) {
		clickOnNewBtn();
		userNameFieldElement.sendKeys(userName);
	}

	public void sendPassword(String password) {
		clickOnNewBtn();
		passwordFieldElement.sendKeys(password);

	}

	
	public void createUser(String userType, String password,String userName ) {
		pageutility=new PageUtility(driver);
		generalutility=new GeneralUtility();
		clickOnNewBtn();
		sendUsername(userName);
		sendPassword(password);
		pageutility.selectByVisibleText(userTypeFieldElement, userType);
		saveButtonElement.click();
	}
	public String getAlertMessage() {
		String alertMessage = generalutility.alertText(alertMessageElement);
		return alertMessage;
	}

}
