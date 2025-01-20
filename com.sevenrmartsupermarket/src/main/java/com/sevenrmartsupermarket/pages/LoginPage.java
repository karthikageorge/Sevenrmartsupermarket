package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;

	Properties properties = new Properties();
	GeneralUtility generalutility = new GeneralUtility();
	
	@CacheLookup
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement userNameFieldElement;
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement passwordFieldElement;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signInButtonElement;
	@FindBy(xpath = "//div[@class='icheck-dark']")
	private WebElement rememberMeCheckBoxElement;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement invalidUsernamePasswordElement;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);

		} catch (Exception e) {
			/** print exception */
			e.printStackTrace();
		}
	}

	public String enterUserName(String userName) {
		userNameFieldElement.sendKeys(userName);
		return userName;
	}

	public void enterPassword(String passWord) {
		passwordFieldElement.sendKeys(passWord);
	}

	public void clickOnSignInButton() {
		WaitUtility waitutility = new WaitUtility(driver);
		waitutility.waitForElementToBeClicked(signInButtonElement, 30);
		signInButtonElement.click();
	}

	public HomePage login(String userName, String passWord) {
		enterUserName(userName);
		enterPassword(passWord);
		clickOnSignInButton();
		return new HomePage(driver);

	}

	public HomePage login() {
		String userName = properties.getProperty("username");
		String passWord = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(passWord);
		clickOnSignInButton();
		return new HomePage(driver);
	}

	public boolean signInBtnIsEnabled() {
		boolean result = signInButtonElement.isEnabled();
		return result;
	}

	public boolean checkBoxIsEnabled() {
		String userName = properties.getProperty("username");
		String passWord = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(passWord);
		rememberMeCheckBoxElement.click();
		boolean result = rememberMeCheckBoxElement.isEnabled();
		return result;
	}

	public String loginWithInvalidPassword(String userName, String passWord) {
		enterUserName(userName);
		enterPassword(passWord);
		clickOnSignInButton();
		String alertMessage = generalutility.alertText(invalidUsernamePasswordElement);
		return alertMessage;

	}
	public String getLoginButtonColor(String color) {
		return generalutility.get_Cssvalue(signInButtonElement,color);
	}

}
