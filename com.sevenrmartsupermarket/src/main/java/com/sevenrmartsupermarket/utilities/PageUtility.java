package com.sevenrmartsupermarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;

	Actions actions;
	JavascriptExecutor js;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
		actions = new Actions(driver);
		js = (JavascriptExecutor) driver;
	}

	public void selectByIndex(WebElement element, int Index) {
		Select select = new Select(element);
		select.selectByIndex(Index);
	}

	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void mouseMoveAndClick(WebElement element) {
		actions.moveToElement(element).build().perform();
		actions.click().perform();
	}
	public void jsClick(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	public void jsScrollIntoElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	public void scrollAndClick(WebElement element) {
		int y = 0;
		while (!isClicked(element)) {
			js.executeScript("window.scrollBy(0," + y + ")");
			y = y + 2;
		}
	}

	public boolean isClicked(WebElement element) {
		try {
			element.click();
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	/*
	 * public void jsClick() { js.executeScript(null, null) }
	 */
}
