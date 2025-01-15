package com.sevenrmartsupermarket.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManageNewsPage {
	WebDriver driver;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newBtnElement;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement newsPageFieldElement;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveBtnElement;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMsgElement;
	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	private WebElement searchBtnElement;

	Properties properties = new Properties();
	GeneralUtility generalutility = new GeneralUtility();

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnNewBtn() {
		newBtnElement.click();
	}

	public void sendNews(String heading) {
		clickOnNewBtn();
		newsPageFieldElement.sendKeys(heading);
	}

	public void clickSaveBtn() {
		saveBtnElement.click();
	}

	public void clickSearchBtn() {
		searchBtnElement.click();
	}

	public String getAlert() {
		String alertMessage = generalutility.alertText(alertMsgElement);
		return alertMessage;

	}
}
