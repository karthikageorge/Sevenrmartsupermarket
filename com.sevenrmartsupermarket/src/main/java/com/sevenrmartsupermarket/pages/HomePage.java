package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;

public class HomePage {
	WebDriver driver;

	PageUtility pageutility;
	@CacheLookup
	By profileLocator = By.xpath("//div[@class='user-panel mt-3 pb-3 mb-3 d-flex']//div/a[@class='d-block']");

	@FindBy(xpath = "//div[@class='user-panel mt-3 pb-3 mb-3 d-flex']//div/a[@class='d-block']")
	private WebElement profileNameElement;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfileName() {
		return profileNameElement.getText();
	}

	public void clickOnTile(String Name) {
		pageutility = new PageUtility(driver);
		WebElement tileElement = driver.findElement(By.xpath("//div[@class='inner']//p[text()='" + Name + "']//following::a[1]"));
		pageutility.scrollAndClick(tileElement);
	}
}
