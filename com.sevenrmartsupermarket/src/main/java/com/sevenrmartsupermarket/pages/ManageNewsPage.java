package com.sevenrmartsupermarket.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManageNewsPage {
	WebDriver driver;
	
	@CacheLookup
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButtonElement;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement newsPageFieldElement;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButtonElement;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessageElement;
	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	private WebElement searchButtonElement;
	

	Properties properties = new Properties();
	GeneralUtility generalutility = new GeneralUtility();

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnNewButton() {
		newButtonElement.click();
	}

	public void sendNews(String heading) {
		clickOnNewButton();
		newsPageFieldElement.sendKeys(heading);
	}

	public void clickSaveButton() {
		saveButtonElement.click();
	}

	public void clickSearchButton() {
		searchButtonElement.click();
	}

	public String getAlert() {
		String alertMessage = generalutility.alertText(alertMessageElement);
		return alertMessage;

	}
	
}
