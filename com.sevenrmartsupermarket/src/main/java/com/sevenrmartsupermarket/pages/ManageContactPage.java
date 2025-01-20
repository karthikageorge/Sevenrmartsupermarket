package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageContactPage {
	WebDriver driver;

	PageUtility pageutility;
	GeneralUtility generalutility = new GeneralUtility();

	@CacheLookup
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneFieldElement;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailFieldElement;
	@FindBy(xpath = "//textarea[@placeholder='Enter the Address']")
	private WebElement adressFieldElement;
	@FindBy(xpath = "//textarea[@id='content']")
	private WebElement deliveryTimeFieldElement;
	@FindBy(xpath = "//input[@id='del_limit']")
	private WebElement deliveryChargeFieldElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//td//a")
	private WebElement editButtonElement;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	private WebElement updateButtonElement;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	private WebElement alertMessageElement;
	@FindBy(xpath = "(//div[@class='card-header']//h3[@class='card-title'])[1]")
	private WebElement contactUsHeadingElement;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnEditButton() {
		editButtonElement.click();
	}

	public void clickOnUpdateButtton() {
		updateButtonElement.click();
	}

	public void enterData(String phone, String email, String address, String time, String charge) {
		phoneFieldElement.clear();
		phoneFieldElement.sendKeys(phone);

		emailFieldElement.clear();
		emailFieldElement.sendKeys(email);

		adressFieldElement.clear();
		adressFieldElement.sendKeys(address);

		deliveryTimeFieldElement.clear();
		deliveryTimeFieldElement.sendKeys(time);

		deliveryChargeFieldElement.clear();
		deliveryChargeFieldElement.sendKeys(charge);

		clickOnUpdateButtton();
	}

	public String getHeading(String heading) {
		return contactUsHeadingElement.getText();
	}

}
