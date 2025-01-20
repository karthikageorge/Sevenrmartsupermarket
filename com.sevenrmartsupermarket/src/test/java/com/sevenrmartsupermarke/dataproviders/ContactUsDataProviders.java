package com.sevenrmartsupermarke.dataproviders;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReader;

public class ContactUsDataProviders {
	ExcelReader excelreader = new ExcelReader();

	@DataProvider(name = "Contact Information")
	public Object[][] insertInformation() {
		excelreader.setExcelFile("ContactDetails", "UpdatedSheet");
		return excelreader.getMultiDimentionalData(1, 5);

	}

}
