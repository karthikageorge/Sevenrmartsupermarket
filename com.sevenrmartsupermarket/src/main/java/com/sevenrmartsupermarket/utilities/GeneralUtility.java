package com.sevenrmartsupermarket.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
	public String get_Attribute(WebElement element, String attribute) {

		return element.getAttribute(attribute);// method is getattribute
	}

	public String get_Cssvalue(WebElement element, String property) {

		return element.getCssValue(property);// method is getattribute
	}

	public List<String> getTextOfElements(List<WebElement> elements) {
		List<String> data = new ArrayList<String>();
		for (WebElement element : elements) {
			data.add(element.getText());
		}
		return data;
	}

	public List<String> getAllElements(List<WebElement> elements) {
		List<String> namesdata = new ArrayList<String>();
		for (WebElement element : elements) {
			namesdata.add(element.getText());
		}
		return namesdata;
	}

	public List<String> getSingleData(List<WebElement> elements) {
		List<String> singleData = new ArrayList<String>();
		for (WebElement element : elements) {
			singleData.add(element.getText());
		}
		return singleData;
	}
	public String alertText(WebElement element) {
		return element.getText();
	}
public static String getTimestamp() {
	String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
	return timeStamp;
}
public String generateRandomUserName() {
	String random = RandomStringUtils.randomAlphanumeric(12);
	String randomUsername = random + "@gmail.com";
	return randomUsername;
} 
public static String getRandomName() {
	Faker faker=new Faker();
	return faker.name().firstName();
}
}
