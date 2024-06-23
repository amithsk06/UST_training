package com.utilities;

import org.testng.annotations.DataProvider;

import com.base.ExcelHandling;

public class DataProviders {
	
	@DataProvider(name = "Data")
	public String[][] getData() throws Exception // ---access excel data
	{
		String[][] data = ExcelHandling.excelHandling(System.getProperty("user.dir") + "/data/register_details.xlsx",
				"Sheet1");
		return data;
	}

}
