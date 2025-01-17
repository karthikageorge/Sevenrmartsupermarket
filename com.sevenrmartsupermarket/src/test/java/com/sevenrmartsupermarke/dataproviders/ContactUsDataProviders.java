package com.sevenrmartsupermarke.dataproviders;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReader;

public class ContactUsDataProviders {
	ExcelReader excelreader=new ExcelReader();
	/*@DataProvider(name = "Contact Information")
    public Object[][] insertInformation() {
		return new Object[][] {
            {"9876543212", "divya@gmil.com", "XYZ House, Kottayam", "11:30 AM", "500"}
           // {"9876543213", "john@example.com", "ABC Street, Bangalore", "2:00 PM", "600"}
        };
    }*/
	@DataProvider(name = "Contact Information")
	public Object[][] insertInformation()
	{
		excelreader.setExcelFile("ContactDetails", "UpdatedSheet");
		return excelreader.getMultiDimentionalData(1, 5);
	
	}


}
